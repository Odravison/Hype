package br.oltecnologias.hype.model;

import javax.persistence.Entity;

@Entity
public class ProdutoDeVenda extends Produto {

    public ProdutoDeVenda() {
    }

    public ProdutoDeVenda(String nome, float valor, int quant, String forcenedor, String cor, int tam) {
        super(nome, valor, quant, forcenedor, cor, tam);
    }
    
    
    
    

}
