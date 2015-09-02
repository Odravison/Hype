/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.exception.DespesaExistenteException;
import br.oltecnologias.hype.exception.DespesaInexistenteException;
import br.oltecnologias.hype.model.Despesa;

/**
 *
 * @author Odravison
 */
public interface DespesaRepository {
    
    public void create(Despesa despesa) throws DespesaExistenteException;
    
    public Despesa findById(long id) throws DespesaInexistenteException;
    
    public boolean existsDespesa(long id);
    
    public void removerDespesa(Despesa despesa)throws DespesaInexistenteException;
    
    public void editarDespesa(Despesa despesa) throws DespesaInexistenteException;
    
}
