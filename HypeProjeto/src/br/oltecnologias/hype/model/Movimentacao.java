/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.model;

import java.io.Serializable;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Luender Lima
 */

@Entity
public class Movimentacao implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private long idDaOperacao;
    
    private String movimento;
    
    private double valor;
    
    
    @Temporal(TemporalType.DATE)
    private Calendar data;
    
    private String responsavel;
    
    private String beneficiario;

    public Movimentacao(String movimento, double valor, Calendar data, String responsavel, String beneficiario, long idDaOperacao) {
        this.movimento = movimento;
        this.valor = valor;
        this.data = data;
        this.responsavel = responsavel;
        this.beneficiario = beneficiario;
        this.idDaOperacao = idDaOperacao;
    }
    
    public Movimentacao() {
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getMovimento() {
        return movimento;
    }

    public void setMovimento(String movimento) {
        this.movimento = movimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }
    
    public String getDataInString() {
        return new SimpleDateFormat("dd/MM/yyyy").format(this.data.getTime());
    }
    
    public String getValorInString() {
        return new DecimalFormat("#.##").format(this.valor);
    }

    public long getIdDaOperacao() {
        return idDaOperacao;
    }

    public void setIdDaOperacao(long idDaOperacao) {
        this.idDaOperacao = idDaOperacao;
    }
    
    public String getMovToString(){        
        String mov = getDataInString() + "     " + getMovimento() + "     " + getResponsavel() + "     " + getValorInString();
        return mov;
        
        
    }
}
