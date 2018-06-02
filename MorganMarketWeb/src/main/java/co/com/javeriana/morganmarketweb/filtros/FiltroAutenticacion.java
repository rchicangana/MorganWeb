/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.morganmarketweb.filtros;


import co.com.javeriana.morganmarketweb.comun.ConstantesComunes;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dospina
 */
@WebFilter(filterName = "Autenticacion", urlPatterns = {"/index.html"})
public class FiltroAutenticacion implements Filter {

    /**
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    private static final String PRUEBAS = "N";
    
    private static final Logger LOG = Logger.getLogger(FiltroAutenticacion.class.getSimpleName());

    /**
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        LOG.log(Level.INFO,"============= FiltroAutenticacion ============");
        if ("S".compareTo(PRUEBAS) == 0) {
            ((HttpServletRequest)request).getSession().setAttribute(ConstantesComunes.SESSION_USUARIO, "79615114");
        }
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            if (req.getSession().getAttribute(ConstantesComunes.SESSION_USUARIO) == null) {
                ((HttpServletResponse) response).sendRedirect("./login.html");

            } else {
                LOG.log(Level.INFO,"============= FiltroAutenticacion === Usuario [{0}] ",req.getSession().getAttribute(ConstantesComunes.SESSION_USUARIO));
            }

        } catch (IOException e) {
            ((HttpServletResponse) response).sendRedirect("#/login");
        }

        chain.doFilter(request, response);
    }

    /**
     *
     */
    @Override
    public void destroy() {

    }

}
