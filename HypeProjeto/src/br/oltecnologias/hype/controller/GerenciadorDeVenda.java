package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.model.Produto;
import br.oltecnologias.hype.model.ProdutoVendido;
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

    public Venda realizarVenda(List<ProdutoVendido> produtos, double valor, String formaPagamento, 
            Calendar dataVenda, int parcelas, double entrada, int desconto) {
        
<<<<<<< HEAD (cdf9800) - Versão Atualizada Odrav
        double valorFinal = valor - ((desconto * valor)/100);

        Venda venda = new Venda(produtos, valorFinal, formaPagamento, dataVenda, parcelas, entrada, desconto);

=======
        Venda venda = new Venda(produtos, valor, formaPagamento, dataVenda, parcelas, entrada, percentualDesconto);
>>>>>>> c35b25f688ad50bbcfe2a73d92d302a702c3a7d9
        this.vendas.add(venda);
        return venda;
    }

    public List<Venda> getVendas() {
        return this.vendas;
    }
}
