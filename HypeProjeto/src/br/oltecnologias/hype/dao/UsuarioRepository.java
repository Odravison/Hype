/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.exception.UsuarioExistenteException;
import br.oltecnologias.hype.exception.UsuarioInexistenteException;
import br.oltecnologias.hype.model.Usuario;
import java.util.List;

/**
 *
 * @author Odravison
 */
public interface UsuarioRepository {
    
    public void create(Usuario usuario) throws UsuarioExistenteException;
    
    public Usuario findByNickName(String nickName) throws UsuarioInexistenteException;
    
    public boolean existsUsuario(String nickName);
    
    public void removerUsuario(String nickName)throws UsuarioInexistenteException;
    
    public void editarUsuario(Usuario usuario) throws UsuarioInexistenteException;
    
    public List<Usuario> getAllUsuarios();
    
    public boolean validarUsuario(String login, String senha) throws UsuarioInexistenteException;
    
    public boolean isAdministrador(String login) throws UsuarioInexistenteException;
    
}
