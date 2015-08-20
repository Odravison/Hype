package br.oltecnologias.hype.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contrato implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    private String modeloPDF;
    private String diretorioDoContrato;

    public Contrato(String modeloPDF) {
        this.modeloPDF = modeloPDF;
    }

    public Contrato() {
    
    }

    public String getModeloPDF() {
        return modeloPDF;
    }

    public void setModeloPDF(String modeloPDF) {
        this.modeloPDF = modeloPDF;
    }
    
    public String getDiretorioDoContrato(){
        return this.diretorioDoContrato;
    }
    
    public void setDiretorioDoContrato(String diretorioDoContrato){
        this.diretorioDoContrato = diretorioDoContrato;
    }

}
