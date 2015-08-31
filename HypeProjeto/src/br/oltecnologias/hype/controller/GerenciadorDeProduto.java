package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.dao.ProdutoJpaRepository;
import br.oltecnologias.hype.model.Produto;
import java.util.ArrayList;
import java.util.List;
import br.oltecnologias.hype.exception.ProdutoInexistenteException;
import br.oltecnologias.hype.model.Fornecedor;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerenciadorDeProduto {

    private List<Produto> produtos;
    private ProdutoJpaRepository pjp;
    
    private EntityManagerFactory emf;
    
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
    
    public void removerProduto(String codigo) throws ProdutoInexistenteException {
        this.produtos.remove(pesquisarProdutoPeloCodigo(codigo));
    }

    public void editarProduto(String codigo, String nome, int tam,
            float valor, String fornecedor, String cor) {
        try {
            Produto p = pesquisarProdutoPeloCodigo(codigo);
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
    public Produto pesquisarProdutoPeloCodigo(String codigo) throws ProdutoInexistenteException {
<<<<<<< HEAD
        emf = Persistence.createEntityManagerFactory("closetpu");
        pjp = new ProdutoJpaRepository (emf);
        
        Produto p = null;
        p = pjp.findById(codigo);
        return p;
        
        
//        for (Produto p : this.produtos) {
//            if (p.getCodigo().equals(codigo)) {
//                return p;
//            }
//        }
//        throw new ProdutoInexistenteException("Produto não cadastrado.");
=======
        for (Produto p : this.produtos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        throw new ProdutoInexistenteException("Produto não cadastrado.");
>>>>>>> 31c767a680c1e0e63ba2bd61a93aed21744e37d5
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
