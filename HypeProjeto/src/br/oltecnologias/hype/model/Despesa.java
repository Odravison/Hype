package br.oltecnologias.hype.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    public Despesa(String nome, String observacao, Calendar data, double valor) {
        this.nome = nome;
        this.observacao = observacao;
        this.data = data;
        this.valor = valor;
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

}
