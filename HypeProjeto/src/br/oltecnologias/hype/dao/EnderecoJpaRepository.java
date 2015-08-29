/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.model.Endereco;
import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Odravison
 */
public class EnderecoJpaRepository implements EnderecoRepository {

    final static private Logger logger = LoggerFactory.getLogger(EnderecoJpaRepository.class);

    private EntityManager entityManager;

    public EnderecoJpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(Endereco endereco) {
        logger.info("add endereco {}", endereco);

        entityManager.getTransaction().begin();
        entityManager.persist(endereco);
        entityManager.getTransaction().commit();
    }

    @Override
    public Endereco findById(int id) {
        logger.info("find by id {}", id);

        return entityManager.find(Endereco.class, id);
    }

}
