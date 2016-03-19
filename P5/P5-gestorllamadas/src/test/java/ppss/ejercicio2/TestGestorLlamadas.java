/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio2;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 *
 * @author ppss
 */
public class TestGestorLlamadas extends Calendario {
    double resultadoEsperado;
    double resultadoReal;
    int minutos;
    
    @Test
    public void TestCalculaConsumoC1() {
        minutos = 10;
        resultadoEsperado = 208.0;
        TestableGestorLlamadas tgl = new TestableGestorLlamadas();
        tgl.getCalendario().setHoraActual(15);
        resultadoReal = tgl.calculaConsumo(minutos);
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
        
    }
    @Test
    public void TestCalculaConsumoC2() {
        minutos = 10;
        resultadoEsperado = 105.0;
        TestableGestorLlamadas tgl = new TestableGestorLlamadas();
        tgl.getCalendario().setHoraActual(22);
        resultadoReal = tgl.calculaConsumo(minutos);
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }
}
