/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.easymock.EasyMock;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
public class TestListados {
    private Connection connectionMock;
    private Statement statementMock;
    private ResultSet resultSetMock;
    
    @Before
    public void setUp(){
        connectionMock = createMock(Connection.class);
        statementMock = createMock(Statement.class);
        resultSetMock = createMock(ResultSet.class);
    }
    
    @Test
    public void TestPorApellidos() throws SQLException{
         
        EasyMock.expect(connectionMock.createStatement()).andReturn(statementMock);
        EasyMock.expect(statementMock.executeQuery("SELECT apellido1, apellido2, nombre FROM alumnos")).andReturn(resultSetMock);
        EasyMock.expect(resultSetMock.next()).andReturn(Boolean.TRUE);
        EasyMock.expect(resultSetMock.getString("apellido1")).andReturn("Garcia");
        EasyMock.expect(resultSetMock.getString("apellido2")).andReturn("Molina");
        EasyMock.expect(resultSetMock.getString("nombre")).andReturn("Ana");
        EasyMock.expect(resultSetMock.next()).andReturn(Boolean.TRUE);
        EasyMock.expect(resultSetMock.getString("apellido1")).andReturn("Lacalle");
        EasyMock.expect(resultSetMock.getString("apellido2")).andReturn("Verna");
        EasyMock.expect(resultSetMock.getString("nombre")).andReturn("Jose Luis");
        EasyMock.expect(resultSetMock.next()).andReturn(Boolean.FALSE);
        
        EasyMock.replay(connectionMock);
        EasyMock.replay(statementMock);
        EasyMock.replay(resultSetMock);
        
        Listados l = new Listados();
        String resultadoReal = l.porApellidos(connectionMock, "alumnos");
        String resultadoEsperado = "Garcia, Molina, Ana\nLacalle, Verna, Jose Luis\n";
        
        assertEquals(resultadoEsperado, resultadoReal);
        
        EasyMock.verify(connectionMock);
        EasyMock.verify(statementMock);
        EasyMock.verify(resultSetMock);
        
    }

    
}
