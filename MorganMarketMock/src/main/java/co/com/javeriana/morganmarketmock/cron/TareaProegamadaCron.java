/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketmock.cron;

import co.com.javeriana.morganmarketapi.dto.CatalogoProveedorDTO;
import co.com.javeriana.morganmarketapi.dto.CotizacionDTO;
import co.com.javeriana.morganmarketapi.dto.DetalleCotizacionDTO;
import co.com.javeriana.morganmarketapi.dto.ProveedorDTO;
import co.com.javeriana.morganmarketapi.dto.SolicitudDTO;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Schedule;
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
public class TareaProegamadaCron {

    private final static String URL = "http://35.185.43.106:8080/MorganMarketServices/services/integracion/cotizar";
    
    @Schedule(hour = "*", minute = "30", second = "0")
    public void notificarCotizacion() {
        CotizacionDTO cotizacion = new CotizacionDTO();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();      
        String reportDate = df.format(today);
        Calendar fecha = Calendar.getInstance();
        fecha.add(Calendar.DAY_OF_YEAR, 2);
        Date tomorrow = fecha.getTime();  
        String fechEntrega = df.format(tomorrow);
        cotizacion.setFecha(reportDate);
        cotizacion.setFechaEstimadaEntrega(fechEntrega);
        ProveedorDTO proveedor = new ProveedorDTO();
        proveedor.setId(1);
        cotizacion.setIdProveedor(proveedor);
        SolicitudDTO solicitud = new SolicitudDTO();
        solicitud.setId(1);
        cotizacion.setIdSolicitud(solicitud);
        List<DetalleCotizacionDTO> detalleCotizacionDTOs = new ArrayList<>();
        DetalleCotizacionDTO detalle = new DetalleCotizacionDTO();
        CatalogoProveedorDTO catalogo = new CatalogoProveedorDTO();
        catalogo.setId(1);
        detalle.setIdCatalogoProv(catalogo);
        detalle.setValorImpuestos(new BigDecimal("10000"));
        detalle.setValorTotal(new BigDecimal("30000"));
        detalle.setValorUnitario(new BigDecimal("20000"));
        detalleCotizacionDTOs.add(detalle);
        cotizacion.setDetalleCotizacionList(detalleCotizacionDTOs);
        final Client client;
        final WebTarget target;
        client = ClientBuilder.newClient();
        target = client.target(URL);
        final Invocation.Builder requestBuilder = target.request();
        final Response resp = requestBuilder.post(Entity.json(cotizacion));
        String respuesta = resp.readEntity(String.class);
        Logger.getLogger(TareaProegamadaCron.class.getName()).log(Level.INFO, respuesta);

    }

}
