package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.model.Endereco;
import br.oltecnologias.hype.model.Administrador;
import br.oltecnologias.hype.model.Fornecedor;
import br.oltecnologias.hype.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class GerenciadorDePessoas {

    private List<Cliente> clientes;
    private List<Fornecedor> fornecedores;
    private List<Administrador> administradores;
    private static GerenciadorDePessoas singleton = null;
    
    private GerenciadorDePessoas(){
        clientes = new ArrayList<Cliente>();
        fornecedores = new ArrayList<Fornecedor>();
        administradores = new ArrayList<Administrador>();
    }
    
    public static GerenciadorDePessoas getInstance(){
        if (singleton == null){
            singleton = new GerenciadorDePessoas();
        }
        return singleton;
    }

    public void cadastrarCliiente(String cpf, Calendar ultimaMedicao, String rg, List<String> telefones, String rua, String bairro, String uf, int numeroCasa, String cidade, int calca, int traje, int colete, int camisa, int gravata, int sapato, List<String> obs) {

    }

    public void editarCliente(String cpf, Calendar ultimaMedicao, String rg, List<String> telefones, String rua, String bairro, String uf, int numeroCasa, String cidade, int calca, int traje, int colete, int camisa, int gravata, int sapato, List<String> obs) {

    }

    public Cliente pesquisarCliente(String CPF) {
        return null;
    }

    public void removerCliente(String CPF) {

    }

    public List<Cliente> pesquisarClientesPorNome(String nome) {
        return null;
    }

    public void cadastrarAdministrador(String nome, String senha, String nickName) {

    }

    public void editarAdministrador(String nome, String senha, String nickName) {

    }

    public void removerAdministrador(int id) {

    }

    public void cadastrarFornecedor(String cnpj, Endereco endereco, String nome) {

    }

    public void editarFornecedor(String cnpj, Endereco endereco, List<String> telefones) {

    }

    public void removerFornecedor(String cnpj) {

    }

    public List<Fornecedor> pesquisarFornecedorPeloNome(String nome) {
        return null;
    }

    public Fornecedor pesquisarFornecedorPeloCnpj(String cnpj) {
        return null;
    }

    public void carregarPessoas() {

    }

}
