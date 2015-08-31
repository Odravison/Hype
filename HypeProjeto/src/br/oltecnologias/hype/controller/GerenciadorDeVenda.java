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

<<<<<<< HEAD
    public Venda realizarVenda(List<Produto> produtos, float valor, String formaPagamento, Calendar dataVenda, int parcelas, float entrada) {
=======
    public Venda realizarVenda(List<Produto> produtos, float valor, String formaPagamento, Calendar dataVenda, int parcelas, float entrada, int desconto) {
>>>>>>> 31c767a680c1e0e63ba2bd61a93aed21744e37d5
        
<<<<<<< HEAD
        Venda venda = new Venda(produtos, valor, formaPagamento, dataVenda, parcelas, entrada);
=======
        float valorFinal = valor - ((desconto * valor)/100);
        Venda venda = new Venda(produtos, valorFinal, formaPagamento, dataVenda, parcelas, entrada);
>>>>>>> 31c767a680c1e0e63ba2bd61a93aed21744e37d5
        this.vendas.add(venda);
        return venda;
    }

    public List<Venda> getVendas() {
        return this.vendas;
    }
}
