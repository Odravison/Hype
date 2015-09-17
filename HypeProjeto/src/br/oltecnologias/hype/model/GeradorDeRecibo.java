/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.model;

import br.oltecnologias.hype.controller.GerenciadorDeLocacao;
import br.oltecnologias.hype.controller.GerenciadorDoSistema;
import br.oltecnologias.hype.exception.LocacaoInexistenteException;
import br.oltecnologias.hype.exception.ProdutoInexistenteException;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Odravison
 */
public class GeradorDeRecibo {

    private static GeradorDeRecibo singleton;
    private List<Produto> produtos;
    private Configuracao conf = GerenciadorDoSistema.getInstance().getConfiguracao();

    public static GeradorDeRecibo getInstance() {
        if (singleton == null) {
            singleton = new GeradorDeRecibo();
        }
        return singleton;
    }

    private GeradorDeRecibo() {
        this.produtos = new ArrayList<Produto>();
    }

    public static String valorPorExtenso(double vlr) {
        if (vlr == 0) {
            return ("zero");
        }

        long inteiro = (long) Math.abs(vlr); // parte inteira do valor
        double resto = vlr - inteiro;       // parte fracionária do valor

        String vlrS = String.valueOf(inteiro);
        if (vlrS.length() > 15) {
            return ("Erro: valor superior a 999 trilhões.");
        }

        String s = "", saux, vlrP;
        String centavos = String.valueOf((int) Math.round(resto * 100));

        String[] unidade = {"", "um", "dois", "três", "quatro", "cinco",
            "seis", "sete", "oito", "nove", "dez", "onze",
            "doze", "treze", "quatorze", "quinze", "dezesseis",
            "dezessete", "dezoito", "dezenove"};
        String[] centena = {"", "cento", "duzentos", "trezentos",
            "quatrocentos", "quinhentos", "seiscentos",
            "setecentos", "oitocentos", "novecentos"};
        String[] dezena = {"", "", "vinte", "trinta", "quarenta", "cinquenta",
            "sessenta", "setenta", "oitenta", "noventa"};
        String[] qualificaS = {"", "mil", "milhão", "bilhão", "trilhão"};
        String[] qualificaP = {"", "mil", "milhões", "bilhões", "trilhões"};

// definindo o extenso da parte inteira do valor
        int n, unid, dez, cent, tam, i = 0;
        boolean umReal = false, tem = false;
        while (!vlrS.equals("0")) {
            tam = vlrS.length();
            
// retira do valor a 1a. parte, 2a. parte, por exemplo, para 123456789:
// 1a. parte = 789 (centena)
// 2a. parte = 456 (mil)
// 3a. parte = 123 (milhões)
            if (tam > 3) {
                vlrP = vlrS.substring(tam - 3, tam);
                vlrS = vlrS.substring(0, tam - 3);
            } else { // última parte do valor
                vlrP = vlrS;
                vlrS = "0";
            }
            if (!vlrP.equals("000")) {
                saux = "";
                if (vlrP.equals("100")) {
                    saux = "cem";
                } else {
                    n = Integer.parseInt(vlrP, 10);  // para n = 371, tem-se:
                    cent = n / 100;                  // cent = 3 (centena trezentos)
                    dez = (n % 100) / 10;            // dez  = 7 (dezena setenta)
                    unid = (n % 100) % 10;           // unid = 1 (unidade um)
                    if (cent != 0) {
                        saux = centena[cent];
                    }
                    if ((dez != 0) || (unid != 0)) {
                        if ((n % 100) <= 19) {
                            if (saux.length() != 0) {
                                saux = saux + " e " + unidade[n % 100];
                            } else {
                                saux = unidade[n % 100];
                            }
                        } else {
                            if (saux.length() != 0) {
                                saux = saux + " e " + dezena[dez];
                            } else {
                                saux = dezena[dez];
                            }
                            if (unid != 0) {
                                if (saux.length() != 0) {
                                    saux = saux + " e " + unidade[unid];
                                } else {
                                    saux = unidade[unid];
                                }
                            }
                        }
                    }
                }
                if (vlrP.equals("1") || vlrP.equals("001")) {
                    if (i == 0) // 1a. parte do valor (um real)
                    {
                        umReal = true;
                    } else {
                        saux = saux + " " + qualificaS[i];
                    }
                } else if (i != 0) {
                    saux = saux + " " + qualificaP[i];
                }
                if (s.length() != 0) {
                    s = saux + ", " + s;
                } else {
                    s = saux;
                }
            }
            if (((i == 0) || (i == 1)) && s.length() != 0) {
                tem = true; // tem centena ou mil no valor
            }
            i = i + 1; // próximo qualificador: 1- mil, 2- milhão, 3- bilhão, ...
        }

        if (s.length() != 0) {
            if (umReal) {
                s = s + " real";
            } else if (tem) {
                s = s + " reais";
            } else {
                s = s + " de reais";
            }
        }

// definindo o extenso dos centavos do valor
        if (!centavos.equals("0")) { // valor com centavos
            if (s.length() != 0) // se não é valor somente com centavos
            {
                s = s + " e ";
            }
            if (centavos.equals("1")) {
                s = s + "um centavo";
            } else {
                n = Integer.parseInt(centavos, 10);
                if (n <= 19) {
                    s = s + unidade[n];
                } else {             // para n = 37, tem-se:
                    unid = n % 10;   // unid = 37 % 10 = 7 (unidade sete)
                    dez = n / 10;    // dez  = 37 / 10 = 3 (dezena trinta)
                    s = s + dezena[dez];
                    if (unid != 0) {
                        s = s + " e " + unidade[unid];
                    }
                }
                s = s + " centavos";
            }
        }
        return (s);
    }

