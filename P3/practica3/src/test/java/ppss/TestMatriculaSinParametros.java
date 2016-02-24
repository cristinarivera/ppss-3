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
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author ppss
 */
public class TestMatriculaSinParametros {
    
    int edad;
    boolean familiaNumerosa;
    boolean repetidor;
    float resultadoReal, resultadoEsperado;
    Matricula mat= new Matricula();
    
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
        //resultadoReal = mat.calculaTasaMatricula(edad,familiaNumerosa,repetidor);        
        //assertEquals(resultadoEsperado, resultadoReal, 0.002f);
    }
    
    @Test
    public void testC1() {
        edad = 20;
        familiaNumerosa = false;
        repetidor = true;
        resultadoEsperado = 2000.00f;
    
        resultadoReal = mat.calculaTasaMatricula(edad,familiaNumerosa,repetidor);
        //el tercer parámetro del método Assert.assertEquals es necesario si estamos comparando "floats"
        //en este caso el método devuelve cierto si:
        //resultadoEsperado = resultadoReal +/- 0.002
        assertEquals(resultadoEsperado, resultadoReal, 0.002f);
    }
    
    @Test
    public void testC2() {
        edad = 70;
        familiaNumerosa = false;
        repetidor = true;
        resultadoEsperado = 250.00f;
        resultadoReal = mat.calculaTasaMatricula(edad,familiaNumerosa,repetidor);
        assertEquals(resultadoEsperado, resultadoReal, 0.002f);
    }
    
    @Test
    public void testC3() { 
        edad = 20;
        familiaNumerosa = true;
        repetidor = true;
        resultadoEsperado = 250.00f;
        resultadoReal = mat.calculaTasaMatricula(edad,familiaNumerosa,repetidor);
        assertEquals(resultadoEsperado, resultadoReal, 0.002f);
    }
    
    @Test
    public void testC4() {
        edad = 20;
        familiaNumerosa = false;
        repetidor = false;
        resultadoEsperado = 500.00f;
        resultadoReal = mat.calculaTasaMatricula(edad,familiaNumerosa,repetidor);
        assertEquals(resultadoEsperado, resultadoReal, 0.002f);
    }
    
    @Test
    public void testC5() {
        edad = 60;
        familiaNumerosa = false;
        repetidor = true;
        resultadoEsperado = 400.00f;
        resultadoReal = mat.calculaTasaMatricula(edad,familiaNumerosa,repetidor);
        assertEquals(resultadoEsperado, resultadoReal, 0.002f);
    }
    
}
