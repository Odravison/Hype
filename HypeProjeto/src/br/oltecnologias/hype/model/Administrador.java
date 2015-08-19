package br.oltecnologias.hype.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="ADMINISTRADOR")
public class Administrador extends Pessoa implements Serializable {
    
    private String senha;
    @Id
    private String nickName;

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
