package br.oltecnologias.hype.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Administrador extends Pessoa {
    
    @Id
    private String nickName;
    private String senha;

    public Administrador() {
    }

    public Administrador(String nome, String nickName, String senha) {
        super(nome);
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

    public String getNickName() {
        return nickName;
    }
}
