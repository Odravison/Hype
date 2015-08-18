package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.exceptions.ProdutoInexistenteException;
import br.oltecnologias.hype.exceptions.LocacaoInexistenteException;
import br.oltecnologias.hype.model.Locacao;
import br.oltecnologias.hype.model.Cliente;
import br.oltecnologias.hype.model.Produto;
import br.oltecnologias.hype.model.ProdutoDeLocacao;
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

    public void realizarLocacao(Cliente cliente, List<ProdutoDeLocacao> produtos, Calendar dataLocacao, float valor) {
        Locacao locacao = new Locacao(cliente, produtos, valor, dataLocacao);

        locacoes.add(locacao);

    }

    public List<Locacao> listarLocacoes() {
        return locacoes;
    }

    public void devolverLocacao(int idLoc, Cliente cliente) throws ProdutoInexistenteException {
        boolean emprestou = false;
        for (Locacao locacaoCliente : cliente.getLocacoes()){
            if (locacaoCliente.getId() == idLoc){
                for (Locacao locacaoGer : this.locacoes){
                    if(locacaoGer.getId() == idLoc 
                            && cliente.getCpf().equals(locacaoGer.getCliente().getCpf())){
                        emprestou = true;
                        for (Produto p: locacaoGer.getProdutos()){
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

    public List<Locacao> listarLocacoesPorData(Calendar data) {
        return null;
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

    public void finalizarLocacao(int idLocacao) {

    }

    public void carregarLocacoes() {

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
}
