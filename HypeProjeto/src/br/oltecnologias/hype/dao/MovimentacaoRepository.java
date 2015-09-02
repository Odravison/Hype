/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.exception.MovimentacaoExistenteException;
import br.oltecnologias.hype.exception.MovimentacaoInexistenteException;
import br.oltecnologias.hype.model.Movimentacao;

/**
 *
 * @author Odravison
 */
public interface MovimentacaoRepository {
    
    public void create(Movimentacao usuario) throws MovimentacaoExistenteException;
    
    public Movimentacao findById(long id) throws MovimentacaoInexistenteException;
    
    public boolean existsUsuario(long id);
    
    public void removerUsuario(Movimentacao usuario)throws MovimentacaoInexistenteException;
    
    public void editarUsuario(Movimentacao usuario) throws MovimentacaoInexistenteException;
    
}
