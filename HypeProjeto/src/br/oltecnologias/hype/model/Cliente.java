package br.oltecnologias.hype.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Cliente extends Pessoa {

    private String cpf;
    private Calendar ultimaMedicao;
    private Endereco endereco;
    private Medidas medidas;
    private String rg;
    private List<String> telefones;
    private List<Locacao> locacoes;

    public Cliente(String cpf, Endereco endereco, Medidas medidas, String rg, List<String> telefones) {
        this.cpf = cpf;
        this.endereco = endereco;
        this.medidas = medidas;
        this.rg = rg;
        this.telefones = telefones;
        this.locacoes = new ArrayList<Locacao>();
        this.ultimaMedicao = Calendar.getInstance();
    }

    @Override
    public String getDescricao() {
        return "Cliente: " + super.getNome() + "\n"
                + "Endereço: " + this.endereco + "\n"
                + "CPF: " + this.cpf + "\n"
                + "RG: " + this.rg + "\n"
                + "telefones: " + this.telefoneToString() + "\n"
                + "Medidas: " + this.medidas.toString();
    }

    public String telefoneToStringEmLista() {
        String telefones = "";
        for (String s : this.telefones) {
            telefones += s.toString() + "\n";
        }
        return telefones;
    }

    public String telefoneToString() {
        String telefones = "";
        for (String s : this.telefones) {
            telefones += s.toString() + ", ";
        }
        return telefones;
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

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
