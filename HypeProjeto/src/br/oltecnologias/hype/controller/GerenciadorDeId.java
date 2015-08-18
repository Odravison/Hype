/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.controller;

/**
 *
 * @author Odravison
 */
public class GerenciadorDeId {
    
    private static GerenciadorDeId singleton = null;
    private int idDeLocacao;
    private int idDeVenda;
    private int idDePessoa;
    
    private GerenciadorDeId() {
        this.idDeLocacao = 0;
        this.idDeVenda = 0;
        this.idDePessoa = 0;
        
    }
    
    public static GerenciadorDeId getInstance(){
        if (singleton == null){
            singleton = new GerenciadorDeId();
        }
        return singleton;
    }

    public int getIdDeLocacao() {
        idDeLocacao+=1;
        return idDeLocacao;
    }

    public int getIdDeVenda() {
        idDeVenda+=1;
        return idDeVenda;
    }

    public int getIdDePessoa() {
        idDePessoa +=1;
        return idDePessoa;
    }
    
    
}
