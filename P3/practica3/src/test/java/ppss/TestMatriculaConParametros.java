/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss;

import java.util.Arrays;
import java.util.Collection;
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
@RunWith(Parameterized.class)
public class TestMatriculaConParametros {
    @Parameterized.Parameters(name = "Caso C{index}: calculaTasaMatricula({0}, {1}, {2}) = {3}")
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
            {20, false, true, 2000},
            {70, false, true, 250},
            {20, true, true, 250},
            {20, false, false, 500},
            {60, false, true, 400}
        });
    }
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
    }

    public TestMatriculaConParametros(int edad, boolean familiaNumerosa, boolean repetidor, float resultadoEsperado){
        this.edad = edad;
        this.familiaNumerosa = familiaNumerosa;
        this.repetidor = repetidor;
        this.resultadoEsperado = resultadoEsperado;
    }
    @Test
    public void testMatricula() {
        
        resultadoReal = mat.calculaTasaMatricula(edad,familiaNumerosa,repetidor);
        //el tercer parámetro del método Assert.assertEquals es necesario si estamos comparando "floats"
        //en este caso el método devuelve cierto si:
        //resultadoEsperado = resultadoReal +/- 0.002
        assertEquals(resultadoEsperado, resultadoReal, 0.002f);
    }
    
}
