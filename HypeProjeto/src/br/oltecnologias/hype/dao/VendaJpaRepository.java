/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.exception.VendaInexistenteException;
import br.oltecnologias.hype.model.Venda;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Odravison
 */
public class VendaJpaRepository implements VendaRepository {
    
    private EntityManagerFactory emf = null;

    public VendaJpaRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(Venda venda) {
        EntityManager em = null;
        
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(venda);
            em.getTransaction().commit();
        } finally{
            if (em != null){
                em.close();
            }
        }
    }

    @Override
    public Venda findById(long id) throws VendaInexistenteException {
        EntityManager em = null;
        Venda result = null;

        try {
            em = getEntityManager();

            if (!existsVenda(id)) {
                throw new VendaInexistenteException("Venda com id: " + id + " não foi cadastrado");
            }
            Query query = em.createQuery("SELECT c FROM Venda c WHERE c.id = :id", Venda.class);
            query.setParameter("id", id);
            query.setMaxResults(1);

            result = (Venda) query.getSingleResult();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
        return result;
        
    }

    @Override
    public boolean existsVenda(long id) {
        Object result = null;
        EntityManager em = null;

        try {
            em = getEntityManager();
            Query query = em.createQuery("SELECT 1 FROM Venda WHERE id = ?");
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
    public void removerVenda(long id) throws VendaInexistenteException {
         EntityManager em = null;
         try{
             em = getEntityManager();
             
             if (!existsVenda(id)){
                 throw new VendaInexistenteException("Esta venda com id: " + id + " não existe!");
             }
             em.getTransaction().begin();
             
             Venda venda = em.find(Venda.class, id);
             em.remove(venda);
             
             em.getTransaction().commit();
             
             
         } finally{
             if (em != null){
                 em.close();
             }
         }
    }

    @Override
    public void editarVenda(Venda venda) throws VendaInexistenteException {
        EntityManager em = null;
        
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            if (existsVenda(venda.getId())){
                em.merge(venda);
            }
            em.getTransaction().commit();
            
        } finally {
            if (em != null){
                em.close();
            }
        }
    }

    @Override
    public List<Venda> getAllVendas() {
        List<Venda> Vendas = new ArrayList<Venda>();
        EntityManager em = null;

        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT c FROM Venda c");
            Vendas = q.getResultList();

        } finally {
            if (em != null) {
                em.close();
            }
        }

        return Vendas;
    }
    
}
