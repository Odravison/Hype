package br.oltecnologias.hype.aplicacao;

//import br.oltecnologias.hype.dao.ClienteJpaController;
//import br.oltecnologias.hype.dao.ConfiguracaoJpaController;
//import br.oltecnologias.hype.dao.MedidasJpaController;
//import br.oltecnologias.hype.dao.ClienteJpaController;
//import br.oltecnologias.hype.dao.ConfiguracaoJpaController;
//import br.oltecnologias.hype.dao.MedidasJpaController;
//import br.oltecnologias.hype.dao.ProdutoJpaController;
import br.oltecnologias.hype.controller.GerenciadorDeLocacao;
import br.oltecnologias.hype.controller.GerenciadorDePessoas;
import br.oltecnologias.hype.controller.GerenciadorDeProduto;
import br.oltecnologias.hype.controller.GerenciadorDoSistema;
import br.oltecnologias.hype.dao.ClienteJpaRepository;
import br.oltecnologias.hype.dao.LocacaoJpaRepository;
import br.oltecnologias.hype.dao.ProdutoJpaRepository;
import br.oltecnologias.hype.dao.VendaJpaRepository;
import br.oltecnologias.hype.gui.LoginFrame;
import br.oltecnologias.hype.model.Cliente;
import br.oltecnologias.hype.model.Configuracao;
import br.oltecnologias.hype.model.Empresa;
import br.oltecnologias.hype.model.Endereco;
import br.oltecnologias.hype.model.Fornecedor;
import br.oltecnologias.hype.model.GeradorDeContrato;
import br.oltecnologias.hype.model.Locacao;
import br.oltecnologias.hype.model.Medidas;
import br.oltecnologias.hype.model.Movimentacao;
import br.oltecnologias.hype.model.Produto;
import br.oltecnologias.hype.model.ProdutoLocado;
import br.oltecnologias.hype.model.ProdutoVendido;
import br.oltecnologias.hype.model.Usuario;
import br.oltecnologias.hype.model.Venda;
import com.itextpdf.text.DocumentException;
import java.awt.BorderLayout;
import java.io.File;
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
//        System.out.println("####################### Realizando os seguintes testes: ########################### \n"
//                + "Teste de cadastro/edição/remoção de produto; \n"
//                + "Teste de cadastro/edição/remoção de locações \n"
//                + "Teste de cadastro/edição/remoção de cliente \n"
//                + "SIMULAÇÃO DE UMA LOCAÇÃO");
//
//        System.out.println(" ================== Criação das entidades ======================");
//
//        Endereco endereco = new Endereco("Rua Onde Judas Perdeu as Botas", "Bairro de Canto Nenhum", "OZ", 40, "Cidade Fantasma");
//        Medidas medidas = new Medidas(10, 10, 10, 10, 10, 10, 10, "Se liga Luender, a gente vai ganhar muito dinheiro");
//
//        Cliente cliente = new Cliente("123456789012", "José Luender", endereco, medidas, "3224-2424", "8888-8888");
//
//        List<ProdutoLocado> produtosDeLocacao = new ArrayList<ProdutoLocado>();
//        List<Produto> produtosDeEstoque = new ArrayList<Produto>();
//
//        for (int i = 0; i < 10; i++) {
//            Produto p = new Produto("AAAAAAA" + i, "Roupa de Varal", 40.00, i, "Envio de Roupas.com", "Branca", 38, true);
//            GerenciadorDeProduto.getInstance().cadastrarProduto(p);
//
//        }
//
//        for (Produto p : produtosDeEstoque) {
//            if (p.getQuantidade() > 0) {
//
//                produtosDeLocacao.add(new ProdutoLocado(p.getCodigo(), p.getQuantidade() - 1));
//                p.removerQuant(1);
//
//            }
//        }
//
//        Locacao locacao = new Locacao(cliente, produtosDeLocacao, 400.00, Calendar.getInstance(), Calendar.getInstance(), "À VISTA", 0, 0, 0);
//        List<Locacao> locacoes = new ArrayList<Locacao>();
//        locacoes.add(locacao);
//
//        cliente.setLocacoes(locacoes);
//
//        try {
//            System.out.println("COMEÇANDO OS TESTES DAS FUNÇÕES DE GERENCIADOR DE PESSOAS");
//
//            GerenciadorDePessoas.getInstance().cadastrarCliiente(cliente);
//            System.out.println("CADASTRAR CLIENTE: ==================> OK");
//
//            cliente.setCelular("9999999999");
//            GerenciadorDePessoas.getInstance().editarCliente(cliente);
//            System.out.println("EDITAR CLIENTE: ==================> OK");
//
//            if (GerenciadorDePessoas.getInstance().getClientes().size() > 0) {
//                System.out.println("GETCLIENTES: ==================> OK");
//            }
//
//            if (GerenciadorDePessoas.getInstance().getLocacoesMaisRecentsPorCliente().size() > 0) {
//                System.out.println("LISTAR LOCAÇÕES MAIS RECENTES: ==================> OK");
//            }
//
//            if (GerenciadorDePessoas.getInstance().pesquisarCliente("123456789012").equals(cliente)) {
//                System.out.println("PESQUISAR CLIENTE: ==================> OK");
//            }
//
//            int quantidade = 0;
//            int comNomes = 0;
//            for (Cliente c : GerenciadorDePessoas.getInstance().pesquisarClientesPorNome("JOSÉ")) {
//                quantidade++;
//                if (c.getNome().toUpperCase().contains("JOSÉ")) {
//                    comNomes++;
//
//                }
//            }
//            System.out.println("Clientes cadastrados: " + quantidade + " Com nome que tenha o que foi pesquisado: " + comNomes);
//
//            System.out.println("============ANTES=====>>>>>>>>>>>>>>>> Tamanho da lista de Pessoas: " + GerenciadorDePessoas.getInstance().getClientes().size());
//            System.out.println("=============ANTES====>>>>>>>>>>>>>>>> Tamanho da lista de Locacao: " + GerenciadorDeLocacao.getInstance().getLocacoes().size());
//            GerenciadorDePessoas.getInstance().removerCliente(cliente.getCpf());
//
//            System.out.println("=======DEPOIS==========>>>>>>>>>>>>>>>> Tamanho da lista de Pessoas: " + GerenciadorDePessoas.getInstance().getClientes().size());
//            System.out.println("=======DEPOIS==========>>>>>>>>>>>>>>>> Tamanho da lista de Locacao: " + GerenciadorDeLocacao.getInstance().getLocacoes().size());
//
//            if (GerenciadorDePessoas.getInstance().getClientes().size() == 0) {
//                System.out.println("REMOVER CLIENTE: ==================> OK");
//            } else {
//                System.out.println("REMOVER CLIENTE: ==================> FALHOU");
//            }
//
//            System.out.println("TODOS OS TESTES FORAM EXECUTADOS");
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//
//        }

