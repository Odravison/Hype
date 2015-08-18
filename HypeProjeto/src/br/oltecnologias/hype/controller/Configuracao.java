package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.model.Endereco;
import br.oltecnologias.hype.model.Empresa;
import java.util.List;

public class Configuracao {

    private Empresa empresa = null;
    private int horasEmprestimo = 0;
    private String diretorioDeContratos = null;
    private String diretorioDeBackup = null;
    private static Configuracao singleton = null;
    
    private Configuracao(){
        
    }
    
    public static Configuracao getInstance(){
        if (singleton == null){
            singleton = new Configuracao();
        }
        return singleton;
    }

    public void cadastrarEmpresa(String CNPJ, String nome, List<String> telefones, Endereco endereco) {

    }

    public void editarEmpresa(String CNPJ, String nome, List<String> telefones, Endereco endereco) {

    }

}
