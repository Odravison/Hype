/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.exception.LocacaoExistenteException;
import br.oltecnologias.hype.exception.LocacaoInexistenteException;
import br.oltecnologias.hype.exception.ProdutoInexistenteException;
import br.oltecnologias.hype.model.Locacao;
import br.oltecnologias.hype.model.Produto;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Odravison
 */
public class LocacaoJpaRepository implements LocacaoRepository {
    
    final static private Logger logger = LoggerFactory.getLogger(ClienteJpaRepository.class);
    private EntityManagerFactory emf = null;

    public LocacaoJpaRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    @Override
    public void create(Locacao locacao) throws LocacaoExistenteException {
        logger.info("adicionando locação {}", locacao);
        
        EntityManager em = null;
        
        try{
            em = getEntityManager();
            
            if (existsLocacao(locacao.getId())){
                throw new LocacaoExistenteException("Locação de já existe");
            }
            
            em.getTransaction().begin();            
            em.persist(locacao);            
            em.getTransaction().commit();
            
            
        }finally{
            if (em != null){
                em.close();
            }
        }
    }

    @Override
    public Locacao findById(int id) throws LocacaoInexistenteException {
        
        EntityManager em = null;
        
        try{
            em = getEntityManager();
            
            if (!existsLocacao(id)){
                throw new LocacaoInexistenteException("Esta locação não existe");
            }

        }finally{
            if (em != null){
                em.close();
            }
        }
        
        return em.find(Locacao.class, id);
        
    }

    @Override
    public boolean existsLocacao(int id) {
        
        Object result = null;
        EntityManager em = null;

        try {
            em = getEntityManager();
            Query query = em.createQuery("SELECT 1 FROM Locacao WHERE id_locacao = ?");
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
    public void editarLocacao(Locacao locacao) throws LocacaoInexistenteException {
        EntityManager em = null;
        Locacao l = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            
            if (!existsLocacao(locacao.getId())){
                throw new LocacaoInexistenteException("A locação para edição não existe!");
            }

            l = em.getReference(Locacao.class, locacao.getId());
            l.setCliente(locacao.getCliente());
            l.setDataDevolucao(locacao.getDataDevolucao());
            l.setDataLocacao(locacao.getDataLocacao());
            l.setFormaDePagamento(locacao.getFormaDePagamento());
            l.setJaPago(locacao.getJaPago());
            l.setProdutos(locacao.getProdutos());
            l.setValorDeEntrada(locacao.getValorDeEntrada());
            l.setValorLocacao(locacao.getValorLocacao());
            l.setParcelas(locacao.getParcelas());
            l.setEntrada(locacao.getEntrada());
            
            em.merge(l);

            em.getTransaction().commit();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void removerLocacao(Locacao locacao) throws LocacaoInexistenteException {
        EntityManager em = null;
        Locacao loca = null;
        
        try{
            em = getEntityManager();
            
            if (!existsLocacao(locacao.getId())){
                throw new LocacaoInexistenteException("Esta locação não existe");
            }
            
            em.getTransaction().begin();
            loca = em.merge(locacao);
            em.remove(loca);
            em.getTransaction().commit();
            
        }finally{
            if (em != null){
                em.close();
            }           
            
        }
    }
    
    @Override
    public List<Locacao> getAllLocacao(){
        EntityManager em = null;
        List<Locacao> locacoes = new ArrayList<Locacao>();
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT l FROM Locacao l");
            locacoes = q.getResultList();

        } finally {
            if (em != null) {
                em.close();
            }
        }

        return locacoes;
    }

    @Override
    public List<Locacao> getLocacaoByCliente(String idCliente) {
        EntityManager em = null;
        List<Locacao> locacoes = new ArrayList<Locacao>();
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT l FROM Locacao as l WHERE l.cliente.cpf = :parametro", Locacao.class);
            q.setParameter("parametro", idCliente);
            locacoes = q.getResultList();

        } finally {
            if (em != null) {
                em.close();
            }
        }

        return locacoes;
    }
    
    
}
