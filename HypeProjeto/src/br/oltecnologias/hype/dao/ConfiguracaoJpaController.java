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
import br.oltecnologias.hype.model.Configuracao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Odravison
 */
public class ConfiguracaoJpaController implements Serializable {

    public ConfiguracaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Configuracao configuracao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Configuracao singleton = configuracao.getSingleton();
            if (singleton != null) {
                singleton = em.getReference(singleton.getClass(), singleton.getId());
                configuracao.setSingleton(singleton);
            }
            em.persist(configuracao);
            if (singleton != null) {
//                singleton.getInstance().add(configuracao);
                singleton = em.merge(singleton);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConfiguracao(configuracao.getId()) != null) {
                throw new PreexistingEntityException("Configuracao " + configuracao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Configuracao configuracao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Configuracao persistentConfiguracao = em.find(Configuracao.class, configuracao.getId());
            Configuracao singletonOld = persistentConfiguracao.getSingleton();
            Configuracao singletonNew = configuracao.getSingleton();
            if (singletonNew != null) {
                singletonNew = em.getReference(singletonNew.getClass(), singletonNew.getId());
                configuracao.setSingleton(singletonNew);
            }
            configuracao = em.merge(configuracao);
            if (singletonOld != null && !singletonOld.equals(singletonNew)) {
//                singletonOld.getInstance().remove(configuracao);
                singletonOld = em.merge(singletonOld);
            }
            if (singletonNew != null && !singletonNew.equals(singletonOld)) {
//                singletonNew.getInstance().add(configuracao);
                singletonNew = em.merge(singletonNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = configuracao.getId();
                if (findConfiguracao(id) == null) {
                    throw new NonexistentEntityException("The configuracao with id " + id + " no longer exists.");
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
            Configuracao configuracao;
            try {
                configuracao = em.getReference(Configuracao.class, id);
                configuracao.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The configuracao with id " + id + " no longer exists.", enfe);
            }
            Configuracao singleton = configuracao.getSingleton();
            if (singleton != null) {
//                singleton.getInstance().remove(configuracao);
                singleton = em.merge(singleton);
            }
            em.remove(configuracao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Configuracao> findConfiguracaoEntities() {
        return findConfiguracaoEntities(true, -1, -1);
    }

    public List<Configuracao> findConfiguracaoEntities(int maxResults, int firstResult) {
        return findConfiguracaoEntities(false, maxResults, firstResult);
    }

    private List<Configuracao> findConfiguracaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Configuracao.class));
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

    public Configuracao findConfiguracao(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Configuracao.class, id);
        } finally {
            em.close();
        }
    }

    public int getConfiguracaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Configuracao> rt = cq.from(Configuracao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
