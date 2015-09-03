package br.oltecnologias.hype.model;

import java.io.Serializable;

import java.text.DecimalFormat;
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
<<<<<<< HEAD (cdf9800) - Versão Atualizada Odrav
    
    private String emissor;
=======
    private String favorecido;
>>>>>>> c35b25f688ad50bbcfe2a73d92d302a702c3a7d9

<<<<<<< HEAD (cdf9800) - Versão Atualizada Odrav
    private String favorecido;



    public Despesa(String nome, String observacao, Calendar data, double valor, String emissor, String favorecido) {
=======
    public Despesa(String nome, String observacao, Calendar data, double valor, String favorecido) {
>>>>>>> c35b25f688ad50bbcfe2a73d92d302a702c3a7d9
        this.nome = nome;
        this.observacao = observacao;
        this.data = data;
        this.valor = valor;
<<<<<<< HEAD (cdf9800) - Versão Atualizada Odrav
        this.emissor = emissor;
=======
>>>>>>> c35b25f688ad50bbcfe2a73d92d302a702c3a7d9
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
    
<<<<<<< HEAD (cdf9800) - Versão Atualizada Odrav
    public String getValorInString(){
=======
    public String getValorInString() {
>>>>>>> c35b25f688ad50bbcfe2a73d92d302a702c3a7d9
        return new DecimalFormat("#.##").format(this.valor);
    }
    
    public String getFavorecido() {
        return favorecido;
    }

    public void setFavorecido(String favorecido) {
        this.favorecido = favorecido;
    }
}
