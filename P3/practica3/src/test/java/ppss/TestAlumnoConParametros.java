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
import org.junit.experimental.categories.Category;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
@RunWith(Parameterized.class)
@Category(TestConParametros.class)
public class TestAlumnoConParametros {
    
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
    
    @Parameterized.Parameters(name="Caso C{index}: validaNif({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"4823", false},
            {"12345678D", false},
            {"48298767D", true},
            {"4829876DD", false},
            {"-12345678", false},
            {"d12456378", false}
        });
    
    }
    
    String nif;
    boolean resultadoReal, resultadoEsperado;
    Alumno alu = new Alumno();
    
    public TestAlumnoConParametros(String nif, boolean resultadoEsperado){
        this.resultadoEsperado = resultadoEsperado;
        this.nif = nif;
    }
    
    @Test
    public void testvalidaNif() { 
        resultadoReal = alu.validaNif(nif);
        assertEquals(resultadoEsperado, resultadoReal);
    }
       
}
