package br.oltecnologias.hype.model;

import java.io.Serializable;
import java.util.List;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Locacao implements Serializable {
    
    @Id
    private int id;
    
    @OneToOne
    private Cliente cliente;
    
    @OneToMany
    private List<ProdutoDeLocacao> produtos;
    private float valor;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataLocacao;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataDevolucao;
    
    @OneToOne
    private Contrato contrato;

    public Locacao() {
    }

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
