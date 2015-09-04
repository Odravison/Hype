/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.model.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.oltecnologias.hype.exception.ClienteExistenteException;
import br.oltecnologias.hype.exception.ClienteInexistenteException;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Odravison
 */
public class ClienteJpaRepository implements ClienteRepository {

    final static private Logger logger = LoggerFactory.getLogger(ClienteJpaRepository.class);
    private EntityManagerFactory emf = null;

    public ClienteJpaRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(Cliente cliente) throws ClienteExistenteException {
        logger.info("cliente adicionado {}", cliente);
        EntityManager em = null;
        try {

            em = getEntityManager();
            em.getTransaction().begin();
            if (existsByCpf(cliente.getCpf())) {
                throw new ClienteExistenteException("Cliente com CPF já existe.");
            }

            em.persist(cliente);
            em.getTransaction().commit();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Cliente findByCpf(String cpf) throws ClienteInexistenteException {
        logger.info("find by cpf {}", cpf);
        EntityManager em = null;
        Cliente result = null;

        try {
            em = getEntityManager();

            if (!existsByCpf(cpf)) {
                throw new ClienteInexistenteException("Cliente com cpf: " + cpf + " não foi cadastrado");
            }
            Query query = em.createQuery("FROM Cliente WHERE id_cliente = ?", Cliente.class);
            query.setParameter(1, cpf);
            query.setMaxResults(1);

            result = (Cliente) query.getSingleResult();
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return result;
    }

    @Override
    public boolean existsByCpf(String cpf) {
        logger.info("existe com cpf {}", cpf);
        Object result = null;
        EntityManager em = null;

        try {
            em = getEntityManager();
            Query query = em.createQuery("SELECT 1 FROM Cliente WHERE id_cliente = ?");
            query.setParameter(1, cpf);
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
    public List<Cliente> getAllClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        EntityManager em = null;

        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT c FROM Cliente c");
            clientes = q.getResultList();

        } finally {
            if (em != null) {
                em.close();
            }
        }

        return clientes;

    }

    @Override
    public void removerCliente(String cpf) throws ClienteInexistenteException {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            if (!existsByCpf(cpf)) {
                throw new ClienteInexistenteException("Cliente com CPF: " + cpf + " não foi cadastrado!");
            }

            Cliente cliente = em.getReference(Cliente.class, cpf);
            em.remove(cliente);
            em.getTransaction().commit();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void editarCliente(Cliente cliente) throws ClienteInexistenteException {
        EntityManager em = null;
        Cliente c = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();

            if (!existsByCpf(cliente.getCpf())) {
                throw new ClienteInexistenteException("O cliente com o número de CPF: " + cliente.getCpf() + " não esta cadastrado!");
            }
            
            c = em.getReference(Cliente.class, cliente.getCpf());
            c.setCelular(cliente.getCelular());
            c.setEndereco(cliente.getEndereco());
            c.setMedidas(cliente.getMedidas());
            c.setNome(cliente.getNome());
            c.setTelefone(cliente.getTelefone());
            c.setDataCadastro(cliente.getDataCadastro());
            c.setLocacoes(cliente.getLocacoes());
            
            em.merge(c);

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
}
