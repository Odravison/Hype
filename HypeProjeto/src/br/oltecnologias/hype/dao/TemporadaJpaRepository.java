/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.exception.TemporadaExistenteException;
import br.oltecnologias.hype.exception.TemporadaInexistenteException;
import br.oltecnologias.hype.model.Temporada;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Odravison
 */
public class TemporadaJpaRepository implements TemporadaRepository{
    
    private EntityManagerFactory emf = null;

    public TemporadaJpaRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(Temporada temporada) throws TemporadaExistenteException {
        EntityManager em = null;
        
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            
            if (getTemporada() != null){
                throw new TemporadaExistenteException("A Temporada já existe, desative-a ou ative-a!");
            }
            
            em.persist(temporada);
            
            em.getTransaction().commit();
        } finally {
            if (emf != null){
                emf.close();
            }
        }
        
    }

    @Override
    public void edit(Temporada temporada) throws TemporadaInexistenteException {
        EntityManager em = null;
        Temporada temp = null;
        
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            
            temp = em.find(Temporada.class, temporada.getId());
            temp.setId(temporada.getId());
            temp.setIsAtivada(temporada.isAtivada());
            temp.setPertentualDeDesconto(temporada.getPertentualDeDesconto());
            
            em.merge(temp);
            
            em.getTransaction().commit();
            
        } finally {
            if (emf != null){
                emf.close();
            }
        }
    }

    @Override
    public void remove(long id) throws TemporadaInexistenteException {
        EntityManager em = null;
        
        try{
            em = getEntityManager();
            if (getTemporada() != null){
                throw new TemporadaInexistenteException("A temporada ainda não foi criada!");
            }
            em.getTransaction().begin();
            
            em.remove(getTemporada());
            
            em.getTransaction().commit();
            
        } finally {
            if (emf != null){
                emf.close();
            }
        }
    }

    @Override
    public Temporada getTemporada() {
       List<Temporada> retorno = new ArrayList<Temporada>();
        EntityManager em = null;
        
        try{
            em = getEntityManager();
            Query q = em.createQuery("SELECT c FROM Temporada c");
            retorno = q.getResultList();
            
            

        } finally {
            if (em != null) {
                em.close();
            }
        }

        return retorno.get(0);
       
    }
    
}
