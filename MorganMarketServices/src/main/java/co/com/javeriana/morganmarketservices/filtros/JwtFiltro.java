package co.com.javeriana.morganmarketservices.filtros;

import co.com.javeriana.morganmarketservices.comun.ConstantesComunes;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import co.com.runt.generadorjwt.ClienteJWT;
import co.com.runt.generadorjwt.exception.ErrorJWTException;
import co.com.runt.generadorjwt.impl.ClienteJWTBuilder;
import javax.ejb.EJB;

/**
 * Filtro JWT para los ws HelpDesk
 *
 * @author ccepeda
 *
 */
@WebFilter(filterName = "filtroJWT", urlPatterns = {"/services/*"})
public class JwtFiltro implements Filter {

    
    private final static Logger LOGGER = Logger.getLogger(JwtFiltro.class.getName());
    private final static String PRUEBAS = "N";
    private final static String LLAVE_SIMETRICA = "e09713e6-35e1-11e8-b467-0ed5f89f718b";
    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String authorizationHeader = (String) ((HttpServletRequest) request).getHeader("authorization");

        String token = getToken((HttpServletRequest) request, (HttpServletResponse) response);
        if (token == null) {
            return;
        }

        // Se recupera la info del usuario de moviliza y el id de la autoridad a
        // la que pertenece
        String idUsuario = ((HttpServletRequest) request).getHeader(ConstantesComunes.HEADER_USUARIO);

        if (idUsuario == null || "".equals(idUsuario)) {
            new AutorizacionException("NO_SE_ENCUENTRA_ID_USUARIO", (HttpServletResponse) response);
            return;
        }

        try {

            
                ClienteJWT clienteJWT = new ClienteJWTBuilder().setLlaveSimetrica(LLAVE_SIMETRICA).build();
                clienteJWT.validarToken(token, LLAVE_SIMETRICA);
                chain.doFilter(request, response);
            
        } catch (ErrorJWTException | IOException | ServletException e) {
            LOGGER.log(Level.SEVERE, "====JWT ERROR => {0}", e);

            new AutorizacionException(Response.Status.UNAUTHORIZED.getStatusCode(),
                    "NO AUTORIZADO E:" + e.getLocalizedMessage(),
                    (HttpServletResponse) response);
            return;
        }

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

    /**
     * Permite obtener el token del request
     *
     * @param httpRequest Peticion Http
     * @param response Respuesta Http
     * @return Token
     * @throws ServletException
     */
    private String getToken(HttpServletRequest httpRequest, HttpServletResponse response) throws ServletException {
        String token = null;
        final String authorizationHeader = httpRequest.getHeader("authorization");
        if (authorizationHeader == null) {
            new AutorizacionException(Response.Status.UNAUTHORIZED.getStatusCode(),
                    "JWT_NO_HEADER", response);
            return null;
        }

        String[] parts = authorizationHeader.split(" ");
        if (parts.length != 2) {
            new AutorizacionException(Response.Status.UNAUTHORIZED.getStatusCode(),
                    "JWT_NO_BEARER", response);
            return null;
        }

        String scheme = parts[0];
        String credentials = parts[1];

        Pattern pattern = Pattern.compile("^Bearer$", Pattern.CASE_INSENSITIVE);
        if (pattern.matcher(scheme).matches()) {
            token = credentials;
        }
        return token;
    }

}
