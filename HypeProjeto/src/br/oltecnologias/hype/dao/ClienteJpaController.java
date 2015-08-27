/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.dao.exceptions.NonexistentEntityException;
import br.oltecnologias.hype.dao.exceptions.PreexistingEntityException;
import br.oltecnologias.hype.model.Cliente;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.oltecnologias.hype.model.Locacao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Odravison
 */
public class ClienteJpaController implements Serializable {

    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) throws PreexistingEntityException, Exception {
        if (cliente.getLocacoes() == null) {
            cliente.setLocacoes(new ArrayList<Locacao>());
            System.out.println("===========>>>>>>>>>>>> 1");
        }
        EntityManager em = null;
        try {
            System.out.println("===========>>>>>>>>>>>> 2");
            em = getEntityManager();
            em.getTransaction().begin();
            List<Locacao> attachedLocacoes = new ArrayList<Locacao>();
            for (Locacao locacoesLocacaoToAttach : cliente.getLocacoes()) {
                System.out.println("===========>>>>>>>>>>>> 3");
                locacoesLocacaoToAttach = em.getReference(locacoesLocacaoToAttach.getClass(), locacoesLocacaoToAttach.getId());
                attachedLocacoes.add(locacoesLocacaoToAttach);
            }
            cliente.setLocacoes(attachedLocacoes);
            System.out.println("===========>>>>>>>>>>>> 4");
            em.persist(cliente);
            System.out.println("===========>>>>>>>>>>>> 5");
            for (Locacao locacoesLocacao : cliente.getLocacoes()) {
                System.out.println("===========>>>>>>>>>>>> 5.1");
                Cliente oldClienteOfLocacoesLocacao = locacoesLocacao.getCliente();
                System.out.println("===========>>>>>>>>>>>> 5.2");
                locacoesLocacao.setCliente(cliente);
                System.out.println("===========>>>>>>>>>>>> 5.3");
                System.out.println("===========>>>>>>>>>>>> 6");
                locacoesLocacao = em.merge(locacoesLocacao);
                if (oldClienteOfLocacoesLocacao != null) {
                    oldClienteOfLocacoesLocacao.getLocacoes().remove(locacoesLocacao);
                    System.out.println("===========>>>>>>>>>>>> 7");
                    oldClienteOfLocacoesLocacao = em.merge(oldClienteOfLocacoesLocacao);
                }
            }
            em.getTransaction().commit();
            System.out.println("===========>>>>>>>>>>>> 8");
        } catch (Exception ex) {
            if (findCliente(cliente.getCpf()) != null) {
                System.out.println("===========>>>>>>>>>>>> 9");
                throw new PreexistingEntityException("Cliente " + cliente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
                System.out.println("===========>>>>>>>>>>>> 10");
            }
        }
    }

    public void edit(Cliente cliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getCpf());
            List<Locacao> locacoesOld = persistentCliente.getLocacoes();
            List<Locacao> locacoesNew = cliente.getLocacoes();
            List<Locacao> attachedLocacoesNew = new ArrayList<Locacao>();
            for (Locacao locacoesNewLocacaoToAttach : locacoesNew) {
                locacoesNewLocacaoToAttach = em.getReference(locacoesNewLocacaoToAttach.getClass(), locacoesNewLocacaoToAttach.getId());
                attachedLocacoesNew.add(locacoesNewLocacaoToAttach);
            }
            locacoesNew = attachedLocacoesNew;
            cliente.setLocacoes(locacoesNew);
            cliente = em.merge(cliente);
            for (Locacao locacoesOldLocacao : locacoesOld) {
                if (!locacoesNew.contains(locacoesOldLocacao)) {
                    locacoesOldLocacao.setCliente(null);
                    locacoesOldLocacao = em.merge(locacoesOldLocacao);
                }
            }
            for (Locacao locacoesNewLocacao : locacoesNew) {
                if (!locacoesOld.contains(locacoesNewLocacao)) {
                    Cliente oldClienteOfLocacoesNewLocacao = locacoesNewLocacao.getCliente();
                    locacoesNewLocacao.setCliente(cliente);
                    locacoesNewLocacao = em.merge(locacoesNewLocacao);
                    if (oldClienteOfLocacoesNewLocacao != null && !oldClienteOfLocacoesNewLocacao.equals(cliente)) {
                        oldClienteOfLocacoesNewLocacao.getLocacoes().remove(locacoesNewLocacao);
                        oldClienteOfLocacoesNewLocacao = em.merge(oldClienteOfLocacoesNewLocacao);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cliente.getCpf();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getCpf();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            List<Locacao> locacoes = cliente.getLocacoes();
            for (Locacao locacoesLocacao : locacoes) {
                locacoesLocacao.setCliente(null);
                locacoesLocacao = em.merge(locacoesLocacao);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cliente findCliente(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
