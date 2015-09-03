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
    private Long Id;
    

    public Temporada() {
    }
    

    public boolean isAtivada() {
        return this.isAtivada;
    }

    public void desativarTemporada() {
        this.isAtivada = false;
        this.pertentualDeDesconto = 0;
    }

    public void ativarTemporada(int percentualDesconto) {
        this.isAtivada = true;
        this.pertentualDeDesconto = percentualDesconto;
    }

    public int getPertentualDeDesconto() {
        return pertentualDeDesconto;
    }

    public void setPertentualDeDesconto(int pertentualDeDesconto) {
        this.pertentualDeDesconto = pertentualDeDesconto;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public void setIsAtivada(boolean isAtivada) {
        this.isAtivada = isAtivada;
    }

   
    
    
    
    
    
    
    
}
