/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.exception.ProdutoExistenteException;
import br.oltecnologias.hype.exception.ProdutoInexistenteException;
import br.oltecnologias.hype.model.Produto;
import java.util.List;

/**
 *
 * @author Odravison
 */
public interface ProdutoRepository {
    
    public void create(Produto produto)throws ProdutoExistenteException;
    
    public Produto findById(String codigo)throws ProdutoInexistenteException;
    
    public List<Produto> getAllProdutos();
    
    public void apagarProduto(String codigo) throws ProdutoInexistenteException;
    
    public void editarProduto(Produto p)throws ProdutoInexistenteException;
    
    public boolean existsCodigo(String codigo);
    
    
    
    
}
