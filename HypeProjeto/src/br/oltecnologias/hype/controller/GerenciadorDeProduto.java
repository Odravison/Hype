package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.model.Produto;
import java.util.ArrayList;
import java.util.List;
import br.oltecnologias.hype.exception.ProdutoInexistenteException;
import br.oltecnologias.hype.model.ProdutoDeLocacao;
import br.oltecnologias.hype.model.ProdutoDeVenda;

public class GerenciadorDeProduto {

    private List<ProdutoDeVenda> produtosDeVenda;
    private List<ProdutoDeLocacao> produtosDeLocacao;
    
    private static GerenciadorDeProduto singleton = null;

    private GerenciadorDeProduto() {
        this.produtosDeLocacao = new ArrayList<ProdutoDeLocacao>();
        this.produtosDeVenda = new ArrayList<ProdutoDeVenda>();
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
        return null;
    }

    /**
     *
     * @param codigo
     * @return
     * @throws br.oltecnologias.hype.exception.ProdutoInexistenteException
     */
    public Produto pesquisarProduto(String codigo) throws ProdutoInexistenteException {
        for (ProdutoDeVenda p : this.produtosDeVenda) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        
        for (ProdutoDeLocacao p : this.produtosDeLocacao) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        
        throw new ProdutoInexistenteException("Produto não cadastrado.");
    }
    
    public List<ProdutoDeVenda> getProdutosDeVenda() {
        return this.produtosDeVenda;
    }

    public List<ProdutoDeLocacao> getProdutosDeLocacao() {
        return produtosDeLocacao;
    }

    public void setProdutosDeLocacao(List<ProdutoDeLocacao> produtosDeLocacao) {
        this.produtosDeLocacao = produtosDeLocacao;
    }
    

}
