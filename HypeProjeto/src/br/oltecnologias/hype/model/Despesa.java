package br.oltecnologias.hype.model;

import java.io.Serializable;

import java.text.NumberFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Despesa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String nome;
    private String observacao;
    
    @Temporal(TemporalType.DATE)
    private Calendar data;
    
    private double valor;
    
    private String emissor;

    private String favorecido;
    
    private String formaDePagamento;



    public Despesa(String nome, String observacao, Calendar data, double valor, String emissor, String favorecido) {
        this.nome = nome;
        this.observacao = observacao;
        this.data = data;
        this.valor = valor;
        this.emissor = emissor;
        this.favorecido = favorecido;
    }

    public Despesa() {
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getEmissor() {
        return emissor;
    }

    public void setEmissor(String emissor) {
        this.emissor = emissor;
    }
    
    public String getValorInString(){
        return NumberFormat.getCurrencyInstance().format(this.valor);
    }
    
    public String getFavorecido() {
        return favorecido;
    }

    public void setFavorecido(String favorecido) {
        this.favorecido = favorecido;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }
    
    
}
