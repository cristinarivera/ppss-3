/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio4;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ppss.ejercicio4.excepciones.IsbnInvalidoException;
import ppss.ejercicio4.excepciones.JDBCException;
import ppss.ejercicio4.excepciones.ReservaException;
import ppss.ejercicio4.excepciones.SocioInvalidoException;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
public class ReservaMockTest {
    String socio, isbn, login, password;
    String[] isbns;
    String resultadoEsperado, resultadoReal;
    Reserva mockReserva;
    FactoriaBOs mockFact;
    IOperacionBO mockIOp;
        
    public ReservaMockTest() {
    }
        
    @Before
    public void setUp() {
        mockReserva = EasyMock.createMockBuilder(Reserva.class).addMockedMethods("compruebaPermisos", "getFactoriaBOs").createMock();
        mockFact = EasyMock.createMockBuilder(FactoriaBOs.class).addMockedMethod("getOperacionBO").createMock();
        mockIOp = EasyMock.createMock(IOperacionBO.class); // no hacer mock parcial cuando es una factoria
        
    }
    
    @After
    public void tearDown() {
        mockReserva = null;
        mockFact = null;
        mockIOp = null;
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void ReservaMockTestC1() throws ReservaException, IsbnInvalidoException, JDBCException, SocioInvalidoException {
        
        socio = "Luis";
        isbn = "11111";
        login = "xxxx";
        password = "xxxx";
        isbns = new String[] {"11111"};
         
        EasyMock.expect(mockReserva.compruebaPermisos(login, password, Usuario.BIBLIOTECARIO)).andReturn(false);
        EasyMock.replay(mockReserva);
        
        try{
            mockReserva.realizaReserva(login, password, socio, isbns);
        }catch(Exception e){
            resultadoEsperado = "ERROR de permisos; ";
            resultadoReal = e.getMessage();
            assertEquals(resultadoEsperado, resultadoReal);
        }
        EasyMock.verify(mockReserva);
    
    }
    @Test
    public void ReservaMockTestC2() throws ReservaException, IsbnInvalidoException, JDBCException, SocioInvalidoException {
        
        socio = "Luis";
        isbn = "11111";
        login = "ppss";
        password = "ppss";
        isbns = new String[] {"11111", "22222"};
         
        EasyMock.expect(mockReserva.compruebaPermisos(login, password, Usuario.BIBLIOTECARIO)).andReturn(true);
        EasyMock.expect(mockReserva.getFactoriaBOs()).andReturn(mockFact);
        EasyMock.expect(mockFact.getOperacionBO()).andReturn(mockIOp);
        EasyMock.replay(mockReserva);
        EasyMock.replay(mockFact);
        try{
            mockReserva.realizaReserva(login, password, socio, isbns);
        }catch(Exception e){
            resultadoEsperado = "";
            resultadoReal = e.getMessage();
            assertEquals(resultadoEsperado, resultadoReal);
        }
        EasyMock.verify(mockReserva);
        EasyMock.verify(mockFact);
    
    }
    @Test
    public void ReservaMockTestC3() throws ReservaException, JDBCException, SocioInvalidoException, IsbnInvalidoException {
        
        socio = "Luis";
        isbn = "33333";
        login = "ppss";
        password = "ppss";
        isbns = new String[] {"33333"};
        
        EasyMock.expect(mockReserva.compruebaPermisos(login, password, Usuario.BIBLIOTECARIO)).andReturn(true);
        EasyMock.expect(mockReserva.getFactoriaBOs()).andReturn(mockFact);
        EasyMock.expect(mockFact.getOperacionBO()).andReturn(mockIOp);
        mockIOp.operacionReserva(socio, isbn);
        EasyMock.expectLastCall().andThrow(new IsbnInvalidoException());
        EasyMock.replay(mockReserva);
        EasyMock.replay(mockFact);
        EasyMock.replay(mockIOp);
        try{
            mockReserva.realizaReserva(login, password, socio, isbns);
        }catch(Exception e){
            resultadoEsperado = "ISBN invalido:33333; ";
            resultadoReal = e.getMessage();
            assertEquals(resultadoEsperado, resultadoReal);
        }
        EasyMock.verify(mockReserva);
        EasyMock.verify(mockFact);
        EasyMock.verify(mockIOp);
    
    }
    @Test
    public void ReservaMockTestC4() throws ReservaException, IsbnInvalidoException, JDBCException, SocioInvalidoException {
        
        socio = "Pepe";
        isbn = "11111";
        login = "ppss";
        password = "ppss";
        isbns = new String[] {"11111"};
        
        EasyMock.expect(mockReserva.compruebaPermisos(login, password, Usuario.BIBLIOTECARIO)).andReturn(true);
        EasyMock.expect(mockReserva.getFactoriaBOs()).andReturn(mockFact);
        EasyMock.expect(mockFact.getOperacionBO()).andReturn(mockIOp);
        mockIOp.operacionReserva(socio, isbn);
        EasyMock.expectLastCall().andThrow(new SocioInvalidoException());
        EasyMock.replay(mockReserva);
        EasyMock.replay(mockFact);
        EasyMock.replay(mockIOp);
        try{
            mockReserva.realizaReserva(login, password, socio, isbns);
        }catch(Exception e){
            resultadoEsperado = "SOCIO invalido; ";
            resultadoReal = e.getMessage();
            assertEquals(resultadoEsperado, resultadoReal);
        }
        EasyMock.verify(mockReserva);
        EasyMock.verify(mockFact);
        EasyMock.verify(mockIOp);
    
    }
    @Test
    public void ReservaMockTestC5() throws ReservaException, IsbnInvalidoException, JDBCException, SocioInvalidoException {
        
        socio = "Luis";
        isbn = "11111";
        login = "ppss";
        password = "ppss";
        isbns = new String[] {"11111"};
        
        EasyMock.expect(mockReserva.compruebaPermisos(login, password, Usuario.BIBLIOTECARIO)).andReturn(true);
        EasyMock.expect(mockReserva.getFactoriaBOs()).andReturn(mockFact);
        EasyMock.expect(mockFact.getOperacionBO()).andReturn(mockIOp);
        mockIOp.operacionReserva(socio, isbn);
        EasyMock.expectLastCall().andThrow(new JDBCException());
        EasyMock.replay(mockReserva);
        EasyMock.replay(mockFact);
        EasyMock.replay(mockIOp);
        try{
            mockReserva.realizaReserva(login, password, socio, isbns);
        }catch(Exception e){
            resultadoEsperado = "CONEXION invalida; ";
            resultadoReal = e.getMessage();
            assertEquals(resultadoEsperado, resultadoReal);
        }
        EasyMock.verify(mockReserva);
        EasyMock.verify(mockFact);
        EasyMock.verify(mockIOp);
    
    }
}
