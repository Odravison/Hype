package br.oltecnologias.hype.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
@DiscriminatorValue("1")
public class Cliente extends Pessoa {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id_cpf")
    private String cpf;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar ultimaMedicao;

    @OneToOne
    private Endereco endereco;

    @OneToOne
    private Medidas medidas;
    
    @Column(nullable = true)
    private String telefone;

    private String celular;

    @OneToMany
    private List<Locacao> locacoes;
    
    public Cliente() {
    }

    public Cliente(String cpf, String nome, Endereco endereco, Medidas medidas, String telefone, String celular) {
        super(nome);
        this.cpf = cpf;
        this.endereco = endereco;
        this.medidas = medidas;
        this.celular = celular;
        this.telefone = telefone;
        this.locacoes = new ArrayList<Locacao>();
        this.ultimaMedicao = Calendar.getInstance();
        
    }

    @Override
    public String getDescricao() {
        return "Cliente: " + super.getNome() + "\n"
                + "Endereço: " + this.endereco + "\n"
                + "CPF: " + this.cpf + "\n"
                + "telefone: " + this.telefone + "\n"
                + "celular: " + this.celular + "\n"
                + "Medidas: " + this.medidas.toString();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getUltimaMedicao() {
        return ultimaMedicao;
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

    //Não precisará desses métodos se a adição e remoção forem feitos diretamente no banco
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

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(List<Locacao> locacoes) {
        this.locacoes = locacoes;
    }

}
