package br.oltecnologias.hype;

import br.oltecnologias.hype.model.Cliente;
import br.oltecnologias.hype.model.Endereco;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Odravison
 */
public class Aplicacao {

    /**
     * Método que inicializa a aplicação
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Opa");
        
        String telefone1 = "1234-5678";
        String telefone2 = "1234-5678";
        
        Endereco end = new Endereco("Coronel", "13 de maio", "Paraíba", 49, "João Pessoa");
        
        List<String> telefones = new ArrayList<String>();
        telefones.add(telefone1);
        telefones.add(telefone2);
        
        Medidas medidas = new Medidas(10,10,10,10,10,10,"obs");
        
        
        Cliente cliente = new Cliente();
        
    }
    
}
