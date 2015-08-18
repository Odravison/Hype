package br.oltecnologias.hype.controller;


import br.oltecnologias.hype.model.Produto;
import java.util.ArrayList;
import java.util.List;
import br.oltecnologias.hype.exceptions.ProdutoInexistenteException;

public class GerenciadorDeProduto {

    private List<Produto> produtos;
    private static GerenciadorDeProduto singleton = null;

    private GerenciadorDeProduto() {
        produtos = new ArrayList<Produto>();
    }
    
    public static GerenciadorDeProduto getInstance(){
        if (singleton == null){
            singleton = new GerenciadorDeProduto();
        }
        return singleton;
    }

    public void cadastrarProduto(String nome, String descricao, float valor, int quant, String fornecedor, String cor) {

    }

    public void editarProduto(String nome, String descricao, float valro, int quant, String fornecedor, String cor) {

    }

    public List<Produto> pesquisarProdutosPeloNome(String nome) {
        return null;
    }

    /**
     *
     * @param codigo
     * @return
     */
    public Produto pesquisarProduto(String codigo) throws ProdutoInexistenteException {
        for (Produto p: this.produtos){
            if (p.getCodigo().equals(codigo)){
                return p;
            }
        }
        throw new ProdutoInexistenteException ("Produto não cadastrado.");
    }

    public List<Produto> listarProdutos() {
        return null;
    }

    public void carregarProdutos() {

    }
    
    public List<Produto> getProdutos(){
        return this.produtos;
    }

}
