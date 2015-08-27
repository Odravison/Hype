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
    
    public Produto cadastrarProduto(String codigo, String nome, float valor,
            int quant, String fornecedor, String cor, int tamanho, boolean isLocation) {
        
        Produto produto = new Produto(codigo, nome, valor, quant, fornecedor, cor, tamanho, isLocation);
        this.produtos.add(produto);
        return produto;
    }

    public void editarProduto(String codigo, String nome, int tam,
            float valor, String fornecedor, String cor) {
        try {
            Produto p = pesquisarProduto(codigo);
            p.setCor(cor);
            p.setTam(tam);
            p.setFornecedor(fornecedor);
            p.setNome(nome);
            p.setValor(valor);
            
        }catch(ProdutoInexistenteException e){
            e.getMessage();
        }
    }

    public List<Produto> pesquisarProdutosPeloNome(String nome) {
        List<Produto> aux = new ArrayList<Produto>();
        for (Produto p: this.produtos){
            if (p.getNome().toUpperCase().contains(nome.toUpperCase())){
                aux.add(p);
            }
        }
        return aux;
    }
      
    public List<Produto> pesquisarProdutosDeLocacaoPeloNome(String nome) {
        List<Produto> aux = new ArrayList<Produto>();
        for (Produto p: this.produtos){
            if (p.isLocation() && p.getNome().toUpperCase().contains(nome.toUpperCase())){
                aux.add(p);
            }
        }
        return aux;
    }
    
    public List<Produto> pesquisarProdutosDeVendaPeloNome(String nome) {
        List<Produto> aux = new ArrayList<Produto>();
        for (Produto p: this.produtos){
            if (!p.isLocation() && p.getNome().toUpperCase().contains(nome.toUpperCase())){
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
        List<Produto> produtosDeLocacao = new ArrayList<Produto>();
        for(Produto produto: this.produtos) {
            if(produto.isLocation()) {
                produtosDeLocacao.add(produto);
            }
        }
        return produtosDeLocacao;
    }
    
    public List<Produto> getProdutosDeVenda() {
        List<Produto> produtosDeVenda = new ArrayList<Produto>();
        for(Produto produto: this.produtos) {
            if(!produto.isLocation()) {
                produtosDeVenda.add(produto);
            }
        }
        return produtosDeVenda;
    }

    public void setProdutosDeLocacao(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public List<Produto> getProdutos() {
        return produtos;
    }

}
