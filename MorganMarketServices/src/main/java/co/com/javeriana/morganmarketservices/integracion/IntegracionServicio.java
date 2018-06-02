/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.integracion;

import co.com.javeriana.morganmarketservices.dto.CotizacionDTO;
import co.com.javeriana.morganmarketservices.dto.MensajeDTO;
import co.com.javeriana.morganmarketservices.logica.CotizacionLogica;
import co.com.javeriana.morganmarketservices.logica.IntegracionLogica;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rchic
 */
@Stateless
@Path("integracion")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IntegracionServicio {
    
    
    @EJB
    private CotizacionLogica cotizacionLogica;
    
    @Path("cotizar")
    public MensajeDTO recibirCotizacion(CotizacionDTO cotizacion){
        return cotizacionLogica.recibirCotizacion(cotizacion);
    }
    
    
    
}
