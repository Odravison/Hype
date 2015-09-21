package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.dao.VendaJpaRepository;
import br.oltecnologias.hype.exception.ProdutoInexistenteException;
import br.oltecnologias.hype.exception.VendaInexistenteException;
import br.oltecnologias.hype.model.Produto;
import br.oltecnologias.hype.model.ProdutoVendido;
import br.oltecnologias.hype.model.Venda;
import java.awt.print.PrinterException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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

    public Venda realizarVenda(Venda venda) throws ProdutoInexistenteException, VendaInexistenteException, IOException, FileNotFoundException, PrinterException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        VendaJpaRepository vjp = new VendaJpaRepository(emf);
        try {
            for (ProdutoVendido pv: venda.getProdutosVendidos()){
                GerenciadorDeProduto.getInstance().removerQuantidade(pv.getCodigoProduto(), pv.getQuantidade());
            }
            vjp.create(venda);
//            venda.gerarEImprimirRecibo();
            
            return venda;
            
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
                retorno += GerenciadorDeProduto.getInstance().pesquisarProdutoPeloCodigo(p.getCodigoProduto()).getNome() + ", ";
            
            }
            return retorno;
        } finally {
            emf.close();
        }
    }
    
    public List<Venda> getMostRecentsSales() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        VendaJpaRepository vjp = new VendaJpaRepository(emf);

        List<Venda> listaOrdenada = new ArrayList<Venda>();

        try {
            listaOrdenada = vjp.getAllVendas();

            Collections.sort(listaOrdenada, (Object o1, Object o2) -> {
                Venda l1 = (Venda) o1;
                Venda l2 = (Venda) o2;
                return l1.getDataVenda().getTimeInMillis() <= l2.getDataVenda().getTimeInMillis() ? +1
                        : (l1.getDataVenda().getTimeInMillis() >= l2.getDataVenda().getTimeInMillis() ? -1 : 0);
            });

        } finally {
            emf.close();
        }

        return listaOrdenada;
    }
    
    public List<Venda> pesquisarVendasPorData(Calendar dataPesquisada){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        VendaJpaRepository vjp = new VendaJpaRepository(emf);
        
        List<Venda> listaDeRetorno = new ArrayList<Venda>();
        
        try{
            for (Venda v: vjp.getAllVendas()){
                if (v.getDataVenda().get(Calendar.DAY_OF_YEAR) == dataPesquisada.get(Calendar.DAY_OF_YEAR)
                        && v.getDataVenda().get(Calendar.YEAR) == dataPesquisada.get(Calendar.YEAR)){
                    listaDeRetorno.add(v);
                }
            }
            
            return listaDeRetorno;
            
        } finally {
            emf.close();
        }
    }
    
    public List<Produto> getProdutosDeVenda(long id) throws ProdutoInexistenteException, VendaInexistenteException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        VendaJpaRepository vjp = new VendaJpaRepository(emf);
        
        try{
            List<Produto> retorno = new ArrayList<Produto>();
            List<ProdutoVendido> produtosVendidos = this.pesquisarVendaPorId(id).getProdutosVendidos();
            for (ProdutoVendido pv: produtosVendidos){
                retorno.add(GerenciadorDeProduto.getInstance().pesquisarProdutoPeloCodigo(pv.getCodigoProduto()));
            }
            return retorno;
            
            
        } finally{
            emf.close();
        }
    }

    public void editarVenda(Venda venda) throws VendaInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        VendaJpaRepository vjp = new VendaJpaRepository(emf);
        
        try{
            
            vjp.editarVenda(venda);
            
        } finally {
            emf.close();
        }
    }
    
    

}
