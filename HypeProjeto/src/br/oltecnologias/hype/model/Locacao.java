package br.oltecnologias.hype.model;

import br.oltecnologias.hype.exception.LocacaoInexistenteException;
import br.oltecnologias.hype.exception.ProdutoInexistenteException;
import com.itextpdf.text.DocumentException;
import java.awt.print.PrinterException;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.Serializable;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.List;

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
    @Column(name = "id_locacao")
    private long id;

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
//    @ElementCollection
//    @CollectionTable(name="produtos", joinColumns=@JoinColumn(name="id_locacao"))
//    @Column(name="produtos")
//    @MapKeyJoinColumn(name="codigo", referencedColumnName="quantidade")
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
//    @MapKeyJoinColumn(name = "codigo")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_locacao")
    private List<ProdutoLocado> produtosLocados;

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

    private int percentualDesconto;

    private String caminhoUltimoContrato = "";
    
    private String tipoEntradaDePromissoria;

    public Locacao() {
    }

    public Locacao(Cliente cliente, List<ProdutoLocado> produtosLocados, double valorLocacao, Calendar dataLocacao,
            Calendar dataDeDevolucao, String formaDePagamento, int parcelas, double valorDeEntrada, int percentualDesconto) {
        this.cliente = cliente;
        this.produtosLocados = produtosLocados;
        this.valorDeEntrada = valorDeEntrada;
        this.valorLocacao = valorLocacao;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDeDevolucao;
        this.formaDePagamento = formaDePagamento;
        this.parcelas = parcelas;
        this.ativa = true;
    }
    
    public Locacao(Cliente cliente, List<ProdutoLocado> produtosLocados, double valorLocacao, Calendar dataLocacao,
            Calendar dataDeDevolucao, String formaDePagamento, int parcelas, double valorDeEntrada, int percentualDesconto, String tipoEntradaDePromissoria) {
        this.cliente = cliente;
        this.produtosLocados = produtosLocados;
        this.valorDeEntrada = valorDeEntrada;
        this.valorLocacao = valorLocacao;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDeDevolucao;
        this.formaDePagamento = formaDePagamento;
        this.parcelas = parcelas;
        this.ativa = true;
        this.tipoEntradaDePromissoria = tipoEntradaDePromissoria;
    }

    public void gerarContrato() throws DocumentException, IOException, Exception {
        GeradorDeContrato.getInstance().gerarContrato(this);

    }

    public void imprimirContrato() throws DocumentException, IOException, Exception {
        GeradorDeContrato.getInstance().gerarEImprimirContrato(this);
    }

    public void gerarRecibo() throws LocacaoInexistenteException, ProdutoInexistenteException, IOException, FileNotFoundException, PrinterException {
        GeradorDeRecibo.getInstance().gerarEImprimirReciboDeLocacao(this);
    }

    public void imprimirRecibo() throws IOException, FileNotFoundException,
            PrinterException, LocacaoInexistenteException, ProdutoInexistenteException {
        GeradorDeRecibo.getInstance().gerarEImprimirReciboDeLocacao(this);
    }

    public void gerarEImprimirPxRecibo(double valorDessePagamento)
            throws LocacaoInexistenteException, ProdutoInexistenteException, IOException, FileNotFoundException, PrinterException {
        GeradorDeRecibo.getInstance().gerarEImprimirPxReciboDeLocacao(this, valorDessePagamento);
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ProdutoLocado> getProdutos() {
        return this.produtosLocados;
    }

    public void setProdutos(List<ProdutoLocado> produtosLocados) {
        this.produtosLocados = produtosLocados;
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
        return this.ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public String getDataLocacaoInString() {
        return new SimpleDateFormat("dd/MM/yyyy").format(this.dataLocacao.getTime());
    }

    public String getEntradaInString() {
        return new DecimalFormat("0.00").format(this.valorDeEntrada);
    }

    public int getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(int percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public void resetarId() {
        this.id = 0;
    }

    public String getCaminhoUltimoContrato() {
        return caminhoUltimoContrato;
    }

    public void setCaminhoUltimoContrato(String caminhoUltimoContrato) {
        this.caminhoUltimoContrato = caminhoUltimoContrato;
    }

    public String getStatus() {
        if (isFinalizada()) {
            return "Fechada";
        }
        return "Ativa";
    }

    public boolean isLocacaoPaga() {
        return (this.jaPago >= this.valorLocacao);
    }

    public boolean isFinalizada() {
        return !this.ativa;
    }

    public String getDataDevolucaoInString() {
        return new SimpleDateFormat("dd/MM/yyyy").format(this.dataDevolucao.getTime());
    }

    public String getTipoEntradaDePromissoria() {
        return tipoEntradaDePromissoria;
    }

    public void setTipoEntradaDePromissoria(String tipoEntradaDePromissoria) {
        this.tipoEntradaDePromissoria = tipoEntradaDePromissoria;
    }
}
