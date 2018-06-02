/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.dao;

import co.com.javeriana.morganmarketservices.entities.Catalogo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchic
 */
@Stateless
public class CatalogoDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    
    public List<Catalogo> findAll(){
        return em.createNamedQuery("Catalogo.findAll")
                .getResultList();
    }
    
}
