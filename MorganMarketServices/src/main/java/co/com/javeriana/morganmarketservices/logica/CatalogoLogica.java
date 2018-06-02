/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketservices.logica;

import co.com.javeriana.morganmarketservices.dao.CatalogoDAO;
import co.com.javeriana.morganmarketservices.dto.CatalogoDTO;
import co.com.javeriana.morganmarketservices.util.TransformacionDozer;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rchic
 */
@Stateless
public class CatalogoLogica {
    
    @EJB
    private CatalogoDAO catalogoDAO;
    
    
    public List<CatalogoDTO> consultar(){
        return TransformacionDozer.transformar(catalogoDAO.findAll(), CatalogoDTO.class);
    }
    
}
