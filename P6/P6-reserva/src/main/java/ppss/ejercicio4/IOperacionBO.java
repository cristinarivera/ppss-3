/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio4;

import ppss.ejercicio4.excepciones.JDBCException;
import ppss.ejercicio4.excepciones.IsbnInvalidoException;
import ppss.ejercicio4.excepciones.SocioInvalidoException;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
public interface IOperacionBO {
    public void operacionReserva(String socio, String isbn) 
            throws IsbnInvalidoException, JDBCException, SocioInvalidoException;
}
