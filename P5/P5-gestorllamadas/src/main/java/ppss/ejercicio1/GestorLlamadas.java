/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio1;
import java.util.Calendar;

/**
 *
 * @author Cristina Rivera Baydal
 */
public class GestorLlamadas {
    static double TARIFA_NOCTURNA=10.5;
    static double TARIFA_DIURNA=20.8;
    
    public int getHoraActual() {
        Calendar c = Calendar.getInstance();
        int hora = c.get(Calendar.HOUR);
        return hora;
    }

    public double calculaConsumo(int minutos) {
        int hora = getHoraActual();
        System.out.println("hora en el método: " + hora);
        if(hora < 8 || hora > 20) {
            return minutos * TARIFA_NOCTURNA;
        } else {
            return minutos * TARIFA_DIURNA;
        }
    }
}