package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.dao.ProdutoJpaRepository;
import br.oltecnologias.hype.exception.ProdutoExistenteException;
import br.oltecnologias.hype.model.Produto;
import java.util.ArrayList;
import java.util.List;
import br.oltecnologias.hype.exception.ProdutoInexistenteException;
import br.oltecnologias.hype.model.Fornecedor;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerenciadorDeProduto {

    private static GerenciadorDeProduto singleton = null;

    private GerenciadorDeProduto() {
    }

    public static GerenciadorDeProduto getInstance() {
        if (singleton == null) {
            singleton = new GerenciadorDeProduto();
        }
        return singleton;
    }

    public Produto cadastrarProduto(String codigo, String nome, float valor,
            int quant, String fornecedor, String cor, int tamanho, boolean isLocation) throws ProdutoExistenteException, ProdutoInexistenteException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ProdutoJpaRepository pjp = new ProdutoJpaRepository(emf);

        Produto produto = new Produto(codigo, nome, valor, quant, fornecedor, cor, tamanho, isLocation);

        try {
            pjp.create(produto);
        } finally {
            emf.close();
        }

        return produto;
    }

    public void removerProduto(String codigo) throws ProdutoInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ProdutoJpaRepository pjp = new ProdutoJpaRepository(emf);

        try {
            pjp.apagarProduto(codigo);
        } finally {
            emf.close();
        }
    }

    public void editarProduto(Produto p) throws ProdutoInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ProdutoJpaRepository pjp = new ProdutoJpaRepository(emf);

        try {
            pjp.editarProduto(p);
        } finally {
            emf.close();
        }
    }

    public List<Produto> pesquisarProdutosPeloNome(String nome) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ProdutoJpaRepository pjp = new ProdutoJpaRepository(emf);

        List<Produto> aux = new ArrayList<Produto>();

        try {
            for (Produto p : pjp.getAllProdutos()) {
                if (p.getNome().toUpperCase().contains(nome.toUpperCase())) {
                    aux.add(p);
                }
            }
        } finally {
            emf.close();
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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ProdutoJpaRepository pjp = new ProdutoJpaRepository(emf);

        Produto pResult = null;

        try {
            for (Produto p : pjp.getAllProdutos()) {
                if (p.getCodigo().equals(codigo)) {
                    pResult = p;
                }
            }
        } finally {
            emf.close();
        }
        return pResult;
    }

    public List<Produto> getProdutos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ProdutoJpaRepository pjp = new ProdutoJpaRepository(emf);
        List<Produto> produtos = new ArrayList<Produto>();

        try {
            produtos = pjp.getAllProdutos();
        } finally {
            emf.close();
        }

        return produtos;
    }

    public void removerQuantidade(String codigoDoProduto, int quantidade) throws ProdutoInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ProdutoJpaRepository pjp = new ProdutoJpaRepository(emf);
        Produto p;

        try {
            p = pjp.findById(codigoDoProduto);
            p.removerQuant(quantidade);
            pjp.editarProduto(p);
        } finally {
            emf.close();
        }
    }
    
    
    //************************************FAZER OS SEGUINTES MÉTODOS**************************************************//
    //getProdutosDeLocacao();//Retorna uma lista com todos os produtos de locação cadastrados
    //pesquisarProdutosDeLocacaoPeloNome(String nome); //se o nome está contido no nome do produto
    
}
