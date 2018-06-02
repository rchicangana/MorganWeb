/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketapi.dto;

import java.util.List;

/**
 *
 * @author rchic
 */
public class SolicitudDTO extends MensajeDTO{
    
    private Integer id;
    private String fecha;
    private String estado;
    private List<CotizacionDTO> cotizacionList;
    private ClienteDTO idCliente;
    private List<DetalleSolicitudDTO> detalleSolicitudList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<CotizacionDTO> getCotizacionList() {
        return cotizacionList;
    }

    public void setCotizacionList(List<CotizacionDTO> cotizacionList) {
        this.cotizacionList = cotizacionList;
    }

    public ClienteDTO getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(ClienteDTO idCliente) {
        this.idCliente = idCliente;
    }

    public List<DetalleSolicitudDTO> getDetalleSolicitudList() {
        return detalleSolicitudList;
    }

    public void setDetalleSolicitudList(List<DetalleSolicitudDTO> detalleSolicitudList) {
        this.detalleSolicitudList = detalleSolicitudList;
    }
    
    
    
}
