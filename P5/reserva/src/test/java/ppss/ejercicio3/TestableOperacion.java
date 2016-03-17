/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio3;

import ppss.ejercicio3.excepciones.IsbnInvalidoException;
import ppss.ejercicio3.excepciones.JDBCException;
import ppss.ejercicio3.excepciones.SocioInvalidoException;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
public class TestableOperacion implements IOperacionBO {
     private String excepcion;
     
     @Override
     public void operacionReserva(String socio, String isbn) 
            throws IsbnInvalidoException, JDBCException, SocioInvalidoException{
         if (excepcion != null) switch (excepcion) {
             case "isbn":
                 throw new IsbnInvalidoException(isbn);         
             case "jdbc":
                 throw new JDBCException(socio);
             case "socio":
                 throw new SocioInvalidoException(socio);
             default:
                 break;
         }
    }
     
    public void setOperacion(String s){
        excepcion = s;
    }
}
