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
