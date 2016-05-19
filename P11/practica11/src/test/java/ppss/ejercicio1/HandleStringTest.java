/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
public class HandleStringTest {
    
    public HandleStringTest() {
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

    @Test
    public void C1MultiPathTest() {
        MultiPathExample mpe = new MultiPathExample();
        int resultadoReal = mpe.multiPath(6, 6, 0);
        int resultadoEsperado = 12;
        assertEquals(resultadoEsperado, resultadoReal);
    }
    @Test
    public void C2MultiPathTest() {
        MultiPathExample mpe = new MultiPathExample();
        int resultadoReal = mpe.multiPath(4, 4, 0);
        int resultadoEsperado = 0;
        assertEquals(resultadoEsperado, resultadoReal);
    }
}
