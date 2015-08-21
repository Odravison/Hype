/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.model;

/**
 *
 * @author Odravison
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import com.sun.pdfview.PDFRenderer;


import javax.print.PrintService;

public class PrintPdf {

    private PrinterJob pjob = null;
    static String imp = "";
    private PrintService impressora = null;

    public PrintPdf(InputStream inputStream, String jobName, String impressora) throws IOException, PrinterException {
        byte[] pdfContent = new byte[inputStream.available()];
        inputStream.read(pdfContent, 0, inputStream.available());
        initialize(pdfContent, jobName);
        imp = impressora;
    }

    public PrintPdf(byte[] content, String jobName) throws IOException, PrinterException {
        initialize(content, jobName);
    }

    private void initialize(byte[] pdfContent, String jobName) throws IOException, PrinterException {
        ByteBuffer bb = ByteBuffer.wrap(pdfContent);

        PDFFile pdfFile = new PDFFile(bb);
        PDFPrintPage pages = new PDFPrintPage(pdfFile);

        PrintService[] pservices = PrinterJob.lookupPrintServices();

        System.out.println(pservices.length);
        if (pservices.length > 0) {
            for (PrintService ps : pservices) {
                System.out.println("Impressora Encontrada: " + ps.getName());


                if (ps.getName().contains(imp)) {
                    System.out.println("Impressora Selecionada: " + ps.getName());
                    impressora = ps;
                    System.out.println("Entrou dentro do if com impressora certa.");
                    break;
                }
            }
        }
        if (impressora != null) {
            pjob = PrinterJob.getPrinterJob();
            pjob.setPrintService(impressora);
            System.out.println("Impressora diferente de null " + pjob.getJobName() + pjob.getUserName());

            PageFormat pf = PrinterJob.getPrinterJob().defaultPage();
            
            
            pjob.setJobName(jobName);
            Book book = new Book();
            book.append(pages, pf, pdfFile.getNumPages());
            pjob.setPageable(book);

            Paper paper = new Paper();
            paper.setSize(595, 842);
            
            System.out.println(" " + Double.toString(paper.getWidth()) + " " + Double.toString(paper.getHeight()));

            paper.setImageableArea(0, 0, paper.getWidth(), paper.getHeight());
            
            pf.setPaper(paper);
            pf.setOrientation(PageFormat.PORTRAIT);
        }
    }

    public void print() throws PrinterException {
        if (impressora != null) {
            System.out.println("IMPRIMINDO....");
            pjob.print();
            System.out.println("IMPRIMIU");
        }

    }
}

class PDFPrintPage implements Printable {

    private PDFFile file;

    PDFPrintPage(PDFFile file) {
        this.file = file;
    }

    @Override
    public int print(Graphics g, PageFormat format, int index) throws PrinterException {
        int pagenum = index + 1;
        if ((pagenum >= 1) && (pagenum <= file.getNumPages())) {
            Graphics2D g2 = (Graphics2D) g;
            PDFPage page = file.getPage(pagenum);

            Rectangle imageArea = new Rectangle((int) format.getImageableX(), (int) format.getImageableY(),
                    (int) format.getImageableWidth(), (int) format.getImageableHeight());
            g2.translate(0, 0);
            PDFRenderer pgs = new PDFRenderer(page, g2, imageArea, null, null);
            try {
                page.waitForFinish();
                pgs.run();
            } catch (InterruptedException ie) {
                System.out.println(ie.toString());
            }
            return PAGE_EXISTS;
        } else {
            return NO_SUCH_PAGE;
        }
    }
}
