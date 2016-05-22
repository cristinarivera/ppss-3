/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.matriculacion.dao;

import java.util.Arrays;
import java.util.Calendar;
import org.apache.log4j.BasicConfigurator;
import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.DataFileLoader;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ppss.matriculacion.to.AlumnoTO;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
public class IAlumnoDAOIT {
    
    private IAlumnoDAO _fAlu; // = new FactoriaDAO();
    private AlumnoTO alumno = new AlumnoTO();
    private IDatabaseTester databaseTester;
    private final Calendar cal = Calendar.getInstance();
    
    @BeforeClass
    public static void only_once() {        
    //    Para evitar el mensaje   
    //    Running ppss.dbunitexample.TestDBUnit
    //    log4j:WARN No appenders could be found for logger (org.dbunit.assertion.SimpleAssert).
    //    log4j:WARN Please initialize the log4j system properly.  
        BasicConfigurator.configure();
    }
    
    @Before
    public void setUp() throws Exception {
        databaseTester = new JdbcDatabaseTester("com.mysql.jdbc.Driver",
        		"jdbc:mysql://localhost:3306/matriculacion", "root", "ppss");      
        DataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet dataSet = loader.load("/tabla2.xml");
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();        
        //_fAlu = FactoriaDAO.class.newInstance();
        _fAlu = new FactoriaDAO().getAlumnoDAO();
    }
    @Test
    public void testA1() throws Exception {        
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.YEAR, 1985);
        cal.set(Calendar.MONTH, 1); // Nota: en la clase Calendar, el primer mes es 0
        cal.set(Calendar.DATE, 22);        
        alumno.setFechaNacimiento(cal.getTime());
        alumno.setNif("33333333C");
        alumno.setNombre("Elena Aguirre Juarez");
        alumno.setDireccion("");
        alumno.setEmail("");
        alumno.setTelefonos(Arrays.asList(""));        
        
        try{
            _fAlu.addAlumno(alumno);
        }
        catch(DAOException ex){
            Assert.fail("Se ha lanzado la excepcion: " + ex.getMessage());
        }
        
        IDatabaseConnection connection = databaseTester.getConnection();
    
    // configuramos la conexión como de tipo mysql
    // para evitar el mensaje: 
    // WARN org.dbunit.dataset.AbstractTableMetaData - Potential problem found: 
    //      The configured data type factory 'class org.dbunit.dataset.datatype.DefaultDataTypeFactory' 
    //      might cause problems with the current database 'MySQL' (e.g. some datatypes may not be supported properly). 
    //      ...
    //DatabaseConfig dbconfig = connection.getConfig();
    //dbconfig.setProperty("http://www.dbunit.org/properties/datatypeFactory", new MySqlDataTypeFactory());
    IDataSet databaseDataSet = connection.createDataSet();
    ITable actualTable = databaseDataSet.getTable("alumnos"); 
    DataFileLoader loader = new FlatXmlDataFileLoader();
    IDataSet expectedDataSet = loader.load("/tabla3.xml");
    ITable expectedTable = expectedDataSet.getTable("alumnos");
    Assertion.assertEquals(expectedTable, actualTable);        
    }
    
    @Test
    public void testA2() throws Exception {        
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.YEAR, 1982);
        cal.set(Calendar.MONTH, 1); // Nota: en la clase Calendar, el primer mes es 0
        cal.set(Calendar.DATE, 22); 
        alumno.setFechaNacimiento(cal.getTime());
        alumno.setNif("11111111A");
        alumno.setNombre("Alfonso Ramirez Ruiz");
        alumno.setDireccion("Rambla, 22");
        alumno.setEmail("alfonso@ppss.ua.es");
        alumno.setTelefonos(Arrays.asList(""));        
        
        try{
            _fAlu.addAlumno(alumno);
        }
        catch(DAOException ex){            
            String resultadoEsperado = "Error al conectar con BD";
            String resultadoReal = ex.getMessage();
            assertEquals(resultadoEsperado, resultadoReal);
        } 
    }
    @Test
    public void testA3() throws Exception {        
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.YEAR, 1982);
        cal.set(Calendar.MONTH, 1); // Nota: en la clase Calendar, el primer mes es 0
        cal.set(Calendar.DATE, 22); 
        alumno.setFechaNacimiento(cal.getTime());
        alumno.setNif("44444444D");     
        
        try{
            _fAlu.addAlumno(alumno);
        }
        catch(DAOException ex){            
            String resultadoEsperado = "Error al conectar con BD";
            String resultadoReal = ex.getMessage();
            assertEquals(resultadoEsperado, resultadoReal);
        } 
    }
    @Test
    public void testA4() throws Exception {        
        alumno = null;
        try{
            _fAlu.addAlumno(alumno);
        }
        catch(DAOException ex){   
            String resultadoEsperado = "El alumno a insertar no puede ser nulo";
            String resultadoReal = ex.getMessage();
            assertEquals(resultadoEsperado, resultadoReal);
        } 
    }
    @Test
    public void testA5() throws Exception {        
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.YEAR, 1982);
        cal.set(Calendar.MONTH, 1); // Nota: en la clase Calendar, el primer mes es 0
        cal.set(Calendar.DATE, 22); 
        alumno.setFechaNacimiento(cal.getTime());
        alumno.setNombre("Pedro Garcia Lopez");
        alumno.setDireccion("Rambla, 22");
        alumno.setEmail("alfonso@ppss.ua.es");
        alumno.setTelefonos(Arrays.asList(""));        
        
        try{
            _fAlu.addAlumno(alumno);
        }
        catch(DAOException ex){            
            String resultadoEsperado = "Error al conectar con BD";
            String resultadoReal = ex.getMessage();
            assertEquals(resultadoEsperado, resultadoReal);
        } 
    }
    @Test
    public void testB1() throws Exception {        
        
        try{
            _fAlu.delAlumno("11111111A");
        }
        catch(DAOException ex){
            Assert.fail("Se ha lanzado la excepcion: " + ex.getMessage());
        }
        
        IDatabaseConnection connection = databaseTester.getConnection();
    
    // configuramos la conexión como de tipo mysql
    // para evitar el mensaje: 
    // WARN org.dbunit.dataset.AbstractTableMetaData - Potential problem found: 
    //      The configured data type factory 'class org.dbunit.dataset.datatype.DefaultDataTypeFactory' 
    //      might cause problems with the current database 'MySQL' (e.g. some datatypes may not be supported properly). 
    //      ...
    //DatabaseConfig dbconfig = connection.getConfig();
    //dbconfig.setProperty("http://www.dbunit.org/properties/datatypeFactory", new MySqlDataTypeFactory());
    IDataSet databaseDataSet = connection.createDataSet();
    ITable actualTable = databaseDataSet.getTable("alumnos"); 
    DataFileLoader loader = new FlatXmlDataFileLoader();
    IDataSet expectedDataSet = loader.load("/tabla4.xml");
    ITable expectedTable = expectedDataSet.getTable("alumnos");
    Assertion.assertEquals(expectedTable, actualTable);        
    }
    @Test
    public void testB2() throws Exception {       
        
        try{
            _fAlu.delAlumno("33333333C");
        }
        catch(DAOException ex){            
            String resultadoEsperado = "No se ha borrado ningun alumno";
                        
            String resultadoReal = ex.getMessage();
            assertEquals(resultadoEsperado, resultadoReal);
        }
    }
}