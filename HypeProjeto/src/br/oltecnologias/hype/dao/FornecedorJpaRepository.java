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
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Odravison
 */
public class FornecedorJpaRepository implements FornecedorRepository {

    public FornecedorJpaRepository(EntityManagerFactory emf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Fornecedor usuario) throws FornecedorExistenteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Fornecedor findById(String cnpj) throws FornecedorInexistenteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existsFornecedor(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerFornecedor(String cnpj) throws FornecedorInexistenteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarFornecedor(Fornecedor usuario) throws FornecedorInexistenteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Fornecedor> getAllFornecedores() throws FornecedorInexistenteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
