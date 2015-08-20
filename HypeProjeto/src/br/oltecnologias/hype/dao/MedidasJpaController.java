/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.dao.exceptions.NonexistentEntityException;
import br.oltecnologias.hype.model.Medidas;
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
public class MedidasJpaController implements Serializable {

    public MedidasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Medidas medidas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(medidas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                System.out.println(em.isOpen());
                em.close();
                System.out.println(em.isOpen());
                System.out.println(emf.isOpen());
                
            }
        }
    }

    public void edit(Medidas medidas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            medidas = em.merge(medidas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = medidas.getId();
                if (findMedidas(id) == null) {
                    throw new NonexistentEntityException("The medidas with id " + id + " no longer exists.");
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
            Medidas medidas;
            try {
                medidas = em.getReference(Medidas.class, id);
                medidas.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The medidas with id " + id + " no longer exists.", enfe);
            }
            em.remove(medidas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Medidas> findMedidasEntities() {
        return findMedidasEntities(true, -1, -1);
    }

    public List<Medidas> findMedidasEntities(int maxResults, int firstResult) {
        return findMedidasEntities(false, maxResults, firstResult);
    }

    private List<Medidas> findMedidasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Medidas.class));
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

    public Medidas findMedidas(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Medidas.class, id);
        } finally {
            em.close();
        }
    }

    public int getMedidasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Medidas> rt = cq.from(Medidas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
