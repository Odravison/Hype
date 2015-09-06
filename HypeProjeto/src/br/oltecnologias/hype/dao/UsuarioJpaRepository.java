/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.dao;

import br.oltecnologias.hype.exception.UsuarioExistenteException;
import br.oltecnologias.hype.exception.UsuarioInexistenteException;
import br.oltecnologias.hype.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Odravison
 */
public class UsuarioJpaRepository implements UsuarioRepository{
    
    private EntityManagerFactory emf = null;

    public UsuarioJpaRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(Usuario usuario) throws UsuarioExistenteException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            if (existsUsuario(usuario.getNickName())) {
                throw new UsuarioExistenteException("Usuário com NickName: " + usuario.getNickName() + " já foi cadastrado");
            }

            em.persist(usuario);
            em.getTransaction().commit();

        } catch (UsuarioExistenteException e) {
            System.out.println(e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Usuario findByNickName(String nickName) throws UsuarioInexistenteException {
        EntityManager em = null;
        try {
            em = getEntityManager();

            if (!existsUsuario(nickName)) {
                throw new UsuarioInexistenteException("Usuário com NickName: " + nickName + " não foi cadastrado!");
            }

            return em.find(Usuario.class, nickName);

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public boolean existsUsuario(String nickName) {
        Object result = null;
        EntityManager em = null;

        try {
            em = getEntityManager();
            Query query = em.createQuery("SELECT 1 FROM Usuario WHERE nickName = ?");
            query.setParameter(1, nickName);
            query.setMaxResults(1);

            result = query.getSingleResult();
        } catch (NoResultException e) {
            result = null;
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return (result != null);
    }

    @Override
    public void removerUsuario(String nickName) throws UsuarioInexistenteException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            Usuario u = em.getReference(Usuario.class, nickName);
            
            em.merge(u);
            
            em.remove(u);
            
            em.getTransaction().commit();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void editarUsuario(Usuario usuario) throws UsuarioInexistenteException {
        EntityManager em = null;
        Usuario u = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            
            if (!existsUsuario(usuario.getNickName())){
                throw new UsuarioInexistenteException("O usuário com nick: " + usuario.getNickName() + " não se encontra cadastrado!");
            }

            u = em.getReference(Usuario.class, usuario.getNickName());
            u.setIsAdministrador(usuario.isAdministrador());
            u.setNickName(usuario.getNickName());
            u.setNome(usuario.getNome());
            u.setSenha(usuario.getSenha());
            
            em.merge(u);

            em.getTransaction().commit();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    @Override
    public List<Usuario> getAllUsuarios() {
        EntityManager em = null;
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT c FROM Usuario c");
            usuarios = q.getResultList();

        } finally {
            if (em != null) {
                em.close();
            }
        }

        return usuarios;
    }
    
    @Override
    public boolean validarUsuario(String login, String senha) throws UsuarioInexistenteException {
        EntityManager em = null;

        try {
            em = getEntityManager();
            
            Usuario result = findByNickName(login);
            
            if (result.getNickName().equals(login) && result.getSenha().equals(senha)){
                return true;
            }
            
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return false;
    }
    
    @Override
    public boolean isAdministrador(String login) throws UsuarioInexistenteException {
        EntityManager em = null;

        try {
            em = getEntityManager();
            
            Usuario result = findByNickName(login);
            
            if (result.isAdministrador()){
                return true;
            }
            
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return false;
    }    
}
