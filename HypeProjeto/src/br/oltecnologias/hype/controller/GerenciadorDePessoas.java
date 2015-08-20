package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.exception.AdministradorExistenteException;
import br.oltecnologias.hype.exception.AdministradorInexistenteException;
import br.oltecnologias.hype.exception.ClienteExistenteException;
import br.oltecnologias.hype.exception.ClienteInexistenteException;
import br.oltecnologias.hype.exception.EmpregadoExistenteException;
import br.oltecnologias.hype.exception.EmpregadoInexistenteException;
import br.oltecnologias.hype.exception.FornecedorExistenteException;
import br.oltecnologias.hype.exception.FornecedorInexistenteException;
import br.oltecnologias.hype.model.Endereco;
import br.oltecnologias.hype.model.Administrador;
import br.oltecnologias.hype.model.Fornecedor;
import br.oltecnologias.hype.model.Cliente;
import br.oltecnologias.hype.model.Empregado;
import br.oltecnologias.hype.model.Medidas;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDePessoas {

    private List<Cliente> clientes;
    private List<Fornecedor> fornecedores;
    private List<Administrador> administradores;
    private List<Empregado> empregados;
    private static GerenciadorDePessoas singleton = null;

    private GerenciadorDePessoas() {
        clientes = new ArrayList<Cliente>();
        fornecedores = new ArrayList<Fornecedor>();
        administradores = new ArrayList<Administrador>();
    }

    public static GerenciadorDePessoas getInstance() {
        if (singleton == null) {
            singleton = new GerenciadorDePessoas();
        }
        return singleton;
    }

    public void cadastrarCliiente(String cpf, String nome, Endereco endereco, Medidas medidas,
            String rg, String telefone, String celular) throws ClienteExistenteException {
        for (Cliente c : this.clientes) {
            if (c.getCpf().equals(cpf)) {
                throw new ClienteExistenteException("CPF já cadastrado.");
            }
        }
        Cliente cliente = new Cliente(cpf, nome, endereco, medidas, rg, telefone, celular);
        this.clientes.add(cliente);
    }

    public void editarCliente(String cpfAntigo, String cpfNovo, Endereco endereco, 
            Medidas medidas, String rg, String telefone, String celular)
            throws ClienteInexistenteException, ClienteExistenteException {
        try {
            pesquisarCliente(cpfAntigo);
        } catch (ClienteInexistenteException e) {
            Cliente alteracao = pesquisarCliente(cpfAntigo);

            alteracao.setCpf(cpfNovo);
            alteracao.setEndereco(endereco);
            alteracao.setMedidas(medidas);
            alteracao.setRg(rg);
            alteracao.setTelefone(telefone);
            alteracao.setCelular(celular);
        }

    }

    public Cliente pesquisarCliente(String cpf) throws ClienteInexistenteException {
        for (Cliente cliente : this.clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        throw new ClienteInexistenteException("Cliente não cadastrado.");
    }

    public void removerCliente(String cpf) throws ClienteInexistenteException {
        this.clientes.remove(pesquisarCliente(cpf));

    }

    public List<Cliente> pesquisarClientesPorNome(String nome) {
        List<Cliente> aux = new ArrayList<Cliente>();
        for (Cliente c : this.clientes) {
            if (c.getNome().contains(nome)) {
                aux.add(c);
            }
        }
        return aux;
    }

    public void cadastrarAdministrador(String nome, String senha, String nickName) throws AdministradorExistenteException {
        for (Administrador adm : this.administradores) {
            if (adm.getNickName().equals(nickName)) {
                throw new AdministradorExistenteException("O NickName informado já está em uso.");
            }
        }
        Administrador adm = new Administrador(senha, nickName, nome);
        this.administradores.add(adm);

    }

    public void editarAdministrador(String nickAntigo, String nome, String senha, String nickNovo) throws AdministradorExistenteException {
        for (Administrador adm : this.administradores) {
            if (adm.getNickName().equals(nickNovo)) {
                throw new AdministradorExistenteException("NickName já está em uso.");
            }
        }
        for (Administrador adm : this.administradores) {
            if (adm.getNickName().equals(nickAntigo)) {
                adm.setNickName(nickNovo);
                adm.setNome(nome);
                adm.setSenha(senha);
            }
        }
    }

    public void removerAdministrador(String nickName) throws AdministradorInexistenteException {
        for (Administrador adm : this.administradores) {
            if (adm.getNickName().equals(nickName)) {
                this.administradores.remove(adm);
                return;
            }
        }
        throw new AdministradorInexistenteException("Administrador não cadastrado.");
    }

    public void cadastrarEmpregado(String nome, String nickName, String senha) throws EmpregadoExistenteException {
        for (Empregado e : this.empregados) {
            if (e.getNickName().equals(nickName)) {
                throw new EmpregadoExistenteException("NickName já esta em uso.");
            }
        }
        Empregado e = new Empregado(nome, nickName, senha);
        this.empregados.add(e);
    }

    public void editarEmpregado(String nome, String nickNovo, String nickAntigo, String senha) throws EmpregadoInexistenteException {
        for (Empregado e : this.empregados) {
            if (e.getNickName().equals(nickAntigo)) {
                e.setNickName(nickNovo);
                e.setNome(nome);
                e.setSenha(senha);
                return;
            }
        }
        throw new EmpregadoInexistenteException("Empregado em questão não existe");
    }

    public void removerEmpregado(String nickName) throws EmpregadoInexistenteException  {
        for (Empregado e : this.empregados) {
            if (e.getNickName().equals(nickName)) {
                this.empregados.remove(e);
                return;
            }
        }
        throw new EmpregadoInexistenteException("Empregado em questão não existe.");
    }

    public void cadastrarFornecedor(String cnpj, Endereco endereco, List<String> telefones, String nome) throws FornecedorExistenteException {
        for (Fornecedor f : this.fornecedores) {
            if (f.getCnpj().equals(cnpj)) {
                throw new FornecedorExistenteException("O CNPJ em questão já foi cadastrado.");
            }
        }
        Fornecedor f = new Fornecedor(cnpj, endereco, telefones, nome);
        this.fornecedores.add(f);
    }

    public void editarFornecedor(String cnpjAntigo, String cnpjNovo, Endereco endereco, List<String> telefones, String nome) throws FornecedorInexistenteException {
        for (Fornecedor f : this.fornecedores) {
            if (f.getCnpj().equals(cnpjAntigo)) {
                f.setCnpj(cnpjNovo);
                f.setEndereco(endereco);
                f.setNome(nome);
                f.setTelefones(telefones);
                return;
            }
        }
        throw new FornecedorInexistenteException("Fornecedor em questão não existe");

    }

    public void removerFornecedor(String cnpj) throws FornecedorInexistenteException {
        for (Fornecedor f : this.fornecedores) {
            if (f.getCnpj().equals(cnpj)) {
                this.fornecedores.remove(f);
                return;
            }
        }
        throw new FornecedorInexistenteException("Fornecedor em questão não existe");
    }

    public List<Fornecedor> pesquisarFornecedorPeloNome(String nome) {
        List<Fornecedor> aux = new ArrayList<Fornecedor>();
        for (Fornecedor f : this.fornecedores) {
            if (f.getNome().contains(nome)) {
                aux.add(f);
            }
        }
        return aux;
    }

    public Fornecedor pesquisarFornecedorPeloCnpj(String cnpj) throws FornecedorInexistenteException {
        for (Fornecedor f : this.fornecedores) {
            if (f.getCnpj().equals(cnpj)) {
                return f;
            }
        }
        throw new FornecedorInexistenteException("Fornecedor não encontrado.");
    }
    
    public boolean validarAdministrador(String login, String senha)  throws AdministradorInexistenteException{
        if(this.pesquisarAdministradorPeloLogin(login).getSenha().equals(senha)) {
            return true;
        }     
        return false;
    }
    
    // Deve servir para funcionários também
    public Administrador pesquisarAdministradorPeloLogin(String login) throws AdministradorInexistenteException{
        this.administradores.add(new Administrador("Luender Lima","luender","1234"));
        this.administradores.add(new Administrador("Odravison Amaral","odravison","1234"));
        for(Administrador a: this.administradores) {
            if(a.getNickName().equals(login)) {
                return a;
            }
        }
        throw new AdministradorInexistenteException("Administrador não cadastrado no sistema. \n\nInforme os dados novamente.");
    }

    public void carregarPessoas() {
        // Método sera implementado quando houver bando de dados.
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public List<Administrador> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<Administrador> administradores) {
        this.administradores = administradores;
    }

    public List<Empregado> getEmpregados() {
        return empregados;
    }

    public void setEmpregados(List<Empregado> empregados) {
        this.empregados = empregados;
    }
}
