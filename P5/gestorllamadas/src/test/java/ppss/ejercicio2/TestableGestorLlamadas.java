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
public class TestableGestorLlamadas extends GestorLlamadas{
    TestableCalendario c = new TestableCalendario();
    @Override
    public TestableCalendario getCalendario() {
        return c;
    }
}
