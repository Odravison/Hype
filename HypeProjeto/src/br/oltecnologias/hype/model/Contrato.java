package br.oltecnologias.hype.model;

public class Contrato {

	private String modeloPDF;
        private String diretorioDoContrato;

    public Contrato(String modeloPDF) {
        this.modeloPDF = modeloPDF;
    }

    Contrato() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
