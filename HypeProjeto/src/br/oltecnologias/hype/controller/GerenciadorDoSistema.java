package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.dao.DespesaJpaRepository;
import br.oltecnologias.hype.dao.EmpresaJpaController;
import br.oltecnologias.hype.dao.MovimentacaoJpaRepository;
import br.oltecnologias.hype.dao.TemporadaJpaRepository;
import br.oltecnologias.hype.exception.DespesaExistenteException;
import br.oltecnologias.hype.exception.DespesaInexistenteException;
import br.oltecnologias.hype.exception.MovimentacaoInexistenteException;
import br.oltecnologias.hype.exception.TemporadaExistenteException;
import br.oltecnologias.hype.exception.TemporadaInexistenteException;
import br.oltecnologias.hype.model.Configuracao;
import br.oltecnologias.hype.model.Despesa;
import br.oltecnologias.hype.model.Empresa;
import br.oltecnologias.hype.model.Movimentacao;
import br.oltecnologias.hype.model.Temporada;
import br.oltecnologias.hype.model.Usuario;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerenciadorDoSistema {

<<<<<<< HEAD (cdf9800) - Versão Atualizada Odrav
=======
    private Usuario usuarioLogado;
    private double valorCaixaDiario;
    private boolean temporadaAtivada;
    private int percentualDescontoTemporada;
    private List<Despesa> despesas;
    private List<Movimentacao> movimentacoes;
>>>>>>> c35b25f688ad50bbcfe2a73d92d302a702c3a7d9
    private static GerenciadorDoSistema singleton = null;
    private Usuario usuarioLogado;
    private Temporada temporada = null;

    private GerenciadorDoSistema() {

    }

    public static GerenciadorDoSistema getInstance() {
        if (singleton == null) {
            singleton = new GerenciadorDoSistema();
        }
        return singleton;
    }

    public void notificarVencimentoDeLocacao() {
        //thread
    }

    public void transacaoDeCaixaListener(double valor) {

    }

    public double getValorCaixaDiario() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        DadosDoSistemaJpaRepository djp = new DadosDoSistemaJpaRepository(emf);
    }

    public double getValorDespesas() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        DespesaJpaRepository ddjp = new DespesaJpaRepository(emf);
        double despesa = 0.00;

        try {
            for (Despesa d : ddjp.getAllDespesas()) {
                despesa += d.getValor();
            }
        } finally {
            if (emf != null) {
                emf.close();
            }
        }

        return despesa;
    }

    public void cadastrarDespesa(Despesa despesa) throws DespesaExistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        DespesaJpaRepository ddjp = new DespesaJpaRepository(emf);
        try {

            ddjp.create(despesa);

        } finally {
            if (emf != null) {
                emf.close();
            }
        }

    }

    public void editarDespesa(Despesa despesa) throws DespesaInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        DespesaJpaRepository ddjp = new DespesaJpaRepository(emf);

        try {

            ddjp.editarDespesa(despesa);

        } finally {
            if (emf != null) {
                emf.close();
            }
        }

    }

    public void removerDespesas(long id) throws DespesaInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        DespesaJpaRepository ddjp = new DespesaJpaRepository(emf);

        try {

            ddjp.removerDespesa(id);

        } finally {
            if (emf != null) {
                emf.close();
            }
        }
    }

    public Despesa pesquisarDespesaPorId(long id) throws DespesaInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        DespesaJpaRepository ddjp = new DespesaJpaRepository(emf);
        Despesa despesa = null;

        try {

            despesa = ddjp.findById(id);

        } finally {
            if (emf != null) {
                emf.close();
            }
        }
        return despesa;
    }

    public List<Despesa> getDespesas() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        DespesaJpaRepository ddjp = new DespesaJpaRepository(emf);

