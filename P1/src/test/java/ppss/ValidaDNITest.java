/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
public class ValidaDNITest {
    String nif;
    boolean resultadoReal, resultadoEsperado;
    ValidaDNI vdni = new ValidaDNI();

    @Test
    public void testValidaDNIT1() { // camino azul
        nif = "4823";
        resultadoEsperado = false;
        resultadoReal = vdni.validaNif(nif);
        assertEquals(resultadoEsperado, resultadoReal);
    }
    
    @Test
    public void testValidaDNIT2() { // camino azul
        nif = "12345678D";
        resultadoEsperado = false;
        resultadoReal = vdni.validaNif(nif);
        assertEquals(resultadoEsperado, resultadoReal);
    }
    
    @Test
    public void testValidaDNIT3() { // camino azul
        nif = "48298767D";
        resultadoEsperado = true;
        resultadoReal = vdni.validaNif(nif);
        assertEquals(resultadoEsperado, resultadoReal);
    }
    
    @Test
    public void testValidaDNIT4() { // camino azul
        nif = "4829876DD";
        resultadoEsperado = false;
        resultadoReal = vdni.validaNif(nif);
        assertEquals(resultadoEsperado, resultadoReal);
    }
    
    @Test
    public void testValidaDNIT5() { // camino azul
        nif = "-12345678";
        resultadoEsperado = false;
        resultadoReal = vdni.validaNif(nif);
        assertEquals(resultadoEsperado, resultadoReal);
    }
    
    @Test
    public void testValidaDNIT6() { // camino azul
        nif = "d12456378";
        resultadoEsperado = false;
        resultadoReal = vdni.validaNif(nif);
        assertEquals(resultadoEsperado, resultadoReal);
    }
}