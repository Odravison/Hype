package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.model.Produto;
import java.util.ArrayList;
import java.util.List;
import br.oltecnologias.hype.exception.ProdutoInexistenteException;

public class GerenciadorDeProduto {

    private List<Produto> produtos;
    
    private static GerenciadorDeProduto singleton = null;

    private GerenciadorDeProduto() {
        this.produtos = new ArrayList<Produto>();
    }

    public static GerenciadorDeProduto getInstance() {
        if (singleton == null) {
            singleton = new GerenciadorDeProduto();
        }
        return singleton;
    }

    public void cadastrarProduto(String nome, String descricao, float valor,
            int quant, String fornecedor, String cor) {
        // Será implementado quando decidirmos o sistema de código

    }

    public void editarProduto(String codigo, String nome, int tam,
            float valor, String fornecedor, String cor) {
        try {
            Produto p = pesquisarProduto(codigo);
            p.setCor(cor);
            p.setTam(tam);
            p.setForcenedor(fornecedor);
            p.setNome(nome);
            p.setValor(valor);
            
        }catch(ProdutoInexistenteException e){
            e.getMessage();
        }
    }

    public List<Produto> pesquisarProdutosPeloNome(String nome) {
        List<Produto> aux = new ArrayList<Produto>();
        for (Produto p: this.produtos){
            if (p.getNome().contains(nome)){
                aux.add(p);
            }
        }
        return aux;
    }

    /**
     *
     * @param codigo
     * @return
     * @throws br.oltecnologias.hype.exception.ProdutoInexistenteException
     */
    public Produto pesquisarProduto(String codigo) throws ProdutoInexistenteException {
        for (Produto p : this.produtos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        
        throw new ProdutoInexistenteException("Produto não cadastrado.");
    }

    public List<Produto> getProdutosDeLocacao() {
        return produtos;
    }

    public void setProdutosDeLocacao(List<Produto> produtos) {
        this.produtos = produtos;
    }
    

}
