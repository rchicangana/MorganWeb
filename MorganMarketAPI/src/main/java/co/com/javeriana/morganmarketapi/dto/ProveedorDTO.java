/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketapi.dto;

/**
 *
 * @author rchic
 */
public class ProveedorDTO {
    
    private Integer id;
    private String nombre;
    private String tipoId;
    private String noIdentificacion;
    private String direccion;
    private String telefono;
    private String email;
    private String pais;
    private String ciudad;
    private String endpointCot;
    private String endpointOc;

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
    
    
    
}
