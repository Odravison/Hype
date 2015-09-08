/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.dao.exceptions.NonexistentEntityException;
import br.oltecnologias.hype.dao.exceptions.PreexistingEntityException;
import br.oltecnologias.hype.model.Temporada;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Odravison
 */
public class TemporadaJpaController implements Serializable {

    public TemporadaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Temporada temporada) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(temporada);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTemporada(temporada.getId()) != null) {
                throw new PreexistingEntityException("Temporada " + temporada + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Temporada temporada) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            temporada = em.merge(temporada);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = temporada.getId();
                if (findTemporada(id) == null) {
                    throw new NonexistentEntityException("The temporada with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Temporada temporada;
            try {
                temporada = em.getReference(Temporada.class, id);
                temporada.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The temporada with id " + id + " no longer exists.", enfe);
            }
            em.remove(temporada);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Temporada> findTemporadaEntities() {
        return findTemporadaEntities(true, -1, -1);
    }

    public List<Temporada> findTemporadaEntities(int maxResults, int firstResult) {
        return findTemporadaEntities(false, maxResults, firstResult);
    }

    private List<Temporada> findTemporadaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Temporada.class));
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

    public Temporada findTemporada(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Temporada.class, id);
        } finally {
            em.close();
        }
    }

    public int getTemporadaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Temporada> rt = cq.from(Temporada.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
