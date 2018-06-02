/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.logica;

import co.com.javeriana.morganmarketservices.dto.LoginOutDTO;
import co.com.runt.generadorjwt.ClienteJWT;
import co.com.runt.generadorjwt.dto.TokenJwtDTO;
import co.com.runt.generadorjwt.exception.ErrorJWTException;
import co.com.runt.generadorjwt.impl.ClienteJWTBuilder;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author rchic
 */
@Stateless
public class SecurityLogica {
    
    private final static String LLAVE_SIMETRICA = "e09713e6-35e1-11e8-b467-0ed5f89f718b";
    
    public void generarJWT(LoginOutDTO entrada){
        
        try {
            ClienteJWTBuilder clienteBuilder = new ClienteJWTBuilder();
            TokenJwtDTO token = new TokenJwtDTO();
            token.setId(UUID.randomUUID().toString());
            token.setAudience("Aui");
            token.setExpiration(604800L);
            token.setIssuedAt(new Date());
            token.setIssuer("Iusser");
            token.setNotBefore(new Date());
            token.setSubject(entrada.getNombre());
            token.setUsername(entrada.getIdUsuario().toString());
            
            ClienteJWT cliente = clienteBuilder.setLlaveSimetrica(LLAVE_SIMETRICA)
                    .setToken(token)
                    .build();
            String tokenGen = cliente.generarToken();
            entrada.setTokenJWT(tokenGen);
        } catch (ErrorJWTException ex) {
            Logger.getLogger(SecurityLogica.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    public LoginOutDTO validarToken(String token){
        try {
            ClienteJWTBuilder clienteBuilder = new ClienteJWTBuilder();
            ClienteJWT cliente = clienteBuilder.setLlaveSimetrica(LLAVE_SIMETRICA).build();
            TokenJwtDTO leido = cliente.validarToken(token, LLAVE_SIMETRICA);
            LoginOutDTO salida = new LoginOutDTO();
            salida.setIdUsuario(Integer.valueOf(leido.getUsername()));
            salida.setNombre(leido.getSubject());
            return salida;
        } catch (ErrorJWTException ex) {
            Logger.getLogger(SecurityLogica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
