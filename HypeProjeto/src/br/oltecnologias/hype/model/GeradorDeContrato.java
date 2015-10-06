/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.model;

import br.oltecnologias.hype.controller.GerenciadorDeLocacao;
import br.oltecnologias.hype.controller.GerenciadorDoSistema;
import br.oltecnologias.hype.exception.LocacaoInexistenteException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Odravison
 */
public class GeradorDeContrato {

    private static GeradorDeContrato singleton;
    private List<Produto> produtos;
    Configuracao conf = GerenciadorDoSistema.getInstance().getConfiguracao();

    public static GeradorDeContrato getInstance() {
        if (singleton == null) {
            singleton = new GeradorDeContrato();
        }
        return singleton;
    }

    private GeradorDeContrato() {
        produtos = new ArrayList<Produto>();

    }

    public void gerarEImprimirContrato(Locacao locacao) throws IOException, Exception {

        gerarContrato(locacao);

        String horaGeracao = new SimpleDateFormat("_HH-mm").format(Calendar.getInstance().getTime());
        String diaContrato = new SimpleDateFormat("dd.MM.yyyy").format(locacao.getDataLocacao().getTime());

        String diretorio = conf.getDiretorioDeDocumentos()
                + "\\" + locacao.getCliente().getNome() + "\\Contratos\\" + "DL_" + diaContrato + "__H_" + horaGeracao + ".pdf";

        FileInputStream fis = new FileInputStream(diretorio);
        PrintPdf printPDFFile = new PrintPdf(fis, "DL_" + diaContrato + "__H_" + horaGeracao + ".pdf",
                conf.getNomeDaImpressora());

        printPDFFile.print();

    }

    // Deveria receber uma locação, pois todos os dados últeis para gerar o contrato se encontram nela
    public void gerarContrato(Locacao locacao) throws DocumentException, IOException, Exception {

        this.produtos = GerenciadorDeLocacao.getInstance().getProdutosDeLocacao(locacao.getId());
        Empresa empresa = Configuracao.getInstance().getEmpresa();

        Document pdf = new Document();
        File diretorio;
        String horaGeracao = new SimpleDateFormat("_HH-mm").format(Calendar.getInstance().getTime());
        String diaContrato = new SimpleDateFormat("dd.MM.yyyy").format(locacao.getDataLocacao().getTime());

        String dia = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
        String mes = new SimpleDateFormat("MMMMM", new Locale("pt", "BR")).format(Calendar.getInstance().getTime());
        String ano = new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());

        String dataLocFormatada = new SimpleDateFormat("dd/MM/yyyy").format(locacao.getDataLocacao().getTime());
        String dataDevFormatada = new SimpleDateFormat("dd/MM/yyyy").format(locacao.getDataDevolucao().getTime());
        Font timesNewRoman14 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        Font timesNewRoman12 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
        Font courier12 = new Font(Font.FontFamily.COURIER, 12);

