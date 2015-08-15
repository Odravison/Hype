package br.oltecnologias.hype.model;

public abstract class Pessoa {

	private String nome;
        
        public String getNome(){
            return this.nome;
        }

	public abstract String getDescricao();

}
