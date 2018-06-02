/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.servicios;

import co.com.javeriana.morganmarketservices.dto.MensajeDTO;
import co.com.javeriana.morganmarketservices.dto.SolicitudDTO;
import co.com.javeriana.morganmarketservices.logica.SolicitudLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rchic
 */
@Stateless
@Path("solicitud")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SolicitudServicio {
    
    @EJB
    private SolicitudLogica solicitudLogica;
    
    @GET
    @Path("consultar/{idCliente}")
    public List<SolicitudDTO> consultar(@PathParam("idCliente") Integer idCliente){
        return solicitudLogica.consultarSolicitudes(idCliente);
    }
    
    @POST
    @Path("registrar/{idCliente}")
    public SolicitudDTO registrar(SolicitudDTO entrada, @PathParam("idCliente") Integer idCliente){
        return solicitudLogica.registrarSolicitud(entrada, idCliente);
    }
    
    @POST
    @Path("radicar/{idSolicitud}")
    public MensajeDTO radicar(@PathParam("idSolicitud") Integer idSolicitud){
        return solicitudLogica.radicarSolicitud(idSolicitud);
    }
}
    
