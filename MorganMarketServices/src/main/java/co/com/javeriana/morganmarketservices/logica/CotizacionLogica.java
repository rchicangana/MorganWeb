/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.logica;

import co.com.javeriana.morganmarketservices.comun.ConstantesComunes;
import co.com.javeriana.morganmarketservices.dao.CotizacionDAO;
import co.com.javeriana.morganmarketservices.dto.CotizacionDTO;
import co.com.javeriana.morganmarketservices.dto.MensajeDTO;
import co.com.javeriana.morganmarketservices.entities.Cotizacion;
import co.com.javeriana.morganmarketservices.util.TransformacionDozer;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rchic
 */
@Stateless
public class CotizacionLogica {
    
    @EJB
    private CotizacionDAO cotizacionDAO;
    
    public List<CotizacionDTO> consultar(Long idSolicitud, Long idCliente){
        return TransformacionDozer.transformar(cotizacionDAO.findAllbySolicitud(idSolicitud), CotizacionDTO.class);
    }
    
    
    public MensajeDTO recibirCotizacion(CotizacionDTO cotizacionDTO){
        MensajeDTO salida = new MensajeDTO();
        try {
            Cotizacion cotizacion = TransformacionDozer.transformar(cotizacionDTO, Cotizacion.class);
            cotizacionDAO.insert(cotizacion);
            salida.setCodigo(ConstantesComunes.CodigoMensaje.OK.name());
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoMensaje.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        return salida;
    }
}
