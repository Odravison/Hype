package br.oltecnologias.hype;

//import br.oltecnologias.hype.dao.ClienteJpaController;
//import br.oltecnologias.hype.dao.ConfiguracaoJpaController;
//import br.oltecnologias.hype.dao.MedidasJpaController;
import br.oltecnologias.hype.dao.ClienteJpaController;
import br.oltecnologias.hype.dao.ConfiguracaoJpaController;
import br.oltecnologias.hype.dao.MedidasJpaController;
import br.oltecnologias.hype.dao.ProdutoJpaController;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
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
        System.out.println("Opa");
        System.out.println("Simulação de persistência do singleton: Configuração");

        String telefone1 = "1234-5678";
        String telefone2 = "1234-5678";

        Endereco end = new Endereco("Coronel", "13 de maio", "Paraíba", 49, "João Pessoa");

        Medidas medidas = new Medidas(10, 10, 10, 10, 10, 10, 10, "obs1");
        Medidas medidas2 = new Medidas(10, 10, 10, 10, 10, 10, 10, "obs1");
        Cliente cliente = new Cliente("1234566", "Luender Viado Lima", end, medidas, telefone1, telefone2);

        

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        
//        ProdutoJpaController pjp = new ProdutoJpaController(emf);
//        
        List<Produto> produtos = new ArrayList<Produto>();

        for (int i = 0; i < 6; i++) {
            Endereco enderecoo = new Endereco("Av. Pres. Epitácio Pessoa", "Centro", "Paraíba", 1234, "João Pessoa");
            String fornecedor = "EMIRATES";
            Produto p = new Produto("AT40P507" + i, "Suéter1", 40, i + 1, fornecedor , "Azul", 40, true);
            produtos.add(p);
//            pjp.destroy(p.getCodigo());
        }
        
        Locacao locacao = new Locacao(cliente, produtos, 234, Calendar.getInstance(), Calendar.getInstance(), telefone2);
        List<Locacao> locacoes = new ArrayList<Locacao>();
        locacoes.add(locacao);

        cliente.setLocacoes(locacoes);
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        em.persist(cliente);
        
        em.getTransaction().commit();
        
        
//        ClienteJpaController cjp = new ClienteJpaController(emf);
//        cjp.create(cliente);
//        System.out.println(cjp.findCliente(cliente.getCpf()).getNome());
//        cliente.setNome("lulisssss");
//        cjp.edit(cliente);
//        cjp.destroy(cliente.getCpf());

        emf.close();

        System.out.println("Funfou");

//        ConfiguracaoJpaController confJpa = new ConfiguracaoJpaController(emf);
//        try {
//            Configuracao config = Configuracao.getInstance();
//            config.setDiasEmprestimo(4);
//            config.setContratoOriginal("asdfasdfasdfasdf");
//            config.setDiretorioDeBackup("asdfasdfasdfasfd");
//            config.setDiretorioDeContratos("asdfasdfasdfasdf");
//            Endereco endereco = new Endereco("asdfad", "asdfasdf", "asdfasdfasdf", 12, "asdfasdf");
//            config.setEmpresa(new Empresa("asdfasdf", "asdfasdf", "asdfasdfa", endereco));
//            
//            confJpa.create(config);
//            System.out.println("ID DA CONFIGURACAO ======>>>>" + Integer.toString(config.getId()));
//            System.out.println("Quantas config ==============>>>> " + confJpa.getConfiguracaoCount());
//            confJpa.destroy(config.getId());
//            System.out.println("==============>>>> " + confJpa.getConfiguracaoCount());
////            confJpa.create(config);
////            config.setContratoOriginal("a");
////            confJpa.edit(config);
//            
//        } catch (Exception ex) {
//            Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        MedidasJpaController ctM = new MedidasJpaController(emf);
//
//        try {
////            ctM.create(medidas);
////            ctM.create(medidas2);
//            cjp.create(cliente);
//            
//            for (Medidas med : ctM.findMedidasEntities()) {
//                System.out.println("==============>>>> Medidas " +  med.getObservacao());
//            }
//        }catch(Exception e){
//            Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, e);
//        }
//        
//        emf.close();
//
//        System.out.println("Funcionou :D");
//        System.out.println("SIMULAÇÃO DE CONTRATO");
//
//        Configuracao conf = Configuracao.getInstance();
//        Endereco endereco = new Endereco("Av. Picamonhagaba", "Centro", "Paraíba", 40, "João Pessoa");
//        conf.setEmpresa(new Empresa("1234566", "Luender sexShop", "1234-5678", endereco));
//        conf.setDiasEmprestimo(2);
//        conf.setDiretorioDeContratos("C:\\Users\\Odravison\\Desktop");
//
//        Cliente luender;
//        luender = new Cliente("123456789012", "José Luender de Lima Santos", endereco, new Medidas(10, 10, 10, 10, 10, 10, 10, "osb"),
//                "3222-2222", "(83)98763-3232");
//
//
//        Locacao locacao = new Locacao(luender, produtos, 240, Calendar.getInstance());
//
//        GeradorDeContrato ger = GeradorDeContrato.getInstance();
//        ger.imprimirContrato(luender, locacao.getDataLocacao(), locacao.getDataDevolucao(), produtos);
//
//        System.out.println("PASSOU");
    }
}
