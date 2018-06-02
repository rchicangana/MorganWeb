/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.servicios;

import co.com.javeriana.morganmarketservices.dto.LoginInDTO;
import co.com.javeriana.morganmarketservices.dto.LoginOutDTO;
import co.com.javeriana.morganmarketservices.logica.AutenticacionLogica;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rchic
 */
@Stateless
@Path("autenticacion")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AutenticacionServicio {
    
    @EJB
    private AutenticacionLogica autenticacionLogica;
    
    @POST
    @Path("autenticar")
    public LoginOutDTO autenticar(LoginInDTO entrada){
        return autenticacionLogica.autenticar(entrada);
    }
    
}
