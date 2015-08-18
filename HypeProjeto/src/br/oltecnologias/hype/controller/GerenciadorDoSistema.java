package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.model.Despesa;
import br.oltecnologias.hype.model.Administrador;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class GerenciadorDoSistema {

    private float valorCaixaDiario;
    private List<Despesa> despesas;
    private Administrador admLogado;
    private static GerenciadorDoSistema singleton = null;
    
    private GerenciadorDoSistema(){
        valorCaixaDiario = 0;
        despesas = new ArrayList<Despesa>();
        
    }
    
    public static GerenciadorDoSistema getInstance(){
        if (singleton == null){
            singleton = new GerenciadorDoSistema();
        }
        return singleton;
    }
    
    public void notificarVencimentoDeLocacao() {

    }

    public void transacaoDeCaixaListener(float valor) {

    }

    public float getValorCaixaDiario() {
        return this.valorCaixaDiario;
    }

    public float getValorDespesas() {
        float despesa = 0;
        for (Despesa d: this.despesas){
            despesa += d.getValor();
        }
        return despesa;
    }

    public void cadastrarDespesa(String nome, String obs, Calendar data) {

    }

    public void editarDespesa(String nome, String obs, Calendar data) {

    }

    public void removerDespesas(int id) {

    }

    public List<Despesa> listarDespesas() {
        return null;
    }

    public void restaurarDadosDeBackup() {

    }

    public void realizarBackup() {

    }

    public void carregarSistema() {

    }

}
