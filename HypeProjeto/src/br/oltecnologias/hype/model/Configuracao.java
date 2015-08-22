package br.oltecnologias.hype.model;

public class Configuracao {
    
    private static DadosConfiguracao dados;
    private static Configuracao singleton = null;

    public Configuracao(){
        
    }
    
    public static Configuracao getInstance(){
        if (singleton == null){
            singleton = new Configuracao();
            dados = new DadosConfiguracao();
        }
        return singleton;
    }
    
    

    public Empresa getEmpresa() {
        return dados.getEmpresa();
    }

    public void setEmpresa(Empresa empresa) {
        dados.setEmpresa(empresa);
    }

    public int getDiasEmprestimo() {
        return dados.getDiasEmprestimo();
    }

    public void setDiasEmprestimo(int diasEmprestimo) {
        dados.setDiasEmprestimo(diasEmprestimo);
    }

    public String getDiretorioDeContratos() {
        return dados.getDiretorioDeContratos();
    }

    public void setDiretorioDeContratos(String diretorioDeContratos) {
        dados.setDiretorioDeContratos(diretorioDeContratos);
    }

    public String getDiretorioDeBackup() {
        return dados.getDiretorioDeBackup();
    }

    public void setDiretorioDeBackup(String diretorioDeBackup) {
        dados.setDiretorioDeBackup(diretorioDeBackup);
    }

    public int getId() {
        return dados.getId();
    }

    public void setId(int id) {
        dados.setId(id);
    }

    public String getContratoOriginal() {
        return dados.getContratoOriginal();
    }

    public void setContratoOriginal(String contratoOriginal) {
        dados.setContratoOriginal(contratoOriginal);
    }

    public String getNomeDaImpressora() {
        return dados.getNomeDaImpressora();
    }

    public void setNomeDaImpressora(String nomeDaImpressora) {
        dados.setNomeDaImpressora(nomeDaImpressora);
    }

    public static Configuracao getSingleton() {
        return singleton;
    }
    
    
    
    
}
