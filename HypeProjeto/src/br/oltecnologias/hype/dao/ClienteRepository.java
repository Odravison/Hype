/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.exception.ClienteExistenteException;
import br.oltecnologias.hype.exception.ClienteInexistenteException;
import br.oltecnologias.hype.model.Cliente;
import java.util.List;

/**
 *
 * @author Odravison
 */
public interface ClienteRepository {

    public void create(Cliente cliente) throws ClienteExistenteException;

    public Cliente findByCpf(String cpf) throws ClienteExistenteException, Exception;

    public boolean existsByCpf(String cpf);
    
    public List<Cliente> getAllClientes();
    
    public void removerCliente(String cpf) throws ClienteInexistenteException;
    
    public void editarCliente(Cliente cliente) throws ClienteInexistenteException;
    
    
}
