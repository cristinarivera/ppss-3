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
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.util.fileloader.DataFileLoader;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ppss.matriculacion.to.AlumnoTO;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
public class IAlumnoDAOIT {
    
    FactoriaDAO fAlu;
    AlumnoTO alumno = new AlumnoTO();
    private IDatabaseTester databaseTester;
    
    @BeforeClass
    public static void setUpClass() {
        
    //    Para evitar el mensaje   
    //    Running ppss.dbunitexample.TestDBUnit
    //    log4j:WARN No appenders could be found for logger (org.dbunit.assertion.SimpleAssert).
    //    log4j:WARN Please initialize the log4j system properly.  
        BasicConfigurator.configure();

      
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ClassNotFoundException, Exception {
        databaseTester = new JdbcDatabaseTester("com.mysql.jdbc.Driver",
        		"jdbc:mysql://localhost:3306/DBUNIT", "root", "ppss");
      
        DataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet dataSet = loader.load("/tabla_init.xml");	 

        databaseTester.setDataSet(dataSet);

        databaseTester.onSetup();
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testA1() throws DAOException, Exception {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.YEAR, 1985);
        cal.set(Calendar.MONTH, 1); // Nota: en la clase Calendar, el primer mes es 0
        cal.set(Calendar.DATE, 22);
         System.out.println("print-0");
        alumno.setFechaNacimiento(cal.getTime());
        alumno.setNif("33333333C");
        alumno.setNombre("Elena Aguirre Juarez");
        alumno.setDireccion("");
        alumno.setEmail("");
        alumno.setTelefonos(Arrays.asList("666666666", "555555555", "444444444"));
        
        System.out.println("print-1");
        
        fAlu = new FactoriaDAO();
        fAlu.getAlumnoDAO().addAlumno(alumno);
        
        System.out.println("print-2");
        
        IDatabaseConnection connection = databaseTester.getConnection();
    
    // configuramos la conexión como de tipo mysql
    // para evitar el mensaje: 
    // WARN org.dbunit.dataset.AbstractTableMetaData - Potential problem found: 
    //      The configured data type factory 'class org.dbunit.dataset.datatype.DefaultDataTypeFactory' 
    //      might cause problems with the current database 'MySQL' (e.g. some datatypes may not be supported properly). 
    //      ...
    DatabaseConfig dbconfig = connection.getConfig();
    dbconfig.setProperty("http://www.dbunit.org/properties/datatypeFactory", new MySqlDataTypeFactory());
	System.out.println("print-3");        
    IDataSet databaseDataSet = connection.createDataSet();
    ITable actualTable = databaseDataSet.getTable("alumnos"); //.getTable(fAlu.getAlumnoDAO().getAlumnos()) //.getTable("tabla3");
System.out.println("print-4");
    DataFileLoader loader = new FlatXmlDataFileLoader();
    IDataSet expectedDataSet = loader.load("/tabla3.xml");
      System.out.println("print-5");
    ITable expectedTable = expectedDataSet.getTable("alumnos");

    System.out.println("print-6");
    Assertion.assertEquals(expectedTable, actualTable);
        
    }
}
