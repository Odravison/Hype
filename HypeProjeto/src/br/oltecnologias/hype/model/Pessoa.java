package br.oltecnologias.hype.model;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pessoa implements Serializable {
        
        private String nome;
        
        public Pessoa(String nome){
            this.nome = nome;
        }
        
        public Pessoa(){
            
        }
        
        public String getNome(){
            return this.nome;
        }
        
        public void setNome(String nome){
            this.nome = nome;
        }

	public abstract String getDescricao();

}
