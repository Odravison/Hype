package br.oltecnologias.hype.model;

import java.util.List;
import java.util.Calendar;

public class Locacao {

    private int id;
    private Cliente cliente;
    private List<ProdutoDeLocacao> produtos;
    private float valor;
    private Calendar dataLocacao;
    private Calendar dataDevolucao;
    private Contrato contrato;

    public Locacao(Cliente cliente, List<ProdutoDeLocacao> produtos, float valor, Calendar dataLocacao) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.valor = valor;
        this.dataLocacao = dataLocacao;
        dataLocacao.add(Calendar.DAY_OF_MONTH, 2);
        this.dataDevolucao = dataLocacao;
        this.contrato = formularContrato();
    }

    private Contrato formularContrato() {
        Contrato documento = new Contrato();
        return documento; // Ver com os clientes qual é o padrão do contrato
    }

    public void exportarContrato() {

    }

    public void imprimirContrato() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ProdutoDeLocacao> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDeLocacao> produtos) {
        this.produtos = produtos;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Calendar getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Calendar dataLocacao) {
        this.dataLocacao = dataLocacao;
        dataLocacao.add(Calendar.DAY_OF_MONTH, 2);
        this.dataDevolucao = dataLocacao;
    }

    public Calendar getDataDevolucao() {
        return dataDevolucao;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}
