package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.dao.LocacaoJpaRepository;
import br.oltecnologias.hype.exception.ClienteExistenteException;
import br.oltecnologias.hype.exception.ClienteInexistenteException;
import br.oltecnologias.hype.exception.ContratoNaoGeradoException;
import br.oltecnologias.hype.exception.LocacaoExistenteException;
import br.oltecnologias.hype.exception.ProdutoInexistenteException;
import br.oltecnologias.hype.exception.LocacaoInexistenteException;
import br.oltecnologias.hype.exception.TipoInexistenteDeMovimentacao;
import br.oltecnologias.hype.model.Locacao;
import br.oltecnologias.hype.model.Cliente;
import br.oltecnologias.hype.model.Configuracao;
import br.oltecnologias.hype.model.Produto;
import br.oltecnologias.hype.model.ProdutoLocado;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Collections;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerenciadorDeLocacao {

    private static GerenciadorDeLocacao singleton = null;

    private GerenciadorDeLocacao() {

    }

    public static GerenciadorDeLocacao getInstance() {
        if (singleton == null) {
            singleton = new GerenciadorDeLocacao();
        }
        return singleton;
    }

    // FALTA TESTAR
    public Locacao realizarLocacao(Cliente cliente, List<ProdutoLocado> produtosLocados, double valor,
            Calendar dataLocacao, Calendar dataDeDevolucao, String formaDePagamento, int parcelas,
            double entrada, int percentualDesconto) throws ProdutoInexistenteException, LocacaoExistenteException,
            ClienteInexistenteException, TipoInexistenteDeMovimentacao, ClienteExistenteException,
            LocacaoInexistenteException, IOException, Exception {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        LocacaoJpaRepository ljp = new LocacaoJpaRepository(emf);

        Locacao locacao = null;

        try {

            double valorFinal = valor - ((percentualDesconto / 100) * valor);
            locacao = new Locacao(cliente, produtosLocados, valorFinal, dataLocacao,
                    dataDeDevolucao, formaDePagamento, parcelas, entrada, percentualDesconto);
            locacao.setAtiva(true);

            ljp.create(locacao);

            cliente.adicionarLocacao(locacao);
            GerenciadorDePessoas.getInstance().editarCliente(cliente);

            for (ProdutoLocado p : produtosLocados) {
                GerenciadorDeProduto.getInstance().removerQuantidade(p.getCodigoProduto(), p.getQuantidade());
            }
            
            locacao.imprimirContrato();
            
            return locacao;
            
        } finally {
            emf.close();
        }
        
        
    }

    public List<Locacao> getLocacoes() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        LocacaoJpaRepository ljp = new LocacaoJpaRepository(emf);
        List<Locacao> locacoesRetorno = new ArrayList<Locacao>();

        try {

            locacoesRetorno = ljp.getAllLocacao();

        } finally {
            emf.close();
        }

        return locacoesRetorno;
    }

    public void finalizarLocacao(long idLoc, Cliente cliente)
            throws ProdutoInexistenteException, LocacaoInexistenteException, ClienteInexistenteException, ClienteExistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        LocacaoJpaRepository ljp = new LocacaoJpaRepository(emf);

        List<Locacao> locacoes = new ArrayList<Locacao>();
        List<Locacao> locacoesDoCliente = new ArrayList<Locacao>();
        List<ProdutoLocado> produtosDaLocacao = new ArrayList<ProdutoLocado>();

        Cliente clienteFinalizada = null;

        boolean emprestou = false;
        try {
            locacoes = ljp.getAllLocacao();
            locacoesDoCliente = ljp.getLocacaoByCliente(cliente.getCpf());
            produtosDaLocacao = ljp.getProdutosFromLocacao(idLoc);

            for (Locacao locacaoCliente : locacoesDoCliente) {
                if (locacaoCliente.getId() == idLoc) {
                    for (Locacao locacaoGer : locacoes) {
                        if (locacaoGer.getId() == idLoc
                                && cliente.getCpf().equals(locacaoGer.getCliente().getCpf())) {
                            emprestou = true;
                            for (ProdutoLocado p : produtosDaLocacao) {
                                GerenciadorDeProduto.getInstance().adicionarQuantidade(p.getCodigoProduto(), p.getQuantidade());
                            }

                            clienteFinalizada = GerenciadorDePessoas.getInstance().pesquisarCliente(cliente.getCpf());
                            locacaoCliente.setAtiva(!emprestou);
                            GerenciadorDePessoas.getInstance().editarCliente(clienteFinalizada);

                            //Verificar se a ação de cima vai cascatear para as filhas, caso não, é necessário executar o código abaixo.
//                        ljp.removerLocacao(locacaoGer);
                        }
                    }
                }

            }
        } finally {
            emf.close();
        }

        if (!(emprestou)) {
            throw new LocacaoInexistenteException("O cliente não possui a locação referente.");
        }

    }

    public List<Locacao> listarLocacoesPorDataDeLocacao(Calendar data) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        LocacaoJpaRepository ljp = new LocacaoJpaRepository(emf);

        List<Locacao> aux = new ArrayList<Locacao>();

        try {
            for (Locacao l : ljp.getAllLocacao()) {
                if (l.getDataLocacao().equals(data)) {
                    aux.add(l);
                }
            }
        } finally {
            emf.close();
        }

        return aux;
    }

    public List<Locacao> listarLocacoesPorDataDeDevolucao(Calendar data) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        LocacaoJpaRepository ljp = new LocacaoJpaRepository(emf);

        List<Locacao> aux = new ArrayList<Locacao>();

        try {
            for (Locacao l : ljp.getAllLocacao()) {
                if (l.getDataDevolucao().equals(data)) {
                    aux.add(l);
                }
            }
        } finally {
            emf.close();
        }

        return aux;
    }

    public List<Locacao> listarLocacoesExtraviadas() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        LocacaoJpaRepository ljp = new LocacaoJpaRepository(emf);

        List<Locacao> extraviadas = new ArrayList<Locacao>();

        try {
            Calendar dataExtravio = Calendar.getInstance();
            dataExtravio.add(Calendar.DAY_OF_MONTH, Configuracao.getInstance().getDiasDeExtravio());

            for (Locacao l : ljp.getAllLocacao()) {
                if (l.getDataDevolucao().before(dataExtravio)) {
                    extraviadas.add(l);
                }
            }
        } finally {
            emf.close();
        }

        return extraviadas;
    }

    public List<Locacao> listarLocacoesEmAtraso() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        LocacaoJpaRepository ljp = new LocacaoJpaRepository(emf);

        List<Locacao> atrasos = new ArrayList<Locacao>();

        try {
            for (Locacao l : ljp.getAllLocacao()) {
                if (l.getDataDevolucao().before(Calendar.getInstance())) {
                    atrasos.add(l);
                }
            }
        } finally {
            emf.close();
        }

        return atrasos;

    }

    public String getProdutosDeLocacaoInString(long idLocacao) throws LocacaoInexistenteException, ProdutoInexistenteException {
        String produtosLocados = "";
        for (Produto produto : this.getProdutosDeLocacao(idLocacao)) {
            produtosLocados += produto.getNome() + ", ";
        }
        return produtosLocados;

    }

    public List<Produto> getProdutosDeLocacao(long id) throws LocacaoInexistenteException, ProdutoInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        LocacaoJpaRepository ljp = new LocacaoJpaRepository(emf);

        try {
            List<ProdutoLocado> produtosLocado = ljp.getProdutosFromLocacao(id);
            List<Produto> retorno = new ArrayList<Produto>();
            for (ProdutoLocado p : produtosLocado) {
                retorno.add(GerenciadorDeProduto.getInstance().pesquisarProdutoPeloCodigo(p.getCodigoProduto()));
            }
            return retorno;
        } finally {
            emf.close();
        }
    }

    public List<Locacao> getMostRecentLocation() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        LocacaoJpaRepository ljp = new LocacaoJpaRepository(emf);

        List<Locacao> listaOrdenada = new ArrayList<Locacao>();

        try {
            listaOrdenada = ljp.getAllLocacao();

            Collections.sort(listaOrdenada, (Object o1, Object o2) -> {
                Locacao l1 = (Locacao) o1;
                Locacao l2 = (Locacao) o2;
                return l1.getDataLocacao().getTimeInMillis() <= l2.getDataLocacao().getTimeInMillis() ? +1
                        : (l1.getDataLocacao().getTimeInMillis() >= l2.getDataLocacao().getTimeInMillis() ? -1 : 0);
            });

        } finally {
            emf.close();
        }

        return listaOrdenada;
    }

    public Locacao pesquisarLocacaoPorId(long id) throws LocacaoInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        LocacaoJpaRepository ljp = new LocacaoJpaRepository(emf);
        Locacao loc = null;

        try {
            loc = ljp.findById(id);

        } finally {
            emf.close();
        }

        return loc;
    }

    public List<Locacao> pesquisarLocacoesDeCliente(String cpfCliente) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        LocacaoJpaRepository ljp = new LocacaoJpaRepository(emf);
        List<Locacao> locacoesDoCliente = new ArrayList<Locacao>();

        try {
            for (Locacao l : ljp.getAllLocacao()) {
                if (l.getCliente().getCpf().equals(cpfCliente)) {
                    locacoesDoCliente.add(l);
                }
            }
            return locacoesDoCliente;

        } finally {
            emf.close();
        }

    }

    public void verUltimoContratoGerado(long idLocacao) throws LocacaoInexistenteException, IOException, ContratoNaoGeradoException {

        Locacao locacao = this.pesquisarLocacaoPorId(idLocacao);

        if (locacao.getCaminhoUltimoContrato().equals("")) {
            throw new ContratoNaoGeradoException("O contrato para locação ainda não foi gerado");
        } else {
            File diretorio = new File(GerenciadorDoSistema.getInstance().getConfiguracao().getDiretorioDeDocumentos()
                    + "\\" + locacao.getCliente().getNome() + "\\Contratos\\" + locacao.getCaminhoUltimoContrato());

            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

            desktop.open(diretorio);
        }

    }
    
    public void gerarEImprimirPxRecibo(long idLocacao, double valorDessePagamento) throws LocacaoInexistenteException, ProdutoInexistenteException{
        Locacao locacao = this.pesquisarLocacaoPorId(idLocacao);
        
        locacao.gerarEImprimirPxRecibo(valorDessePagamento);
    }
}
