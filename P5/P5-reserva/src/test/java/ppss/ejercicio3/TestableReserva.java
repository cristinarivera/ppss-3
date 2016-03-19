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
public class TestableReserva extends Reserva {
    private boolean comprobaciones;
    @Override
    public boolean compruebaPermisos(String login, String password, Usuario tipoUsu) {
        return comprobaciones;
    }
    public void setCompruebaPermisos(boolean c){
        comprobaciones = c;
    }
}
