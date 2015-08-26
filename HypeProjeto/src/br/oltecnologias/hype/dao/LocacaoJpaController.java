/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.dao.exceptions.NonexistentEntityException;
import br.oltecnologias.hype.dao.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.oltecnologias.hype.model.Cliente;
import br.oltecnologias.hype.model.Locacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Odravison
 */
public class LocacaoJpaController implements Serializable {

    public LocacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Locacao locacao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente = locacao.getCliente();
            if (cliente != null) {
                cliente = em.getReference(cliente.getClass(), cliente.getCpf());
                locacao.setCliente(cliente);
            }
            em.persist(locacao);
            if (cliente != null) {
                cliente.getLocacoes().add(locacao);
                cliente = em.merge(cliente);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLocacao(locacao.getId()) != null) {
                throw new PreexistingEntityException("Locacao " + locacao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Locacao locacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Locacao persistentLocacao = em.find(Locacao.class, locacao.getId());
            Cliente clienteOld = persistentLocacao.getCliente();
            Cliente clienteNew = locacao.getCliente();
            if (clienteNew != null) {
                clienteNew = em.getReference(clienteNew.getClass(), clienteNew.getCpf());
                locacao.setCliente(clienteNew);
            }
            locacao = em.merge(locacao);
            if (clienteOld != null && !clienteOld.equals(clienteNew)) {
                clienteOld.getLocacoes().remove(locacao);
                clienteOld = em.merge(clienteOld);
            }
            if (clienteNew != null && !clienteNew.equals(clienteOld)) {
                clienteNew.getLocacoes().add(locacao);
                clienteNew = em.merge(clienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = locacao.getId();
                if (findLocacao(id) == null) {
                    throw new NonexistentEntityException("The locacao with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Locacao locacao;
            try {
                locacao = em.getReference(Locacao.class, id);
                locacao.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The locacao with id " + id + " no longer exists.", enfe);
            }
            Cliente cliente = locacao.getCliente();
            if (cliente != null) {
                cliente.getLocacoes().remove(locacao);
                cliente = em.merge(cliente);
            }
            em.remove(locacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Locacao> findLocacaoEntities() {
        return findLocacaoEntities(true, -1, -1);
    }

    public List<Locacao> findLocacaoEntities(int maxResults, int firstResult) {
        return findLocacaoEntities(false, maxResults, firstResult);
    }

    private List<Locacao> findLocacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Locacao.class));
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

    public Locacao findLocacao(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Locacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getLocacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Locacao> rt = cq.from(Locacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
