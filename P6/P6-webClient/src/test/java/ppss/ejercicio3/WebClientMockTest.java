/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio3;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.easymock.EasyMock;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
public class WebClientMockTest {
    private String resultadoEsperado, resultadoReal;
    HttpURLConnection mockHttpURLConnection;
    WebClient mockWebClient;
    URL url;
    public WebClientMockTest() {
    }
    
    @Before
    public void setUp() throws MalformedURLException {        
        url = new URL("http://www.ua.es");
        mockWebClient = EasyMock.createMockBuilder(WebClient.class).addMockedMethod("createHttpURLConnection").createMock();
        mockHttpURLConnection = EasyMock.createMock(HttpURLConnection.class);
    }

    @Test
    public void GetContentTestC1() throws IOException {
        EasyMock.expect(mockWebClient.createHttpURLConnection(url)).andReturn(mockHttpURLConnection);        
        InputStream t = new ByteArrayInputStream("Funciona".getBytes());
        EasyMock.expect(mockHttpURLConnection.getInputStream()).andReturn(t);
        EasyMock.replay(mockHttpURLConnection);
        EasyMock.replay(mockWebClient);
        resultadoEsperado = "Funciona";
        resultadoReal = mockWebClient.getContent(url);
        assertEquals(resultadoEsperado, resultadoReal);
        EasyMock.verify(mockHttpURLConnection);
        EasyMock.verify(mockWebClient);
    }
    @Test
    public void GetContentTestC2() throws MalformedURLException, IOException {
        EasyMock.expect(mockWebClient.createHttpURLConnection(url)).andReturn(mockHttpURLConnection);
        EasyMock.expect(mockHttpURLConnection.getInputStream());
        EasyMock.replay(mockWebClient);
        EasyMock.replay(mockHttpURLConnection);
        assertNull(mockWebClient.getContent(url));
        EasyMock.verify(mockWebClient);
        EasyMock.verify(mockHttpURLConnection);
    }
}
