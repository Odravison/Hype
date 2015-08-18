package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.model.Venda;
import br.oltecnologias.hype.model.ProdutoDeVenda;
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

    public void realizarVenda(List<ProdutoDeVenda> produtos, float valor) {
        Venda venda = new Venda(produtos, valor);
        this.vendas.add(venda);
        

    }

    public List<Venda> listarVendas() {
        return this.vendas;
    }

    public void carregarVendas() {
        // Implementar método após definir banco de dados
    }

}
