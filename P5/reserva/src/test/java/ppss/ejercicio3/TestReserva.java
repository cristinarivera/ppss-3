/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ppss.ejercicio3.excepciones.ReservaException;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
public class TestReserva {
    private Exception resultadoEsperado, resultadoReal;
    public TestReserva() {
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
    public void TestReservaC1() throws Exception{
        TestableReserva tr = new TestableReserva();//
        OperacionStub to = new OperacionStub();
        IOperacionFactoria io = new IOperacionFactoria();
        tr.setCompruebaPermisos(false); //
        to.setOperacion(""); // no tiene que lanzar ninguna excepción específica
        resultadoEsperado = new ReservaException("ERROR de permisos;");
        
        io.setOperacion();
        String[] isbns = new String[1];        
        isbns[0] = "11111";
        try{
            tr.realizaReserva("xxxx", "xxxx", "Luis", isbns);
        }catch(ReservaException e){
            resultadoEsperado.equals(e);
        }
    }
    @Test
    public void TestReservaC2() throws Exception{
        TestableReserva tr = new TestableReserva();
        OperacionStub to = new OperacionStub();
        tr.setCompruebaPermisos(true);
        to.setOperacion(""); // no tiene que lanzar ninguna excepción
        resultadoEsperado = new ReservaException("");
        String[] isbns = new String[2];        
        isbns[0] = "11111";
        isbns[1] = "22222";
        try{
            tr.realizaReserva("ppss", "ppss", "Luis", isbns);
        }catch(ReservaException e){
            resultadoEsperado.equals(e);
        }
    }
    @Test
    public void TestReservaC3() throws Exception{
        TestableReserva tr = new TestableReserva();
        OperacionStub to = new OperacionStub();
        tr.setCompruebaPermisos(true);
        to.setOperacion("isbn"); // no tiene que lanzar ninguna excepción
        resultadoEsperado = new ReservaException("ISBN invalido:33333");
        String[] isbns = new String[1];        
        isbns[0] = "33333";
        try{
            tr.realizaReserva("ppss", "ppss", "Luis", isbns);
        }catch(ReservaException e){
            resultadoEsperado.equals(e);
        }
    }
    @Test
    public void TestReservaC4() throws Exception{
        TestableReserva tr = new TestableReserva();
        OperacionStub to = new OperacionStub();
        tr.setCompruebaPermisos(true);
        to.setOperacion("socio"); 
        resultadoEsperado = new ReservaException("SOCIO invalido");
        String[] isbns = new String[1];        
        isbns[0] = "11111";
        try{
            tr.realizaReserva("ppss", "ppss", "Pepe", isbns);
        }catch(ReservaException e){
            resultadoEsperado.equals(e);
        }
    }
    @Test
    public void TestReservaC5() throws Exception{
        TestableReserva tr = new TestableReserva();
        OperacionStub to = new OperacionStub();
        tr.setCompruebaPermisos(true);
        to.setOperacion("jdbc"); 
        resultadoEsperado = new ReservaException("CONEXION invalida");
        String[] isbns = new String[1];        
        isbns[0] = "11111";
        try{
            tr.realizaReserva("ppss", "ppss", "Luis", isbns);
        }catch(ReservaException e){
            resultadoEsperado.equals(e);
        }
    }
}
