package br.oltecnologias.hype.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medidas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_medidas")
    private long id;

    private int calca;
    private int colete;
    private int camisa;
    private int sapato;
    private String observacao;
    private int blazer;
    private int comprimentoManga;
    private int comprimentoCalca;

    public Medidas(int calca, int colete, int camisa, int sapato, int blazer, int comprimentoManga, int comprimentoCalca, String observacao) {
        this.calca = calca;
        this.colete = colete;
        this.camisa = camisa;
        this.sapato = sapato;
        this.observacao = observacao;
        this.blazer = blazer;
        this.comprimentoCalca = comprimentoCalca;
        this.comprimentoManga = comprimentoManga;
    }

    public Medidas() {

    }

    @Override
    public String toString() {
        return "Medidas{" + "\n Comp. Manga=" + comprimentoManga
                + "\n Comp. Calça=" + comprimentoCalca
                + "Tam. calça=" + calca
                + "\n Colete=" + colete
                + "\n Camisa=" + camisa
                + "\n Sapato=" + sapato + '}';
    }

    public int getCalca() {
        return calca;
    }

    public void setCalca(int calca) {
        this.calca = calca;
    }

    public int getComprimentoManga() {
        return comprimentoManga;
    }

    public void setComprimentoManga(int comprimentoManga) {
        this.comprimentoManga = comprimentoManga;
    }

    public int getComprimentoCalca() {
        return comprimentoCalca;
    }

    public void setComprimentoCalca(int comprimentoCalca) {
        this.comprimentoCalca = comprimentoCalca;
    }

    public int getColete() {
        return colete;
    }

    public void setColete(int colete) {
        this.colete = colete;
    }

    public int getCamisa() {
        return camisa;
    }

    public void setCamisa(int camisa) {
        this.camisa = camisa;
    }

    public int getSapato() {
        return sapato;
    }

    public void setSapato(int sapato) {
        this.sapato = sapato;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBlazer() {
        return blazer;
    }

    public void setBlazer(int blazer) {
        this.blazer = blazer;
    }
}
