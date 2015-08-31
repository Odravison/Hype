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
    
    private int quantidadeParcelas;

    private float entrada;

    public Venda() {
    }

    /**
     *
     * @param produtos
     * @param valor
     */
    public Venda(List<Produto> produtos, double valor, String formaDePagamento, Calendar dataVenda, int quantidadeParcelas, float entrada) {
        this.produtos = produtos;
        this.valor = valor;
        this.formaDePagamento = formaDePagamento;
        this.dataVenda = dataVenda;
        this.quantidadeParcelas = quantidadeParcelas;
        this.entrada = entrada;
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
    
    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public float getEntrada() {
        return entrada;
    }

    public void setEntrada(float entrada) {
        this.entrada = entrada;
    }

}
