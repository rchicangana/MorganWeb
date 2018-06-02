/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.dto;

import java.util.List;

/**
 *
 * @author rchic
 */
public class CotizacionDTO {
    
    private Integer id;
    private String fecha;
    private String fechaEstimadaEntrega;
    private List<DetalleCotizacionDTO> detalleCotizacionList;
    private ProveedorDTO idProveedor;
    private SolicitudDTO idSolicitud;

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

    public String getFechaEstimadaEntrega() {
        return fechaEstimadaEntrega;
    }

    public void setFechaEstimadaEntrega(String fechaEstimadaEntrega) {
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
    }

    public List<DetalleCotizacionDTO> getDetalleCotizacionList() {
        return detalleCotizacionList;
    }

    public void setDetalleCotizacionList(List<DetalleCotizacionDTO> detalleCotizacionList) {
        this.detalleCotizacionList = detalleCotizacionList;
    }

    public ProveedorDTO getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(ProveedorDTO idProveedor) {
        this.idProveedor = idProveedor;
    }

    public SolicitudDTO getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(SolicitudDTO idSolicitud) {
        this.idSolicitud = idSolicitud;
    }
    
    
    
}
