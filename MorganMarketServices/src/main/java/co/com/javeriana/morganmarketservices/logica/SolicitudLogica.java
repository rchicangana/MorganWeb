/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.logica;

import co.com.javeriana.morganmarketservices.comun.ConstantesComunes;
import co.com.javeriana.morganmarketservices.dao.ClienteDAO;
import co.com.javeriana.morganmarketservices.dao.SolicitudDAO;
import co.com.javeriana.morganmarketservices.dto.MensajeDTO;
import co.com.javeriana.morganmarketservices.dto.SolicitudDTO;
import co.com.javeriana.morganmarketservices.entities.Solicitud;
import co.com.javeriana.morganmarketservices.util.TransformacionDozer;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rchic
 */
@Stateless
public class SolicitudLogica {
    
    @EJB
    private SolicitudDAO solicitudDAO;
    @EJB
    private ClienteDAO clienteDAO;
    @EJB
    private IntegracionLogica integracionLogica;
    
    public List<SolicitudDTO> consultarSolicitudes(Integer idCliente) {
        return TransformacionDozer.transformar(solicitudDAO.findByCliente(idCliente), SolicitudDTO.class);
    }
    
    public SolicitudDTO registrarSolicitud(SolicitudDTO entrada, Integer idCliente) {
        SolicitudDTO salida = new SolicitudDTO();
        try {
            Solicitud solicitud = TransformacionDozer.transformar(entrada, Solicitud.class);
            solicitud.setIdCliente(clienteDAO.findById(idCliente));
            solicitud.setFecha(new Date());
            
            solicitudDAO.insert(solicitud);           
            salida = TransformacionDozer.transformar(solicitud, SolicitudDTO.class);
            salida.setCodigo(ConstantesComunes.CodigoMensaje.OK.name());
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoMensaje.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        return salida;
        
    }
    
    public MensajeDTO radicarSolicitud(Integer idSolicitud){
        MensajeDTO salida = new MensajeDTO();
        salida.setCodigo(ConstantesComunes.CodigoMensaje.OK.name());
        integracionLogica.generarEventos(idSolicitud.longValue());
        return salida;
    }
    
}
