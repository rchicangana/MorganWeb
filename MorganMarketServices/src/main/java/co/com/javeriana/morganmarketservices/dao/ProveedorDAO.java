/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.dao;

import co.com.javeriana.morganmarketservices.entities.Proveedor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchic
 */
@Stateless
public class ProveedorDAO {

    @PersistenceContext
    private EntityManager em;

    private static final String SQL_NATIVO_PROVEEDORESXSOLICITUD = "select distinct p.* \n"
            + "from proveedor p\n"
            + "inner join catalogo_proveedor cp on cp.id_proveedor = p.id\n"
            + "inner join catalogo c on c.id = cp.id_catalogo\n"
            + "inner join detalle_solicitud ds on ds.id_catalogo = c.id\n"
            + "where ds.id_solicitud = ?";

    public List<Proveedor> findAllProveeedorBySolicitud(Long idSolicitud){
        return em.createNativeQuery(SQL_NATIVO_PROVEEDORESXSOLICITUD, Proveedor.class)
                .setParameter(1, idSolicitud)
                .getResultList(); 
    }
    
}
