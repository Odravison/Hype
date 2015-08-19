/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.model.Administrador;
import br.oltecnologias.hype.model.Cliente;
import br.oltecnologias.hype.model.Empregado;
import br.oltecnologias.hype.model.Endereco;
import br.oltecnologias.hype.model.Fornecedor;
import br.oltecnologias.hype.model.Medidas;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Odravison
 */
public class GerenciadorDePessoasIT {
    
    public GerenciadorDePessoasIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class GerenciadorDePessoas.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        GerenciadorDePessoas expResult = GerenciadorDePessoas.getInstance();
        GerenciadorDePessoas result = GerenciadorDePessoas.getInstance();
        assertEquals(expResult, result);
    }

    /**
     * Test of cadastrarCliiente method, of class GerenciadorDePessoas.
     */
    @Test
    public void testCadastrarCliiente() throws Exception {
        System.out.println("cadastrarCliiente");
        String cpf = "1234";
        Endereco endereco = new Endereco ("rua", "bairro", "uf", 12, "jp");
        Medidas medidas = new Medidas (10,10,10,10,10,10, "obs");
        String rg = "123456";
        List<String> telefones = new ArrayList<String>();
        telefones.add("1234");
        GerenciadorDePessoas instance = GerenciadorDePessoas.getInstance();
        instance.cadastrarCliiente(cpf, endereco, medidas, rg, telefones);
        assertEquals(GerenciadorDePessoas.getInstance().getClientes().size(), 1);
        
    }

    /**
     * Test of editarCliente method, of class GerenciadorDePessoas.
     */
    @Test
    public void testEditarCliente() throws Exception {
        System.out.println("editarCliente");
        String cpfAntigo = "123";
        String cpfNovo = "345";
        Endereco endereco = new Endereco ("rua", "bairro", "uf", 12, "jp");
        Medidas medidas = new Medidas (10,10,10,10,10,10, "obs");
        Medidas medidasNova = null;
        String rg = "";
        List<String> telefones = null;
        GerenciadorDePessoas instance = null;
        instance.editarCliente(cpfAntigo, cpfNovo, endereco, medidas, rg, telefones);
    }

    /**
     * Test of pesquisarCliente method, of class GerenciadorDePessoas.
     */
    @Test
    public void testPesquisarCliente() throws Exception {
        System.out.println("pesquisarCliente");
        String cpf = "";
        GerenciadorDePessoas instance = null;
        Cliente expResult = null;
        Cliente result = instance.pesquisarCliente(cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removerCliente method, of class GerenciadorDePessoas.
     */
    @Test
    public void testRemoverCliente() throws Exception {
        System.out.println("removerCliente");
        String cpf = "";
        GerenciadorDePessoas instance = null;
        instance.removerCliente(cpf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pesquisarClientesPorNome method, of class GerenciadorDePessoas.
     */
    @Test
    public void testPesquisarClientesPorNome() {
        System.out.println("pesquisarClientesPorNome");
        String nome = "";
        GerenciadorDePessoas instance = null;
        List<Cliente> expResult = null;
        List<Cliente> result = instance.pesquisarClientesPorNome(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cadastrarAdministrador method, of class GerenciadorDePessoas.
     */
    @Test
    public void testCadastrarAdministrador() throws Exception {
        System.out.println("cadastrarAdministrador");
        String nome = "";
        String senha = "";
        String nickName = "";
        GerenciadorDePessoas instance = null;
        instance.cadastrarAdministrador(nome, senha, nickName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarAdministrador method, of class GerenciadorDePessoas.
     */
    @Test
    public void testEditarAdministrador() throws Exception {
        System.out.println("editarAdministrador");
        String nickAntigo = "";
        String nome = "";
        String senha = "";
        String nickNovo = "";
        GerenciadorDePessoas instance = null;
        instance.editarAdministrador(nickAntigo, nome, senha, nickNovo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removerAdministrador method, of class GerenciadorDePessoas.
     */
    @Test
    public void testRemoverAdministrador() throws Exception {
        System.out.println("removerAdministrador");
        String nickName = "";
        GerenciadorDePessoas instance = null;
        instance.removerAdministrador(nickName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cadastrarEmpregado method, of class GerenciadorDePessoas.
     */
    @Test
    public void testCadastrarEmpregado() throws Exception {
        System.out.println("cadastrarEmpregado");
        String nome = "";
        String nickName = "";
        String senha = "";
        GerenciadorDePessoas instance = null;
        instance.cadastrarEmpregado(nome, nickName, senha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarEmpregado method, of class GerenciadorDePessoas.
     */
    @Test
    public void testEditarEmpregado() throws Exception {
        System.out.println("editarEmpregado");
        String nome = "";
        String nickNovo = "";
        String nickAntigo = "";
        String senha = "";
        GerenciadorDePessoas instance = null;
        instance.editarEmpregado(nome, nickNovo, nickAntigo, senha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removerEmpregado method, of class GerenciadorDePessoas.
     */
    @Test
    public void testRemoverEmpregado() throws Exception {
        System.out.println("removerEmpregado");
        String nickName = "";
        GerenciadorDePessoas instance = null;
        instance.removerEmpregado(nickName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cadastrarFornecedor method, of class GerenciadorDePessoas.
     */
    @Test
    public void testCadastrarFornecedor() throws Exception {
        System.out.println("cadastrarFornecedor");
        String cnpj = "";
        Endereco endereco = null;
        List<String> telefones = null;
        String nome = "";
        GerenciadorDePessoas instance = null;
        instance.cadastrarFornecedor(cnpj, endereco, telefones, nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarFornecedor method, of class GerenciadorDePessoas.
     */
    @Test
    public void testEditarFornecedor() throws Exception {
        System.out.println("editarFornecedor");
        String cnpjAntigo = "";
        String cnpjNovo = "";
        Endereco endereco = null;
        List<String> telefones = null;
        String nome = "";
        GerenciadorDePessoas instance = null;
        instance.editarFornecedor(cnpjAntigo, cnpjNovo, endereco, telefones, nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removerFornecedor method, of class GerenciadorDePessoas.
     */
    @Test
    public void testRemoverFornecedor() throws Exception {
        System.out.println("removerFornecedor");
        String cnpj = "";
        GerenciadorDePessoas instance = null;
        instance.removerFornecedor(cnpj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pesquisarFornecedorPeloNome method, of class GerenciadorDePessoas.
     */
    @Test
    public void testPesquisarFornecedorPeloNome() {
        System.out.println("pesquisarFornecedorPeloNome");
        String nome = "";
        GerenciadorDePessoas instance = null;
        List<Fornecedor> expResult = null;
        List<Fornecedor> result = instance.pesquisarFornecedorPeloNome(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pesquisarFornecedorPeloCnpj method, of class GerenciadorDePessoas.
     */
    @Test
    public void testPesquisarFornecedorPeloCnpj() throws Exception {
        System.out.println("pesquisarFornecedorPeloCnpj");
        String cnpj = "";
        GerenciadorDePessoas instance = null;
        Fornecedor expResult = null;
        Fornecedor result = instance.pesquisarFornecedorPeloCnpj(cnpj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of carregarPessoas method, of class GerenciadorDePessoas.
     */
    @Test
    public void testCarregarPessoas() {
        System.out.println("carregarPessoas");
        GerenciadorDePessoas instance = null;
        instance.carregarPessoas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClientes method, of class GerenciadorDePessoas.
     */
    @Test
    public void testGetClientes() {
        System.out.println("getClientes");
        GerenciadorDePessoas instance = null;
        List<Cliente> expResult = null;
        List<Cliente> result = instance.getClientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClientes method, of class GerenciadorDePessoas.
     */
    @Test
    public void testSetClientes() {
        System.out.println("setClientes");
        List<Cliente> clientes = null;
        GerenciadorDePessoas instance = null;
        instance.setClientes(clientes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFornecedores method, of class GerenciadorDePessoas.
     */
    @Test
    public void testGetFornecedores() {
        System.out.println("getFornecedores");
        GerenciadorDePessoas instance = null;
        List<Fornecedor> expResult = null;
        List<Fornecedor> result = instance.getFornecedores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFornecedores method, of class GerenciadorDePessoas.
     */
    @Test
    public void testSetFornecedores() {
        System.out.println("setFornecedores");
        List<Fornecedor> fornecedores = null;
        GerenciadorDePessoas instance = null;
        instance.setFornecedores(fornecedores);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAdministradores method, of class GerenciadorDePessoas.
     */
    @Test
    public void testGetAdministradores() {
        System.out.println("getAdministradores");
        GerenciadorDePessoas instance = null;
        List<Administrador> expResult = null;
        List<Administrador> result = instance.getAdministradores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAdministradores method, of class GerenciadorDePessoas.
     */
    @Test
    public void testSetAdministradores() {
        System.out.println("setAdministradores");
        List<Administrador> administradores = null;
        GerenciadorDePessoas instance = null;
        instance.setAdministradores(administradores);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmpregados method, of class GerenciadorDePessoas.
     */
    @Test
    public void testGetEmpregados() {
        System.out.println("getEmpregados");
        GerenciadorDePessoas instance = null;
        List<Empregado> expResult = null;
        List<Empregado> result = instance.getEmpregados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmpregados method, of class GerenciadorDePessoas.
     */
    @Test
    public void testSetEmpregados() {
        System.out.println("setEmpregados");
        List<Empregado> empregados = null;
        GerenciadorDePessoas instance = null;
        instance.setEmpregados(empregados);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
