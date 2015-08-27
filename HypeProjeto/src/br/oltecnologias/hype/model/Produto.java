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
    private int quantidade;
    private int tam;
    
    private String fornecedor; //Deveria ser do tipo Fornecedor
    
    private String cor;
    private boolean isLocation;

    public Produto() {
    }

    public Produto(String codigo, String nome, double valor, int quantidade, String fornecedor, String cor, int tam, boolean isLocation) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
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
        return this.nome + ", " + this.cor + " - Tam: " + this.tam + " - R$ " + this.valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void addQuant(int add) {
        this.quantidade += add;
    }

    public void removerQuant(int add) {
        this.quantidade -= add;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }
    
    public boolean isLocation() {
        return isLocation;
    }

    public void setIsLocation(boolean isLocation) {
        this.isLocation = isLocation;
    }
    
    public String getFinalidade() {
        if(isLocation)
            return "Locação";
        else
            return "Venda";
    }

}
