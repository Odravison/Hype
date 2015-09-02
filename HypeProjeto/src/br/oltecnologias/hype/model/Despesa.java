package br.oltecnologias.hype.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Despesa implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String observacao;
    
    @Temporal(TemporalType.DATE)
    private Calendar data;
    private double valor;
    private String favorecido;

    public Despesa(String nome, String observacao, Calendar data, double valor, String favorecido) {
        this.nome = nome;
        this.observacao = observacao;
        this.data = data;
        this.valor = valor;
        this.favorecido = favorecido;
    }

    public Despesa() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    
    public String getValorInString() {
        return new DecimalFormat("#.##").format(this.valor);
    }
    
    public String getFavorecido() {
        return favorecido;
    }

    public void setFavorecido(String favorecido) {
        this.favorecido = favorecido;
    }
}