        try {
            diretorio = new File(conf.getDiretorioDeDocumentos() + "\\" + locacao.getCliente().getNome() + "\\Contratos");
            diretorio.mkdirs();

            System.out.println("Contrato gerado para: " + diretorio.toString());

            PdfWriter.getInstance(pdf, new FileOutputStream(diretorio.toString() + "\\" + "DL_" + diaContrato + "__H_" + horaGeracao + ".pdf"));
            pdf.open();
            pdf.setPageSize(PageSize.A4);

            String diretorioFinal = diretorio.toString() + "\\" + "DL_" + diaContrato + "__H_" + horaGeracao + ".pdf";
            //Essa linha acima que deveria ser salva em UltimoCaminhoContrato

            GerenciadorDeLocacao.getInstance().setUltimoCaminhoContrato(locacao.getId(), diretorio.toString());

            Paragraph tituloContrato = new Paragraph("CONTRATO DE LOCAÇÃO DE ROUPAS E ACESSÓRIOS", timesNewRoman14);
            tituloContrato.setAlignment(Paragraph.ALIGN_CENTER);
            tituloContrato.setSpacingAfter(10);

            Paragraph textoContrato;
            textoContrato = new Paragraph(empresa.getNome() + " , inscrita no CNPJ " + empresa.getCnpj() + ", "
                    + empresa.getEndereco().getRua() + "," + empresa.getEndereco().getNumeroCasa() + " doravante denominada “"+ empresa.getNome() +"”, "
                    + "neste ato representada na Forma de seu contrato social e de outro lado o contratante denominado de “LOCADOR”, "
                    + "resolvem celebrar o presente contrato de locação, nas seguintes condições:\n"
                    .concat(conf.getContratoPt2()
                            .concat(conf.getContratoPt3()
                                    .concat(conf.getContratoPt4()
                                            .concat(conf.getContratoPt5()
                                                    .concat(conf.getContratoPt6()
                                                            .concat(conf.getContratoPt7())))))), timesNewRoman12);
            textoContrato.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            textoContrato.setPaddingTop(2);

            Paragraph periodo;
            periodo = new Paragraph("Período da Locação: " + dataLocFormatada + " a " + dataDevFormatada, timesNewRoman12);
            periodo.setAlignment(Paragraph.ALIGN_CENTER);

            Paragraph objLocados;
            objLocados = new Paragraph("Trajes e acessórios Locados: \n" + getDescricaoDeProdutos(locacao.getId()), courier12);
            objLocados.setSpacingAfter(20);

            Paragraph linhaAssinatura;
            linhaAssinatura = new Paragraph("________________________________________________________________________", timesNewRoman12);
            linhaAssinatura.setAlignment(Paragraph.ALIGN_CENTER);

            Paragraph dadosCliente;
            dadosCliente = new Paragraph("Locador: " + locacao.getCliente().getNome() + ", portador do nº de CPF: " + locacao.getCliente().getCpf(), timesNewRoman12);
            dadosCliente.setSpacingAfter(40);
            dadosCliente.setAlignment(Paragraph.ALIGN_CENTER);

            Paragraph dadosEmpresa;
            dadosEmpresa = new Paragraph("Locatário: " + conf.getEmpresa().getNome()
                    + ", portador do nº de CNPJ: " + conf.getEmpresa().getCnpj(), timesNewRoman12);
            dadosEmpresa.setSpacingAfter(20);
            dadosEmpresa.setAlignment(Paragraph.ALIGN_CENTER);

            Paragraph diaLocal;
            diaLocal = new Paragraph(conf.getEmpresa().getEndereco().getCidade()
                    + ", " + dia + " de " + mes + " de" + ano, timesNewRoman12);
            diaLocal.setAlignment(Paragraph.ALIGN_RIGHT);

            pdf.add(tituloContrato);
            pdf.add(textoContrato);
            pdf.add(periodo);
            pdf.add(objLocados);
            pdf.add(linhaAssinatura);
            pdf.add(dadosCliente);
            pdf.add(linhaAssinatura);
            pdf.add(dadosEmpresa);
            pdf.add(diaLocal);

            pdf.newPage();

            pdf.add(tituloContrato);
            pdf.add(textoContrato);
            pdf.add(periodo);
            pdf.add(objLocados);
            pdf.add(linhaAssinatura);
            pdf.add(dadosCliente);
            pdf.add(linhaAssinatura);
            pdf.add(dadosEmpresa);
            pdf.add(diaLocal);

        } catch (DocumentException | IOException de) {
            System.err.println(de.getMessage());

        } finally {
            pdf.close();
        }
    }

    private String getDescricaoDeProdutos(long idLocacao) throws LocacaoInexistenteException {
        String descCompleta = "";
        List<ProdutoLocado> produtosLocados = new ArrayList<ProdutoLocado>();
        produtosLocados = GerenciadorDeLocacao.getInstance().pesquisarLocacaoPorId(idLocacao).getProdutos();
        for (Produto p : this.produtos) {
            for (ProdutoLocado pl : produtosLocados) {
                if (pl.getCodigoProduto().toUpperCase().equals(p.getCodigo().toUpperCase())) {
                    descCompleta += pl.getQuantidade() + " - " + p.getDescricao() + "\n";
                }
            }

        }

        return descCompleta;
    }
}
