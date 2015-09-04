/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.exception.FornecedorExistenteException;
import br.oltecnologias.hype.exception.FornecedorInexistenteException;
import br.oltecnologias.hype.model.Fornecedor;
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
public class FornecedorJpaRepository implements FornecedorRepository {

    private EntityManagerFactory emf = null;

    public FornecedorJpaRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(Fornecedor fornecedor) throws FornecedorExistenteException {
        EntityManager em = null;
        try {

            em = getEntityManager();
            em.getTransaction().begin();
            if (existsFornecedor(fornecedor.getCnpj())) {
                throw new FornecedorExistenteException("Fornecedor com este CNPJ já existe.");
            }

            em.persist(fornecedor);
            em.getTransaction().commit();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Fornecedor findByCnpj(String cnpj) throws FornecedorInexistenteException {
        EntityManager em = null;
        Fornecedor result = null;

        try {
            em = getEntityManager();

            if (!existsFornecedor(cnpj)) {
                throw new FornecedorInexistenteException("Fornecedor com CNPJ: " + cnpj + " não foi cadastrado");
            }
            Query query = em.createQuery("SELECT f FROM Fornecedor f WHERE f.cnpj = :cnpj", Fornecedor.class);
            query.setParameter("cnpj", cnpj);
            query.setMaxResults(1);

            result = (Fornecedor) query.getSingleResult();
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return result;
    }

    @Override
    public boolean existsFornecedor(String cnpj) {
        Object result = null;
        EntityManager em = null;

        try {
            em = getEntityManager();
            Query query = em.createQuery("SELECT 1 FROM Fornecedor WHERE cnpj = ?");
            query.setParameter(1, cnpj);
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
    public void removerFornecedor(String cnpj) throws FornecedorInexistenteException {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            if (!existsFornecedor(cnpj)) {
                throw new FornecedorInexistenteException("Fornecedor com CNPJ: " + cnpj + " não foi cadastrado!");
            }

            Fornecedor fornecedor = em.getReference(Fornecedor.class, cnpj);
            em.remove(fornecedor);
            em.getTransaction().commit();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void editarFornecedor(Fornecedor fornecedor) throws FornecedorInexistenteException {
        EntityManager em = null;
        Fornecedor f = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();

            if (!existsFornecedor(fornecedor.getCnpj())) {
                throw new FornecedorInexistenteException("O fornecedor com número de CNPJ: " + fornecedor.getCnpj() + " não esta cadastrado!");
            }

            f = em.getReference(Fornecedor.class, fornecedor.getCnpj());
            f.setEndereco(fornecedor.getEndereco());
            f.setNome(fornecedor.getNome());
            f.setTelefone(fornecedor.getTelefone());

            em.merge(f);

            // Não vejo a necessidade de rodar a linha abaixo, devido ao fato de que: NÃO É POSSÍVEL EDITAR LOCAÇÕES, ATRAVÉS DE UM CLIENTE.
            /**
             * c.setLocacoes(cliente.getLocacoes());*
             */
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Fornecedor> getAllFornecedores() {
        List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
        EntityManager em = null;

        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT c FROM Fornecedor c");
            fornecedores = q.getResultList();

        } finally {
            if (em != null) {
                em.close();
            }
        }

        return fornecedores;
    }

}
