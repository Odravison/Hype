/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.model;

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

    public static GeradorDeContrato getInstance() {
        if (singleton == null) {
            singleton = new GeradorDeContrato();
        }
        return singleton;
    }

    private GeradorDeContrato() {
        produtos = new ArrayList<Produto>();

    }
    
    public void imprimirContrato(Cliente cliente, Calendar dataLocacao, Calendar dataDevolucao, List<Produto> produtos) throws IOException, Exception{
        
        gerarContrato(cliente, dataLocacao, dataDevolucao, produtos);
        String horaGeracao = new SimpleDateFormat("_HH-mm").format(Calendar.getInstance().getTime());
        String diaContrato = new SimpleDateFormat("dd.MM.yyyy").format(dataLocacao.getTime());
        
        String diretorio = Configuracao.getInstance().getDiretorioDeContratos()
                    + "\\" + cliente.getNome()+ "\\" + "DL_" + diaContrato + "__H_" + horaGeracao +".pdf";
        
        
        FileInputStream fis = new FileInputStream(diretorio);
        PrintPdf printPDFFile = new PrintPdf(fis, "DL_" + diaContrato + "__H_" + horaGeracao +".pdf", "RICOH Class Driver");

        printPDFFile.print();
        
    }

    public void gerarContrato(Cliente cliente, Calendar dataLocacao, Calendar dataDevolucao, List<Produto> produtos)
            throws DocumentException, IOException, Exception {
        this.produtos = produtos;
        Document pdf = new Document();
        File diretorio = null;
        String horaGeracao = new SimpleDateFormat("_HH-mm").format(Calendar.getInstance().getTime());
        String diaContrato = new SimpleDateFormat("dd.MM.yyyy").format(dataLocacao.getTime());

        String dia = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
        String mes = new SimpleDateFormat("MMMMM", new Locale("pt", "BR")).format(Calendar.getInstance().getTime());
        String ano = new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());

        String dataLocFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataLocacao.getTime());
        String dataDevFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataDevolucao.getTime());
        Font timesNewRoman14 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        Font timesNewRoman12 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
        Font courier12 = new Font(Font.FontFamily.COURIER, 12);

        try {
            diretorio = new File(Configuracao.getInstance().getDiretorioDeContratos()
                    + "\\" + cliente.getNome());
            
            diretorio.mkdir();
            
            System.out.println(diretorio.toString());
            
            PdfWriter.getInstance(pdf, new FileOutputStream(diretorio.toString() + "\\" + "DL_" + diaContrato + "__H_" + horaGeracao +".pdf"));
            pdf.open();
            pdf.setPageSize(PageSize.A4);

            Paragraph tituloContrato = new Paragraph("CONTRATO DE LOCAÇÃO DE ROUPAS E ACESSÓRIOS", timesNewRoman14);
            tituloContrato.setAlignment(Paragraph.ALIGN_CENTER);
            tituloContrato.setSpacingAfter(10);

            Paragraph textoContrato;
            textoContrato = new Paragraph(Configuracao.getInstance().getContratoOriginal(), timesNewRoman12);
            textoContrato.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            textoContrato.setPaddingTop(2);

            Paragraph periodo;
            periodo = new Paragraph("Período da Locação: " + dataLocFormatada + " a " + dataDevFormatada, timesNewRoman12);
            periodo.setAlignment(Paragraph.ALIGN_CENTER);

            Paragraph objLocados;
            objLocados = new Paragraph("Trajes e acessórios Locados: \n" + getDescricaoDeProdutos(), courier12);
            objLocados.setSpacingAfter(20);

            Paragraph linhaAssinatura;
            linhaAssinatura = new Paragraph("________________________________________________________________________", timesNewRoman12);
            linhaAssinatura.setAlignment(Paragraph.ALIGN_CENTER);

            Paragraph dadosCliente;
            dadosCliente = new Paragraph("Locador: " + cliente.getNome() + ", portador do nº de CPF: " + cliente.getCpf(), timesNewRoman12);
            dadosCliente.setSpacingAfter(40);
            dadosCliente.setAlignment(Paragraph.ALIGN_CENTER);

            Paragraph dadosEmpresa;
            dadosEmpresa = new Paragraph("Locatário: " + Configuracao.getInstance().getEmpresa().getNome()
                    + ", portador do nº de CNPJ: " + Configuracao.getInstance().getEmpresa().getCnpj(), timesNewRoman12);
            dadosEmpresa.setSpacingAfter(20);
            dadosEmpresa.setAlignment(Paragraph.ALIGN_CENTER);

            Paragraph diaLocal;
            diaLocal = new Paragraph(Configuracao.getInstance().getEmpresa().getEndereco().getCidade()
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

        } catch (DocumentException | IOException de) {
            throw de;

        } finally {
            pdf.close();
        }

    }

    private String getDescricaoDeProdutos() {
        String descCompleta = "";
        for (Produto p: this.produtos) {
            descCompleta += p.getDescricao() + "\n";
        }
                
        return descCompleta;
    }
}
