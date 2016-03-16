/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio1;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
public class TestableGestorLlamadas extends GestorLlamadas{
    private Calendario cal;
    @Override
    public Calendario getCalendario() {
        return cal;
    }
    public void setCalendario(Calendario c){
        this.cal = c;
    }
}
