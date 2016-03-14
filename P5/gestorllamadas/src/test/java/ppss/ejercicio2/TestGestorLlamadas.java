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
        minutos = 10;
        resultadoEsperado = 208.0;
        setHoraActual(15);
        resultadoReal = gl.calculaConsumo(minutos);
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
        
    }
    @Test
    public void TestCalculaConsumoC2() {
        minutos = 10;
        resultadoEsperado = 105.0;
        setHoraActual(22);
        resultadoReal = gl.calculaConsumo(minutos);
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }
}
