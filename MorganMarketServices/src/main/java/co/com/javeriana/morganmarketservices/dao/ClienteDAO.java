/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.dao;

import co.com.javeriana.morganmarketservices.entities.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author rchic
 */
@Stateless
public class ClienteDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public Cliente findById(Integer id){
        return em.find(Cliente.class, id);
    }
    
}
