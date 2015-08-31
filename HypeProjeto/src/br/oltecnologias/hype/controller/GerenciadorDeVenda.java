package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.model.Produto;
import br.oltecnologias.hype.model.Venda;
import java.util.ArrayList;
import java.util.Calendar;
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

    public Venda realizarVenda(List<Produto> produtos, float valor, String formaPagamento, Calendar dataVenda, int parcelas, float entrada, int desconto) {
        
        float valorFinal = valor - ((desconto * valor)/100);
        Venda venda = new Venda(produtos, valorFinal, formaPagamento, dataVenda, parcelas, entrada);
        this.vendas.add(venda);
        return venda;
    }

    public List<Venda> getVendas() {
        return this.vendas;
    }
}
