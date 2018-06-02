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
public class DetalleCotizacionDTO {
    
    private Integer id;
    private BigDecimal valorUnitario;
    private BigDecimal valorImpuestos;
    private BigDecimal valorTotal;
    private CatalogoProveedorDTO idCatalogoProv;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorImpuestos() {
        return valorImpuestos;
    }

    public void setValorImpuestos(BigDecimal valorImpuestos) {
        this.valorImpuestos = valorImpuestos;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public CatalogoProveedorDTO getIdCatalogoProv() {
        return idCatalogoProv;
    }

    public void setIdCatalogoProv(CatalogoProveedorDTO idCatalogoProv) {
        this.idCatalogoProv = idCatalogoProv;
    }
    
    
    
    
}
