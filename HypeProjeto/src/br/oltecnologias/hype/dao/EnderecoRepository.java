/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.model.Endereco;

/**
 *
 * @author Odravison
 */
public interface EnderecoRepository {
    public void create(Endereco endereco);
    
    public Endereco findById(int id);
}
