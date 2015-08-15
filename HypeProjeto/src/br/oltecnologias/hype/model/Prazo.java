package br.oltecnologias.hype.model;

import java.util.Calendar;

public class Prazo {

    private Calendar dataLocacao;
    private Calendar dataDevolucao;

    public Prazo(Calendar dataLocacao, Calendar dataDevolucao) {
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
    }

    public Calendar getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Calendar dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Calendar getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Calendar dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
    

}
