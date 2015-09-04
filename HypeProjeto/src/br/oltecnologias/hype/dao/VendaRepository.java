/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.exception.VendaInexistenteException;
import br.oltecnologias.hype.model.Venda;
import java.util.List;

/**
 *
 * @author Odravison
 */
public interface VendaRepository {
    public void create(Venda venda);
    
    public Venda findById(long id) throws VendaInexistenteException;
    
    public boolean existsVenda(long id);
    
    public void removerVenda(long id)throws VendaInexistenteException;
    
    public void editarVenda(Venda venda) throws VendaInexistenteException;
    
    public List<Venda> getAllVendas();
}
