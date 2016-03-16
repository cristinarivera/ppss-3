/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio2;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
public class TestableCalendario extends Calendario{
    private int hora; 
    @Override
    public int getHoraActual() {
        return hora;
    }
    public void setHoraActual(int h){
        this.hora = h;
    }
}
