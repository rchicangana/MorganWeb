/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.logica;

import co.com.javeriana.morganmarketservices.dao.ProveedorDAO;
import co.com.javeriana.morganmarketservices.dao.SolicitudDAO;
import co.com.javeriana.morganmarketservices.dto.MensajeDTO;
import co.com.javeriana.morganmarketservices.dto.SolicitudDTO;
import co.com.javeriana.morganmarketservices.entities.Proveedor;
import co.com.javeriana.morganmarketservices.entities.Solicitud;
import co.com.javeriana.morganmarketservices.util.TransformacionDozer;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
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
public class IntegracionLogica {

    @EJB
    private ProveedorDAO proveedorDAO;
    @EJB
    private SolicitudDAO solicitudDAO;

    @Asynchronous
    public void generarEventos(Long idSolicitud) {
        try {
            Solicitud solicitud = solicitudDAO.findByID(idSolicitud.intValue());
            SolicitudDTO solicitudDTO = TransformacionDozer.transformar(solicitud, SolicitudDTO.class);
            List<Proveedor> proveedores = proveedorDAO.findAllProveeedorBySolicitud(idSolicitud);
            for (Proveedor proveedore : proveedores) {
                final Client client;
                final WebTarget target;
                client = ClientBuilder.newClient();
                target = client.target(proveedore.getEndpointCot());
                final Invocation.Builder requestBuilder = target.request();
                final Response resp = requestBuilder.post(Entity.json(solicitudDTO));
                resp.readEntity(MensajeDTO.class);
            }
        } catch (Exception e) {
            Logger.getLogger(IntegracionLogica.class.getName()).log(Level.SEVERE, "Error en envio del evento", e);
        }

    }

}
