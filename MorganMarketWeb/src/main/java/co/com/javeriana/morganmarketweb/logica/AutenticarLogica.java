/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketweb.logica;

import co.com.javeriana.morganmarketweb.comun.ConstantesComunes;
import co.com.javeriana.morganmarketweb.dto.LoginDTO;
import co.com.javeriana.morganmarketweb.dto.LoginOutDTO;
import com.google.gson.Gson;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 *
 * @author rchic
 */
@Stateless
public class AutenticarLogica {
    
    private static final String URL_AUTENTICACION = "http://busServicios.com:8080/MorganMarketServices/services/autenticacion/autenticar";
    
    public LoginOutDTO autenticar(LoginDTO entrada, HttpServletRequest request) {
        LoginOutDTO salida = new LoginOutDTO();
        try {
            final Client client;
            final WebTarget target;
            client = ClientBuilder.newClient();
            target = client.target(URL_AUTENTICACION);
            
            final Invocation.Builder requestBuilder = target.request();
            final Response resp = requestBuilder.post(Entity.json(entrada));
            salida = resp.readEntity(LoginOutDTO.class);
            
        } catch (Exception e) {
            salida.setCodigo("ERROR");
            salida.setMensaje(e.getLocalizedMessage());
        }
        
        if("OK".equals(salida.getCodigo())){
            request.getSession().setAttribute(ConstantesComunes.SESSION_USUARIO, salida);
        }
        return salida;
    }
    
    public void logout(HttpServletRequest request) {
        request.getSession().removeAttribute(ConstantesComunes.SESSION_USUARIO);
    }
}
