/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.util;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author rchic
 */
@javax.ws.rs.ApplicationPath("services")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.com.javeriana.morganmarketservices.integracion.IntegracionServicio.class);
        resources.add(co.com.javeriana.morganmarketservices.servicios.AutenticacionServicio.class);
        resources.add(co.com.javeriana.morganmarketservices.servicios.CatalogoServicio.class);
        resources.add(co.com.javeriana.morganmarketservices.servicios.CotizacionServicio.class);
        resources.add(co.com.javeriana.morganmarketservices.servicios.SolicitudServicio.class);
        resources.add(co.com.javeriana.morganmarketservices.util.GsonMessageBodyHandler.class);
    }
    
}
