/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Odravison
 */
@Entity
public class DadosConfiguracao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nomeDaImpressora;
    
    @OneToOne(cascade = {CascadeType.ALL})
    private Empresa empresa = null;
    
    private String contratoOriginal = "Terni Vellucci , inscrita no CNPJ/22.833.691/0001-47, Av.Presidente Epitácio Pessoa, Nº 2400 doravante denominada “Terni Vellucci”, neste ato representada na Forma de seu contrato social e de outro lado o contratante denominado de “LOCADOR”, resolvem celebrar o presente contrato de locação, nas seguintes condições:\n"
                + "Cláusula 1ª. O objeto do presente contrato é a locação de roupas, usadas ou não, e acessórios de uso pessoal, as quais são selecionados e indicados pelo LOCADOR, pessoalmente na loja física.\n"
                + "Cláusula 2ª. A Terni Vellucci se compromete a disponibilizar ao LOCADOR, as roupas e acessórios, escolhidos e locados, em perfeito estado para uso e conservação, na data estabelecida;\n"
                + " Cláusula 3ª. A não devolução dos bens locados, em até 5 (cinco) dias da data pactuada para devolução, será considerado EXTRAVIO, obrigando-se, o LOCADOR a indenizar a Terni Vellucci, as roupas e acessórios locados, no valor correspondente a duas vezes o mesmo valor pago pela locação, ficando autorizado a emissão de boleto de cobrança correspondente;\n"
                + "Cláusula 4ª. Se houver danos aos bens locados, tais como: rasgos, manchas, esfolamento e outros que tornem o produto impróprio para nova locação, o LOCADOR fica obrigado a indenizar a Terni Vellucci, na forma da clausula anterior e mediante o pagamento, os bens danificados serão entregues ao LOCADOR;\n"
                + "Cláusula 5ª. Quando o LOCADOR deixar de comparecer à loja para retirar os produtos, na data e dentro de horário de funcionamento da loja, o mesmo perderá os valores já pagos, bem como, ficará obrigado a pagar o valor restante que eventualmente tenha ficado devendo do total da locação, autorizando a emissão de boleto de cobrança correspondente;\n"
                + "Cláusula 6ª. Nenhuma peça locada será entregue ao CLIENTE sem o devido pagamento. E por estarem de acordo firmam o presente contrato.";
    
    private int diasEmprestimo = 0;
    private String diretorioDeContratos = null;
    private String diretorioDeBackup = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DadosConfiguracao)) {
            return false;
        }
        DadosConfiguracao other = (DadosConfiguracao) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.oltecnologias.hype.model.DadosConfiguracao[ id=" + id + " ]";
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

    public String getContratoOriginal() {
        return contratoOriginal;
    }

    public void setContratoOriginal(String contratoOriginal) {
        this.contratoOriginal = contratoOriginal;
    }

    public int getDiasEmprestimo() {
        return diasEmprestimo;
    }

    public void setDiasEmprestimo(int diasEmprestimo) {
        this.diasEmprestimo = diasEmprestimo;
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
    
    
}
