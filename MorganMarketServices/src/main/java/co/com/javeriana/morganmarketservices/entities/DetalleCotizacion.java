/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rchic
 */
@Entity
@Table(name = "detalle_cotizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCotizacion.findAll", query = "SELECT d FROM DetalleCotizacion d")
    , @NamedQuery(name = "DetalleCotizacion.findById", query = "SELECT d FROM DetalleCotizacion d WHERE d.id = :id")
    , @NamedQuery(name = "DetalleCotizacion.findByValorUnitario", query = "SELECT d FROM DetalleCotizacion d WHERE d.valorUnitario = :valorUnitario")
    , @NamedQuery(name = "DetalleCotizacion.findByValorImpuestos", query = "SELECT d FROM DetalleCotizacion d WHERE d.valorImpuestos = :valorImpuestos")
    , @NamedQuery(name = "DetalleCotizacion.findByValorTotal", query = "SELECT d FROM DetalleCotizacion d WHERE d.valorTotal = :valorTotal")})
public class DetalleCotizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_unitario")
    private BigDecimal valorUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_impuestos")
    private BigDecimal valorImpuestos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @JoinColumn(name = "id_catalogo_prov", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CatalogoProveedor idCatalogoProv;
    @JoinColumn(name = "id_cotizacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cotizacion idCotizacion;

    public DetalleCotizacion() {
    }

    public DetalleCotizacion(Integer id) {
        this.id = id;
    }

    public DetalleCotizacion(Integer id, BigDecimal valorUnitario, BigDecimal valorImpuestos, BigDecimal valorTotal) {
        this.id = id;
        this.valorUnitario = valorUnitario;
        this.valorImpuestos = valorImpuestos;
        this.valorTotal = valorTotal;
    }

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

    public CatalogoProveedor getIdCatalogoProv() {
        return idCatalogoProv;
    }

    public void setIdCatalogoProv(CatalogoProveedor idCatalogoProv) {
        this.idCatalogoProv = idCatalogoProv;
    }

    public Cotizacion getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(Cotizacion idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCotizacion)) {
            return false;
        }
        DetalleCotizacion other = (DetalleCotizacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.javeriana.morganmarketservices.entities.DetalleCotizacion[ id=" + id + " ]";
    }
    
}
