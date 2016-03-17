/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio3;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
public class IOperacionFactoria {
    private static Operacion operacion = null;
    public static Operacion create(){
        if (operacion!=null) return operacion;
        else return new Operacion();
    }
    public void setOperacion(Operacion op){
        operacion = op;
    }
}
