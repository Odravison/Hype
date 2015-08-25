/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

/**
 *
 * @author Odravison
 */
@Entity
public class Configuracao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nomeDaImpressora;

    @OneToOne(cascade = {CascadeType.ALL})
    private Empresa empresa = null;
    
    private double descontoAVista;

    private String contratoPt1 = "Terni Vellucci , inscrita no CNPJ/22.833.691/0001-47, Av.Presidente Epitácio Pessoa, Nº 2400 doravante denominada “Terni Vellucci”, neste ato representada na Forma de seu contrato social e de outro lado o contratante denominado de “LOCADOR”, resolvem celebrar o presente contrato de locação, nas seguintes condições:\n"
            + "Cláusula 1ª. O objeto do presente contrato é a locação de roupas, usadas ou não, e acessórios de uso pessoal, as quais são selecionados e indicados pelo LOCADOR, pessoalmente na loja física.\n"
            + "Cláusula 2ª. A Terni Vellucci se compromete a disponibilizar ao LOCADOR, as roupas e acessórios, escolhidos e locados, em perfeito estado para uso e conservação, na data estabelecida;\n";
    
    private String contratoPt2 = "Cláusula 3ª. A não devolução dos bens locados, em até 5 (cinco) dias da data pactuada para devolução, será considerado EXTRAVIO, obrigando-se, o LOCADOR a indenizar a Terni Vellucci, as roupas e acessórios locados, no valor correspondente a duas vezes o mesmo valor pago pela locação, ficando autorizado a emissão de boleto de cobrança correspondente;\n"
            + "Cláusula 4ª. Se houver danos aos bens locados, tais como: rasgos, manchas, esfolamento e outros que tornem o produto impróprio para nova locação, o LOCADOR fica obrigado a indenizar a Terni Vellucci, na forma da clausula anterior e mediante o pagamento, os bens danificados serão entregues ao LOCADOR;\n"
            + "Cláusula 5ª. Quando o LOCADOR deixar de comparecer à loja para retirar os produtos, na data e dentro de horário de funcionamento da loja, o mesmo perderá os valores já pagos, bem como, ficará obrigado a pagar o valor restante que eventualmente tenha ficado devendo do total da locação, autorizando a emissão de boleto de cobrança correspondente;\n"
            + "Cláusula 6ª. Nenhuma peça locada será entregue ao CLIENTE sem o devido pagamento. E por estarem de acordo firmam o presente contrato.";
    
    private String diretorioDeContratos = null;
    private String diretorioDeBackup = null;

    public Configuracao() {
    }

    public static Configuracao getInstance() {
        return ConfiguracaoHolder.INSTANCE;
    }

    private static class ConfiguracaoHolder {
        private static final Configuracao INSTANCE = new Configuracao();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDaImpressora() {
        return nomeDaImpressora;
    }

    public void setNomeDaImpressora(String nomeDaImpressora) {
        this.nomeDaImpressora = nomeDaImpressora;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getContratoPt1() {
        return contratoPt1;
    }

    public void setContratoPt1(String contratoPt1) {
        this.contratoPt1 = contratoPt1;
    }

    public String getContratoPt2() {
        return contratoPt2;
    }

    public void setContratoPt2(String contratoPt2) {
        this.contratoPt2 = contratoPt2;
    }

    public String getDiretorioDeContratos() {
        return diretorioDeContratos;
    }

    public void setDiretorioDeContratos(String diretorioDeContratos) {
        this.diretorioDeContratos = diretorioDeContratos;
    }

    public String getDiretorioDeBackup() {
        return diretorioDeBackup;
    }

    public void setDiretorioDeBackup(String diretorioDeBackup) {
        this.diretorioDeBackup = diretorioDeBackup;
    }

    public double getDescontoAVista() {
        return descontoAVista;
    }

    public void setDescontoAVista(double descontoAVista) {
        this.descontoAVista = descontoAVista * 0.01;
    }
}
