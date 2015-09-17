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
    
    private boolean isAtivadaDeLocacao;
    private boolean isAtivadaDeVenda;
    private int percentualDeDescontoDeVenda;
    private int percentualDeDescontoDeLocacao;
    
    @Id
    private long id;
    
    public Temporada() {
    }
    
    public static Temporada getInstance() {
        return TemporadaHolder.INSTANCE;
    }

    public void ativarTemporadaDeVenda(int percentualDesconto) {
        this.percentualDeDescontoDeVenda = percentualDesconto;
        this.isAtivadaDeVenda = true;
    }

    public void desativarTemporadaDeVenda() {
        this.isAtivadaDeVenda = false;
    }
    
    public void ativarTemporadaDeLocacao(int percentualDesconto) {
        this.percentualDeDescontoDeLocacao = percentualDesconto;
        this.isAtivadaDeLocacao = true;
    }

    public void desativarTemporadaDeLocacao() {
        this.isAtivadaDeLocacao = false;
    }
    
    private static class TemporadaHolder {

        private static final Temporada INSTANCE = new Temporada();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isIsAtivadaDeLocacao() {
        return isAtivadaDeLocacao;
    }

    public void setIsAtivadaDeLocacao(boolean isAtivadaDeLocacao) {
        this.isAtivadaDeLocacao = isAtivadaDeLocacao;
    }

    public boolean isIsAtivadaDeVenda() {
        return isAtivadaDeVenda;
    }

    public void setIsAtivadaDeVenda(boolean isAtivadaDeVenda) {
        this.isAtivadaDeVenda = isAtivadaDeVenda;
    }

    public int getPercentualDeDescontoDeVenda() {
        return percentualDeDescontoDeVenda;
    }

    public void setPercentualDeDescontoDeVenda(int percentualDeDescontoDeVenda) {
        this.percentualDeDescontoDeVenda = percentualDeDescontoDeVenda;
    }

    public int getPercentualDeDescontoDeLocacao() {
        return percentualDeDescontoDeLocacao;
    }

    public void setPercentualDeDescontoDeLocacao(int percentualDeDescontoDeLocacao) {
        this.percentualDeDescontoDeLocacao = percentualDeDescontoDeLocacao;
    }
    
    
}
