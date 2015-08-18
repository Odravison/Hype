package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.model.Venda;
import br.oltecnologias.hype.model.Produto;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeVenda {

    private List<Venda> vendas;
    private static GerenciadorDeVenda singleton = null;
    
    private GerenciadorDeVenda(){
        vendas = new ArrayList<Venda>();
        
    }
    public static GerenciadorDeVenda getInstance(){
        if (singleton == null){
            singleton = new GerenciadorDeVenda();
        }
        return singleton;
    }

    public void realizarVenda(List<Produto> produtos, float valor) {

    }

    public List<Venda> listarVendas() {
        return null;
    }

    public void carregarVendas() {

    }

}
