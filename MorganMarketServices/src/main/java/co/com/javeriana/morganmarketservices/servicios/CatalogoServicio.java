/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.servicios;

import co.com.javeriana.morganmarketservices.dto.CatalogoDTO;
import co.com.javeriana.morganmarketservices.logica.CatalogoLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rchic
 */
@Stateless
@Path("catalogo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CatalogoServicio {
    
    @EJB
    private CatalogoLogica catalogoLogica;
    
    @GET
    public List<CatalogoDTO> consultar(){
        return catalogoLogica.consultar();
    }
    
}
