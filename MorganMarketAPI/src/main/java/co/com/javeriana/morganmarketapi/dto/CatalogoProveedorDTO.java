/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketapi.dto;

import java.math.BigDecimal;

/**
 *
 * @author rchic
 */
public class CatalogoProveedorDTO {
    
    private Integer id;
    private String descripcion;
    private BigDecimal precio;
    private CatalogoDTO idCatalogo;
    private ProveedorDTO idProveedor;
    private String idProveedorProducto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public CatalogoDTO getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(CatalogoDTO idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public ProveedorDTO getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(ProveedorDTO idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getIdProveedorProducto() {
        return idProveedorProducto;
    }

    public void setIdProveedorProducto(String idProveedorProducto) {
        this.idProveedorProducto = idProveedorProducto;
    }
    
    
    
}
