package br.oltecnologias.hype.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_endereco")
    private int id;
    private String rua;
    private String bairro;
    private String uf;
    private int numeroCasa;
    private String cidade;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    
    @OneToOne
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;
    
    @OneToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;
    
    

    public Endereco() {
    }

    public Endereco(String rua, String bairro, String uf, int numeroCasa, String cidade) {
        this.rua = rua;
        this.bairro = bairro;
        this.uf = uf;
        this.numeroCasa = numeroCasa;
        this.cidade = cidade;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        String endereco = this.rua + ", " + this.numeroCasa + " - " + this.bairro + ", " + this.cidade + ", " + this.uf;

        return endereco;
    }
}
