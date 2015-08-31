package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.dao.ClienteJpaRepository;
import br.oltecnologias.hype.dao.LocacaoJpaRepository;
import br.oltecnologias.hype.exception.ClienteInexistenteException;
import br.oltecnologias.hype.exception.ProdutoInexistenteException;
import br.oltecnologias.hype.exception.LocacaoInexistenteException;
import br.oltecnologias.hype.model.Locacao;
import br.oltecnologias.hype.model.Cliente;
import br.oltecnologias.hype.model.Configuracao;
import br.oltecnologias.hype.model.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerenciadorDeLocacao {

    private List<Locacao> locacoes;
    private static GerenciadorDeLocacao singleton = null;
    
    private LocacaoJpaRepository ljp;
    private ClienteJpaRepository cjp;
    
    private EntityManagerFactory emf;
    private EntityManagerFactory emfPessoas;

    private GerenciadorDeLocacao() {
        locacoes = new ArrayList<Locacao>();
    }

    public static GerenciadorDeLocacao getInstance() {
        if (singleton == null) {
            singleton = new GerenciadorDeLocacao();
        }
        return singleton;
    }

    public Locacao realizarLocacao(Cliente cliente, List<Produto> produtos, float valor, Calendar dataLocacao, 
            Calendar dataDeDevolucao, String formaDePagamento, int parcelas, float entrada, int desconto) throws ProdutoInexistenteException {
        
        float valorFinal = valor - ((desconto * valor)/100);
        Locacao locacao = new Locacao(cliente, produtos, valorFinal, dataLocacao, dataDeDevolucao, formaDePagamento, parcelas, entrada);
        cliente.adicionarLocacao(locacao);
        this.locacoes.add(locacao);
        for (Produto p: produtos){
            GerenciadorDeProduto.getInstance().pesquisarProdutoPeloCodigo(p.getCodigo()).removerQuant(p.getQuantidade());
        }
        return locacao;
    }

    public List<Locacao> getLocacoes() {
        emf = Persistence.createEntityManagerFactory("closetpu");
        ljp = new LocacaoJpaRepository(emf);
        
        return ljp.getAllLocacao();
    }

    public void finalizarLocacao(int idLoc, Cliente cliente) throws ProdutoInexistenteException, LocacaoInexistenteException, ClienteInexistenteException {
        emf = Persistence.createEntityManagerFactory("closetpu");
        ljp = new LocacaoJpaRepository(emf);
        
        
        boolean emprestou = false;
        
        for (Locacao locacaoCliente : ljp.getLocacaoByCliente(cliente.getCpf())) {
            if (locacaoCliente.getId() == idLoc) {
                for (Locacao locacaoGer : ljp.getAllLocacao()) {
                    if (locacaoGer.getId() == idLoc
                            && cliente.getCpf().equals(locacaoGer.getCliente().getCpf())) {
                        emprestou = true;
                        for (Produto p : locacaoGer.getProdutos()) {
<<<<<<< HEAD
                            System.out.println("===============>>>>> " + p.getCodigo());
=======

>>>>>>> 31c767a680c1e0e63ba2bd61a93aed21744e37d5
                            GerenciadorDeProduto.getInstance().pesquisarProdutoPeloCodigo(p.getCodigo()).addQuant(p.getQuantidade());
                        }
                        cliente.removerLocacao(locacaoCliente);
                        cjp.editarCliente(cliente);
                        
//                        this.locacoes.remove(locacaoGer);
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
        for(Locacao l: this.locacoes){
            if (l.getDataLocacao().equals(data)){
                aux.add(l);
            }
        }
        return aux;
    }
    
    public List<Locacao> listarLocacoesPorDataDeDevolucao(Calendar data){
        List<Locacao> aux = new ArrayList<Locacao>();
        for(Locacao l: this.locacoes){
            if (l.getDataDevolucao().equals(data)){
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

