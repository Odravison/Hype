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
import br.oltecnologias.hype.gui.CadastrarDiretoriosDialog;
import br.oltecnologias.hype.gui.CadastrarEmpresaDialog;
import br.oltecnologias.hype.gui.LoginFrame;
import br.oltecnologias.hype.gui.PrincipalFrame;
import br.oltecnologias.hype.model.Cliente;
import br.oltecnologias.hype.model.Configuracao;
import br.oltecnologias.hype.model.Despesa;
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
import java.util.Random;
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
    public static String gerar() {
        Random geradorAux = new Random();
        int i = geradorAux.nextInt();
        Random gerador;
        gerador = new Random(i);
        Long l = gerador.nextLong();
        while (l < 0) {
            l = gerador.nextLong();
        }
        return Long.toString(l).substring(0, 11);
    }

    public static String gerarCodigoProduto() {
        Random geradorAux = new Random();
        int i = geradorAux.nextInt();
        Random gerador;
        gerador = new Random(i);
        Long l = gerador.nextLong();
        while (l < 0) {
            l = gerador.nextLong();
        }
        return Long.toString(l).substring(0, 8);
    }

    public static void main(String[] args) throws DocumentException, IOException, Exception {
        Random gerador = new Random();

        for (int i = 0; i < 100; i++) {
            System.out.println(gerar());
            GerenciadorDePessoas.getInstance().cadastrarCliiente(new Cliente(gerar(), "Tesste " + i,
                    new Endereco("Rua fulano de tal " + i, "Bairro do teste", "PB", i, "JAMPA"),
                    new Medidas(i, i, i, i, i, i, i, "asdfasdfasdf"), null, "(83)99658-6798"));

            GerenciadorDeProduto.getInstance().cadastrarProduto(new Produto(gerarCodigoProduto(), "nome do produto " + i, (30 * i) + 1, i + 1,
                    null, "PRETO", i, gerador.nextBoolean()));
            
            GerenciadorDoSistema.getInstance().cadastrarDespesa(new Despesa("Pagamento " + i+1, "Blá Blá Blá", Calendar.getInstance(), (1+i)*40, "Doido " + i, "O governo"));
            
            System.out.println(i);
        
        }

    }
}
