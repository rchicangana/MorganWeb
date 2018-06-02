/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.dao;

import co.com.javeriana.morganmarketservices.entities.Usuario;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchic
 */
@Stateless
public class UsuarioDAO {
    
    private static final Logger LOG = Logger.getLogger(UsuarioDAO.class.getName());
    
    @PersistenceContext
    private EntityManager em;
    
    public Usuario findByLogin(String login, String password){
        try {
            return (Usuario)em.createNamedQuery("Usuario.findByLogin")
                .setParameter("username", login)
                .setParameter("password", password)
                .getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {
            LOG.info("Usuario o Password Invalido");
        }
        return null;
        
    }
    
}
