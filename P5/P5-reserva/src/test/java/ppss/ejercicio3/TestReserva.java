/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio3;

import org.junit.Test;
import static org.junit.Assert.*;
import ppss.ejercicio3.excepciones.ReservaException;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
public class TestReserva {
    private String resultadoEsperado, resultadoReal;
    public TestReserva() {
    }
    
    @Test
    public void TestReservaC1() throws Exception {
        TestableReserva tr = new TestableReserva();//
        OperacionStub to = new OperacionStub();
        IOperacionFactoria io = new IOperacionFactoria();
        tr.setCompruebaPermisos(false); //
        to.setException(null); // no tiene que lanzar ninguna excepción específica
        io.setOperacion(to);
        String[] isbns = {"11111"};
        try{
            tr.realizaReserva("xxxx", "xxxx", "Luis", isbns);
        }catch(ReservaException e){
            resultadoEsperado = "ERROR de permisos; ";
            resultadoReal = e.getMessage();
            assertEquals(resultadoEsperado, resultadoReal);
        }
    }
    
    @Test
    public void TestReservaC2() throws Exception{
        TestableReserva tr = new TestableReserva();
        OperacionStub to = new OperacionStub();
        IOperacionFactoria io = new IOperacionFactoria();
        tr.setCompruebaPermisos(true);
        to.setException(""); // no tiene que lanzar ninguna excepción
        io.setOperacion(to);
        String[] isbns = {"11111", "22222"};
        try{
            tr.realizaReserva("ppss", "ppss", "Luis", isbns);
        }catch(ReservaException e){
            resultadoEsperado = "";
            resultadoReal = e.getMessage();
            assertEquals(resultadoEsperado, resultadoReal);
        }
    }
    
    @Test
    public void TestReservaC3() throws Exception{
        
        TestableReserva tr3 = new TestableReserva();
        tr3.setCompruebaPermisos(true);        
        OperacionStub to3 = new OperacionStub();        
        to3.setException("isbn"); 
        IOperacionFactoria io3 = new IOperacionFactoria();
        io3.setOperacion(to3);
        resultadoEsperado = "ISBN invalido:33333; ";
        String[] isbns = new String[1];        
        isbns[0] = "33333";
        try{
            tr3.realizaReserva("ppss", "ppss", "Luis", isbns);
        }catch(ReservaException e){
            resultadoReal = e.getMessage();
            assertEquals(resultadoEsperado, resultadoReal);
        }
    }
    @Test
    public void TestReservaC4() throws Exception{
        TestableReserva tr = new TestableReserva();
        OperacionStub to = new OperacionStub();
        tr.setCompruebaPermisos(true);
        to.setException("socio"); 
        IOperacionFactoria io = new IOperacionFactoria();
        io.setOperacion(to);
        resultadoEsperado = "SOCIO invalido; ";
        String[] isbns = new String[1];        
        isbns[0] = "11111";
        try{
            tr.realizaReserva("ppss", "ppss", "Pepe", isbns);
        }catch(ReservaException e){
            resultadoReal = e.getMessage();
            assertEquals(resultadoEsperado, resultadoReal);
        }
    }
    @Test
    public void TestReservaC5() throws Exception{
        TestableReserva tr = new TestableReserva();
        OperacionStub to = new OperacionStub();
        tr.setCompruebaPermisos(true);
        to.setException("jdbc"); 
        IOperacionFactoria io = new IOperacionFactoria();
        io.setOperacion(to);
        resultadoEsperado = "CONEXION invalida; ";
        String[] isbns = new String[1];        
        isbns[0] = "11111";
        try{
            tr.realizaReserva("ppss", "ppss", "Luis", isbns);
        }catch(ReservaException e){
            resultadoReal = e.getMessage();
            assertEquals(resultadoEsperado, resultadoReal);
        }
    }

}
