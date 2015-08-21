package br.oltecnologias.hype.model;

import com.itextpdf.text.DocumentException;
import java.io.IOException;
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
    private List<Produto> produtos;
    private double valor;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataLocacao;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataDevolucao;
    
    private String caminhoDoContrato;


    public Locacao() {
    }

    public Locacao(Cliente cliente, List<Produto> produtos, double valor, Calendar dataLocacao) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.valor = valor;
        this.dataLocacao = dataLocacao;
        
        this.dataDevolucao = Calendar.getInstance();
        this.dataDevolucao.setTime(this.dataLocacao.getTime());
        this.dataDevolucao.add(Calendar.DAY_OF_MONTH, Configuracao.getInstance().getDiasEmprestimo());
    }

    public void gerarContrato() throws DocumentException, IOException, Exception {
        GeradorDeContrato.getInstance().gerarContrato(this.cliente, this.dataLocacao, this.dataDevolucao, this.produtos);

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

    public String produtosToString() {
        String string = null;
        for (Produto p : this.produtos) {
            string += p.getDescricao();
        }

        return string;
    }
}
