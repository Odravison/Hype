/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.exception.UsuarioExistenteException;
import br.oltecnologias.hype.exception.UsuarioInexistenteException;
import br.oltecnologias.hype.model.Usuario;

/**
 *
 * @author Odravison
 */
public interface UsuarioRepository {
    
    public void create(Usuario usuario) throws UsuarioExistenteException;
    
    public Usuario findById(long id) throws UsuarioInexistenteException;
    
    public boolean existsUsuario(long id);
    
    public void removerUsuario(Usuario usuario)throws UsuarioInexistenteException;
    
    public void editarUsuario(Usuario usuario) throws UsuarioInexistenteException;
    
}
