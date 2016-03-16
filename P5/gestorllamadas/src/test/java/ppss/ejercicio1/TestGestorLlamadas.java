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
    TestableGestorLlamadas tgl = new TestableGestorLlamadas();
    
    @Test
    public void TestCalculaConsumoC1() {
        System.out.println("Test C1");
        minutos = 10;
        resultadoEsperado = 208.0;
        tgl.setHoraActual(15);
        System.out.println("hora: " + getHoraActual());
        resultadoReal = tgl.calculaConsumo(minutos);
        System.out.println("resultadoReal: " + resultadoReal);
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
        
    }
    @Test
    public void TestCalculaConsumoC2() {
        System.out.println("Test C2");
        minutos = 10;
        resultadoEsperado = 105.0;
        tgl.setHoraActual(22);
        System.out.println("hora: " + getHoraActual());
        resultadoReal = tgl.calculaConsumo(minutos);
        System.out.println("resultadoReal: " + resultadoReal);
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }
}
