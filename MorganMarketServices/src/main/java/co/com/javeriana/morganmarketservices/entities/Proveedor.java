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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")
    , @NamedQuery(name = "Proveedor.findById", query = "SELECT p FROM Proveedor p WHERE p.id = :id")
    , @NamedQuery(name = "Proveedor.findByNombre", query = "SELECT p FROM Proveedor p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proveedor.findByTipoId", query = "SELECT p FROM Proveedor p WHERE p.tipoId = :tipoId")
    , @NamedQuery(name = "Proveedor.findByNoIdentificacion", query = "SELECT p FROM Proveedor p WHERE p.noIdentificacion = :noIdentificacion")
    , @NamedQuery(name = "Proveedor.findByDireccion", query = "SELECT p FROM Proveedor p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Proveedor.findByTelefono", query = "SELECT p FROM Proveedor p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Proveedor.findByEmail", query = "SELECT p FROM Proveedor p WHERE p.email = :email")
    , @NamedQuery(name = "Proveedor.findByPais", query = "SELECT p FROM Proveedor p WHERE p.pais = :pais")
    , @NamedQuery(name = "Proveedor.findByCiudad", query = "SELECT p FROM Proveedor p WHERE p.ciudad = :ciudad")
    , @NamedQuery(name = "Proveedor.findByEndpointCot", query = "SELECT p FROM Proveedor p WHERE p.endpointCot = :endpointCot")
    , @NamedQuery(name = "Proveedor.findByEndpointOc", query = "SELECT p FROM Proveedor p WHERE p.endpointOc = :endpointOc")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "tipo_id")
    private String tipoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "no_identificacion")
    private String noIdentificacion;
    @Size(max = 40)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 10)
    @Column(name = "telefono")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ciudad")
    private String ciudad;
    @Size(max = 250)
    @Column(name = "endpoint_cot")
    private String endpointCot;
    @Size(max = 200)
    @Column(name = "endpoint_oc")
    private String endpointOc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProveedor")
    private List<Cotizacion> cotizacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProveedor")
    private List<CatalogoProveedor> catalogoProveedorList;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @OneToOne
    private Usuario idUsuario;

    public Proveedor() {
    }

    public Proveedor(Integer id) {
        this.id = id;
    }

    public Proveedor(Integer id, String nombre, String tipoId, String noIdentificacion, String pais, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.tipoId = tipoId;
        this.noIdentificacion = noIdentificacion;
        this.pais = pais;
        this.ciudad = ciudad;
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

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getNoIdentificacion() {
        return noIdentificacion;
    }

    public void setNoIdentificacion(String noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEndpointCot() {
        return endpointCot;
    }

    public void setEndpointCot(String endpointCot) {
        this.endpointCot = endpointCot;
    }

    public String getEndpointOc() {
        return endpointOc;
    }

    public void setEndpointOc(String endpointOc) {
        this.endpointOc = endpointOc;
    }

    @XmlTransient
    public List<Cotizacion> getCotizacionList() {
        return cotizacionList;
    }

    public void setCotizacionList(List<Cotizacion> cotizacionList) {
        this.cotizacionList = cotizacionList;
    }

    @XmlTransient
    public List<CatalogoProveedor> getCatalogoProveedorList() {
        return catalogoProveedorList;
    }

    public void setCatalogoProveedorList(List<CatalogoProveedor> catalogoProveedorList) {
        this.catalogoProveedorList = catalogoProveedorList;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.javeriana.morganmarketservices.entities.Proveedor[ id=" + id + " ]";
    }
    
}
