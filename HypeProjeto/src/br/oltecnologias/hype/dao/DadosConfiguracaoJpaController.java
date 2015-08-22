/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.dao.exceptions.NonexistentEntityException;
import br.oltecnologias.hype.model.DadosConfiguracao;
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
public class DadosConfiguracaoJpaController implements Serializable {

    public DadosConfiguracaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DadosConfiguracao dadosConfiguracao) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(dadosConfiguracao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DadosConfiguracao dadosConfiguracao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            dadosConfiguracao = em.merge(dadosConfiguracao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = dadosConfiguracao.getId();
                if (findDadosConfiguracao(id) == null) {
                    throw new NonexistentEntityException("The dadosConfiguracao with id " + id + " no longer exists.");
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
            DadosConfiguracao dadosConfiguracao;
            try {
                dadosConfiguracao = em.getReference(DadosConfiguracao.class, id);
                dadosConfiguracao.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dadosConfiguracao with id " + id + " no longer exists.", enfe);
            }
            em.remove(dadosConfiguracao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DadosConfiguracao> findDadosConfiguracaoEntities() {
        return findDadosConfiguracaoEntities(true, -1, -1);
    }

    public List<DadosConfiguracao> findDadosConfiguracaoEntities(int maxResults, int firstResult) {
        return findDadosConfiguracaoEntities(false, maxResults, firstResult);
    }

    private List<DadosConfiguracao> findDadosConfiguracaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DadosConfiguracao.class));
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

    public DadosConfiguracao findDadosConfiguracao(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DadosConfiguracao.class, id);
        } finally {
            em.close();
        }
    }

    public int getDadosConfiguracaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DadosConfiguracao> rt = cq.from(DadosConfiguracao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
