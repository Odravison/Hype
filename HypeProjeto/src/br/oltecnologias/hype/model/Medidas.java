package br.oltecnologias.hype.model;

public class Medidas {
    
    private String id;
    private int calca;
    private int traje;
    private int colete;
    private int camisa;
    private int gravata;
    private int sapato;
    private String observacao;

    public Medidas(int calca, int traje, int colete, int camisa, int gravata, int sapato, String observacao) {
        this.calca = calca;
        this.traje = traje;
        this.colete = colete;
        this.camisa = camisa;
        this.gravata = gravata;
        this.sapato = sapato;
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "Medidas{" + "calca=" + calca 
                + "\n traje=" + traje 
                + "\n colete=" + colete 
                + "\n camisa=" + camisa 
                + "\n gravata=" + gravata 
                + "\n sapato=" + sapato + '}';
    }
    
    

    public int getCalca() {
        return calca;
    }

    public void setCalca(int calca) {
        this.calca = calca;
    }

    public int getTraje() {
        return traje;
    }

    public void setTraje(int traje) {
        this.traje = traje;
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

    public int getGravata() {
        return gravata;
    }

    public void setGravata(int gravata) {
        this.gravata = gravata;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }        

}
