package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.dao.VendaJpaRepository;
import br.oltecnologias.hype.exception.ProdutoInexistenteException;
import br.oltecnologias.hype.exception.VendaInexistenteException;
import br.oltecnologias.hype.model.Produto;
import br.oltecnologias.hype.model.ProdutoVendido;
import br.oltecnologias.hype.model.Venda;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerenciadorDeVenda {

    private static GerenciadorDeVenda singleton = null;

    private GerenciadorDeVenda() {

    }

    public static GerenciadorDeVenda getInstance() {
        if (singleton == null) {
            singleton = new GerenciadorDeVenda();
        }
        return singleton;
    }

    public void realizarVenda(Venda venda) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        VendaJpaRepository vjp = new VendaJpaRepository(emf);
        try {
            vjp.create(venda);
            
        } finally {
            if (emf != null){
                emf.close();
            }
        }

    }

    public List<Venda> getVendas() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        VendaJpaRepository vjp = new VendaJpaRepository(emf);
        
        try{
            return vjp.getAllVendas();
        } finally { 
            if (emf != null){
                emf.close();
            }
        }
    }
    
    public Venda pesquisarVendaPorId(long id) throws VendaInexistenteException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        VendaJpaRepository vjp = new VendaJpaRepository(emf);
        
        try{
            return vjp.findById(id);
        } finally{
            if (emf != null){
                emf.close();
            }
        }
    }
    
    public String getProdutosDeVendaInString(long idVenda) throws ProdutoInexistenteException, VendaInexistenteException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        VendaJpaRepository vjp = new VendaJpaRepository(emf);
        String retorno = "";
        try {
            
            Venda venda = vjp.findById(idVenda);
            for (ProdutoVendido p: venda.getProdutosVendidos()){
                retorno += GerenciadorDeProduto.getInstance().pesquisarProdutoPeloCodigo(p.getId()).getDescricao();
            
            }
            return retorno;
        } finally {
            emf.close();
        }
    }

}
