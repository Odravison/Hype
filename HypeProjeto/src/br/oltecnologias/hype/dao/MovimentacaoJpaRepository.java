/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.exception.MovimentacaoExistenteException;
import br.oltecnologias.hype.exception.MovimentacaoInexistenteException;
import br.oltecnologias.hype.model.Movimentacao;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Odravison
 */
public class MovimentacaoJpaRepository implements MovimentacaoRepository {

    private EntityManagerFactory emf = null;

    public MovimentacaoJpaRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(Movimentacao movimentacao) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            em.persist(movimentacao);
            em.getTransaction().commit();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Movimentacao findById(long id) throws MovimentacaoInexistenteException {
        EntityManager em = null;
        try {
            em = getEntityManager();

            if (!existsMovimentacao(id)) {
                throw new MovimentacaoInexistenteException("Produto com código: " + id + " não foi cadastrado!");
            }

            return em.find(Movimentacao.class, id);

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public boolean existsMovimentacao(long id) {
        Movimentacao result;
        try {
            result = findById(id);
        } catch (MovimentacaoInexistenteException ex) {
            result = null;
        }

        return (result != null);
    }

    @Override
    public void removerMovimentacao(long id) throws MovimentacaoInexistenteException {
        Movimentacao m = null;
        EntityManager em = null;
        
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            
            if (!existsMovimentacao(id)){
                throw new MovimentacaoInexistenteException("Esta movimentação não existe!");
            }
            m = em.find(Movimentacao.class, id);
            
            em.remove(m);
            
            em.getTransaction().commit();
        } finally{
            if (em != null){
                em.close();
            }
        }
        
        
    }

    @Override
    public void editarMovimentacao(Movimentacao movimentacao) throws MovimentacaoInexistenteException {
        Movimentacao m = null;
        EntityManager em = null;
        
        
        try{            
            em = getEntityManager();
            
            em.getTransaction().begin();
            
            if (!existsMovimentacao(movimentacao.getId())){
                throw new MovimentacaoInexistenteException("Não existe movimentação com o ID: " + movimentacao.getId());
            }
            m = em.find(Movimentacao.class, movimentacao.getId());
            
            m.setBeneficiario(movimentacao.getBeneficiario());
            m.setData(movimentacao.getData());
            m.setIdDaOperacao(movimentacao.getIdDaOperacao());
            m.setMovimento(movimentacao.getMovimento());
            m.setResponsavel(movimentacao.getResponsavel());
            m.setValor(movimentacao.getValor());
            
            em.merge(m);
            
            em.getTransaction().commit();
            
        } finally{
            if (em != null){
                em.close();
            }
        }
        
    }

    @Override
    public long getIdDaOperacao(long idMovimentacao) throws MovimentacaoInexistenteException {
        return findById(idMovimentacao).getIdDaOperacao();
    }
    
    @Override
    public List<Movimentacao> getAllMovimentacoes(){
        EntityManager em = null;
        List<Movimentacao> retorno = new ArrayList<Movimentacao>();
        
        try{
            em = getEntityManager();
            Query q = em.createQuery("SELECT c FROM Movimentacao c");
            retorno = q.getResultList();

        } finally {
            if (em != null) {
                em.close();
            }
        }

        return retorno;
    }
}
