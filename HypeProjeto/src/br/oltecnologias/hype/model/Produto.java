package br.oltecnologias.hype.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUTO")
public abstract class Produto implements Serializable {

    @Id
    private String codigo;
    private String nome;
    private float valor;
    private int quant;
    private int tam;
    
    @Column(name="FORNECEDOR", nullable=true)
    private String forcenedor;
    private String cor;

    public Produto() {
    }

    public Produto(String nome, float valor, int quant, String forcenedor, String cor, int tam) {
        this.nome = nome;
        this.valor = valor;
        this.quant = quant;
        this.tam = tam;
        this.forcenedor = forcenedor;
        this.cor = cor;
    }   
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.nome + " - Tam: " + this.tam + " " + this.cor + " - R$ " + this.valor;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public String getForcenedor() {
        return forcenedor;
    }

    public void setForcenedor(String forcenedor) {
        this.forcenedor = forcenedor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
       
    public void addQuant(int add) {
        this.quant += add;
    }
        
    public void removerQuant(int add){
        this.quant -= add;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }
}
