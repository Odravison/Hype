/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.exception;

/**
 *
 * @author Odravison
 */
public class ClienteInexistenteException extends Exception {
    public ClienteInexistenteException (String msg){
        super(msg);
    }
}
