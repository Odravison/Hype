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
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
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

    public Locacao realizarLocacao(Cliente cliente, List<ProdutoLocado> produtosLocados, double valor,
            Calendar dataLocacao, Calendar dataDeDevolucao, String formaDePagamento, int parcelas,
            double entrada, int percentualDesconto, String tipoDeEntradaPromissoria) throws ProdutoInexistenteException, LocacaoExistenteException,
            ClienteInexistenteException, TipoInexistenteDeMovimentacao, ClienteExistenteException,
            LocacaoInexistenteException, IOException, Exception {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        LocacaoJpaRepository ljp = new LocacaoJpaRepository(emf);

        Locacao locacao = null;

        try {
            locacao = new Locacao(cliente, produtosLocados, valor, dataLocacao,
                    dataDeDevolucao, formaDePagamento, parcelas, entrada, percentualDesconto,tipoDeEntradaPromissoria);
            locacao.setAtiva(true);

            //Persistindo a locação, ela modificará o objeto colocando seu ID;
            ljp.create(locacao);

            //Adicionando a locação AO cliente, e depois editando o cliente, para que sua referência fique atualizada;
            cliente.adicionarLocacao(locacao);
            GerenciadorDePessoas.getInstance().editarCliente(cliente);

            locacao.imprimirContrato();
            locacao.gerarRecibo();

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

    public void setUltimoCaminhoContrato(long id, String caminho) throws LocacaoInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        LocacaoJpaRepository ljp = new LocacaoJpaRepository(emf);

        try {

            Locacao loc = this.pesquisarLocacaoPorId(id);
            loc.setCaminhoUltimoContrato(caminho);
            ljp.editarLocacao(loc);

        } finally {
            emf.close();
        }
    }

    public void finalizarLocacao(long idLoc) throws LocacaoInexistenteException, ProdutoInexistenteException {

        Locacao locacao = this.pesquisarLocacaoPorId(idLoc);
        locacao.setAtiva(false);
        this.editarLocacao(locacao);

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
        List<Locacao> locacoesEmAtraso = new ArrayList<Locacao>();
        for (Locacao l : this.getLocacoesAtivas()) {
            if (!l.isFinalizada()) {
                if (!l.isLocacaoPaga()) {
                    if (l.getDataLocacao().get(Calendar.DAY_OF_YEAR) == Calendar.getInstance().get(Calendar.DAY_OF_YEAR)) {
                        locacoesEmAtraso.add(l);
                    }
                }
            }
        }

        return locacoesEmAtraso;

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
    
    public List<Locacao> getLocacoesMaisAntigas() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        LocacaoJpaRepository ljp = new LocacaoJpaRepository(emf);

        List<Locacao> listaOrdenada = new ArrayList<Locacao>();

        try {
            listaOrdenada = ljp.getAllLocacao();

            Collections.sort(listaOrdenada, (Object o1, Object o2) -> {
                Locacao l1 = (Locacao) o1;
                Locacao l2 = (Locacao) o2;
                return l1.getDataLocacao().getTimeInMillis() >= l2.getDataLocacao().getTimeInMillis() ? +1
                        : (l1.getDataLocacao().getTimeInMillis() <= l2.getDataLocacao().getTimeInMillis() ? -1 : 0);
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
        File diretorio = new File(GerenciadorDoSistema.getInstance().getConfiguracao().getDiretorioDeDocumentos()
                + "\\" + locacao.getCliente().getNome() + "\\Contratos");
        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
        desktop.open(diretorio);

//            System.out.println("agora sai no throws: ====>>>>> " + locacao.getCaminhoUltimoContrato());
//            throw new ContratoNaoGeradoException("O contrato para locação ainda não foi gerado");
    }

    public void gerarEImprimirPxReciboDeLocacao(long idLocacao, double valorDessePagamento) throws LocacaoInexistenteException, ProdutoInexistenteException, IOException, FileNotFoundException, PrinterException {
        Locacao locacao = this.pesquisarLocacaoPorId(idLocacao);

        locacao.gerarEImprimirPxRecibo(valorDessePagamento);
    }

    public boolean isLocacaoPaga(long idLocacao) throws LocacaoInexistenteException {
        Locacao locacao = this.pesquisarLocacaoPorId(idLocacao);
        return locacao.isLocacaoPaga();
    }

    public void editarLocacao(Locacao locacao) throws LocacaoInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        LocacaoJpaRepository ljp = new LocacaoJpaRepository(emf);

        try {

            ljp.editarLocacao(locacao);

        } finally {
            emf.close();
        }
    }

    public boolean isFinalizada(long idLocacao) throws LocacaoInexistenteException {
        return this.pesquisarLocacaoPorId(idLocacao).isFinalizada();
    }

    public List<Locacao> pesquisarLocacoesEntreDatas(Calendar dataInicio, Calendar dataFinal) {
        List<Locacao> locacoesEntreDatas = new ArrayList<Locacao>();
        int manutencao = GerenciadorDoSistema.getInstance().getDiasDeManutencao();
        int costureira = GerenciadorDoSistema.getInstance().getDiasDaCostureira();

        for (Locacao l : this.getLocacoes()) {
            if (l.isAtiva()) {
                Calendar dataLocNoPeriodo = l.getDataLocacao();
                dataLocNoPeriodo.add(Calendar.DAY_OF_MONTH, costureira);

                Calendar dataDevNoPeriodo = l.getDataDevolucao();
                dataDevNoPeriodo.add(Calendar.DAY_OF_MONTH, manutencao);

                if (dataLocNoPeriodo.get(Calendar.YEAR) >= dataInicio.get(Calendar.YEAR)
                        && dataDevNoPeriodo.get(Calendar.YEAR) <= dataFinal.get(Calendar.YEAR)) {

                    if ((dataLocNoPeriodo.get(Calendar.DAY_OF_YEAR) <= dataInicio.get(Calendar.DAY_OF_YEAR)
                            && dataDevNoPeriodo.get(Calendar.DAY_OF_YEAR) >= dataInicio.get(Calendar.DAY_OF_YEAR))
                            || (dataLocNoPeriodo.get(Calendar.DAY_OF_YEAR) <= dataFinal.get(Calendar.DAY_OF_YEAR)
                            && dataDevNoPeriodo.get(Calendar.DAY_OF_YEAR) >= dataFinal.get(Calendar.DAY_OF_YEAR))) {

                        locacoesEntreDatas.add(l);

                    }

                }
            }

        }

        return locacoesEntreDatas;

    }

    public List<Locacao> getLocacoesAtivas() {
        List<Locacao> locacoesAtivas = new ArrayList<Locacao>();
        for (Locacao l : this.getLocacoes()) {
            if (l.isAtiva()) {
                locacoesAtivas.add(l);
            }

        }

        return locacoesAtivas;
    }

    public List<Locacao> getLocacaoASerPreparada() {
        List<Locacao> locacaoASerPreparada = new ArrayList<Locacao>();
        int costureira = GerenciadorDoSistema.getInstance().getDiasDaCostureira();

        for (Locacao l : this.getLocacoes()) {
            if (l.isAtiva()) {
                Calendar dataLocNoPeriodo = l.getDataLocacao();
                dataLocNoPeriodo.add(Calendar.DAY_OF_MONTH, costureira);
                if (dataLocNoPeriodo.get(Calendar.YEAR) == Calendar.getInstance().get(Calendar.YEAR)) {
                    if (dataLocNoPeriodo.get(Calendar.DAY_OF_YEAR) == Calendar.getInstance().get(Calendar.DAY_OF_YEAR)) {
                        
                        locacaoASerPreparada.add(l);

                    }
                }
            }
        }
        return locacaoASerPreparada;
    }
    
    public List<Locacao> listarLocacoesPorDataDeDevolucao(Calendar dataPesquisada){
        List<Locacao> locacoesDeHoje = new ArrayList<Locacao>();
        for (Locacao l: getLocacoesAtivas()){
            if (l.getDataDevolucao().get(Calendar.DAY_OF_YEAR) == dataPesquisada.get(Calendar.DAY_OF_YEAR)){
                locacoesDeHoje.add(l);
            }
        }
        return locacoesDeHoje;
    }
}
