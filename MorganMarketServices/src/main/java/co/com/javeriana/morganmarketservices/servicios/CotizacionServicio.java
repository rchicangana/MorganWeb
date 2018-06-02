/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.servicios;

import co.com.javeriana.morganmarketservices.dto.CotizacionDTO;
import co.com.javeriana.morganmarketservices.logica.CotizacionLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rchic
 */
@Stateless
@Path("cotizacion")   
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CotizacionServicio {
    
    @EJB
    private CotizacionLogica cotizacionLogica;
    
    
    
    @GET
    @Path("consultar/{idSolicitud}")
    public List<CotizacionDTO> consultar(@PathParam("idSolicitud") Long idSolicitud){
        return cotizacionLogica.consultar(idSolicitud, 0L) ;
    }
    
}
