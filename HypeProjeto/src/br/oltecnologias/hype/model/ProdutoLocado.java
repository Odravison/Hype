/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Odravison
 */
@Entity
public class ProdutoLocado implements Serializable {

    
    @Id
    @GeneratedValue
    private long id;
    
    private String codigoProduto;
    
    private int quantidade;

    public ProdutoLocado(String codigoProduto, int quantidade) {
        this.codigoProduto = codigoProduto;
        this.quantidade = quantidade;
    }

    public ProdutoLocado() {
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
    
}
