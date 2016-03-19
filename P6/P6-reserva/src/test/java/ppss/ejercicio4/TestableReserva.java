/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio4;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
class TestableReserva extends Reserva {
    private boolean c;
    @Override
    public boolean compruebaPermisos(String login, String password, Usuario tipoUsu) {
        return c;
    }
    public void setCompruebaPermisos(boolean c){
        this.c = c;
    }
}
