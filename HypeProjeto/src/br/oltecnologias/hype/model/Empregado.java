/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Odravison
 */
@Entity
public class Empregado extends Pessoa {
    
    @Id
    private String nickName;
    private String senha;
    
    public Empregado (String nome, String nickName, String senha){
        super(nome);
        this.nickName = nickName;
        this.senha = senha;
    }
    
    public Empregado (){
        
    }

    @Override
    public String getDescricao() {
        String descricao = "Usuário: " + super.getNome() + "\n"
                + "Nickname: " + this.nickName;
        
        return descricao;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
