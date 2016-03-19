/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio2;

import org.easymock.EasyMock;
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
public class TestPremio {
    private String resultadoEsperado, resultadoReal;
    public TestPremio() {
    }
    
    @Test
    public void TestPremioC1() throws ClienteWebServiceException {
        TestablePremio premio = new TestablePremio();
        ClienteWebService mockCliente = EasyMock.createMock(ClienteWebService.class);
        EasyMock.expect(mockCliente.obtenerPremio()).andReturn("pez de goma");
        premio.setNumero(0.01f);
        premio.setCliente(mockCliente);
        EasyMock.replay(mockCliente);
        resultadoEsperado = "Premiado con pez de goma";
        resultadoReal = premio.compruebaPremio();
        assertEquals(resultadoEsperado, resultadoReal);
        EasyMock.verify(mockCliente);
    }
    @Test
    public void TestPremioC2() throws ClienteWebServiceException {
        TestablePremio premio = new TestablePremio();
        ClienteWebService mockCliente = EasyMock.createMock(ClienteWebService.class);
        EasyMock.expect(mockCliente.obtenerPremio()).andThrow(new ClienteWebServiceException());
        premio.setNumero(0.01f);
        premio.setCliente(mockCliente);
        EasyMock.replay(mockCliente);
        resultadoEsperado = "Premiado";
        resultadoReal = premio.compruebaPremio();
        assertEquals(resultadoEsperado, resultadoReal);
        EasyMock.verify(mockCliente);
    }
}
