/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.exception.MovimentacaoExistenteException;
import br.oltecnologias.hype.exception.MovimentacaoInexistenteException;
import br.oltecnologias.hype.model.Movimentacao;
import java.util.List;

/**
 *
 * @author Odravison
 */
public interface MovimentacaoRepository {
    
    public void create(Movimentacao movimentacao);
    
    public Movimentacao findById(long id) throws MovimentacaoInexistenteException;
    
    public boolean existsMovimentacao(long id);
    
    public void removerMovimentacao(long id) throws MovimentacaoInexistenteException;
    
    public void editarMovimentacao(Movimentacao movimentacao) throws MovimentacaoInexistenteException;
    
    public long getIdDaOperacao(long idMovimentacao) throws MovimentacaoInexistenteException;
    
    public List<Movimentacao> getAllMovimentacoes();
    
}
