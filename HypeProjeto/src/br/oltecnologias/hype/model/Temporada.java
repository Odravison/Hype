/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Odravison
 */
@Entity
public class Temporada implements Serializable {
    
    private boolean isAtivada;
    private int pertentualDeDesconto;
    
    @Id
    private long id;
    
    public Temporada() {
    }
    
    public static Temporada getInstance() {
        return TemporadaHolder.INSTANCE;
    }

    public void ativarTemporada(int percentualDesconto) {
        this.pertentualDeDesconto = percentualDesconto;
        this.isAtivada = true;
    }

    public void desativarTemporada() {
        this.isAtivada = false;
    }
    
    private static class TemporadaHolder {

        private static final Temporada INSTANCE = new Temporada();
    }

    public boolean isIsAtivada() {
        return isAtivada;
    }

    public void setIsAtivada(boolean isAtivada) {
        this.isAtivada = isAtivada;
    }

    public int getPertentualDeDesconto() {
        return pertentualDeDesconto;
    }

    public void setPertentualDeDesconto(int pertentualDeDesconto) {
        this.pertentualDeDesconto = pertentualDeDesconto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
}