//                Configuracao conf = GerenciadorDoSistema.getInstance().getConfiguracao();
//                conf.setDiretorioDeRelatorios("C:\\ProjetoCloset");
//                conf.setDiretorioDeDocumentos("C:\\ProjetoCloset");
//                List<Venda> movimentacoes = new ArrayList<Venda>();
//                List<ProdutoVendido> lista = new ArrayList<ProdutoVendido>();
//                
//                Usuario u = new Usuario("Luender", "Luendinho", "1234", true);
//                Endereco end = new Endereco("Rua fulano de tal", "Bairro do 13", "PB", 49, "João Pessoa");
//                Empresa empresa = new Empresa("1234556788", "Luender Roupas", "1234-1234", end);
//                conf.setEmpresa(empresa);
//                GerenciadorDoSistema.getInstance().salvarEstadoDeConfiguracao(conf);
//                GerenciadorDoSistema.getInstance().setUsuarioLogado(u);
//                
//                
//                
//                Calendar dataInicial = Calendar.getInstance();
//                
//                for (int i = 0; i < 10; i++){
//                    movimentacoes.add(new Venda(lista, i, "À VISTA", Calendar.getInstance(), i, i, 10));
//                }
//                for (Venda m: movimentacoes){
//                    GerenciadorDoSistema.getInstance().adicionarMovimentacao(m, "VENDA");
//                }
//                
//                Calendar dataFinal = Calendar.getInstance();
//                
//                GerenciadorDoSistema.getInstance().gerarRelatorioDeCaixa(dataInicial, dataFinal);
//                
//                System.out.println("RODOU");
        
//        for (Locacao l: GerenciadorDePessoas.getInstance().pesquisarCliente("096.961.514-03").getLocacoes()){
//            System.out.println(l.getId());
//            System.out.println("O cliente tem locações de quantidade: " 
//                    + GerenciadorDePessoas.getInstance().pesquisarCliente("096.961.514-03").getLocacoes().size());
//            
//            
//        }
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

            desktop.open(new File("C:\\"));
                
    }
}
