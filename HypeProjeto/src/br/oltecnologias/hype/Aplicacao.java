package br.oltecnologias.hype;

import br.oltecnologias.hype.dao.ClienteJpaController;
import br.oltecnologias.hype.dao.ConfiguracaoJpaController;

import br.oltecnologias.hype.model.Cliente;
import br.oltecnologias.hype.model.Configuracao;
import br.oltecnologias.hype.model.Empresa;
import br.oltecnologias.hype.model.Endereco;
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

//        String telefone1 = "1234-5678";
//        String telefone2 = "1234-5678";
//        
//        Endereco end = new Endereco("Coronel", "13 de maio", "Paraíba", 49, "João Pessoa");
//        
//        List<String> telefones = new ArrayList<String>();
//        telefones.add(telefone1);
//        telefones.add(telefone2);
//        Medidas medidas = new Medidas(10, 10, 10, 10, 10, 10, 10, "obs1");
//        Medidas medidas2 = new Medidas(10, 10, 10, 10, 10, 10, 10, "obs1");
//        Cliente cliente = new Cliente("1234566", end, medidas, "123456", telefones);
//        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hypepu");
        
//        ClienteJpaController cjp = new ClienteJpaController(emf);
        ConfiguracaoJpaController confJpa = new ConfiguracaoJpaController(emf);
        
        try {
            Configuracao config = Configuracao.getInstance();
            config.setContratoOriginal("asdfasdfasdfasdf");
            config.setDiasEmprestimo(4);
            config.setDiretorioDeBackup("asdfasdfasdfasfd");
            config.setDiretorioDeContratos("asdfasdfasdfasdf");
            Endereco endereco = new Endereco("asdfad", "asdfasdf", "asdfasdfasdf", 12, "asdfasdf");
            config.setEmpresa(new Empresa("asdfasdf", "asdfasdf", "asdfasdfa", endereco));
            
            confJpa.create(config);
            confJpa.destroy(config.getId());
            confJpa.create(config);
            config.setContratoOriginal("a");
            confJpa.edit(config);
            
        } catch (Exception ex) {
            Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
        }

//        MedidasJpaController ctM = new MedidasJpaController(emf);
//
//        try {
//            ctM.create(medidas);
//            //ctM.create(medidas2);
//            
//            for (Medidas med : ctM.findMedidasEntities()) {
//                System.out.println(med.getObservacao());
//            }
//        }catch(Exception e){
//            Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, e);
//        }
        
        emf.close();

        System.out.println("Funcionou :D");
        
        /*        System.out.println("SIMULAÇÃO DE CONTRATO");
        
        Configuracao conf = Configuracao.getInstance();
        Endereco endereco = new Endereco ("Av. Picamonhagaba", "Centro", "Paraíba", 40, "João Pessoa");
        conf.setEmpresa(new Empresa("1234566", "Luender sexShop", "1234-5678", endereco));
        conf.setDiasEmprestimo(2);
        conf.setDiretorioDeContratos("C:\\Users\\Odravison\\Desktop");
        
        Cliente luender;
        luender = new Cliente("123456789012", "José Luender de Lima Santos", endereco, new Medidas(10,10,10,10,10,10,10,"osb"),
        "123456", "3222-2222", "(83)98763-3232");
        
        List<Produto> produtos = new ArrayList<Produto>();
        
        for (int i = 0; i < 6; i++){
        Produto p = new Produto("Suéter1", 40, i+1, "Fornecedor1", "Azul", 40);
        produtos.add(p);
        }
        
        Locacao locacao = new Locacao(luender,produtos, 240, Calendar.getInstance() );
        
        GeradorDeContrato ger = GeradorDeContrato.getInstance();
        ger.gerarContrato(luender, locacao.getDataLocacao(), locacao.getDataDevolucao(), produtos);
        
        System.out.println("PASSOU");*/
        
        
        
        
    }

}
