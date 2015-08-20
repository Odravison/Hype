package br.oltecnologias.hype;

import br.oltecnologias.hype.dao.MedidasJpaController;
import br.oltecnologias.hype.model.Cliente;
import br.oltecnologias.hype.model.Endereco;
import br.oltecnologias.hype.model.Medidas;
import java.util.ArrayList;
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
    public static void main(String[] args) {
        System.out.println("Opa");

//        String telefone1 = "1234-5678";
//        String telefone2 = "1234-5678";
//        
//        Endereco end = new Endereco("Coronel", "13 de maio", "Paraíba", 49, "João Pessoa");
//        
//        List<String> telefones = new ArrayList<String>();
//        telefones.add(telefone1);
//        telefones.add(telefone2);
        Medidas medidas = new Medidas(10, 10, 10, 10, 10, 10, "obs");

//        Cliente cliente = new Cliente("1234566", end, medidas, "123456", telefones);
//        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hypepu");
//        
//        ClienteJpaController cjp = new ClienteJpaController(emf);
//        
//        try {
//            cjp.create(cliente);
//            System.out.println(cjp.findCliente("1234566").getNome());
//        } catch (Exception ex) {
//            Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
//        }

        MedidasJpaController ctM = new MedidasJpaController(emf);

        try {
            for (Medidas med : ctM.findMedidasEntities()) {
                System.out.println(med.getObservacao());
            }
        }catch(Exception e){
            Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, e);
        }

        System.out.println("Funcionou :D");

    }

}
