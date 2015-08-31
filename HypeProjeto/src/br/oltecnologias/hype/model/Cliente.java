/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Odravison
 */
@Entity
public class Cliente implements Serializable {

    @Id
    @Column(name = "id_cliente")
    private String cpf;
    
    @Column(name = "nome")
    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(name = "ultima_medicao")
    private Calendar ultimaMedicao;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="fk_endereco")
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="fk_medidas")
    private Medidas medidas;
    
    @Column(name = "telefone")
    private String telefone;

    @Column(nullable = false, name="celular")
    private String celular;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name="fk_cliente")
    private List<Locacao> locacoes;

    public Cliente() {
    }

    public Cliente(String cpf, String nome, Endereco endereco, Medidas medidas, String telefone, String celular) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.medidas = medidas;
        this.celular = celular;
        this.telefone = telefone;
        this.locacoes = new ArrayList<Locacao>();
        this.ultimaMedicao = Calendar.getInstance();

    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpf != null ? cpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.oltecnologias.hype.model.Cliente[ cpf=" + cpf + " ]";
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

<<<<<<< HEAD
    public String getUltimaMedicaoToShow() {
=======
    public String getUltimaMedicao() {
>>>>>>> 31c767a680c1e0e63ba2bd61a93aed21744e37d5
        return new SimpleDateFormat("dd/MM/yyyy").format(ultimaMedicao.getTime());
    }

    public void setUltimaMedicao(Calendar ultimaMedicao) {
        this.ultimaMedicao = ultimaMedicao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Medidas getMedidas() {
        return medidas;
    }

    public void setMedidas(Medidas medidas) {
        this.medidas = medidas;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(List<Locacao> locacoes) {
        this.locacoes = locacoes;
    }

    // retirar métodos depois que o banco de dados estiver integrado
    public void adicionarLocacao(Locacao locacao) {
        this.locacoes.add(locacao);
    }

    public void removerLocacao(Locacao locacao) {
        for (Locacao l : this.locacoes) {
            if (l.getId() == locacao.getId()) {
                this.locacoes.remove(l);
                break;
            }
        }
    }

    public Calendar getUltimaMedicao() {
        return ultimaMedicao;
    }
    
    

}
