package br.oltecnologias.hype.model;

import java.util.List;

public class Fornecedor extends Pessoa {

    private String cnpj;
    private Endereco endereco;
    private List<String> telefones;
    
    public Fornecedor(String cnpj, Endereco end, List<String> telefones, String nome){
        super(nome);
        this.cnpj = cnpj;
        this.endereco = end;
        this.telefones = telefones;
    }
    
    public Fornecedor(){
        
    }

    @Override
    public String getDescricao() {
        return "CPJ: " + this.cnpj + "\n"
                + "Endereco: " + this.endereco.toString() + "\n "
                + "Telefones:  " + this.telefoneToStringEmLista();
    }
    
    public String telefoneToStringEmLista(){
        String telefones = "";
        for (String s: this.telefones){
                    telefones += s.toString() + "\n";
                }
        return telefones;
    }
    
    public String telefoneToString(){
        String telefones = "";
        for (String s: this.telefones){
                    telefones += s.toString() + ", ";
                }
        return telefones;
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

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }
}
