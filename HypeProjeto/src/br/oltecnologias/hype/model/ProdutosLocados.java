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
public class ProdutosLocados implements Serializable {

    
    @Id
    private String id;
    
    private int quantidade;

    public ProdutosLocados(String id, int quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public ProdutosLocados() {
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
