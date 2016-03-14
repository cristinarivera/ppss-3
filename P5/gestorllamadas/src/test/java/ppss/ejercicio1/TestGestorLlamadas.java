/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio1;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 *
 * @author ppss
 */
public class TestGestorLlamadas extends GestorLlamadas{
    double resultadoEsperado;
    double resultadoReal;
    int minutos;
    GestorLlamadas gl = new GestorLlamadas();
    private int hora; 
    @Override
    public int getHoraActual() {
        return hora;
    }
    public void setHoraActual(int h){
        this.hora = h;
    }
    @Test
    public void TestCalculaConsumoC1() {
        System.out.println("Test C1");
        minutos = 10;
        resultadoEsperado = 208.0;
        setHoraActual(15);
        System.out.println("hora: " + getHoraActual());
        resultadoReal = gl.calculaConsumo(minutos);
        System.out.println("resultadoReal: " + resultadoReal);
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
        
    }
    @Test
    public void TestCalculaConsumoC2() {
        System.out.println("Test C2");
        minutos = 10;
        resultadoEsperado = 105.0;
        setHoraActual(22);
        System.out.println("hora: " + getHoraActual());
        resultadoReal = gl.calculaConsumo(minutos);
        System.out.println("resultadoReal: " + resultadoReal);
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }
}
