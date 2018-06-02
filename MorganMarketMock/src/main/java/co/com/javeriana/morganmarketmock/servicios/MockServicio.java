/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketmock.servicios;


import co.com.javeriana.morganmarketapi.dto.MensajeDTO;
import co.com.javeriana.morganmarketapi.dto.SolicitudDTO;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rchic
 */
@Path("proveedor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MockServicio {
    
    
    @POST
    @Path("suscripcion")
    public MensajeDTO escucharEventos(SolicitudDTO solicitudDTO){
        MensajeDTO salida = new MensajeDTO();
        salida.setCodigo("OK");
        return salida;
    }
    
    
    
    
    
    
}
