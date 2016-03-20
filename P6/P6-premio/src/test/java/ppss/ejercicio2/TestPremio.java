/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio2;

import org.easymock.EasyMock;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
public class TestPremio {
    private String resultadoEsperado, resultadoReal;
    Premio mockPremio;
    ClienteWebService mockCliente;
    public TestPremio() {
    }
    
    @Test
    public void TestPremioC1() throws ClienteWebServiceException {
        mockCliente = EasyMock.createMock(ClienteWebService.class);
        mockPremio = EasyMock.createMockBuilder(Premio.class).addMockedMethod("generaNumero").createMock();
        mockPremio.cliente = mockCliente;
        EasyMock.expect(mockCliente.obtenerPremio()).andReturn("pez de goma");
        EasyMock.expect(mockPremio.generaNumero()).andReturn(0.01f);
        EasyMock.replay(mockCliente);
        EasyMock.replay(mockPremio);
        resultadoEsperado = "Premiado con pez de goma";
        resultadoReal = mockPremio.compruebaPremio();
        assertEquals(resultadoEsperado, resultadoReal);
        EasyMock.verify(mockCliente);
    }
    @Test
    public void TestPremioC2() throws ClienteWebServiceException {
        mockCliente = EasyMock.createMock(ClienteWebService.class);
        mockPremio = EasyMock.createMockBuilder(Premio.class).addMockedMethod("generaNumero").createMock();
        mockPremio.cliente = mockCliente;
        EasyMock.expect(mockCliente.obtenerPremio()).andThrow(new ClienteWebServiceException());
        EasyMock.replay(mockCliente);
        resultadoEsperado = "Premiado";
        resultadoReal = mockPremio.compruebaPremio();
        assertEquals(resultadoEsperado, resultadoReal);
        EasyMock.verify(mockCliente);
    }
}
