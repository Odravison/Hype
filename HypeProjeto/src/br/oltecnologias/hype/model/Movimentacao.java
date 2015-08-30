/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Luender Lima
 */
public class Movimentacao {
    
    private long id;
    private String movimento;
    private String valor;
    private Calendar data;
    private Usuario responsavel;
    private String beneficiario;

    public Movimentacao(String movimento, String valor, Calendar data, Usuario responsavel, String beneficiario) {
        this.movimento = movimento;
        this.valor = valor;
        this.data = data;
        this.responsavel = responsavel;
        this.beneficiario = beneficiario;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
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
    
}
