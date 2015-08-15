package br.oltecnologias.hype.model;

import java.util.List;

public class Fornecedor extends Pessoa {

    private String cnpj;
    private Endereco endereco;
    private List<String> telefones;

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

}
