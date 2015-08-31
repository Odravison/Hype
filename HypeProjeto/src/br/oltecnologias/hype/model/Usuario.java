package br.oltecnologias.hype.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Usuario implements Serializable {
    
    private String nome;
    
    @Id
    private String nickName;
    private String senha;
    private boolean isAdministrador;

    public Usuario() {
    }

    public Usuario(String nome, String nickName, String senha, boolean isAdministrador) {
        this.nome = nome;
        this.senha = senha;
        this.nickName = nickName;
        this.isAdministrador = isAdministrador;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isIsAdministrador() {
        return isAdministrador;
    }
    
    public String getCategoria() {
        if(isAdministrador) {
            return "Administrador";
        }
        return "Funcionário";
    }
}