    public void gerarRecibo(Locacao loc) throws LocacaoInexistenteException, ProdutoInexistenteException {
        this.produtos = GerenciadorDeLocacao.getInstance().getProdutosDeLocacao(loc.getId());

        Image logo = null;

        double valorResta = loc.getValorLocacao() - loc.getValorDeEntrada();

        try {

            logo = Image.getInstance("C:\\Projeto\\HypeProjeto\\HypeProjeto\\Imagens\\SmallLogo-wide.png");
            logo.scaleToFit(307, 91);

        } catch (BadElementException | IOException ex) {
            Logger.getLogger(GeradorDeRecibo.class.getName()).log(Level.SEVERE, null, ex);
        }

        Font timesNewRoman14 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        Font timesNewRoman18 = new Font(Font.FontFamily.TIMES_ROMAN, 18);
        Font timesNewRoman12 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
        Font courier12 = new Font(Font.FontFamily.COURIER, 12);

        Document pdf = new Document();
        File diretorio;

        String horaGeracao = new SimpleDateFormat("_HH-mm").format(Calendar.getInstance().getTime());
        String diaRecibo = new SimpleDateFormat("dd.MM.yyyy").format(loc.getDataLocacao().getTime());

        String dia = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
        String mes = new SimpleDateFormat("MMMMM", new Locale("pt", "BR")).format(Calendar.getInstance().getTime());
        String ano = new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());

        String dataLocFormatada = new SimpleDateFormat("dd/MM/yyyy").format(loc.getDataLocacao().getTime());

