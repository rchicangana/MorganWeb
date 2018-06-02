/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rchic
 */
@Entity
@Table(name = "catalogo_proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoProveedor.findAll", query = "SELECT c FROM CatalogoProveedor c")
    , @NamedQuery(name = "CatalogoProveedor.findById", query = "SELECT c FROM CatalogoProveedor c WHERE c.id = :id")
    , @NamedQuery(name = "CatalogoProveedor.findByDescripcion", query = "SELECT c FROM CatalogoProveedor c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "CatalogoProveedor.findByPrecio", query = "SELECT c FROM CatalogoProveedor c WHERE c.precio = :precio")
    , @NamedQuery(name = "CatalogoProveedor.findByIdProveedorproducto", query = "SELECT c FROM CatalogoProveedor c WHERE c.idProveedorproducto = :idProveedorproducto")})
public class CatalogoProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private BigDecimal precio;
    @Size(max = 50)
    @Column(name = "id_proveedorproducto")
    private String idProveedorproducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCatalogoProv")
    private List<DetalleCotizacion> detalleCotizacionList;
    @JoinColumn(name = "id_catalogo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Catalogo idCatalogo;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Proveedor idProveedor;

    public CatalogoProveedor() {
    }

    public CatalogoProveedor(Integer id) {
        this.id = id;
    }

    public CatalogoProveedor(Integer id, String descripcion, BigDecimal precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
    }

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

    public String getIdProveedorproducto() {
        return idProveedorproducto;
    }

    public void setIdProveedorproducto(String idProveedorproducto) {
        this.idProveedorproducto = idProveedorproducto;
    }

    @XmlTransient
    public List<DetalleCotizacion> getDetalleCotizacionList() {
        return detalleCotizacionList;
    }

    public void setDetalleCotizacionList(List<DetalleCotizacion> detalleCotizacionList) {
        this.detalleCotizacionList = detalleCotizacionList;
    }

    public Catalogo getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(Catalogo idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
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
        if (!(object instanceof CatalogoProveedor)) {
            return false;
        }
        CatalogoProveedor other = (CatalogoProveedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.javeriana.morganmarketservices.entities.CatalogoProveedor[ id=" + id + " ]";
    }
    
}
