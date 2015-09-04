/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.exception.FornecedorExistenteException;
import br.oltecnologias.hype.exception.FornecedorInexistenteException;
import br.oltecnologias.hype.model.Fornecedor;
import java.util.List;

/**
 *
 * @author Odravison
 */
public interface FornecedorRepository {
    
    public void create(Fornecedor fornecedor) throws FornecedorExistenteException;
    
    public Fornecedor findByCnpj(String id) throws FornecedorInexistenteException;
    
    public boolean existsFornecedor(String cnpj);
    
    public void removerFornecedor(String cnpj)throws FornecedorInexistenteException;
    
    public void editarFornecedor(Fornecedor fornecedor) throws FornecedorInexistenteException;
    
    public List<Fornecedor> getAllFornecedores();
    
}
