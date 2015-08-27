package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.exception.DespesaInexistenteException;
import br.oltecnologias.hype.model.Despesa;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class GerenciadorDoSistema {

    private double valorCaixaDiario;
    private List<Despesa> despesas;
    private static GerenciadorDoSistema singleton = null;

    private GerenciadorDoSistema() {
        valorCaixaDiario = 0;
        despesas = new ArrayList<Despesa>();

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

    public static GerenciadorDoSistema getSingleton() {
        return singleton;
    }

    public static void setSingleton(GerenciadorDoSistema singleton) {
        GerenciadorDoSistema.singleton = singleton;
    }

}
