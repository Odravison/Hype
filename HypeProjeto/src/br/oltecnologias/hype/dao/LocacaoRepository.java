/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.exception.LocacaoExistenteException;
import br.oltecnologias.hype.exception.LocacaoInexistenteException;
import br.oltecnologias.hype.model.Locacao;
import br.oltecnologias.hype.model.Produto;
import java.util.List;

/**
 *
 * @author Odravison
 */
public interface LocacaoRepository {
    
    public void create(Locacao locacao) throws LocacaoExistenteException;
    
    public Locacao findById(long id) throws LocacaoInexistenteException;
    
    public boolean existsLocacao(long id);
    
    public void removerLocacao(Locacao locacao)throws LocacaoInexistenteException;
    
    public void editarLocacao(Locacao locacao) throws LocacaoInexistenteException;
    
    public List<Locacao> getAllLocacao();
    
    public List<Locacao> getLocacaoByCliente(String idCliente);
    
    public List<Produto> getProdutosFromLocacao(long idLocacao) throws LocacaoInexistenteException;
    
}
