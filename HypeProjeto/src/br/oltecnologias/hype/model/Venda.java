package br.oltecnologias.hype.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Venda implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @OneToMany
    private List<Produto> produtos;
    
    private double valor;
    
    private String formaDePagamento;
    
    private Calendar dataVenda;

    public Venda() {
    }

    /**
     *
     * @param produtos
     * @param valor
     */
    public Venda(List<Produto> produtos, double valor, String formaDePagamento, Calendar dataVenda) {
        this.produtos = produtos;
        this.valor = valor;
        this.formaDePagamento = formaDePagamento;
        this.dataVenda = dataVenda;
        if (formaDePagamento.toUpperCase().equals("À VISTA")){
            this.valor = valor - (valor*Configuracao.getInstance().getDescontoAVista());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }
    
    public String getProdutosVendidos() {
        String produtosVendidos = "";
        for(Produto produto: this.produtos) {
            produtosVendidos += produto.getNome()+", ";
        }
        return produtosVendidos;
    }
    
    public String getDataVenda() {
        return new SimpleDateFormat("dd/MM/yyyy").format(this.dataVenda.getTime());
    }

}
