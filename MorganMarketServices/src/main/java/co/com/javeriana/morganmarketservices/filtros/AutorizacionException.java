package co.com.javeriana.morganmarketservices.filtros;


import co.com.javeriana.morganmarketservices.dto.MensajeDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;




/**
 *
 * @author ccepeda
 *
 */
public class AutorizacionException {

    private static final int CODIGO_ERROR = 400;

    private static final Logger LOG = Logger.getLogger(AutorizacionException.class.getSimpleName());

    public AutorizacionException(final String mensaje, final HttpServletResponse response) {
        PrintWriter pw = null;
        try {
            response.setStatus(CODIGO_ERROR);
            response.setContentType(MediaType.APPLICATION_JSON);
            pw = response.getWriter();
            pw.print(new Gson().toJson(crearMensaje(mensaje, String.valueOf(CODIGO_ERROR))));
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }

    }

    public AutorizacionException(final int codigoError, final String mensaje, final HttpServletResponse response) {
        PrintWriter pw = null;
        try {
            response.setStatus(codigoError);
            response.setContentType(MediaType.APPLICATION_JSON);
            pw = response.getWriter();
            pw.print(new Gson().toJson(crearMensaje(mensaje, String.valueOf(codigoError))));

        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }

    }

    public static MensajeDTO crearMensaje(final String mensaje, final String codigo) {
        final MensajeDTO msg = new MensajeDTO();
        msg.setCodigo(codigo);
        msg.setMensaje(mensaje);
        return msg;
    }

}
