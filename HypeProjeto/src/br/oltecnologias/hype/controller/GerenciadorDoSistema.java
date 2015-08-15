package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.model.Despesa;
import br.oltecnologias.hype.model.Administrador;
import java.util.List;
import java.util.Calendar;

public class GerenciadorDoSistema {

	private float valorCaixaDiario;

	private List<Despesa> despesas;

	private Administrador admLogado;

	public void notificarVencimentoDeLocacao() {

	}

	public void transacaoDeCaixaListener(float valor) {

	}

	public float getValorCaixaDiario() {
		return 0;
	}

	public float getValorDespesas() {
		return 0;
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
