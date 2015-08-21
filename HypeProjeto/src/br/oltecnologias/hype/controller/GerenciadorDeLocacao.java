package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.exception.ProdutoInexistenteException;
import br.oltecnologias.hype.exception.LocacaoInexistenteException;
import br.oltecnologias.hype.model.Locacao;
import br.oltecnologias.hype.model.Cliente;
import br.oltecnologias.hype.model.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class GerenciadorDeLocacao {

    private List<Locacao> locacoes;
    private static GerenciadorDeLocacao singleton = null;

    private GerenciadorDeLocacao() {
        locacoes = new ArrayList<Locacao>();
    }

    public static GerenciadorDeLocacao getInstance() {
        if (singleton == null) {
            singleton = new GerenciadorDeLocacao();
        }
        return singleton;
    }

    public void realizarLocacao(Cliente cliente, List<Produto> produtos, Calendar dataLocacao, float valor) throws ProdutoInexistenteException {
        Locacao locacao = new Locacao(cliente, produtos, valor, dataLocacao);
        cliente.adicionarLocacao(locacao);
        this.locacoes.add(locacao);
        for (Produto p: produtos){
            GerenciadorDeProduto.getInstance().pesquisarProduto(p.getCodigo()).removerQuant(p.getQuant());
        }
        
        
        

    }

    public List<Locacao> listarLocacoes() {
        return locacoes;
    }

    public void finalizarLocacao(int idLoc, Cliente cliente) throws ProdutoInexistenteException, LocacaoInexistenteException {
        boolean emprestou = false;
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
