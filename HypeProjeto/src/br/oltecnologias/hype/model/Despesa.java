package br.oltecnologias.hype.model;

import java.util.Calendar;

public class Despesa {

	private int id;
	private String nome;
	private String observacao;
	private Calendar data;
        private float valor;

    public Despesa(String nome, String observacao, Calendar data, float valor) {
        this.nome = nome;
        this.observacao = observacao;
        this.data = data;
        this.valor = valor;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
        
    

}
