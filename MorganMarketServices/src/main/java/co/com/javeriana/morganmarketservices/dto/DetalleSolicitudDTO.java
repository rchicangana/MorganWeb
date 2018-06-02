/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.dto;

/**
 *
 * @author rchic
 */
public class DetalleSolicitudDTO {
    
    private Integer id;
    private int cantidad;
    private CatalogoDTO idCatalogo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public CatalogoDTO getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(CatalogoDTO idCatalogo) {
        this.idCatalogo = idCatalogo;
    }
    
    
    
}
