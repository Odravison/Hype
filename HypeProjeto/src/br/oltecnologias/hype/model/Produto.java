package br.oltecnologias.hype.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Produto implements Serializable {

    @Id
    private String codigo;
    private String nome;
    private double valor;
    private int quant;
    private int tam;
    
    @OneToOne
    private Fornecedor fornecedor;
    
    private String cor;
    private boolean isLocation;

    public Produto() {
    }

    public Produto(String codigo, String nome, double valor, int quant, Fornecedor fornecedor, String cor, int tam, boolean isLocation) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.quant = quant;
        this.tam = tam;
        this.fornecedor = fornecedor;
        this.cor = cor;
        this.isLocation = isLocation;
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
        return this.codigo + " | " + this.nome + " - Tam: " + this.tam + ", " + this.cor + " - R$ " + this.valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
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

    public void removerQuant(int add) {
        this.quant -= add;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }
    
    public boolean isIsLocation() {
        return isLocation;
    }

    public void setIsLocation(boolean isLocation) {
        this.isLocation = isLocation;
    }
    
    
}
