package br.oltecnologias.hype.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_endereco")
    private long id;
    private String rua;
    private String bairro;
    private String uf;
    private int numeroCasa;
    private String cidade;
    private String cep = null;

    public Endereco() {
    }

    public Endereco(String rua, String bairro, String uf, int numeroCasa, String cidade) {
        this.rua = rua;
        this.bairro = bairro;
        this.uf = uf;
        this.numeroCasa = numeroCasa;
        this.cidade = cidade;
    }
    
    public Endereco(String rua, String bairro, String uf, int numeroCasa, String cidade, String cep) {
        this.rua = rua;
        this.bairro = bairro;
        this.uf = uf;
        this.numeroCasa = numeroCasa;
        this.cidade = cidade;
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String endereco = this.rua + ", " + this.numeroCasa + " - " + this.bairro + ", " + this.cidade + ", " + this.uf;

        return endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
