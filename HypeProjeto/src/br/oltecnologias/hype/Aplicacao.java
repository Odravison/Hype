package br.oltecnologias.hype;

//import br.oltecnologias.hype.dao.ClienteJpaController;
//import br.oltecnologias.hype.dao.ConfiguracaoJpaController;
//import br.oltecnologias.hype.dao.MedidasJpaController;
//import br.oltecnologias.hype.dao.ClienteJpaController;
//import br.oltecnologias.hype.dao.ConfiguracaoJpaController;
//import br.oltecnologias.hype.dao.MedidasJpaController;
//import br.oltecnologias.hype.dao.ProdutoJpaController;
import br.oltecnologias.hype.controller.GerenciadorDeLocacao;
import br.oltecnologias.hype.controller.GerenciadorDePessoas;
import br.oltecnologias.hype.dao.ClienteJpaRepository;
import br.oltecnologias.hype.dao.LocacaoJpaRepository;
import br.oltecnologias.hype.dao.ProdutoJpaRepository;
import br.oltecnologias.hype.model.Cliente;
import br.oltecnologias.hype.model.Configuracao;
import br.oltecnologias.hype.model.Empresa;
import br.oltecnologias.hype.model.Endereco;
import br.oltecnologias.hype.model.Fornecedor;
import br.oltecnologias.hype.model.GeradorDeContrato;
import br.oltecnologias.hype.model.Locacao;
import br.oltecnologias.hype.model.Medidas;
import br.oltecnologias.hype.model.Produto;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Odravison
 */
public class Aplicacao {

    /**
     * Método que inicializa a aplicação
     *
     * @param args
     */
    public static void main(String[] args) throws DocumentException, IOException, Exception {

        System.out.println("####################### Realizando os seguintes testes: ########################### \n"
                + "Teste de cadastro/edição/remoção de produto; \n"
                + "Teste de cadastro/edição/remoção de locações \n"
                + "Teste de cadastro/edição/remoção de cliente \n"
                + "SIMULAÇÃO DE UMA LOCAÇÃO");

        System.out.println(" ================== Criação das entidades ======================");

        Endereco endereco = new Endereco("Rua Onde Judas Perdeu as Botas", "Bairro de Canto Nenhum", "OZ", 40, "Cidade Fantasma");
        Medidas medidas = new Medidas(10, 10, 10, 10, 10, 10, 10, "Se liga Luender, a gente vai ganhar muito dinheiro");

        Cliente cliente = new Cliente("123456789012", "José Luender", endereco, medidas, "3224-2424", "8888-8888");

        HashMap<String, Integer> produtosDeLocacao = new HashMap<String, Integer>();
        List<Produto> produtosDeEstoque = new ArrayList<Produto>();

        for (int i = 0; i < 10; i++) {
            produtosDeLocacao.put("AAAAAAA" + i, i + 1);

            Produto p = new Produto("AAAAAAA" + i, "Roupa de Varal", 40.00, i, "Envio de Roupas.com", "Branca", 38, true);
            produtosDeEstoque.add(p);
        }

        Locacao locacao = new Locacao(cliente, produtosDeLocacao, 400.00, Calendar.getInstance(), Calendar.getInstance(), "À VISTA", 0, 0);
        List<Locacao> locacoes = new ArrayList<Locacao>();
        locacoes.add(locacao);

        cliente.setLocacoes(locacoes);

        try {
            System.out.println("COMEÇANDO OS TESTES DAS FUNÇÕES DE GERENCIADOR DE PESSOAS");
            
            GerenciadorDePessoas.getInstance().cadastrarCliiente(cliente);
            System.out.println("CADASTRAR CLIENTE: ==================> OK");
            
            cliente.setCelular("9999999999");
            GerenciadorDePessoas.getInstance().editarCliente(cliente);
            System.out.println("EDITAR CLIENTE: ==================> OK");
            
            if (GerenciadorDePessoas.getInstance().getClientes().size() > 0){
                System.out.println("GETCLIENTES: ==================> OK");
            }
            
            if (GerenciadorDePessoas.getInstance().getMostRecentLocationsByClientes().size() > 0){
                System.out.println("LISTAR LOCAÇÕES MAIS RECENTES: ==================> OK");
            }
            
            if ( GerenciadorDePessoas.getInstance().pesquisarCliente("123456789012").equals(cliente)){
                System.out.println("PESQUISAR CLIENTE: ==================> OK");
            }
            
            int quantidade = 0; int comNomes = 0;
            for (Cliente c: GerenciadorDePessoas.getInstance().pesquisarClientesPorNome("josé")){
                quantidade++;
                if (c.getNome().contains("josé")){
                    comNomes++;
                    
                }
            }
            System.out.println("Clientes cadastrados: " + quantidade + "Com nome que tenha o que foi pesquisado: " + comNomes);
            
            GerenciadorDePessoas.getInstance().removerCliente(cliente.getCpf());
            if (GerenciadorDePessoas.getInstance().getClientes().size() == 0){
                System.out.println("REMOVER CLIENTE: ==================> OK");
            } else{
                System.out.println("REMOVER CLIENTE: ==================> FALHOU");
            }
            
            System.out.println("TODOS OS TESTES FORAM EXECUTADOS");
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
