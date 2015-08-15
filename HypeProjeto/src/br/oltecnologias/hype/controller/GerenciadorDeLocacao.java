package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.model.Locacao;
import br.oltecnologias.hype.model.Cliente;
import br.oltecnologias.hype.model.Produto;
import java.util.List;
import java.util.Calendar;

public class GerenciadorDeLocacao {

	private List<Locacao> locacoes;

	public void realizarLocacao(Cliente cliente, List<Produto> produtos, Calendar dataLocacao, float valor) {

	}

	public List<Locacao> listarLocacoes() {
		return null;
	}

	public void removerLocacao(int id) {

	}

	public List<Locacao> listarLocacoesPorData(Calendar data) {
		return null;
	}

	public List<Locacao> listarLocacoesExtraviadas() {
		return null;
	}

	public void finalizarLocacao(int idLocacao) {

	}

	public void carregarLocacoes() {

	}

}
