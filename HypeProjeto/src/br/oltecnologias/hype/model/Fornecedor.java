/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Odravison
 */

@Entity
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private String cnpj;
    
    @OneToOne(cascade = {CascadeType.ALL})
    private Endereco endereco;
    
    private String telefone;
    
    public Fornecedor() {

    }
    
    public Fornecedor(String cnpj, Endereco end, String telefone){
        this.cnpj = cnpj;
        this.endereco = end;
        this.telefone = telefone;
    }

    public String getId() {
        return cnpj;
    }

    public void setId(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cnpj != null ? cnpj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.cnpj == null && other.cnpj != null) || (this.cnpj != null && !this.cnpj.equals(other.cnpj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.oltecnologias.hype.model.Fornecedor[ cnpj=" + cnpj + " ]";
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
