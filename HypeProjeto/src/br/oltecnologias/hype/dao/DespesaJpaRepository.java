/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.exception.DespesaExistenteException;
import br.oltecnologias.hype.exception.DespesaInexistenteException;
import br.oltecnologias.hype.model.Despesa;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Odravison
 */
public class DespesaJpaRepository implements DespesaRepository{
    
    private EntityManagerFactory emf = null;

    public DespesaJpaRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(Despesa despesa) throws DespesaExistenteException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            em.persist(despesa);
            em.getTransaction().commit();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Despesa findById(long id) throws DespesaInexistenteException {
        EntityManager em = null;
        Despesa desp = null;
        try{
            em = getEntityManager();
            if (!existsDespesa(id)){
                throw new DespesaInexistenteException("A despesa do ID: " + id + " não existe!");
            }
            desp = em.find(Despesa.class, id);
            
        } finally{
            if (em != null){
                em.close();
            }
        }
        
        return desp;
    }

    @Override
    public boolean existsDespesa(long id) {
        Object result = null;
        EntityManager em = null;

        try {
            em = getEntityManager();
            Query query = em.createQuery("SELECT 1 FROM Despesa WHERE id = ?");
            query.setParameter(1, id);
            query.setMaxResults(1);

            result = query.getSingleResult();
        } catch (NoResultException e) {
            result = null;
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return (result != null);
        
    }

    @Override
    public void removerDespesa(long id) throws DespesaInexistenteException {
        EntityManager em = null;
        Despesa despesa = null;
        
        try{
            em = getEntityManager();
            
            
            despesa = em.find(Despesa.class, id);
            if (existsDespesa(id)){
                em.getTransaction().begin();
                em.remove(despesa);
                em.getTransaction().commit();
                
                
            }
            
            
        } finally {
            if (em != null){
                em.close();
            }
        }
    }

    @Override
    public void editarDespesa(Despesa despesa) throws DespesaInexistenteException {
        Despesa d = null;
        EntityManager em = null;
        
        
        try{            
            em = getEntityManager();
            em.getTransaction().begin();
            
            if (!existsDespesa(despesa.getId())){
                throw new DespesaInexistenteException("Não existe despesa com o ID: " + despesa.getId());
            }
            d = em.find(Despesa.class, despesa.getId());
            
            d.setData(despesa.getData());
            d.setEmissor(despesa.getEmissor());
            d.setFavorecido(despesa.getFavorecido());
            d.setNome(despesa.getNome());
            d.setObservacao(despesa.getObservacao());
            d.setValor(despesa.getValor());
            
            em.merge(d);
            em.getTransaction().commit();
            
        } finally{
            if (em != null){
                em.close();
            }
        }
    }
    
    @Override
    public List<Despesa> getAllDespesas(){
        List<Despesa> retorno = new ArrayList<Despesa>();
        EntityManager em = null;
        
        try{
            em = getEntityManager();
            Query q = em.createQuery("SELECT c FROM Despesa c");
            retorno = q.getResultList();

        } finally {
            if (em != null) {
                em.close();
            }
        }

        return retorno;
        
        
        
    }
    
    
}
