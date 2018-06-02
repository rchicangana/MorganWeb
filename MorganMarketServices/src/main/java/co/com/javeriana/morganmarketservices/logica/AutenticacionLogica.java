/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.logica;

import co.com.javeriana.morganmarketservices.comun.ConstantesComunes;
import co.com.javeriana.morganmarketservices.dao.UsuarioDAO;
import co.com.javeriana.morganmarketservices.dto.LoginInDTO;
import co.com.javeriana.morganmarketservices.dto.LoginOutDTO;
import co.com.javeriana.morganmarketservices.entities.Usuario;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rchic
 */
@Stateless
public class AutenticacionLogica {
    
    @EJB
    private UsuarioDAO usuarioDAO;
    @EJB
    private SecurityLogica securityLogica;
    
    
    public LoginOutDTO autenticar(LoginInDTO entrada){
        LoginOutDTO salida = new LoginOutDTO();
        try {
            //Consultamos el usuario
            Usuario usuario = usuarioDAO.findByLogin(entrada.getUsuario(), entrada.getPassword());
            if(usuario!=null){
                if(ConstantesComunes.TIPO_CLIENTE.equals(entrada.getTipo())){
                    if(usuario.getCliente()==null){
                        salida.setCodigo(ConstantesComunes.CodigoMensaje.ERROR.name());
                        salida.setMensaje(ConstantesComunes.ERROR_AUTENTICACION);
                    } else {
                        salida.setCodigo(ConstantesComunes.CodigoMensaje.OK.name());
                        salida.setIdUsuario(usuario.getCliente().getId());
                        salida.setNombre(usuario.getCliente().getNombres());
                    }
                } else {
                    if(usuario.getProveedor()==null){
                        salida.setCodigo(ConstantesComunes.CodigoMensaje.ERROR.name());
                        salida.setMensaje(ConstantesComunes.ERROR_AUTENTICACION);
                    } else {
                        salida.setCodigo(ConstantesComunes.CodigoMensaje.OK.name());
                        salida.setIdUsuario(usuario.getProveedor().getId());
                        salida.setNombre(usuario.getProveedor().getNombre());
                    }
                }
            } else {
                salida.setCodigo(ConstantesComunes.CodigoMensaje.ERROR.name());
                salida.setMensaje(ConstantesComunes.ERROR_AUTENTICACION);
            }
            
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoMensaje.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        
        if(ConstantesComunes.CodigoMensaje.OK.name().equals(salida.getCodigo())){
            //generamos el JWT
            securityLogica.generarJWT(salida);
        }
        
        return salida;
    }
    
}
