/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketweb.servicios;


import co.com.javeriana.morganmarketweb.dto.LoginDTO;
import co.com.javeriana.morganmarketweb.dto.LoginOutDTO;
import co.com.javeriana.morganmarketweb.logica.AutenticarLogica;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rchic
 */
@Path("autenticar")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class AutenticacionServicio {
    
    @Context
    private HttpServletRequest request;
    
    @EJB
    private AutenticarLogica autenticacionLogica;
    
    
    @POST
    public LoginOutDTO autenticar(LoginDTO entrada){
       return autenticacionLogica.autenticar(entrada, request);
    }
    
    @DELETE
    public void logout(){
        autenticacionLogica.logout(request);
    }
    
}
