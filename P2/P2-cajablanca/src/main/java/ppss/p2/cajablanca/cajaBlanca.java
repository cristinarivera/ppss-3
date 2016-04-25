/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.p2.cajablanca;

import java.util.ArrayList;

/**
 *
 * @author ppss
 */
public class cajaBlanca {
 
    public void realizaReserva(String login, String password, String socio, String [] isbns) throws Exception {
        ArrayList<String> errores = new ArrayList<String>();
        if(!compruebaPermisos(login, password, Usuario.BIBLIOTECARIO)) {
            errores.add("ERROR de permisos");
        } else {
            FactoriaBOs fd = FactoriaBOs.getInstance();
            IOperacionBO io = fd.getOperacionBO();
            try {
                for(String isbn: isbns) {
                    try {
                        io.realizaReserva(socio, isbn);
                    } catch (IsbnInvalidoException iie) {
                        errores.add("ISBN invalido" + ":" + isbn);
                    }
                }
            } catch (SocioInvalidoException sie) {
                errores.add("SOCIO invalido");
            } catch (JDBCException je) {
                errores.add("CONEXION invalida");
            }
        }
        if (errores.size() > 0) {
            String mensajeError = "";
            for(String error: errores) {
                mensajeError += error + "; ";
            }
            throw new ReservaException(mensajeError);
        }
    }

    private boolean compruebaPermisos(String login, String password, String BIBLIOTECARIO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
