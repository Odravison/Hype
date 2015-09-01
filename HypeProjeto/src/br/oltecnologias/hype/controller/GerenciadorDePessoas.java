package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.dao.ClienteJpaRepository;
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
import br.oltecnologias.hype.model.Locacao;
import br.oltecnologias.hype.model.Medidas;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerenciadorDePessoas {

    private static GerenciadorDePessoas singleton = null;

    private GerenciadorDePessoas() {

    }

    public static GerenciadorDePessoas getInstance() {
        if (singleton == null) {
            singleton = new GerenciadorDePessoas();
        }
        return singleton;
    }

    public Cliente cadastrarCliiente(Cliente cliente) throws ClienteExistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ClienteJpaRepository cjp = new ClienteJpaRepository(emf);

        try {
            cjp.create(cliente);
        } finally {
            emf.close();
        }

        return cliente;
    }

    public void editarCliente(Cliente cliente)
            throws ClienteInexistenteException, ClienteExistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ClienteJpaRepository cjp = new ClienteJpaRepository(emf);

        try {
            Cliente alteracao = cjp.findByCpf(cliente.getCpf());

            alteracao.setCpf(cliente.getCpf());
            alteracao.setEndereco(cliente.getEndereco());
            alteracao.setMedidas(cliente.getMedidas());
            alteracao.setTelefone(cliente.getTelefone());
            alteracao.setCelular(cliente.getCelular());

            cjp.editarCliente(alteracao);

        } finally {
            emf.close();
        }

    }

    public Cliente pesquisarCliente(String cpf) throws ClienteInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ClienteJpaRepository cjp = new ClienteJpaRepository(emf);
        Cliente clienteRetorno = null;

        try {
            for (Cliente cliente : cjp.getAllClientes()) {
                if (cliente.getCpf().equals(cpf)) {
                    clienteRetorno = cliente;
                    break;
                }
            }
        } finally {
            emf.close();
        }

        return clienteRetorno;
    }

    public void removerCliente(String cpf) throws ClienteInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ClienteJpaRepository cjp = new ClienteJpaRepository(emf);
        try {
            cjp.removerCliente(cpf);
        } finally {
            emf.close();
        }
    }

    public List<Cliente> pesquisarClientesPorNome(String nome) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ClienteJpaRepository cjp = new ClienteJpaRepository(emf);

        List<Cliente> aux = new ArrayList<Cliente>();

        try {
            for (Cliente c : cjp.getAllClientes()) {
                if (c.getNome().toUpperCase().contains(nome.toUpperCase())) {
                    aux.add(c);
                }
            }
        } finally {
            emf.close();
        }

        return aux;
    }

    //////////////////////////////// COMENTADA SÓ PARA TESTE ///////////////////////////
