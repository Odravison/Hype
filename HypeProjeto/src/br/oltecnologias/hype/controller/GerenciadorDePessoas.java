package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.dao.ClienteJpaRepository;
import br.oltecnologias.hype.dao.FornecedorJpaRepository;
import br.oltecnologias.hype.dao.UsuarioJpaRepository;
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

            cjp.editarCliente(cliente);

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

    //////////////////////////////// IMPLEMENTADOS ///////////////////////////
    public Usuario cadastrarUsuario(Usuario usuario) throws UsuarioExistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        UsuarioJpaRepository ujp = new UsuarioJpaRepository(emf);
        
        try{
            ujp.create(usuario);
            
        } finally {
            emf.close();
        }
        
        return usuario;
    }

    public void editarUsuario(Usuario usuario) throws UsuarioInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        UsuarioJpaRepository ujp = new UsuarioJpaRepository(emf);
        
        try{
            ujp.editarUsuario(usuario);
            
        } finally {
            emf.close();
        }
    }

    public void removerUsuario(String nickName) throws UsuarioInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        UsuarioJpaRepository ujp = new UsuarioJpaRepository(emf);
        
        try{
            ujp.removerUsuario(nickName);
        } finally {
            emf.close();
        }
        
    }

    public Fornecedor cadastrarFornecedor(Fornecedor fornecedor) throws FornecedorExistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        FornecedorJpaRepository fjp = new FornecedorJpaRepository(emf);
        
        try{
            
            fjp.create(fornecedor);
            
        } finally {
            emf.close();
        }
        
        return fornecedor;
    }

    public void editarFornecedor(Fornecedor fornecedor) throws FornecedorInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        FornecedorJpaRepository fjp = new FornecedorJpaRepository(emf);
        
        try {
            
            fjp.editarFornecedor(fornecedor);
            
        } finally {
            emf.close();
        }

    }

    public void removerFornecedor(String cnpj) throws FornecedorInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        FornecedorJpaRepository fjp = new FornecedorJpaRepository(emf);
        
        try{
            fjp.removerFornecedor(cnpj);
        } finally {
            emf.close();
        }
    }

    public List<Fornecedor> pesquisarFornecedorPeloNome(String nome) throws FornecedorInexistenteException {
        List<Fornecedor> aux = new ArrayList<Fornecedor>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        FornecedorJpaRepository fjp = new FornecedorJpaRepository(emf);
        
        try{
            aux = fjp.getAllFornecedores();
        } finally { 
            emf.close();
        }
        
        return aux;
    }

    public Fornecedor pesquisarFornecedorPeloCnpj(String cnpj) throws FornecedorInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        FornecedorJpaRepository fjp = new FornecedorJpaRepository(emf);
        Fornecedor forn = null;
        
        try{
            forn = fjp.findByCnpj(cnpj);
        } finally {
            emf.close();
        }
        
        return forn;
        
    }
    
    public List<Fornecedor> getAllFornecedores() throws FornecedorInexistenteException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        FornecedorJpaRepository fjp = new FornecedorJpaRepository(emf);
        
        try{
            return fjp.getAllFornecedores();
        } finally{
            if (emf != null){
                emf.close();
            }
        }
    }
    
    public List<Usuario> getAllUsuarios(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        UsuarioJpaRepository ujp = new UsuarioJpaRepository(emf);
        
        try{
            return ujp.getAllUsuarios();
        } finally{
            if (emf != null){
                emf.close();
            }
        }
    }
    
    public boolean validarUsuario(String login, String senha) throws UsuarioInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        UsuarioJpaRepository ujp = new UsuarioJpaRepository(emf);
        boolean resposta;
        
        try{
            
            resposta = ujp.validarUsuario(login, senha);
            
        } finally {
            emf.close();
        }
        
        
        return resposta;
    }

    public boolean isAdministrador(String login) throws UsuarioInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        UsuarioJpaRepository ujp = new UsuarioJpaRepository(emf);
        boolean resposta;
        
        try{
            resposta = ujp.isAdministrador(login);
        } finally {
            emf.close();
        }
        
        return resposta;
    }

    public Usuario pesquisarUsuarioPeloLogin(String login) throws UsuarioInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        UsuarioJpaRepository ujp = new UsuarioJpaRepository(emf);
        Usuario u = null;
        
        try {
            u = ujp.findByNickName(login);
        } finally {
            emf.close();
        }
        
        return u;
        
    }
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

    
    
    
    //************************************FAZER OS SEGUINTES MÉTODOS**************************************************//
    //pesquisarUsuarioPeloLogin(String login);
    //pesquisarFornecedorPeloCnpj(String cnpj);
    //isAdministrador(String login); //True, caso o usuário seja um adm, false, caso contrário
    //getUsuarios(); //Retorna uma lista com todos os usuários cadastrados
    //getFornecedores(); //Retorna uma lista com todos os fornecedores cadastrados
    //cadastrarFornecedor(Fornecedor fornecedor);
    //cadastrarUsuario(Usuario usuario);
    
}
