package br.oltecnologias.hype.model;

import java.util.List;

public class Empresa {

    private String cnpj;
    private String nome;
    private List<String> telefones;
    private Endereco endereco;

    public Empresa(String cnpj, String nome, List<String> telefones, Endereco endereco) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefones = telefones;
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
        
    public String telefoneToStringEmLista(){
        String lista = "";
        for (String s: this.telefones){
                    lista += s + "\n";
                }
        return lista;
    }
    
    public String telefoneToString(){
        String lista = "";
        for (String s: this.telefones){
                    lista += s + ", ";
        }
        return lista;
    }

}
