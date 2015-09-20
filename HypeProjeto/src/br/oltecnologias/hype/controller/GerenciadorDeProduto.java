package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.dao.ProdutoJpaRepository;
import br.oltecnologias.hype.exception.ProdutoExistenteException;
import br.oltecnologias.hype.model.Produto;
import java.util.ArrayList;
import java.util.List;
import br.oltecnologias.hype.exception.ProdutoInexistenteException;
import br.oltecnologias.hype.model.Fornecedor;
import br.oltecnologias.hype.model.Locacao;
import br.oltecnologias.hype.model.ProdutoLocado;
import br.oltecnologias.hype.model.ProdutoVendido;
import br.oltecnologias.hype.model.Venda;
import java.util.Calendar;
import java.util.Collections;
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

    public Produto cadastrarProduto(Produto produto) throws ProdutoExistenteException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ProdutoJpaRepository pjp = new ProdutoJpaRepository(emf);

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
    
    public void adicionarQuantidade(String codigoDoProduto, int quantidade) throws ProdutoInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ProdutoJpaRepository pjp = new ProdutoJpaRepository(emf);
        Produto p;

        try {
            p = pjp.findById(codigoDoProduto);
            p.addQuant(quantidade);
            pjp.editarProduto(p);
        } finally {
            emf.close();
        }
    }

    public List<Produto> getProdutosDeLocacao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ProdutoJpaRepository pjp = new ProdutoJpaRepository(emf);
        List<Produto> produtosLocaveis = new ArrayList<Produto>();
        try {

            for (Produto p : pjp.getAllProdutos()) {
                if (p.isLocation()) {
                    produtosLocaveis.add(p);
                }
            }
            return produtosLocaveis;
        } finally {
            emf.close();
        }

    }

    public List<Produto> getProdutosDeVenda() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ProdutoJpaRepository pjp = new ProdutoJpaRepository(emf);
        List<Produto> produtosDeVenda = new ArrayList<Produto>();
        try {

            for (Produto p : pjp.getAllProdutos()) {
                if (!p.isLocation()) {
                    produtosDeVenda.add(p);
                }
            }
            return produtosDeVenda;
        } finally {
            emf.close();
        }
    }

    public List<Produto> pesquisarProdutosDeLocacaoPeloNome(String nome) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ProdutoJpaRepository pjp = new ProdutoJpaRepository(emf);
        List<Produto> retorno = new ArrayList<Produto>();

        try {

            for (Produto p : pjp.getAllProdutos()) {
                if (p.isLocation()) {
                    if (p.getNome().contains(nome)) {
                        retorno.add(p);
                    }
                }
            }

            return retorno;

        } finally {
            if (emf != null) {
                emf.close();
            }
        }
    }

    public List<Produto> pesquisarProdutosDeVendaPeloNome(String nome) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ProdutoJpaRepository pjp = new ProdutoJpaRepository(emf);
        List<Produto> produtosDeVenda = new ArrayList<Produto>();
        try {

            for (Produto p : pjp.getAllProdutos()) {
                if (!p.isLocation()) {
                    if (p.getNome().contains(nome)) {
                        produtosDeVenda.add(p);
                    }

                }
            }
            return produtosDeVenda;
        } finally {
            emf.close();
        }
    }

    public List<Produto> LocadosPorNome(String nome) throws ProdutoInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ProdutoJpaRepository pjp = new ProdutoJpaRepository(emf);

        List<Produto> listaDeRetorno = new ArrayList<Produto>();

        try {

            for (Locacao l : GerenciadorDeLocacao.getInstance().getMostRecentLocation()) {
                for (ProdutoLocado pl : l.getProdutos()) {
                    Produto produto = GerenciadorDeProduto.getInstance().pesquisarProdutoPeloCodigo(pl.getCodigoProduto());
                    if (produto.getNome().toUpperCase().contains(nome.toUpperCase())) {
                        if (!listaDeRetorno.contains(produto)) {
                            listaDeRetorno.add(produto);
                        }
                    }
                }
            }
            return listaDeRetorno;

        } finally {
            emf.close();
        }
    }

    public List<Produto> pesquisarUltimosProdutosVendidosPorNome(String nome) throws ProdutoInexistenteException {

        List<Produto> listaDeRetorno = new ArrayList<Produto>();

            for (Venda v : GerenciadorDeVenda.getInstance().getMostRecentsSales()) {
                for (ProdutoVendido pv : v.getProdutosVendidos()) {
                    Produto produto = GerenciadorDeProduto.getInstance().pesquisarProdutoPeloCodigo(pv.getCodigoProduto());
                    if (produto.getNome().toUpperCase().contains(nome.toUpperCase())) {
                        if (!listaDeRetorno.contains(produto)) {
                            listaDeRetorno.add(produto);
                        }
                    }
                }
            }
            return listaDeRetorno;
    }

    public List<Produto> pesquisarUltimosProdutosLocadosPorData(Calendar data)
            throws ProdutoInexistenteException {

        List<Produto> listaDeRetorno = new ArrayList<Produto>();

            for (Locacao l : GerenciadorDeLocacao.getInstance().getMostRecentLocation()) {
                if ((l.getDataLocacao().get(Calendar.DAY_OF_YEAR) == data.get(Calendar.DAY_OF_YEAR))
                        && (l.getDataLocacao().get(Calendar.YEAR) == data.get(Calendar.YEAR))) {
                    for (ProdutoLocado pl : l.getProdutos()) {
                        Produto produto = GerenciadorDeProduto.getInstance()
                                .pesquisarProdutoPeloCodigo(pl.getCodigoProduto());
                        if (!listaDeRetorno.contains(produto)) {
                            listaDeRetorno.add(produto);
                        }
                    }
                }
            }
            return listaDeRetorno;
    }

    public List<Produto> pesquisarUltimosProdutosVendidosPorData(Calendar data)
            throws ProdutoInexistenteException {

        List<Produto> listaDeRetorno = new ArrayList<Produto>();

        for (Venda v : GerenciadorDeVenda.getInstance().getMostRecentsSales()) {
            if ((v.getDataVenda().get(Calendar.DAY_OF_YEAR) == data.get(Calendar.DAY_OF_YEAR))
                    && (v.getDataVenda().get(Calendar.YEAR) == data.get(Calendar.YEAR))) {
                for (ProdutoVendido pv : v.getProdutosVendidos()) {
                    Produto produto = GerenciadorDeProduto.getInstance()
                            .pesquisarProdutoPeloCodigo(pv.getCodigoProduto());
                    if (!listaDeRetorno.contains(produto)) {
                        listaDeRetorno.add(produto);
                    }
                }
            }
        }
        return listaDeRetorno;
    }

    public List<Produto> pesquisarUltimosProdutosLocados()
            throws ProdutoInexistenteException {

        List<Produto> listaDeRetorno = new ArrayList<Produto>();

        for (Locacao l : GerenciadorDeLocacao.getInstance().getMostRecentLocation()) {
                for (ProdutoLocado pl : l.getProdutos()) {
                    Produto produto = GerenciadorDeProduto.getInstance()
                            .pesquisarProdutoPeloCodigo(pl.getCodigoProduto());
                        listaDeRetorno.add(produto);
                }
        }
        return listaDeRetorno;

    }
    
    public List<Produto> pesquisarUltimosProdutosVendidos()
            throws ProdutoInexistenteException {

        List<Produto> listaDeRetorno = new ArrayList<Produto>();

        for (Venda v : GerenciadorDeVenda.getInstance().getMostRecentsSales()) {
                for (ProdutoVendido pl : v.getProdutosVendidos()) {
                    Produto produto = GerenciadorDeProduto.getInstance()
                            .pesquisarProdutoPeloCodigo(pl.getCodigoProduto());
                        listaDeRetorno.add(produto);
                }
        }
        return listaDeRetorno;

    }
    
    public List<Produto> pesquisarUltimosProdutosLocadosPorNome(String nome) throws ProdutoInexistenteException{
        List<Produto> listaDeRetorno = new ArrayList<Produto>();

            for (Locacao l : GerenciadorDeLocacao.getInstance().getMostRecentLocation()) {
                    for (ProdutoLocado pl : l.getProdutos()) {
                        Produto produto = GerenciadorDeProduto.getInstance()
                                .pesquisarProdutoPeloCodigo(pl.getCodigoProduto());
                        if (!listaDeRetorno.contains(produto) && produto.getNome().toUpperCase().equals(nome.toUpperCase())) {
                            listaDeRetorno.add(produto);
                        }
                    }
            }
            return listaDeRetorno;
    }

}
