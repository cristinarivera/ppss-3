package ppss;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatriculaTest {
    int edad;
    boolean familiaNumerosa;
    boolean repetidor;
    float resultadoReal, resultadoEsperado;
    Matricula mat= new Matricula();

    @Test
    public void testCalculaTasaMatriculaC1() { // camino azul
        edad = 23;
        familiaNumerosa = true;
        repetidor = true;
        resultadoEsperado = 250.00f;
        resultadoReal = mat.calculaTasaMatricula(edad,familiaNumerosa,repetidor);
        //el tercer parámetro del método Assert.assertEquals es necesario si estamos comparando "floats"
        //en este caso el método devuelve cierto si:
        //resultadoEsperado = resultadoReal +/- 0.002
        assertEquals(resultadoEsperado, resultadoReal, 0.002f);
    }
    
    
    @Test
    public void testCalculaTasaMatriculaC2() { // camino verde
        edad = 23;
        familiaNumerosa = false;
        repetidor = true;
        resultadoEsperado = 2000.00f;
        resultadoReal = mat.calculaTasaMatricula(edad,familiaNumerosa,repetidor);
        //el tercer parámetro del método Assert.assertEquals es necesario si estamos comparando "floats"
        //en este caso el método devuelve cierto si:
        //resultadoEsperado = resultadoReal +/- 0.002
        assertEquals(resultadoEsperado, resultadoReal, 0.002f);
    }
    
    @Test
    public void testCalculaTasaMatriculaC3() { // camino lápiz
        edad = 23;
        familiaNumerosa = false;
        repetidor = false;
        resultadoEsperado = 500.00f;
        resultadoReal = mat.calculaTasaMatricula(edad,familiaNumerosa,repetidor);
        //el tercer parámetro del método Assert.assertEquals es necesario si estamos comparando "floats"
        //en este caso el método devuelve cierto si:
        //resultadoEsperado = resultadoReal +/- 0.002
        assertEquals(resultadoEsperado, resultadoReal, 0.002f);
    }
    
    @Test
    public void testCalculaTasaMatriculaC4() { // camino malva
        edad = 70;
        familiaNumerosa = true;
        repetidor = true;
        resultadoEsperado = 250.00f;
        resultadoReal = mat.calculaTasaMatricula(edad,familiaNumerosa,repetidor);
        //el tercer parámetro del método Assert.assertEquals es necesario si estamos comparando "floats"
        //en este caso el método devuelve cierto si:
        //resultadoEsperado = resultadoReal +/- 0.002
        assertEquals(resultadoEsperado, resultadoReal, 0.002f);
    }
    
    @Test
    public void testCalculaTasaMatriculaC5() { // camino rosa
        edad = 60;
        familiaNumerosa = false;
        repetidor = true;
        resultadoEsperado = 400.00f;
        resultadoReal = mat.calculaTasaMatricula(edad,familiaNumerosa,repetidor);
        //el tercer parámetro del método Assert.assertEquals es necesario si estamos comparando "floats"
        //en este caso el método devuelve cierto si:
        //resultadoEsperado = resultadoReal +/- 0.002
        assertEquals(resultadoEsperado, resultadoReal, 0.002f);
    }
    
    @Test
    public void testCalculaTasaMatriculaC6() { // camino 
        edad = 60;
        familiaNumerosa = true;
        repetidor = true;
        resultadoEsperado = 150.00f;
        resultadoReal = mat.calculaTasaMatricula(edad,familiaNumerosa,repetidor);
        //el tercer parámetro del método Assert.assertEquals es necesario si estamos comparando "floats"
        //en este caso el método devuelve cierto si:
        //resultadoEsperado = resultadoReal +/- 0.002
        assertEquals(resultadoEsperado, resultadoReal, 0.002f);
    }
}