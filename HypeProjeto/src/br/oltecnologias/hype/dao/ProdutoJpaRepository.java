/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.exception.ProdutoExistenteException;
import br.oltecnologias.hype.exception.ProdutoInexistenteException;
import br.oltecnologias.hype.model.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

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
public class ProdutoJpaRepository implements ProdutoRepository {

    final static private Logger logger = LoggerFactory.getLogger(ClienteJpaRepository.class);
    private EntityManagerFactory emf = null;

    public ProdutoJpaRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(Produto produto) throws ProdutoExistenteException {
        logger.info("adicionando produto {}", produto);

        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            if (existsCodigo(produto.getCodigo())) {
                throw new ProdutoExistenteException("Produto com código: " + produto.getCodigo() + " já foi cadastrado");
            }

            em.persist(produto);
            em.getTransaction().commit();

        } catch (ProdutoExistenteException e) {
            System.out.println(e.getMessage());

        } catch (ProdutoInexistenteException ex) {

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Produto findById(String codigo) throws ProdutoInexistenteException {
        logger.info("Procurando produto com id: ", codigo);

        EntityManager em = null;
        try {
            em = getEntityManager();

            if (!existsCodigo(codigo)) {
                throw new ProdutoInexistenteException("Produto com código: " + codigo + " não foi cadastrado!");
            }

            return em.find(Produto.class, codigo);

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void apagarProduto(String codigo) throws ProdutoInexistenteException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            if (!existsCodigo(codigo)) {
                throw new ProdutoInexistenteException("Produto com código: " + codigo + " não foi cadastrado!");
            }

            em.remove(em.getReference(Produto.class, codigo));

            em.getTransaction().commit();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void editarProduto(Produto produto) throws ProdutoInexistenteException {
        EntityManager em = null;
        Produto p = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();

            if (!existsCodigo(produto.getCodigo())) {
                throw new ProdutoInexistenteException("O produto com o código de número: " + produto.getCodigo() + " não se encontra cadastrado!");
            }

            p = em.getReference(Produto.class, produto.getCodigo());
            p.setCor(produto.getCor());
            p.setFornecedor(produto.getFornecedor());
            p.setIsLocation(produto.isLocation());
            p.setNome(produto.getNome());
            p.setQuantidade(produto.getQuantidade());
            p.setTam(produto.getTam());
            p.setValor(produto.getValor());

            em.merge(p);

            em.getTransaction().commit();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Produto> getAllProdutos() {
        EntityManager em = null;
        List<Produto> produtos = new ArrayList<Produto>();
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT c FROM Produto c");
            produtos = q.getResultList();

        } finally {
            if (em != null) {
                em.close();
            }
        }

        return produtos;
    }

    @Override
    public boolean existsCodigo(String codigo) throws ProdutoInexistenteException {
        Object result = null;
        EntityManager em = null;

        try {
            em = getEntityManager();
            Query query = em.createQuery("SELECT 1 FROM Produto WHERE id_produto = ?");
            query.setParameter(1, codigo);
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
}
