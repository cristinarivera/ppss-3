/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio1;

import java.io.IOException;
import static org.easymock.EasyMock.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ppss
 */
public class GestorLlamadasPartialMockTest {
    
    double resultadoEsperado;
    double resultadoReal;
    
    public GestorLlamadasPartialMockTest() {
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
    public void TestCalculaConsumoC1() throws IOException
    {
        GestorLlamadas gl = createMockBuilder(GestorLlamadas.class).addMockedMethods("getCalendario").createMock();
        Calendario cal = createMockBuilder(Calendario.class).addMockedMethods("getHoraActual").createMock();
        expect(gl.getCalendario()).andReturn(cal);
        expect(cal.getHoraActual()).andReturn(15);
        replay(gl);
        replay(cal);
        resultadoReal = gl.calculaConsumo(10);
        resultadoEsperado = 208;
        assertEquals(resultadoReal, resultadoEsperado, 0.001f);
        verify(gl);
        verify(cal);
    }
    
    @Test
    public void TestCalculaConsumoC2() throws IOException
    {
        GestorLlamadas gl = createMockBuilder(GestorLlamadas.class).addMockedMethods("getCalendario").createMock();
        Calendario cal = createMockBuilder(Calendario.class).addMockedMethods("getHoraActual").createMock();
        expect(gl.getCalendario()).andReturn(cal);
        expect(cal.getHoraActual()).andReturn(22);
        replay(gl);
        replay(cal);
        resultadoReal = gl.calculaConsumo(10);
        resultadoEsperado = 105;
        assertEquals(resultadoReal, resultadoEsperado, 0.001f);
        verify(gl);
        verify(cal);
    }
}
