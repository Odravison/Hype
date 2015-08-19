package br.oltecnologias.hype.model;

import java.util.List;
import javax.persistence.Entity;

@Entity(name = "VENDA")
public class Venda {
    
    private int id;
    private List<ProdutoDeVenda> produtos;
    private float valor;

    public Venda(List<ProdutoDeVenda> produtos, float valor) {
        this.produtos = produtos;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ProdutoDeVenda> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDeVenda> produtos) {
        this.produtos = produtos;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

}
