package br.oltecnologias.hype.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa", schema = "anotacoes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "tipo_pessoa",
        discriminatorType = DiscriminatorType.INTEGER
)
@DiscriminatorValue("0")
public abstract class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_pessoa")
    private int id;

    private String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa() {

    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract String getDescricao();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
