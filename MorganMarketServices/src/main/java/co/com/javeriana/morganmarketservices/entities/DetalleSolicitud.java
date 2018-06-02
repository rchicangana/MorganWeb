/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.entities;

import java.io.Serializable;
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
@Table(name = "detalle_solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleSolicitud.findAll", query = "SELECT d FROM DetalleSolicitud d")
    , @NamedQuery(name = "DetalleSolicitud.findById", query = "SELECT d FROM DetalleSolicitud d WHERE d.id = :id")
    , @NamedQuery(name = "DetalleSolicitud.findByCantidad", query = "SELECT d FROM DetalleSolicitud d WHERE d.cantidad = :cantidad")})
public class DetalleSolicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "id_catalogo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Catalogo idCatalogo;
    @JoinColumn(name = "id_solicitud", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Solicitud idSolicitud;

    public DetalleSolicitud() {
    }

    public DetalleSolicitud(Integer id) {
        this.id = id;
    }

    public DetalleSolicitud(Integer id, int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

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

    public Catalogo getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(Catalogo idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public Solicitud getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Solicitud idSolicitud) {
        this.idSolicitud = idSolicitud;
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
        if (!(object instanceof DetalleSolicitud)) {
            return false;
        }
        DetalleSolicitud other = (DetalleSolicitud) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.javeriana.morganmarketservices.entities.DetalleSolicitud[ id=" + id + " ]";
    }
    
}
