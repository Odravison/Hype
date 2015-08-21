package br.oltecnologias.hype.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("2")
public class Fornecedor extends Pessoa {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fornecedor_id_cnpj")
    private String cnpj;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fornecedor_id_endereco")
    private Endereco endereco;
    private String telefone;

    public Fornecedor(String cnpj, Endereco end, String telefones, String nome) {
        super(nome);
        this.cnpj = cnpj;
        this.endereco = end;
        this.telefone = telefone;
    }

    public Fornecedor() {

    }

    @Override
    public String getDescricao() {
        return "CPJ: " + this.cnpj + "\n"
                + "Endereco: " + this.endereco.toString() + "\n "
                + "Telefone:  " + this.telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
