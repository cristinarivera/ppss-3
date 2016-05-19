
package ppss.matriculacion.dao;

import ppss.matriculacion.dao.FactoriaDAO;
import ppss.matriculacion.dao.DAOException;
import ppss.matriculacion.dao.IAlumnoDAO;
import java.util.List;
import ppss.matriculacion.to.AlumnoTO;


public class ConsultaBD {
    
    public static void main(String[] args) throws DAOException {

		FactoriaDAO factoriaDao = new FactoriaDAO();
		IAlumnoDAO alumnoDao = factoriaDao.getAlumnoDAO();
		List<AlumnoTO> alumnos = alumnoDao.getAlumnos();
		System.out.println("Numero de alumnos: " + alumnos.size());
		
		for(AlumnoTO alumno: alumnos) {
			System.out.println(alumno.getNombre());
		}
	} 
    
}