<<<<<<< HEAD (cdf9800) - Versão Atualizada Odrav
        try {
=======
    public void editarDespesa(int id, String nome, String obs, Calendar data) throws DespesaInexistenteException {
        Despesa d;
        d = this.pesquisarDespesaPorId(id);
        d.setNome(nome);
        d.setObservacao(obs);
        d.setData(data);
>>>>>>> c35b25f688ad50bbcfe2a73d92d302a702c3a7d9

            return ddjp.getAllDespesas();

<<<<<<< HEAD (cdf9800) - Versão Atualizada Odrav
        } finally {
            if (emf != null) {
                emf.close();
=======
    public void removerDespesas(long id) throws DespesaInexistenteException {
        this.despesas.remove(pesquisarDespesaPorId(id));
    }

    public Despesa pesquisarDespesaPorId(long id) throws DespesaInexistenteException {
        for (Despesa d : this.despesas) {
            if (d.getId() == id) {
                return d;
>>>>>>> c35b25f688ad50bbcfe2a73d92d302a702c3a7d9
            }
        }
    }

    public List<Movimentacao> getMovimentacoes() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        MovimentacaoJpaRepository mjp = new MovimentacaoJpaRepository(emf);

        try {

            return mjp.getAllMovimentacoes();

        } finally {
            if (emf != null) {
                emf.close();
            }
        }
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public void gerarRelatorioDeCaixa(Calendar dataInicial, Calendar dataFinal) throws IOException {
            }
        }

        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
        desktop.open(new File("D:\\Sistemas de Informação\\Horário.pdf"));
    }
    
    public boolean isTemporadaAtivada() {
        return temporadaAtivada;
    }

    public void setTemporadaAtivada(boolean temporadaAtivada) {
        this.temporadaAtivada = temporadaAtivada;
    }

    public int getPercentualDescontoTemporada() {
        return percentualDescontoTemporada;
    }

    public void setPercentualDescontoTemporada(int percentualDescontoTemporada) {
        this.percentualDescontoTemporada = percentualDescontoTemporada;
    }
    
    public void ativarTemporada(int percentualDesconto) {
        setPercentualDescontoTemporada(percentualDesconto);
        setTemporadaAtivada(true);
    }
    
    public void desativarTemporada() {
        setTemporadaAtivada(false);
    }
    
    public void cadastrarEmpresa(Empresa empresa) {
        //Código para cadastrar a empresa no sistema
    }
    
    public boolean isEmpresaCadastrada() {
        //true se a empresa já estiver cadastada, false, caso contário
    }
    
    public Despesa pesquisarDespesaPeloId(String id) {
        //Retorna a despesa pesquisado pelo id
    }

    public Movimentacao cadastrarMovimentacao(Movimentacao movimentacao) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        MovimentacaoJpaRepository mjp = new MovimentacaoJpaRepository(emf);

        try {

            mjp.create(movimentacao);

        } finally {
            if (emf != null) {
                emf.close();
            }
        }
        
        return movimentacao;
    }

    public void removerMovimentacao(long id) throws MovimentacaoInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        MovimentacaoJpaRepository mjp = new MovimentacaoJpaRepository(emf);

        try {

            mjp.removerMovimentacao(id);

        } finally {
            if (emf != null) {
                emf.close();
            }
        }
    }

    public Movimentacao pesquisarMovimentacaoPorId(long id) throws MovimentacaoInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        MovimentacaoJpaRepository mjp = new MovimentacaoJpaRepository(emf);

        try {

           return mjp.findById(id);

        } finally {
            if (emf != null) {
                emf.close();
            }
        }
    }

    public boolean isTemporadaAtivada() throws TemporadaInexistenteException{
        if (this.temporada != null){
            return this.temporada.isAtivada();
        }        
        throw new TemporadaInexistenteException("A temporada ainda não foi criada");
        
        
    }
    
    public void setTemporada() throws TemporadaExistenteException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        TemporadaJpaRepository tjp = new TemporadaJpaRepository(emf);
        
        try{
            if (tjp.getTemporada() == null){
                if (this.temporada == null){
                    this.temporada = new Temporada();
                    tjp.create(this.temporada);
                }
            } else{
                this.temporada = tjp.getTemporada();
            }
        } finally {
            emf.close();
        }
        
        
    }

    public int getPercentualDescontoTemporada() throws TemporadaInexistenteException {
        if (this.temporada != null){
            return this.temporada.getPertentualDeDesconto();
        }        
        throw new TemporadaInexistenteException("A temporada ainda não foi criada");
        
    }

    public void ativarTemporada(int percentualDesconto) throws TemporadaInexistenteException {
        
        if (this.temporada != null){
            this.temporada.ativarTemporada(percentualDesconto);
        }        
        throw new TemporadaInexistenteException("A temporada ainda não foi criada");
        
    }

    public void desativarTemporada() throws TemporadaInexistenteException {
        if (this.temporada != null){
            this.temporada.desativarTemporada();
        }        
        throw new TemporadaInexistenteException("A temporada ainda não foi criada");
        
        
        
    }

    public void cadastrarEmpresa(Empresa empresa) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        EmpresaJpaController ejp = new EmpresaJpaController(emf);

        try {

           ejp.create(empresa);

        } finally {
            if (emf != null) {
                emf.close();
            }
        }
    }

    public boolean isEmpresaCadastrada() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        EmpresaJpaController ejp = new EmpresaJpaController(emf);

        try {

           if (ejp.getEmpresaCount() > 1){
               return false;
           }
           
           return true;

        } finally {
            if (emf != null) {
                emf.close();
            }
        }
    }
    
    public List<Movimentacao> pesquisarMovimentacaoPorOperacao(String operacao){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        MovimentacaoJpaRepository mjp = new MovimentacaoJpaRepository(emf);
        List<Movimentacao> retorno = new ArrayList<Movimentacao>();

        try {

           for (Movimentacao mov: mjp.getAllMovimentacoes()){
               if (mov.getMovimento().equals(operacao)){
                   retorno.add(mov);
               }
           }

        } finally {
            if (emf != null) {
                emf.close();
            }
        }
        
        return retorno;
        
    }
}
<<<<<<< HEAD (cdf9800) - Versão Atualizada Odrav
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        MovimentacaoJpaRepository mjp = new MovimentacaoJpaRepository(emf);
        String relatorio = "";

        try {

            for (Movimentacao mov : mjp.getAllMovimentacoes()) {
                if (mov.getData().getTimeInMillis() >= dataInicial.getTimeInMillis()
                        && mov.getData().getTimeInMillis() <= dataFinal.getTimeInMillis()) {
                    relatorio += mov.getMovToString() + "\n";
                    //FORMATAR ISSO DEPOIS
                }
            }

        } finally {
            if (emf != null) {
                emf.close();
=======
        //Abrir o pdf do relatório gerado no sistema
        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();  
        desktop.open(new File("D:\\Sistemas de Informação\\Horário.pdf")); 
    }
    
    public Movimentacao cadastrarMovimentacao(String movimento, double valor, Calendar data, Usuario responsavel, String beneficiario) {
        
        Movimentacao movimentacao = new Movimentacao(movimento, valor, data, responsavel, beneficiario);
        this.movimentacoes.add(movimentacao);
        if(movimento.toUpperCase().equals("DESPESA") ) {
            this.valorCaixaDiario -= valor;
        } else {
            this.valorCaixaDiario += valor;
        }
        return movimentacao;
    }
    
    public void removerMovimentacao(long id) throws MovimentacaoInexistenteException {
        this.movimentacoes.remove(pesquisarMovimentacaoPorId(id));
    }
    
    public Movimentacao pesquisarMovimentacaoPorId(long id) throws MovimentacaoInexistenteException{
        for(Movimentacao movimentacao: this.movimentacoes) {
            if(movimentacao.getId() == id) {
                return movimentacao;
>>>>>>> c35b25f688ad50bbcfe2a73d92d302a702c3a7d9
