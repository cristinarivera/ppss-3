/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio1;

import java.io.IOException;
import org.easymock.EasyMock;
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
public class GestorLlamadasMockTest {
    
    public GestorLlamadasMockTest() {
    }
    
    double resultadoEsperado;
    double resultadoReal;
        
    @Test
    public void TestCalculaConsumoC1() throws IOException
    {
        Calendario mock = EasyMock.createMock(Calendario.class);
        TestableGestorLlamadas tgl = new TestableGestorLlamadas();
        EasyMock.expect(mock.getHoraActual()).andReturn(15);
        tgl.setCalendario(mock);
        EasyMock.replay(mock);
        resultadoReal = tgl.calculaConsumo(10);
        resultadoEsperado = 208;
        assertEquals(resultadoReal, resultadoEsperado, 0.001f);
        EasyMock.verify(mock);
    }
    
    @Test
    public void TestCalculaConsumoC2() throws IOException
    {
        Calendario mock = EasyMock.createMock(Calendario.class);
        TestableGestorLlamadas tgl = new TestableGestorLlamadas();
        EasyMock.expect(mock.getHoraActual()).andReturn(22);
        tgl.setCalendario(mock);
        EasyMock.replay(mock);
        resultadoReal = tgl.calculaConsumo(10);
        resultadoEsperado = 105;
        assertEquals(resultadoReal, resultadoEsperado, 0.001f);
        EasyMock.verify(mock);
    }
}
