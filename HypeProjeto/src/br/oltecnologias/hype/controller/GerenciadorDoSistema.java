package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.exception.DespesaInexistenteException;
import br.oltecnologias.hype.exception.MovimentacaoInexistenteException;
import br.oltecnologias.hype.model.Despesa;
import br.oltecnologias.hype.model.Movimentacao;
import br.oltecnologias.hype.model.Usuario;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class GerenciadorDoSistema {

    private Usuario usuarioLogado;
    private double valorCaixaDiario;
    private List<Despesa> despesas;
    private List<Movimentacao> movimentacoes;
    private static GerenciadorDoSistema singleton = null;

    private GerenciadorDoSistema() {
        valorCaixaDiario = 0;
        despesas = new ArrayList<Despesa>();
        movimentacoes = new ArrayList<Movimentacao>();

    }

    public static GerenciadorDoSistema getInstance() {
        if (singleton == null) {
            singleton = new GerenciadorDoSistema();
        }
        return singleton;
    }

    public void notificarVencimentoDeLocacao() {
        //thread
    }

    public void transacaoDeCaixaListener(double valor) {

    }

    public double getValorCaixaDiario() {
        return this.valorCaixaDiario;
    }

    public double getValorDespesas() {
        double despesa = 0.00;
        for (Despesa d : this.despesas) {
            despesa += d.getValor();
        }
        return despesa;
    }

    public void cadastrarDespesa(String nome, String obs, Calendar data, double valor) {
        Despesa d = new Despesa(nome, obs, data, valor);
        this.despesas.add(d);
    }

    public void editarDespesa(int id, String nome, String obs, Calendar data) throws DespesaInexistenteException {
        Despesa d;
        d = this.pesquisarDespesaPeloId(id);
        d.setNome(nome);
        d.setObservacao(obs);
        d.setData(data);

    }

    public void removerDespesas(int id) throws DespesaInexistenteException {
        this.despesas.remove(pesquisarDespesaPeloId(id));
    }

    public Despesa pesquisarDespesaPeloId(int id) throws DespesaInexistenteException {
        for (Despesa d : this.despesas) {
            if (d.getId() == id) {
                return d;
            }
        }
        throw new DespesaInexistenteException("Esta despesa em questão não existe");
    }

    public void restaurarDadosDeBackup() {
        
    }
    
    public void carregarSistema() {
        
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }
    
    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }
    
    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    
    //????
    public static GerenciadorDoSistema getSingleton() {
        return singleton;
    }
    //????
    public static void setSingleton(GerenciadorDoSistema singleton) {
        GerenciadorDoSistema.singleton = singleton;
    }
    
    public void gerarRelatorioDeCaixa(Calendar dataInicial, Calendar dataFinal) throws IOException {
        //Abrir o pdf do relatório gerado no sistema
        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();  
        desktop.open(new File("D:\\Sistemas de Informação\\Horário.pdf")); 
    }
    
    public Movimentacao cadastrarMovimentacao(String movimento, float valor, Calendar data, Usuario responsavel, String beneficiario) {
        Movimentacao movimentacao = new Movimentacao(movimento, valor, data, responsavel, beneficiario);
        this.movimentacoes.add(movimentacao);
        return movimentacao;
    }
    
    public void removerMovimentacao(long id) throws MovimentacaoInexistenteException {
        this.movimentacoes.remove(pesquisarMovimentacao(id));
    }
    
    public Movimentacao pesquisarMovimentacao(long id) throws MovimentacaoInexistenteException{
        for(Movimentacao movimentacao: this.movimentacoes) {
            if(movimentacao.getId() == id) {
                return movimentacao;
            }
        }
        throw new MovimentacaoInexistenteException("A movimentação em questão não existe.");
    }

}
