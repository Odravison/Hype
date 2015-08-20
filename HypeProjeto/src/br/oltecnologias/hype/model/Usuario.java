package br.oltecnologias.hype.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario extends Pessoa {
    
    @Id
    private String nickName;
    private String senha;
    private boolean isAdministrador;

    public Usuario() {
    }

    public Usuario(String nome, String nickName, String senha, boolean isAdministrador) {
        super(nome);
        this.senha = senha;
        this.nickName = nickName;
        this.isAdministrador = isAdministrador;
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

    public String getNickName() {
        return nickName;
    }
    
    public boolean isAdministrador() {
        return isAdministrador;
    }

    public void setIsAdministrador(boolean isAdministrador) {
        this.isAdministrador = isAdministrador;
    }

}
