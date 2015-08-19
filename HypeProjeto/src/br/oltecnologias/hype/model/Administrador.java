package br.oltecnologias.hype.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="ADMINISTRADOR")
public class Administrador extends Pessoa {
    
    @Id
    @Column(name="ID_ADMINISTRADOR")
    @GeneratedValue
    private int id;
    
    @Column(name="ADM_SENHA", nullable = false, columnDefinition = "VARCHAR(10)",
            length = 10)
    private String senha;
    
    @Column(name="ADM_NICKNAME", nullable = false, columnDefinition = "VARCHAR(12)",
            length = 12)
    private String nickName;

    public Administrador(String senha, String nickName, String nome) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
