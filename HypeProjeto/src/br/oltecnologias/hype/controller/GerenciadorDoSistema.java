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
import br.oltecnologias.hype.model.Locacao;
import br.oltecnologias.hype.model.Movimentacao;
import br.oltecnologias.hype.model.Temporada;
import br.oltecnologias.hype.model.Usuario;
import br.oltecnologias.hype.model.Venda;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerenciadorDoSistema {

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

    /*public double getValorCaixaDiario() {
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
     DadosDoSistemaJpaRepository djp = new DadosDoSistemaJpaRepository(emf);
     }*/
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

    public Despesa cadastrarDespesa(Despesa despesa) throws DespesaExistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        DespesaJpaRepository ddjp = new DespesaJpaRepository(emf);
        try {

            ddjp.create(despesa);
            return despesa;

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

        try {

            return ddjp.getAllDespesas();

        } finally {
            if (emf != null) {
                emf.close();
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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        MovimentacaoJpaRepository mjp = new MovimentacaoJpaRepository(emf);
        List<String> relatorio = new ArrayList<String>();
        relatorio.add("     DATA      ");
        relatorio.add("   MOVIMENTO   ");
        relatorio.add("  RESPONSÁVEL  ");
        relatorio.add("     VALOR     ");
        String diretorioFinal = null;
        try {
            for (Movimentacao mov : mjp.getAllMovimentacoes()) {
                if (mov.getData().getTimeInMillis() >= dataInicial.getTimeInMillis()
                        && mov.getData().getTimeInMillis() <= dataFinal.getTimeInMillis()) {
                    relatorio.add(mov.getDataInString());
                    relatorio.add(mov.getMovimento());
                    relatorio.add(mov.getResponsavel());
                    relatorio.add(mov.getValorInString());
                }
            }
        //FORMATAR ISSO DEPOIS

            String diaIni = new SimpleDateFormat("dd").format(dataInicial.getTime());
            String mesIni = new SimpleDateFormat("MMMMM", new Locale("pt", "BR")).format(dataInicial.getTime());
            String anoIni = new SimpleDateFormat("yyyy").format(dataInicial.getTime());

            String diaFinal = new SimpleDateFormat("dd").format(dataInicial.getTime());
            String mesFinal = new SimpleDateFormat("MMMMM", new Locale("pt", "BR")).format(dataInicial.getTime());
            String anoFinal = new SimpleDateFormat("yyyy").format(dataInicial.getTime());

            Font timesNewRoman14 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
            Font timesNewRoman12 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
            Font courier12 = new Font(Font.FontFamily.COURIER, 12);

            Document pdf = new Document(PageSize.A4, 10, 10, 10, 10);

            File diretorio = null;

            try {
                diretorio = new File(Configuracao.getInstance().getDiretorioDeRelatorios());
                diretorio.mkdir();

                PdfContentByte canvas = new PdfContentByte(PdfWriter.getInstance(pdf, new FileOutputStream(diretorio.toString() + "\\" + "Relatorio_"
                        + "" + diaIni + "." + mesIni + "." + anoIni + " TO "
                        + "" + diaFinal + "." + mesFinal + "." + anoFinal)));
                
                diretorioFinal = diretorio.toString() + "\\" + "Relatorio_"
                        + "" + diaIni + "." + mesIni + "." + anoIni + " TO " + diaFinal + "." + mesFinal + "." + anoFinal;
                
                
                
                
                PdfPTable table = new PdfPTable(4);
                
                for (String s: relatorio){
                    table.addCell(s);
                }
                
                pdf.add(table);
                
                ColumnText columns = new ColumnText(canvas);
                
                

            } catch (DocumentException | IOException de) {
                System.err.println(de.getMessage());
            } finally {
                pdf.close();
            }

        } finally {
            if (emf != null) {
                emf.close();
            }
        }

        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

        desktop.open(new File(diretorioFinal));
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

    public boolean isTemporadaAtivada() throws TemporadaInexistenteException {
        if (this.temporada != null) {
            return this.temporada.isAtivada();
        }
        throw new TemporadaInexistenteException("A temporada ainda não foi criada");

    }

    public void setTemporada() throws TemporadaExistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        TemporadaJpaRepository tjp = new TemporadaJpaRepository(emf);

        try {
            if (tjp.getTemporada() == null) {
                if (this.temporada == null) {
                    this.temporada = new Temporada();
                    tjp.create(this.temporada);
                }
            } else {
                this.temporada = tjp.getTemporada();
            }
        } finally {
            emf.close();
        }

    }

    public int getPercentualDescontoTemporada() throws TemporadaInexistenteException {
        if (this.temporada != null) {
            return this.temporada.getPertentualDeDesconto();
        }
        throw new TemporadaInexistenteException("A temporada ainda não foi criada");

    }

    public void ativarTemporada(int percentualDesconto) throws TemporadaInexistenteException {

        if (this.temporada != null) {
            this.temporada.ativarTemporada(percentualDesconto);
        }
        throw new TemporadaInexistenteException("A temporada ainda não foi criada");

    }

    public void desativarTemporada() throws TemporadaInexistenteException {
        if (this.temporada != null) {
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

            if (ejp.getEmpresaCount() > 1) {
                return false;
            }

            return true;

        } finally {
            if (emf != null) {
                emf.close();
            }
        }
    }

    public List<Movimentacao> pesquisarMovimentacaoPorOperacao(String operacao) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        MovimentacaoJpaRepository mjp = new MovimentacaoJpaRepository(emf);
        List<Movimentacao> retorno = new ArrayList<Movimentacao>();

        try {

            for (Movimentacao mov : mjp.getAllMovimentacoes()) {
                if (mov.getMovimento().equals(operacao)) {
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
    
    public Movimentacao adicionarMovimentacao(Object obj, String tipo){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        MovimentacaoJpaRepository mjp = new MovimentacaoJpaRepository(emf);
        Movimentacao mov = null;
        
        if (tipo.toUpperCase().equals("VENDA")){
            Venda venda = (Venda) obj;
            mov = new Movimentacao("Venda", venda.getValor(), venda.getDataVenda(), usuarioLogado.getNickName(),"Cliente", venda.getId());
        }
        else if (tipo.toUpperCase().equals("DESPESA")){
            Despesa despesa = (Despesa) obj;
            mov = new Movimentacao("Despesa", despesa.getValor(), despesa.getData(), despesa.getEmissor(), despesa.getFavorecido(), despesa.getId());
        }
        else if (tipo.toUpperCase().equals("LOCAÇÃO")){
            Locacao locacao = (Locacao) obj;
            mov = new Movimentacao("Locação", locacao.getValorLocacao()-locacao.getValorDeEntrada()+locacao.getJaPago(), Calendar.getInstance(), 
                    usuarioLogado.getNickName(), locacao.getCliente().getCelular(), locacao.getId());
        }
        
        try{
            mjp.create(mov);
            return mov;
        } finally{
            if (emf != null){
                emf.close();
            }
        }
        
    }
    
    public double getValorCaixaDiario(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        MovimentacaoJpaRepository mjp = new MovimentacaoJpaRepository(emf);
        double valorTotalEmCaixa = 0;
        Calendar c = Calendar.getInstance();
        int diaDeHoje = c.get(Calendar.DAY_OF_MONTH);
        int mesDeHoje = c.get(Calendar.MONTH);
        int anoDeHoje = c.get(Calendar.YEAR);
        
        try{
            for (Movimentacao mov: mjp.getAllMovimentacoes()){
                if (mov.getData().get(Calendar.DAY_OF_MONTH) == diaDeHoje &&
                    mov.getData().get(Calendar.MONTH) == mesDeHoje &&
                    mov.getData().get(Calendar.YEAR) == anoDeHoje){
                    
                    valorTotalEmCaixa += mov.getValor();
                    
                }
            }
            
            return valorTotalEmCaixa;
            
        } finally{
            if (emf != null){
                emf.close();
            }
        }
        
    }
    
    public void editarMovimentacao(Movimentacao movimentacao) throws MovimentacaoInexistenteException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        MovimentacaoJpaRepository mjp = new MovimentacaoJpaRepository(emf);
        
        try{
            mjp.editarMovimentacao(movimentacao);
        } finally {
            if (emf != null){
                emf.close();
            }
        }
    }
    
    public void editarEmpresa(Empresa empresa) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        EmpresaJpaController ejp = new EmpresaJpaController(emf);
        
        try{
            ejp.edit(empresa);
        }finally{
            if (emf != null){
                emf.close();
            }
        }
    }
}
