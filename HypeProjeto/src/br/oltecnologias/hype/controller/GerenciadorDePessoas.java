package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.exception.UsuarioExistenteException;
import br.oltecnologias.hype.exception.UsuarioInexistenteException;
import br.oltecnologias.hype.exception.ClienteExistenteException;
import br.oltecnologias.hype.exception.ClienteInexistenteException;
import br.oltecnologias.hype.exception.FornecedorExistenteException;
import br.oltecnologias.hype.exception.FornecedorInexistenteException;
import br.oltecnologias.hype.model.Endereco;
import br.oltecnologias.hype.model.Usuario;
import br.oltecnologias.hype.model.Fornecedor;
import br.oltecnologias.hype.model.Cliente;
import br.oltecnologias.hype.model.Dependente;
import br.oltecnologias.hype.model.Medidas;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDePessoas {

    private List<Cliente> clientes;
    private List<Fornecedor> fornecedores;
    private List<Usuario> usuarios;
    private static GerenciadorDePessoas singleton = null;

    private GerenciadorDePessoas() {
        clientes = new ArrayList<Cliente>();
        fornecedores = new ArrayList<Fornecedor>();
        usuarios = new ArrayList<Usuario>();
    }

    public static GerenciadorDePessoas getInstance() {
        if (singleton == null) {
            singleton = new GerenciadorDePessoas();
        }
        return singleton;
    }

    public void cadastrarCliiente(String cpf, String nome, Endereco endereco, Medidas medidas,
            String telefone, String celular, List<Dependente> dependentes) throws ClienteExistenteException {
        for (Cliente c : this.clientes) {
            if (c.getCpf().equals(cpf)) {
                throw new ClienteExistenteException("CPF já cadastrado.");
            }
        }
        this.clientes.add(new Cliente(cpf, nome, endereco, medidas, telefone, celular, dependentes));
    }

    public void editarCliente(String cpfAntigo, String cpfNovo, Endereco endereco, 
            Medidas medidas, String telefone, String celular)
            throws ClienteInexistenteException, ClienteExistenteException {
        try {
            pesquisarCliente(cpfAntigo);
        } catch (ClienteInexistenteException e) {
            Cliente alteracao = pesquisarCliente(cpfAntigo);

            alteracao.setCpf(cpfNovo);
            alteracao.setEndereco(endereco);
            alteracao.setMedidas(medidas);
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
            if (c.getNome().toUpperCase().contains(nome.toUpperCase())) {
                aux.add(c);
            }
        }
        return aux;
    }

    public void cadastrarUsuario(String nome, String nickName, String senha, boolean isAdm) throws UsuarioExistenteException {
        for (Usuario u : this.usuarios) {
            if (u.getNickName().equals(nickName)) {
                throw new UsuarioExistenteException("O NickName informado já está em uso.");
            }
        }
        this.usuarios.add(new Usuario(nome, nickName, senha, isAdm));
    }

    public void editarUsuario(String nickAntigo, String nome, String senha, String nickNovo) throws UsuarioExistenteException {
        for (Usuario u : this.usuarios) {
            if (u.getNickName().equals(nickNovo)) {
                throw new UsuarioExistenteException("NickName já está em uso.");
            }
        }
        for (Usuario u : this.usuarios) {
            if (u.getNickName().equals(nickAntigo)) {
                u.setNickName(nickNovo);
                u.setNome(nome);
                u.setSenha(senha);
            }
        }
    }

    public void removerUsuario(String nickName) throws UsuarioInexistenteException {
        for (Usuario u : this.usuarios) {
            if (u.getNickName().equals(nickName)) {
                this.usuarios.remove(u);
                return;
            }
        }
        throw new UsuarioInexistenteException("Administrador não cadastrado.");
    }

    public void cadastrarFornecedor(String cnpj, Endereco endereco, String telefone, String nome) throws FornecedorExistenteException {
        for (Fornecedor f : this.fornecedores) {
            if (f.getCnpj().equals(cnpj)) {
                throw new FornecedorExistenteException("O CNPJ em questão já foi cadastrado.");
            }
        }
        this.fornecedores.add(new Fornecedor(cnpj, endereco, telefone, nome));
    }

    public void editarFornecedor(String cnpjAntigo, String cnpjNovo, Endereco endereco, String telefone, String nome) throws FornecedorInexistenteException {
        for (Fornecedor f : this.fornecedores) {
            if (f.getCnpj().equals(cnpjAntigo)) {
                f.setCnpj(cnpjNovo);
                f.setEndereco(endereco);
                f.setNome(nome);
                f.setTelefone(telefone);
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
    
    public boolean validarUsuario(String login, String senha)  throws UsuarioInexistenteException{
        return pesquisarUsuarioPeloLogin(login).getSenha().equals(senha);
    }
    
    public boolean isAdministrador(String login) throws UsuarioInexistenteException {
        return this.pesquisarUsuarioPeloLogin(login).isAdministrador();
    }
    
    public Usuario pesquisarUsuarioPeloLogin(String login) throws UsuarioInexistenteException{
        this.usuarios.add(new Usuario("Luender Lima", "luender", "1234", true));
        this.usuarios.add(new Usuario("Odravison Amaral", "odravison", "1234", false));
        for(Usuario a: this.usuarios) {
            if(a.getNickName().equals(login)) {
                return a;
            }
        }
        throw new UsuarioInexistenteException("Usuário não cadastrado no sistema. \n\nInforme os dados novamente.");
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public void carregarPessoas() {
        // Método sera implementado quando houver bando de dados.
    }

}
