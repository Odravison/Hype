package br.oltecnologias.hype.model;

public class Administrador extends Pessoa {

    private int id;
    private String senha;
    private String nickName;

    public Administrador(String senha, String nickName) {
        this.senha = senha;
        this.nickName = nickName;
    }
    
    @Override
    public String getDescricao() {
        return "Nome: " + super.getNome() + "\n"
                + "Usuário: " + this.nickName;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    
}
