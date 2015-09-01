package br.oltecnologias.hype.model;

import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Transient;

@Entity
public class Locacao implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_locacao")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name="fk_locacao")
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)  //o nome da propriedade de "value" que liga a esta classe  
//    @JoinColumn(name = "fk_locacao")
//    @ElementCollection
//    @MapKeyColumn(name="CODIGO")
//    @Column(name="QUANTIDADE")
//    @CollectionTable(name="locacao_produtos", joinColumns=@JoinColumn(name="id_locacao"))
//    @ElementCollection
//
//    @CollectionTable(
//            name = "PRODUTOS_LOCACAO",
//            joinColumns = @JoinColumn(name = "id_locacao"))
//    @Column(name = "produtos")
    
//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "PRODUTOS")
//    @MapKeyColumn(name = "CODIGO")
//    @Column(name = "QUANTIDADE")
    
    @Transient
    private HashMap<String, Integer> produtos;

    private double valorLocacao;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataLocacao;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataDevolucao;

    private String formaDePagamento;

    private double valorDeEntrada = 0;

    private double jaPago = 0;

    private int parcelas;

    private boolean ativa;

    public Locacao() {
    }

    public Locacao(Cliente cliente, HashMap<String, Integer> produtos, double valorLocacao, Calendar dataLocacao,
            Calendar dataDeDevolucao, String formaDePagamento, int parcelas, double valorDeEntrada) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.valorDeEntrada = valorDeEntrada;
        this.valorLocacao = valorLocacao;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDeDevolucao;
        this.formaDePagamento = formaDePagamento;
        if (valorDeEntrada == 0) {
            this.jaPago = valorLocacao;
        }
        this.parcelas = parcelas;
        if (formaDePagamento.equals("A VISTA")) {
            this.valorLocacao = valorLocacao - (valorLocacao * Configuracao.getInstance().getDescontoAVista());
        }
        this.ativa = true;
    }

    public void gerarContrato() throws DocumentException, IOException, Exception {
        GeradorDeContrato.getInstance().gerarContrato(this);

    }

    public void imprimirContrato() throws DocumentException, IOException, Exception {
        GeradorDeContrato.getInstance().imprimirContrato(this);
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

    public HashMap<String, Integer> getProdutos() {
        return produtos;
    }

    public void setProdutos(HashMap<String, Integer> produtos) {
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

    public void addValorJaPago(double valorDessePagamento) {
        this.jaPago += valorDessePagamento;
    }

    public String getValorLocacaoInString() {
        return new DecimalFormat("#.##").format(this.valorLocacao);
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

}
