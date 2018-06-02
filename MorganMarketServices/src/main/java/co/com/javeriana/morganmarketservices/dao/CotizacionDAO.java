/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.dao;

import co.com.javeriana.morganmarketservices.entities.Cotizacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchic
 */
@Stateless
public class CotizacionDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Cotizacion> findAllbySolicitud(Long idSolicitud){
        return em.createNamedQuery("Cotizacion.findAllBySolicitud")
                .setParameter("idSolicitud", idSolicitud)
                .getResultList();
    }
    
    public Cotizacion insert(Cotizacion entidad){
        em.persist(entidad);
        return entidad;
    }
    
}
