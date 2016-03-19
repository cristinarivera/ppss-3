/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio3;

import java.net.MalformedURLException;
import java.net.URL;
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
public class WebClientMockTest {
    private String resultadoEsperado, resultadoReal;
    public WebClientMockTest() {
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
    public void TestGetContentC1() throws MalformedURLException {
        URL url = new URL("http://www.ua.es");
        StringBuilder sbMock = EasyMock.createMockBuilder(StringBuilder.class).addMockedMethod("toString").createMock();
        EasyMock.expect(sbMock.toString()).andReturn("Funciona");
        StringBuilderFactoria sbf = new StringBuilderFactoria();
        sbf.setStringBuilder(sbMock);
        EasyMock.replay(sbMock);
        WebClient webc = new WebClient();
        resultadoEsperado = "Funciona";
        resultadoReal = webc.getContent(url);
        assertEquals(resultadoEsperado, resultadoReal);
        EasyMock.verify(sbMock);
    }
}
