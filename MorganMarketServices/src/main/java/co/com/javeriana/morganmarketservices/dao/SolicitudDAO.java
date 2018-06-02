/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.dao;

import co.com.javeriana.morganmarketservices.entities.Solicitud;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchic
 */
@Stateless
public class SolicitudDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Solicitud> findByCliente(Integer idCliente){
        return em.createNamedQuery("Solicitud.findByCliente")
                .setParameter("idCliente", idCliente)
                .getResultList();
    }
    
    public Solicitud findByID(Integer id){
        return em.find(Solicitud.class, id);
    }
    
    
    public Solicitud insert(Solicitud entidad){
        em.persist(entidad);
        return entidad;
    }
    
    public void update(Solicitud entidad){
        em.merge(entidad);
    }
    
    
}
