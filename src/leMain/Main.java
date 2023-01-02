package leMain;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import daosInstituto.DAOAlumno;
import daosInstituto.DAOException;
import miClase.Alumno;
import mySQL.MySQLAlumnoDAO;

public class Main {
	


	public static void main(String[] args) throws SQLException, DAOException {
		// TODO Auto-generated method stub
		Connection conn = null; 
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "nkptv");
			//Obtener la lista de alumnos completa desde la base de datos y asignarla a objetos de tipo Alumno;
			DAOAlumno a = new MySQLAlumnoDAO(conn);
			System.out.println("Imprimiendo lista de alumnos actual...\n");
			List<Alumno> lista = a.getAll();
			for (Alumno alm : lista) 
			{
				System.out.println(alm);
			}
			Integer id = null;
			
			//Agregamos a un alumno con su constructor
			System.out.println("Agregando a un nuevo alumno...\n");
			Alumno a1 = new Alumno("Luis Gomez Lopez", Date.valueOf("1995-01-02"), "56843902J", 56783201, 1, "647893230", "lLop_95@gmail.com", 5.7f );
			a.insert(a1);
			//obtenemos la lista de alumnos otra vez, con el alumno nuevo actualizado...
			System.out.println("Imprimiendo lista de alumnos actualizada con el alumno nuevo agregado...\n");
			List<Alumno> listaActualizada = a.getAll();
			for (Alumno alm : listaActualizada) 
			{
				System.out.println(alm);
			}
			
			
			// obtenemos al alumno e imprimimos la lista otra vez...
			Alumno b  = a.getById(listaActualizada.get(listaActualizada.size()-1).getIdAlumno());
			a.delete(b);
			List<Alumno> listaAct = a.getAll();
			for (Alumno alm : listaAct) 
			{
				System.out.println(alm);
			}
			
			System.out.println("\nActualizando la nota del alumno con id 1...");
			Alumno alumnoAct = a.getById(1);
			alumnoAct.setNota(10f);
			a.update(alumnoAct);
			List<Alumno> listaAct1 = a.getAll();
			System.out.println("Mostrando la info de este alumno actualizada...");
			System.out.println(a.getById(1));
			
			
			
			
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
		
	}

}
