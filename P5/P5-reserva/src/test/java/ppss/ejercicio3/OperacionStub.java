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
public class OperacionStub extends Operacion {
     private String excepcion;
     
     @Override
     public void operacionReserva(String socio, String isbn) 
            throws IsbnInvalidoException, JDBCException, SocioInvalidoException{
         
         if (excepcion != null) switch (excepcion) {
             case "isbn":
                 throw new IsbnInvalidoException();         
             case "jdbc":
                 throw new JDBCException();
             case "socio":
                 throw new SocioInvalidoException();
             default:
                 break;
         }
    }
     
    public void setException(String s){
        excepcion = s;
    }
}
