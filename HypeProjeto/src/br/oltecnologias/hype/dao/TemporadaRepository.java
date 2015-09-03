/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.exception.TemporadaExistenteException;
import br.oltecnologias.hype.exception.TemporadaInexistenteException;
import br.oltecnologias.hype.model.Temporada;

/**
 *
 * @author Odravison
 */
public interface TemporadaRepository {
    
    public void create(Temporada temporada) throws TemporadaExistenteException;
    
    public void edit(Temporada temporada) throws TemporadaInexistenteException;
    
    public void remove(long id) throws TemporadaInexistenteException;
    
    public Temporada getTemporada();
    
    
    
}
