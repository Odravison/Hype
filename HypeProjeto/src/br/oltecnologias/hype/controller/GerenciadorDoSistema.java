package br.oltecnologias.hype.controller;

import br.oltecnologias.hype.dao.ConfiguracaoJpaController;
import br.oltecnologias.hype.dao.DespesaJpaRepository;
import br.oltecnologias.hype.dao.EmpresaJpaController;
import br.oltecnologias.hype.dao.MovimentacaoJpaRepository;
import br.oltecnologias.hype.dao.TemporadaJpaController;
import br.oltecnologias.hype.dao.UsuarioJpaRepository;
import br.oltecnologias.hype.exception.DespesaExistenteException;
import br.oltecnologias.hype.exception.DespesaInexistenteException;
import br.oltecnologias.hype.exception.LocacaoInexistenteException;
import br.oltecnologias.hype.exception.MovimentacaoInexistenteException;
import br.oltecnologias.hype.exception.TemporadaExistenteException;
import br.oltecnologias.hype.exception.TemporadaInexistenteException;
import br.oltecnologias.hype.exception.TipoInexistenteDeMovimentacao;
import br.oltecnologias.hype.exception.UsuarioExistenteException;
import br.oltecnologias.hype.exception.VendaInexistenteException;
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
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
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
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerenciadorDoSistema {

    private static GerenciadorDoSistema singleton = null;
    private Usuario usuarioLogado;
    private Temporada temporada = null;
    private Configuracao conf = this.getConfiguracao();

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

    public void gerarRelatorioDeCaixa(Calendar dataInicial, Calendar dataFinal) throws IOException, VendaInexistenteException, LocacaoInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        MovimentacaoJpaRepository mjp = new MovimentacaoJpaRepository(emf);
        List<String> relatorio = new ArrayList<String>();
        relatorio.add("DATA");
        relatorio.add("MOV.");
        relatorio.add("RESP.");
        relatorio.add("VALOR");
        relatorio.add("RECEB.");
        relatorio.add("PGMT");
        String diretorioFinal = null;

        double valorRecebido = 0.00;
        
        double cartaoVenda = 0.00;
        double cartaoLocacao = 0.00;

        int quantVenda = 0;
        double totalVenda = 0.00;

        int quantLocacao = 0;
        double totalLocacao = 0.00;

        int quantDespesa = 0;
        double totalDespesa = 0.00;

        String diaIni = new SimpleDateFormat("dd").format(dataInicial.getTime());
        String mesIni = new SimpleDateFormat("MMMMM", new Locale("pt", "BR")).format(dataInicial.getTime());
        String anoIni = new SimpleDateFormat("yyyy").format(dataInicial.getTime());

        String diaFinal = new SimpleDateFormat("dd").format(dataFinal.getTime());
        String mesFinal = new SimpleDateFormat("MMMMM", new Locale("pt", "BR")).format(dataFinal.getTime());
        String anoFinal = new SimpleDateFormat("yyyy").format(dataFinal.getTime());

        try {
            for (Movimentacao mov : mjp.getAllMovimentacoes()) {
                System.out.println("===>> " + mov.getData().getTime().before(dataInicial.getTime()));

                System.out.println("essa é a data que veio: " + dataInicial.getTimeInMillis());
                System.out.println("essa é a data do objeto: " + mov.getData().getTimeInMillis());

                if ((mov.getData().get(Calendar.DAY_OF_YEAR) >= dataInicial.get(Calendar.DAY_OF_YEAR)
                        && mov.getData().get(Calendar.YEAR) >= dataInicial.get(Calendar.YEAR))
                        && (mov.getData().get(Calendar.DAY_OF_YEAR) <= dataFinal.get(Calendar.DAY_OF_YEAR)
                        && mov.getData().get(Calendar.YEAR) <= dataFinal.get(Calendar.YEAR))) {

                    if (mov.getMovimento().toUpperCase().equals("VENDA")) {
                        Venda venda = GerenciadorDeVenda.getInstance().pesquisarVendaPorId(mov.getIdDaOperacao());
                        if (venda.getFormaDePagamento().toUpperCase().equals("CARTÃO - DÉBITO")
                            || venda.getFormaDePagamento().toUpperCase().equals("CARTÃO - CRÉDITO")){
                            cartaoVenda += venda.getJaPago();
                        }
                        quantVenda++;
                        valorRecebido = venda.getJaPago();
                        totalVenda += valorRecebido;

                    } else if (mov.getMovimento().toUpperCase().equals("LOCAÇÃO")) {
                        Locacao locacao = GerenciadorDeLocacao.getInstance().pesquisarLocacaoPorId(mov.getIdDaOperacao());
                        if (locacao.getFormaDePagamento().toUpperCase().equals("CARTÃO - CRÉDITO")
                            || locacao.getFormaDePagamento().toUpperCase().equals("CARTÃO - DÉBITO")){
                            cartaoLocacao += locacao.getJaPago();
                        }
                        quantLocacao++;
                        valorRecebido = locacao.getJaPago();
                        totalLocacao += valorRecebido;

                    } else if (mov.getMovimento().toUpperCase().equals("DESPESA")) {
                        quantDespesa++;
                        totalDespesa += mov.getValor();
                    }

                    relatorio.add(mov.getDataInString());
                    relatorio.add(mov.getMovimento());
                    relatorio.add(mov.getResponsavel().substring(0, 11));
                    relatorio.add("R$ " + mov.getValorInString());
                    relatorio.add(Double.toString(valorRecebido));
                    relatorio.add(mov.getFormaDePagamento());

                }
            }

            //FORMATAR ISSO DEPOIS
            Font timesNewRoman14 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
            Font timesNewRoman12 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
            Font courier12 = new Font(Font.FontFamily.COURIER, 12);

            Document pdf;
            pdf = new Document();

            File diretorio = null;

            try {

                diretorio = new File(conf.getDiretorioDeRelatorios());
                diretorio.mkdir();

                PdfWriter.getInstance(pdf, new FileOutputStream(diretorio.toString() + "\\" + "Relatorio_"
                        + "" + diaIni + "." + mesIni + "." + anoIni + " TO "
                        + "" + diaFinal + "." + mesFinal + "." + anoFinal + ".pdf"));

                diretorioFinal = diretorio.toString() + "\\" + "Relatorio_"
                        + "" + diaIni + "." + mesIni + "." + anoIni + " TO " + diaFinal + "." + mesFinal + "." + anoFinal + ".pdf";

                pdf.open();
                pdf.setPageSize(PageSize.A4);
                float[] larguras = new float[]{50, 50, 70, 48, 45, 60};

                PdfPTable table = new PdfPTable(larguras);
                table.setSpacingAfter(5);
                table.setSpacingBefore(5);
                table.setTotalWidth(100);
                table.setWidths(larguras);

                for (String s : relatorio) {
                    table.addCell(new Phrase (s, timesNewRoman12));
                }
                Paragraph tituloRelatorio = new Paragraph("RELÁTÓRIO DE " + diaIni + "/" + mesIni + " a "
                        + diaFinal + "/" + mesFinal, timesNewRoman14);
                tituloRelatorio.setAlignment(Paragraph.ALIGN_CENTER);
                tituloRelatorio.setSpacingAfter(10);

                Paragraph resumoRelatorio = new Paragraph("Resumo do relatório: \n"
                        + "Quantidade de vendas: " + quantVenda + " - Total de venda: R$ " + totalVenda + "\n"
                        + "Quantidade de Locações: " + quantLocacao + " - Total de locações: R$ " + totalLocacao + "\n"
                        + "Quantidade de Despesas: " + quantDespesa + " - Total de despesas: R$ " + totalDespesa + "\n"
                        + "Valor em caixa neste período: " + ((totalVenda + totalLocacao - totalDespesa)-(cartaoLocacao + cartaoVenda)) + "\n"
                        + "Valor pago em Cartão para vendas: " + cartaoVenda + "\n"
                        + "Valor pago em Cartão para locações: " + cartaoLocacao, timesNewRoman12);
                resumoRelatorio.setAlignment(Paragraph.ALIGN_LEFT);

                pdf.add(tituloRelatorio);
                pdf.add(table);
                pdf.add(resumoRelatorio);

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
        System.out.println("CHEGOU NO ADICIONARMOVIMENTACAO");
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

    public boolean isTemporadaAtivada(String tipo) throws TemporadaInexistenteException, Exception {
        if (this.temporada != null) {
            if (tipo.toUpperCase().equals("VENDA")) {
                return this.temporada.isIsAtivadaDeVenda();
            } else if (tipo.toUpperCase().equals("LOCAÇÃO")) {
                return this.temporada.isIsAtivadaDeLocacao();
            }
        } else {
            this.setTemporada();
            if (tipo.toUpperCase().equals("VENDA")) {
                return this.temporada.isIsAtivadaDeVenda();
            } else if (tipo.toUpperCase().equals("LOCAÇÃO")) {
                return this.temporada.isIsAtivadaDeLocacao();
            }
        }

        throw new TemporadaInexistenteException("Tipo inválido");
    }

    public void setTemporada() throws TemporadaExistenteException, Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        TemporadaJpaController tjp = new TemporadaJpaController(emf);

        try {
            if (tjp.getTemporadaCount() == 0) {
                if (this.temporada == null) {
                    this.temporada = Temporada.getInstance();
                    tjp.create(this.temporada);

                }
            } else {
                for (Temporada t : tjp.findTemporadaEntities()) {
                    this.temporada = t;
                    break;

                }
            }
        } finally {
            emf.close();
        }

    }

    public int getPercentualDescontoTemporada(String tipo) throws TemporadaInexistenteException {
        if (this.temporada != null) {
            if (tipo.toUpperCase().equals("VENDA")) {
                return this.temporada.getPercentualDeDescontoDeVenda();
            } else if (tipo.toUpperCase().equals("LOCAÇÃO")) {
                return this.temporada.getPercentualDeDescontoDeLocacao();
            } else {
                throw new TemporadaInexistenteException("Tipo de desconto inválido");
            }
        }
        throw new TemporadaInexistenteException("A temporada ainda não foi criada 2 ");

    }

    public void ativarTemporada(int percentualDesconto, String tipo) throws TemporadaInexistenteException, Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        TemporadaJpaController tjp = new TemporadaJpaController(emf);
        try {
            if (this.temporada == null) {

                throw new TemporadaInexistenteException("A temporada ainda não foi criada COD: 3");
            }

            if (tipo.toUpperCase().equals("VENDA")) {
                this.temporada.ativarTemporadaDeVenda(percentualDesconto);
                tjp.edit(temporada);
            } else if (tipo.toUpperCase().equals("LOCAÇÃO")) {
                this.temporada.ativarTemporadaDeLocacao(percentualDesconto);
                tjp.edit(temporada);
            } else {
                throw new TemporadaInexistenteException("TIPO DE DESCONTO INEXISTENTE COD: 4");
            }

        } finally {
            if (emf != null) {
                emf.close();
            }
        }

    }

    public void desativarTemporada(String tipo) throws TemporadaInexistenteException, Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        TemporadaJpaController tjp = new TemporadaJpaController(emf);
        try {
            if (this.temporada == null) {
                throw new TemporadaInexistenteException("A temporada ainda não foi criada");
            }

            if (tipo.toUpperCase().equals("VENDA")) {
                this.temporada.desativarTemporadaDeVenda();
                tjp.edit(temporada);
            } else if (tipo.toUpperCase().equals("LOCAÇÃO")) {
                this.temporada.desativarTemporadaDeLocacao();
                tjp.edit(temporada);
            } else {
                throw new TemporadaInexistenteException("TIPO DE DESCONTO INEXISTENTE COD: 5");
            }

        } finally {
            if (emf != null) {
                emf.close();
            }
        }

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

            if (ejp.getEmpresaCount() > 0) {
                return true;
            }

            return false;

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

    public Movimentacao adicionarMovimentacao(Object obj, String tipo) throws TipoInexistenteDeMovimentacao {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        MovimentacaoJpaRepository mjp = new MovimentacaoJpaRepository(emf);
        Movimentacao mov;
        System.out.println("CHEGOU NO ADICIONARMOVIMENTACAO");
        if (tipo.toUpperCase().equals("VENDA")) {
            System.out.println("VAI TRANSFORMAR O OBJECT EM VENDA");
            Venda venda = (Venda) obj;
            System.out.println("VENDA\nVALOR: " + venda.getValor() + ", DATA: " + venda.getDataVenda() + ", EMPRESA: "
                    + conf.getEmpresa().getNome() + " ID: " + venda.getId() + ", FORMAPAG: " + venda.getFormaDePagamento());
            mov = new Movimentacao("Venda", venda.getValor(), venda.getDataVenda(), usuarioLogado.getNickName(),
                    conf.getEmpresa().getNome(), venda.getId(), venda.getFormaDePagamento());
        } else if (tipo.toUpperCase().equals("DESPESA")) {
            System.out.println("VAI TRANSFORMAR O OBJECT EM DESPESA");
            Despesa despesa = (Despesa) obj;
            mov = new Movimentacao("Despesa", despesa.getValor(), despesa.getData(), despesa.getEmissor(), despesa.getFavorecido(), despesa.getId(),
                    despesa.getFormaDePagamento());
        } else if (tipo.toUpperCase().equals("LOCAÇÃO")) {
            System.out.println("VAI TRANSFORMAR O OBJECT EM LOCAÇÃO");
            Locacao locacao = (Locacao) obj;
            System.out.println("LOCAÇÃO\nVALOR: " + (locacao.getValorLocacao() - locacao.getValorDeEntrada() + locacao.getJaPago())
                    + ", EMPRESA: " + conf.getEmpresa().getNome()
                    + conf.getEmpresa().getNome() + " ID: " + locacao.getId() + ", FORMAPAG: " + locacao.getFormaDePagamento());

            mov = new Movimentacao("Locação", locacao.getValorLocacao() - locacao.getValorDeEntrada() + locacao.getJaPago(), Calendar.getInstance(),
                    usuarioLogado.getNickName(), conf.getEmpresa().getNome(), locacao.getId(), locacao.getFormaDePagamento());
        } else {
            throw new TipoInexistenteDeMovimentacao("Este tipo de movimentação não existe.");
        }

        try {
            mjp.create(mov);
            return mov;
        } finally {
            if (emf != null) {
                emf.close();
            }
        }

    }

    public double getValorCaixaDiario() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        MovimentacaoJpaRepository mjp = new MovimentacaoJpaRepository(emf);
        double valorTotalEmCaixa = 0.00;
        Calendar c = Calendar.getInstance();
        int diaDeHoje = c.get(Calendar.DAY_OF_MONTH);
        int mesDeHoje = c.get(Calendar.MONTH);
        int anoDeHoje = c.get(Calendar.YEAR);

        try {
            for (Movimentacao mov : mjp.getAllMovimentacoes()) {
                if (mov.getData().get(Calendar.DAY_OF_MONTH) == diaDeHoje
                        && mov.getData().get(Calendar.MONTH) == mesDeHoje
                        && mov.getData().get(Calendar.YEAR) == anoDeHoje) {
                    if (mov.getMovimento().toUpperCase().equals("DESPESA")) {
                        valorTotalEmCaixa -= mov.getValor();
                    } else {
                        valorTotalEmCaixa += mov.getValor();
                    }

                }
            }

            return valorTotalEmCaixa;

        } finally {
            if (emf != null) {
                emf.close();
            }
        }

    }

    public void editarMovimentacao(Movimentacao movimentacao) throws MovimentacaoInexistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        MovimentacaoJpaRepository mjp = new MovimentacaoJpaRepository(emf);

        try {
            mjp.editarMovimentacao(movimentacao);
        } finally {
            if (emf != null) {
                emf.close();
            }
        }
    }

    public void editarEmpresa(Empresa empresa) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        EmpresaJpaController ejp = new EmpresaJpaController(emf);

        try {
            ejp.edit(empresa);
        } finally {
            if (emf != null) {
                emf.close();
            }
        }
    }

    public List<Movimentacao> pesquisarMovimentacoesEspecificas(String tipoMov) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        MovimentacaoJpaRepository mjp = new MovimentacaoJpaRepository(emf);
        List<Movimentacao> listaDeRetorno = new ArrayList<Movimentacao>();

        try {

            for (Movimentacao m : mjp.getAllMovimentacoes()) {
                if (m.getMovimento().toUpperCase().equals(tipoMov.toUpperCase())) {
                    listaDeRetorno.add(m);
                }
            }

            return listaDeRetorno;

        } finally {
            emf.close();
        }
    }

    public List<Movimentacao> pesquisarMovimentacoesPendentes() {
        List<Movimentacao> listaDeRetorno = new ArrayList<Movimentacao>();

        for (Movimentacao m : this.getMovimentacoes()) {
            if (m.getFormaDePagamento().toUpperCase().equals("CARTÃO - CRÉDITO")
                    || m.getFormaDePagamento().toUpperCase().equals("CARTÃO - DÉBITO")
                    || m.getFormaDePagamento().toUpperCase().equals("PROMISSÓRIA")) {
                listaDeRetorno.add(m);
            }
        }
        return listaDeRetorno;
    }

    public Movimentacao adicionarMovimentacaoDeLocacao(Locacao locacao) throws TipoInexistenteDeMovimentacao {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        MovimentacaoJpaRepository mjp = new MovimentacaoJpaRepository(emf);
        Movimentacao mov;

        try {
            mov = new Movimentacao("Locação", locacao.getValorLocacao() - locacao.getValorDeEntrada() + locacao.getJaPago(), Calendar.getInstance(),
                    usuarioLogado.getNome(), conf.getEmpresa().getNome(), locacao.getId(), locacao.getFormaDePagamento());
            mjp.create(mov);
            return mov;
        } finally {
            if (emf != null) {
                emf.close();
            }
        }

    }

    public Movimentacao adicionarMovimentacaoDeVenda(Venda venda) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        MovimentacaoJpaRepository mjp = new MovimentacaoJpaRepository(emf);
        Movimentacao mov;

        try {

            mov = new Movimentacao("Venda", venda.getValor(), venda.getDataVenda(), usuarioLogado.getNome(),
                    conf.getEmpresa().getNome(), venda.getId(), venda.getFormaDePagamento());
            mjp.create(mov);
            return mov;
        } finally {
            if (emf != null) {
                emf.close();
            }
        }
    }

    public Movimentacao adicionarMovimentacaoDeDespesa(Despesa despesa) throws TipoInexistenteDeMovimentacao {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        MovimentacaoJpaRepository mjp = new MovimentacaoJpaRepository(emf);
        Movimentacao mov;

        try {
            mov = new Movimentacao("Despesa", despesa.getValor(), despesa.getData(),
                    despesa.getEmissor(), despesa.getFavorecido(), despesa.getId(), despesa.getFormaDePagamento());
            mjp.create(mov);
            return mov;
        } finally {
            if (emf != null) {
                emf.close();
            }
        }
    }

    public Configuracao getConfiguracao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ConfiguracaoJpaController cjp = new ConfiguracaoJpaController(emf);

        try {

            if (cjp.getConfiguracaoCount() == 0) {
                return Configuracao.getInstance();
            } else {
                Configuracao conf = cjp.findConfiguracao(1);
                return conf;
            }

        } finally {
            emf.close();
        }

    }

    public void salvarEstadoDeConfiguracao(Configuracao configuracao) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        ConfiguracaoJpaController cjp = new ConfiguracaoJpaController(emf);

        try {

            if (cjp.getConfiguracaoCount() == 0) {
                cjp.create(configuracao);
            } else {
                cjp.edit(configuracao);
            }

        } finally {
            emf.close();
        }

    }

    public Usuario pesquisarUsuarioPeloNome(String nome) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        UsuarioJpaRepository ujp = new UsuarioJpaRepository(emf);
        Usuario user = null;
        try {
            for (Usuario u : ujp.getAllUsuarios()) {
                if (u.getNome().toUpperCase().equals(nome.toUpperCase())) {
                    user = u;
                }
            }
            return user;
        } finally {
            emf.close();
        }
    }

    public void inserirAdminPadrao() throws UsuarioExistenteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("closetpu");
        UsuarioJpaRepository ujp = new UsuarioJpaRepository(emf);

        try {
            if (ujp.getUserCount() == 0) {
                Usuario userDefault = new Usuario("Administrador", "admin", "admin", true);
                ujp.create(userDefault);
            }

        } finally {
            emf.close();
        }
    }

    public int getDiasDaCostureira() {
        return getConfiguracao().getDiasDaCostureira();
    }

    public int getDiasDeManutencao() {
        return getConfiguracao().getDiasDeManutencao();
    }
}