        try {

            diretorio = new File(conf.getDiretorioDeDocumentos()
                    + "\\" + loc.getCliente().getNome() + "\\Recibos");

            diretorio.mkdir();

            System.out.println(diretorio.toString());

            PdfWriter.getInstance(pdf, new FileOutputStream(diretorio.toString() + "\\" + "Rec_"
                    + diaRecibo + "__H_" + horaGeracao + ".pdf"));

            pdf.open();
            pdf.setPageSize(PageSize.A4);

            Paragraph cabecalhoDeRecibo;
            cabecalhoDeRecibo = new Paragraph("Terni Vellucci \n"
                    + "CNPJ 22.833.691/0001-47 Av.Presidente Epitácio Pessoa, 2400 Centro – João Pessoa – PB\n"
                    + "Fone: " + conf.getEmpresa().getTelefone(), timesNewRoman12);
            cabecalhoDeRecibo.setAlignment(Paragraph.ALIGN_CENTER);
            cabecalhoDeRecibo.setSpacingAfter(10);

            Paragraph tituloDeRecibo;
            tituloDeRecibo = new Paragraph("RECIBO", timesNewRoman18);
            tituloDeRecibo.setAlignment(Paragraph.ALIGN_CENTER);

            Paragraph descCurtaProd;
            descCurtaProd = new Paragraph(getDescricaoCurta(produtos), courier12);

            Paragraph textoRecibo;
            textoRecibo = new Paragraph("Recebi de " + loc.getCliente().getNome() + " a importância de " + valorPorExtenso(loc.getValorDeEntrada()) + "\n"
                    + "Forma de pagamento: " + loc.getFormaDePagamento() + "\n"
                    + "Referente à locação de " + descCurtaProd.toString() + "\n "
                    + "Valor Total: " + loc.getValorLocacao() + "\n"
                    + "Entrada: " + loc.getValorDeEntrada() + "\n"
                    + "Resta: " + valorResta + "\n"
                    + "Para dia: " + loc.getDataLocacao(), timesNewRoman12);
            textoRecibo.setAlignment(Paragraph.ALIGN_CENTER);

            Paragraph linhaAssinatura;
            linhaAssinatura = new Paragraph("________________________________________________________________________",
                    timesNewRoman12);
            linhaAssinatura.setAlignment(Paragraph.ALIGN_CENTER);

            Paragraph diaLocal;
            diaLocal = new Paragraph(conf.getEmpresa().getEndereco().getCidade()
                    + ", " + dia + " de " + mes + " de" + ano, timesNewRoman12);
            diaLocal.setAlignment(Paragraph.ALIGN_RIGHT);

            Paragraph linhaDeCorte;
            linhaDeCorte = new Paragraph("==============================================================",
                    timesNewRoman12);
            linhaDeCorte.setAlignment(Paragraph.ALIGN_CENTER);

            pdf.add(logo);
            pdf.add(cabecalhoDeRecibo);
            pdf.add(tituloDeRecibo);
            pdf.add(textoRecibo);
            pdf.add(linhaAssinatura);

            pdf.add(linhaDeCorte);

            pdf.add(logo);
            pdf.add(cabecalhoDeRecibo);
            pdf.add(tituloDeRecibo);
            pdf.add(textoRecibo);
            pdf.add(linhaAssinatura);

            String diretorioImpressao = conf.getDiretorioDeDocumentos()
                    + "\\" + loc.getCliente().getNome() + "\\Recibos\\" + "Rec_" + diaRecibo + "__H_" + horaGeracao + ".pdf";

            FileInputStream fis = new FileInputStream(diretorioImpressao);
            PrintPdf printPDFFile = new PrintPdf(fis, "Rec_" + diaRecibo + "__H_" + horaGeracao + ".pdf", 
                    conf.getNomeDaImpressora());

        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(GeradorDeRecibo.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (IOException | PrinterException ex) {
            Logger.getLogger(GeradorDeRecibo.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            pdf.close();
            loc.setJaPago(loc.getValorDeEntrada());

        }

    }

    public void gerarEImprimirRecibo(Locacao loc) throws FileNotFoundException, IOException, PrinterException, LocacaoInexistenteException, ProdutoInexistenteException {
        gerarRecibo(loc);
        String horaGeracao = new SimpleDateFormat("_HH-mm").format(Calendar.getInstance().getTime());
        String diaRecibo = new SimpleDateFormat("dd.MM.yyyy").format(loc.getDataLocacao().getTime());
        
        
        String diretorio = conf.getDiretorioDeDocumentos()
                    + "\\" + loc.getCliente().getNome()+ "\\Recibos\\" +  "Rec_" + diaRecibo + "__H_" + horaGeracao +".pdf";
        
        
        FileInputStream fis = new FileInputStream(diretorio);
        PrintPdf printPDFFile = new PrintPdf(fis, "Rec_" + diaRecibo + "__H_" + horaGeracao +".pdf", conf.getNomeDaImpressora());
        
        
        printPDFFile.print();
        
    }

    private String getDescricaoCurta(List<Produto> produtos) {
        String descricaoCurta = "";
        for (Produto p : produtos) {
            descricaoCurta += p.getNome() + ", ";
        }

        return descricaoCurta;
    }

    public void gerarEImprimirPxRecibo(Locacao loc, double valorDessePagamento) throws LocacaoInexistenteException, ProdutoInexistenteException {
        this.produtos = GerenciadorDeLocacao.getInstance().getProdutosDeLocacao(loc.getId());

        Image logo = null;
        
        loc.addValorJaPago(valorDessePagamento);
        double valorResta = loc.getValorLocacao() - loc.getJaPago();
        

        try {

            logo = Image.getInstance("C:\\Projeto\\HypeProjeto\\HypeProjeto\\Imagens\\SmallLogo-wide.png");
            logo.scaleToFit(307, 91);

        } catch (BadElementException | IOException ex) {
            Logger.getLogger(GeradorDeRecibo.class.getName()).log(Level.SEVERE, null, ex);
        }

        Font timesNewRoman14 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        Font timesNewRoman18 = new Font(Font.FontFamily.TIMES_ROMAN, 18);
        Font timesNewRoman12 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
        Font courier12 = new Font(Font.FontFamily.COURIER, 12);

        Document pdf = new Document();
        File diretorio;

        String horaGeracao = new SimpleDateFormat("_HH-mm").format(Calendar.getInstance().getTime());
        String diaRecibo = new SimpleDateFormat("dd.MM.yyyy").format(loc.getDataLocacao().getTime());

        String dia = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
        String mes = new SimpleDateFormat("MMMMM", new Locale("pt", "BR")).format(Calendar.getInstance().getTime());
        String ano = new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());

        String dataLocFormatada = new SimpleDateFormat("dd/MM/yyyy").format(loc.getDataLocacao().getTime());

        try {

            diretorio = new File(conf.getDiretorioDeDocumentos()
                    + "\\" + loc.getCliente().getNome() + "\\Recibos");

            diretorio.mkdir();

            System.out.println(diretorio.toString());

            PdfWriter.getInstance(pdf, new FileOutputStream(diretorio.toString() + "\\" + "Rec_"
                    + diaRecibo + "__H_" + horaGeracao + ".pdf"));

            pdf.open();
            pdf.setPageSize(PageSize.A4);

            Paragraph cabecalhoDeRecibo;
            cabecalhoDeRecibo = new Paragraph("Terni Vellucci \n"
                    + "CNPJ 22.833.691/0001-47 Av.Presidente Epitácio Pessoa, 2400 Centro – João Pessoa – PB\n"
                    + "Fone: " + conf.getEmpresa().getTelefone(), timesNewRoman12);
            cabecalhoDeRecibo.setAlignment(Paragraph.ALIGN_CENTER);
            cabecalhoDeRecibo.setSpacingAfter(10);

            Paragraph tituloDeRecibo;
            tituloDeRecibo = new Paragraph("RECIBO", timesNewRoman18);
            tituloDeRecibo.setAlignment(Paragraph.ALIGN_CENTER);

            Paragraph descCurtaProd;
            descCurtaProd = new Paragraph(getDescricaoCurta(produtos), courier12);

            Paragraph textoRecibo;
            textoRecibo = new Paragraph("Recebi de " + loc.getCliente().getNome() + " a importância de " + valorPorExtenso(valorDessePagamento) + "\n"
                    + "Forma de pagamento: " + loc.getFormaDePagamento() + "\n"
                    + "Referente à locação de " + descCurtaProd.toString() + "\n "
                    + "Valor Total: " + loc.getValorLocacao() + "\n"
                    + "Pago neste dia: " + valorDessePagamento + "\n"
                    + "Resta: " + valorResta + "\n"
                    + "Para dia: " + loc.getDataLocacao(), timesNewRoman12);
            textoRecibo.setAlignment(Paragraph.ALIGN_CENTER);

            Paragraph linhaAssinatura;
            linhaAssinatura = new Paragraph("________________________________________________________________________",
                    timesNewRoman12);
            linhaAssinatura.setAlignment(Paragraph.ALIGN_CENTER);

            Paragraph diaLocal;
            diaLocal = new Paragraph(conf.getEmpresa().getEndereco().getCidade()
                    + ", " + dia + " de " + mes + " de" + ano, timesNewRoman12);
            diaLocal.setAlignment(Paragraph.ALIGN_RIGHT);

            Paragraph linhaDeCorte;
            linhaDeCorte = new Paragraph("==============================================================",
                    timesNewRoman12);
            linhaDeCorte.setAlignment(Paragraph.ALIGN_CENTER);

            pdf.add(logo);
            pdf.add(cabecalhoDeRecibo);
            pdf.add(tituloDeRecibo);
            pdf.add(textoRecibo);
            pdf.add(linhaAssinatura);

            pdf.add(linhaDeCorte);

            pdf.add(logo);
            pdf.add(cabecalhoDeRecibo);
            pdf.add(tituloDeRecibo);
            pdf.add(textoRecibo);
            pdf.add(linhaAssinatura);
            
            String diretorioImpressao = conf.getDiretorioDeDocumentos()
                    + "\\" + loc.getCliente().getNome() + "\\Recibos\\" +  "Rec_" + diaRecibo + "__H_" + horaGeracao + ".pdf";

            FileInputStream fis = new FileInputStream(diretorioImpressao);
            PrintPdf printPDFFile = new PrintPdf(fis, "Rec_" + diaRecibo + "__H_" + horaGeracao + ".pdf", 
                    conf.getNomeDaImpressora());

            printPDFFile.print();

        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(GeradorDeRecibo.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (IOException | PrinterException ex) {
            Logger.getLogger(GeradorDeRecibo.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            pdf.close();
            loc.setJaPago(loc.getJaPago() + valorDessePagamento);
        }
    }
}
