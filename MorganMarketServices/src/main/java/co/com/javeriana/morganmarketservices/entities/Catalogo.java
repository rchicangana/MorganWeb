/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "catalogo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalogo.findAll", query = "SELECT c FROM Catalogo c")
    , @NamedQuery(name = "Catalogo.findById", query = "SELECT c FROM Catalogo c WHERE c.id = :id")
    , @NamedQuery(name = "Catalogo.findByNombre", query = "SELECT c FROM Catalogo c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Catalogo.findByDescripcion", query = "SELECT c FROM Catalogo c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Catalogo.findByTipo", query = "SELECT c FROM Catalogo c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "Catalogo.findByEstado", query = "SELECT c FROM Catalogo c WHERE c.estado = :estado")})
public class Catalogo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 1)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCatalogo")
    private List<CatalogoProveedor> catalogoProveedorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCatalogo")
    private List<DetalleSolicitud> detalleSolicitudList;

    public Catalogo() {
    }

    public Catalogo(Integer id) {
        this.id = id;
    }

    public Catalogo(Integer id, String nombre, String descripcion, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<CatalogoProveedor> getCatalogoProveedorList() {
        return catalogoProveedorList;
    }

    public void setCatalogoProveedorList(List<CatalogoProveedor> catalogoProveedorList) {
        this.catalogoProveedorList = catalogoProveedorList;
    }

    @XmlTransient
    public List<DetalleSolicitud> getDetalleSolicitudList() {
        return detalleSolicitudList;
    }

    public void setDetalleSolicitudList(List<DetalleSolicitud> detalleSolicitudList) {
        this.detalleSolicitudList = detalleSolicitudList;
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
        if (!(object instanceof Catalogo)) {
            return false;
        }
        Catalogo other = (Catalogo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.javeriana.morganmarketservices.entities.Catalogo[ id=" + id + " ]";
    }
    
}
