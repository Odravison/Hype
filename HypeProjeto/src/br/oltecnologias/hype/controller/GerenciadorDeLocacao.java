package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.dao.LocacaoJpaController;
import br.oltecnologias.hype.exception.ProdutoInexistenteException;
import br.oltecnologias.hype.exception.LocacaoInexistenteException;
import br.oltecnologias.hype.model.Locacao;
import br.oltecnologias.hype.model.Cliente;
import br.oltecnologias.hype.model.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerenciadorDeLocacao {

    private static GerenciadorDeLocacao singleton = null;
    private LocacaoJpaController locJpa = null;
    private EntityManagerFactory emf = null;

    private GerenciadorDeLocacao() {
    }

    public static GerenciadorDeLocacao getInstance() {
        if (singleton == null) {
            singleton = new GerenciadorDeLocacao();
        }
        return singleton;
    }

    public void realizarLocacaoSemEntrada(Cliente cliente, List<Produto> produtos, double valorLocacao,
            Calendar dataLocacao, Calendar dataDevolucao, float valor, String formaDePagamento) throws ProdutoInexistenteException, Exception {
        int produtosEmEstoque = 0;
        try {
            emf = Persistence.createEntityManagerFactory("hypepu");
            locJpa = new LocacaoJpaController(emf);
            
            Locacao locacao = new Locacao(cliente, produtos, valorLocacao, dataLocacao, dataDevolucao, formaDePagamento);
            cliente.getLocacoes().add(locacao);
            
            
            for (Produto p : produtos) {
                if (GerenciadorDeProduto.getInstance().pesquisarProduto(p.getCodigo()).getQuant() > 0){
                    GerenciadorDeProduto.getInstance().pesquisarProduto(p.getCodigo()).removerQuant(p.getQuant());
                    produtosEmEstoque += 1;
                }
            }
            if (produtos.size() > produtosEmEstoque){
                locJpa.create(locacao);
            }
            

        } finally {
            if (emf != null) {
                emf.close();
            }
        }
    }

    public List<Locacao> listarLocacoes() {
        emf = Persistence.createEntityManagerFactory("hypepu");
        locJpa = new LocacaoJpaController(emf);
        return locJpa.findLocacaoEntities();
    }

    public void finalizarLocacao(int idLoc, Cliente cliente) throws ProdutoInexistenteException, LocacaoInexistenteException {

        emf = Persistence.createEntityManagerFactory("hypepu");
        locJpa = new LocacaoJpaController(emf);
        boolean emprestou = false;
        
        try{
          for(Locacao locCliente: cliente.getLocacoes()){
              if (locCliente.getId() == idLoc){
                  
              }
          }
          
        }
        
        

        
        for (Locacao locacaoCliente : cliente.getLocacoes()) {
            if (locacaoCliente.getId() == idLoc) {
                for (Locacao locacaoGer : this.locacoes) {
                    if (locacaoGer.getId() == idLoc
                            && cliente.getCpf().equals(locacaoGer.getCliente().getCpf())) {
                        emprestou = true;
                        for (Produto p : locacaoGer.getProdutos()) {
                            GerenciadorDeProduto.getInstance().pesquisarProduto(p.getCodigo()).addQuant(p.getQuant());
                        }
                        cliente.removerLocacao(locacaoCliente);
                        this.locacoes.remove(locacaoGer);
                    }
                }
            }

        }

        if (!(emprestou)) {
            throw new LocacaoInexistenteException("O cliente não possui a locação referente.");
        }

    }

    public List<Locacao> listarLocacoesPorDataDeLocacao(Calendar data) {
        List<Locacao> aux = new ArrayList<Locacao>();
        for (Locacao l : this.locacoes) {
            if (l.getDataLocacao().equals(data)) {
                aux.add(l);
            }
        }
        return aux;
    }

    public List<Locacao> listarLocacoesPorDataDeDevolucao(Calendar data) {
        List<Locacao> aux = new ArrayList<Locacao>();
        for (Locacao l : this.locacoes) {
            if (l.getDataDevolucao().equals(data)) {
                aux.add(l);
            }
        }
        return aux;
    }

    public List<Locacao> listarLocacoesExtraviadas() {
        List<Locacao> extraviadas = new ArrayList<Locacao>();
        Calendar dataExtravio = Calendar.getInstance();
        dataExtravio.add(Calendar.DAY_OF_MONTH, -4);
        for (Locacao l : this.locacoes) {
            if (l.getDataDevolucao().before(dataExtravio)) {
                extraviadas.add(l);
            }
        }
        return extraviadas;
    }

    public List<Locacao> listarLocacoesEmAtraso() {
        List<Locacao> atrasos = new ArrayList<Locacao>();
        for (Locacao l : this.locacoes) {
            if (l.getDataDevolucao().before(Calendar.getInstance())) {
                atrasos.add(l);
            }
        }
        return atrasos;

    }

    public void carregarLocacoes() {
        // Metódo será implementado para quando.
    }
}