//    public Usuario cadastrarUsuario(String nome, String nickName, String senha, boolean isAdm) throws UsuarioExistenteException {
//        for (Usuario u : this.usuarios) {
//            if (u.getNickName().equals(nickName)) {
//                throw new UsuarioExistenteException("O NickName informado já está em uso.");
//            }
//        }
//        Usuario usuario = new Usuario(nome, nickName, senha, isAdm);
//        this.usuarios.add(usuario);
//        return usuario;
//    }
//
//    public void editarUsuario(String nickAntigo, String nome, String senha, String nickNovo) throws UsuarioExistenteException {
//        for (Usuario u : this.usuarios) {
//            if (u.getNickName().equals(nickNovo)) {
//                throw new UsuarioExistenteException("NickName já está em uso.");
//            }
//        }
//        for (Usuario u : this.usuarios) {
//            if (u.getNickName().equals(nickAntigo)) {
//                u.setNickName(nickNovo);
//                u.setNome(nome);
//                u.setSenha(senha);
//            }
//        }
//    }
//
//    public void removerUsuario(String nickName) throws UsuarioInexistenteException {
//        for (Usuario u : this.usuarios) {
//            if (u.getNickName().equals(nickName)) {
//                this.usuarios.remove(u);
//                return;
//            }
//        }
//        throw new UsuarioInexistenteException("Administrador não cadastrado.");
//    }
//
//    public Fornecedor cadastrarFornecedor(String cnpj, Endereco endereco, String telefone, String nome) throws FornecedorExistenteException {
//        for (Fornecedor f : this.fornecedores) {
//            if (f.getCnpj().equals(cnpj)) {
//                throw new FornecedorExistenteException("O CNPJ em questão já foi cadastrado.");
//            }
//        }
//        Fornecedor fornecedor = new Fornecedor(cnpj, endereco, telefone, nome);
//        this.fornecedores.add(fornecedor);
//        return fornecedor;
//    }
//
//    public void editarFornecedor(String cnpjAntigo, String cnpjNovo, Endereco endereco, String telefone, String nome) throws FornecedorInexistenteException {
//        for (Fornecedor f : this.fornecedores) {
//            if (f.getCnpj().equals(cnpjAntigo)) {
//                f.setCnpj(cnpjNovo);
//                f.setEndereco(endereco);
//                f.setNome(nome);
//                f.setTelefone(telefone);
//                return;
//            }
//        }
//        throw new FornecedorInexistenteException("Fornecedor em questão não existe");
//
//    }
//
//    public void removerFornecedor(String cnpj) throws FornecedorInexistenteException {
//        for (Fornecedor f : this.fornecedores) {
//            if (f.getCnpj().equals(cnpj)) {
//                this.fornecedores.remove(f);
//                return;
//            }
//        }
//        throw new FornecedorInexistenteException("Fornecedor em questão não existe");
//    }
//
//    public List<Fornecedor> pesquisarFornecedorPeloNome(String nome) {
//        List<Fornecedor> aux = new ArrayList<Fornecedor>();
//        for (Fornecedor f : this.fornecedores) {
//            if (f.getNome().contains(nome)) {
//                aux.add(f);
//            }
//        }
//        return aux;
//    }
//
//    public Fornecedor pesquisarFornecedorPeloCnpj(String cnpj) throws FornecedorInexistenteException {
//        for (Fornecedor f : this.fornecedores) {
//            if (f.getCnpj().equals(cnpj)) {
//                return f;
//            }
//        }
//        throw new FornecedorInexistenteException("Fornecedor não encontrado.");
//    }
//    
//
//
//    public boolean validarUsuario(String login, String senha) throws UsuarioInexistenteException {
//        return pesquisarUsuarioPeloLogin(login).getSenha().equals(senha);
//    }
//
//    public boolean isAdministrador(String login) throws UsuarioInexistenteException {
//        return this.pesquisarUsuarioPeloLogin(login).isAdministrador();
//    }
//
//    public Usuario pesquisarUsuarioPeloLogin(String login) throws UsuarioInexistenteException {
//        this.usuarios.add(new Usuario("Luender Lima", "luender", "1234", true));
//        this.usuarios.add(new Usuario("Odravison Amaral", "odravison", "1234", false));
//        for (Usuario a : this.usuarios) {
//            if (a.getNickName().equals(login)) {
//                return a;
//            }
//        }
//        throw new UsuarioInexistenteException("Usuário não cadastrado no sistema. \n\nInforme os dados novamente.");
//    }
    public List<Cliente> getClientes() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ClienteJpaRepository cjp = new ClienteJpaRepository(emf);
        List<Cliente> listaRetorno = new ArrayList<Cliente>();

        try {
            listaRetorno = cjp.getAllClientes();
        } finally {
            emf.close();
        }

        return listaRetorno;
    }

    public void setClientes(List<Cliente> clientes) throws ClienteExistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ClienteJpaRepository cjp = new ClienteJpaRepository(emf);

        try {
            for (Cliente cliente : clientes) {
                cjp.create(cliente);
            }
        } finally {
            emf.close();
        }
    }

//    public List<Fornecedor> getFornecedores() {
//        return fornecedores;
//    }
//
//    public void setFornecedores(List<Fornecedor> fornecedores) {
//        this.fornecedores = fornecedores;
//    }
//
//    public List<Usuario> getUsuarios() {
//        return usuarios;
//    }
//
//    public void setUsuarios(List<Usuario> usuarios) {
//        this.usuarios = usuarios;
//    }
    
    
    //Método para pesquisar os clientes que fizeram locações as mais recentes
    // Retorno: uma lista de clientes ordenada pela data (mais recente para a menos recente) da sua última locação
    public List<Cliente> getMostRecentLocationsByClientes() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ClienteJpaRepository cjp = new ClienteJpaRepository(emf);
        
        List<Cliente> listaDeRetorno = new ArrayList<Cliente>();
        List<Locacao> listaOrdenadaDeLocacao = new ArrayList<Locacao>();
        List<Cliente> listaDeCliente = new ArrayList<Cliente>();

        try {
            listaDeRetorno = new ArrayList<Cliente>();
            listaOrdenadaDeLocacao = GerenciadorDeLocacao.getInstance().getMostRecentLocation();
            listaDeCliente = cjp.getAllClientes();

            for (Cliente c : listaDeCliente) {
                for (Locacao l : listaOrdenadaDeLocacao) {
                    if (c.getCpf().equals(l.getCliente().getCpf())) {
                        listaDeRetorno.add(c);
                    }
                }
            }
        } finally {
            emf.close();
        }

        return listaDeRetorno;
    }

    //PesquisarUltimosLocatarios(String: nome): List<Cliente>
    //Método para pesquisar os últimos clientes que foram cadastrados
    
    //PesquisarUltimosClientesCadastrados(String: nome): List<Cliente>
}
