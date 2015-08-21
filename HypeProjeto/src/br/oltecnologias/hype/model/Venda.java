package br.oltecnologias.hype.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="VENDA")
public class Venda implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    
    @OneToMany
    private List<Produto> produtos;
    
    private double valor;

    public Venda() {
    }

    /**
     *
     * @param produtos
     * @param valor
     */
    public Venda(List<Produto> produtos, double valor) {
        this.produtos = produtos;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
