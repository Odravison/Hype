package br.oltecnologias.hype.model;

import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Locacao implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="id_locacao")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="fk_locacao")
    private List<Produto> produtos;

    private double valorLocacao;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataLocacao;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataDevolucao;

    private String formaDePagamento;

    private double valorDeEntrada = 0;

    private double jaPago = 0;
    
    private int parcelas;
    
    private double entrada;

    
    public Locacao() {
    }

    public Locacao(Cliente cliente, List<Produto> produtos, double valorLocacao, Calendar dataLocacao,
            Calendar dataDeDevolucao, String formaDePagamento, int parcelas, double entrada) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.valorLocacao = valorLocacao;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDeDevolucao;
        this.formaDePagamento = formaDePagamento;
        this.parcelas = parcelas;
        this.entrada = entrada;
        if (formaDePagamento.equals("À VISTA")) {
            this.valorLocacao = valorLocacao - (valorLocacao * Configuracao.getInstance().getDescontoAVista());
        }
    }

    public Locacao(Cliente cliente, List<Produto> produtos, double valorLocacao, Calendar dataLocacao,
            Calendar dataDeDevolucao, String formaDePagamento, double valorDeEntrada) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.valorLocacao = valorLocacao;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDeDevolucao;
        this.formaDePagamento = formaDePagamento;
        this.valorDeEntrada = valorDeEntrada;
        this.jaPago = valorDeEntrada;
    }

    public void gerarContrato() throws DocumentException, IOException, Exception {
        GeradorDeContrato.getInstance().gerarContrato(this.cliente, this.dataLocacao, this.dataDevolucao, this.produtos);

    }

    public void imprimirContrato() throws DocumentException, IOException, Exception {
        GeradorDeContrato.getInstance().imprimirContrato(this.cliente, this.dataLocacao, this.dataDevolucao, this.produtos);
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

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public Calendar getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Calendar dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public void setDataDevolucao(Calendar dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Calendar getDataDevolucao() {
        return dataDevolucao;
    }

    public String produtosToString() {
        String string = null;
        for (Produto p : this.produtos) {
            string += p.getDescricao();
        }

        return string;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public double getValorDeEntrada() {
        return valorDeEntrada;
    }

    public void setValorDeEntrada(double valorDeEntrada) {
        this.valorDeEntrada = valorDeEntrada;
    }

    public double getJaPago() {
        return jaPago;
    }

    public void setJaPago(double jaPago) {
        this.jaPago = jaPago;
    }

    public String getProdutosLocados() {
        String produtosLocados = "";
        for (Produto produto : this.produtos) {
            produtosLocados += produto.getNome() + ", ";
        }
        return produtosLocados;
    }

    public String getVencimento() {
        return new SimpleDateFormat("dd/MM/yyyy").format(this.dataDevolucao.getTime());
    }

    public String getContato() {
        return this.cliente.getCelular();
    }
    
    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }
    
    public void addValorJaPago(double valorDessePagamento){
        this.jaPago += valorDessePagamento;
    }

    public double getEntrada() {
        return entrada;
    }

    public void setEntrada(double entrada) {
        this.entrada = entrada;
    }

    public void setEntrada(float entrada) {
        this.entrada = entrada;
    }
    
    public String getValorLocacaoInString() {
        return new DecimalFormat("#.##").format(this.valorLocacao);
    }
}
