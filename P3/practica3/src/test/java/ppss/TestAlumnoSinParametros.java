/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
@Category(TestSinParametros.class)
public class TestAlumnoSinParametros {
    
    public TestAlumnoSinParametros() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    String nif;
    boolean resultadoReal, resultadoEsperado;
    Alumno alu = new Alumno();

    @Test
    public void testValidaDNIT1() { // camino azul
        nif = "4823";
        resultadoEsperado = false;
        resultadoReal = alu.validaNif(nif);
        assertEquals(resultadoEsperado, resultadoReal);
    }
    
    @Test
    public void testValidaDNIT2() { // camino azul
        nif = "12345678D";
        resultadoEsperado = false;
        resultadoReal = alu.validaNif(nif);
        assertEquals(resultadoEsperado, resultadoReal);
    }
    
    @Test
    public void testValidaDNIT3() { // camino azul
        nif = "48298767D";
        resultadoEsperado = true;
        resultadoReal = alu.validaNif(nif);
        assertEquals(resultadoEsperado, resultadoReal);
    }
    
    @Test
    public void testValidaDNIT4() { // camino azul
        nif = "4829876DD";
        resultadoEsperado = false;
        resultadoReal = alu.validaNif(nif);
        assertEquals(resultadoEsperado, resultadoReal);
    }
    
    @Test
    public void testValidaDNIT5() { // camino azul
        nif = "-12345678";
        resultadoEsperado = false;
        resultadoReal = alu.validaNif(nif);
        assertEquals(resultadoEsperado, resultadoReal);
    }
    
    @Test
    public void testValidaDNIT6() { // camino azul
        nif = "d12456378";
        resultadoEsperado = false;
        resultadoReal = alu.validaNif(nif);
        assertEquals(resultadoEsperado, resultadoReal);
    }
}
