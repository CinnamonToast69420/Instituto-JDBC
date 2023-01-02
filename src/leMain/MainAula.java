package leMain;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import daosInstituto.DAOAlumno;
import daosInstituto.DAOAula;
import daosInstituto.DAOException;
import miClase.Alumno;
import miClase.Aula;
import mySQL.MySQLAlumnoDAO;
import mySQL.MySQLAulaDAO;

public class MainAula {

	public static void main(String[] args) throws SQLException, DAOException {
		// TODO Auto-generated method stub
		
		Connection conn = null; 
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "nkptv");
			//Obtener la lista de alumnos completa desde la base de datos y asignarla a objetos de tipo Alumno;
			DAOAula a = new MySQLAulaDAO(conn);
			System.out.println("Imprimiendo lista de aulas actual...\n");
			List<Aula> lista = a.getAll();
			for (Aula alm : lista) 
			{
				System.out.println(alm);
			}
			
			//Agregamos un aula nueva con su constructor
			System.out.println("\nAgregando a una nueva aula...\n");
			Aula a1 = new Aula("C.0.8", "IES Eduardo Primo Marqués", "Carlet");
			a.insert(a1);
			//obtenemos la lista de alumnos otra vez, con el alumno nuevo actualizado...
			System.out.println("Imprimiendo lista de aulas actualizada con el aula nueva agregada...");
			List<Aula> listaActualizada = a.getAll();
			for (Aula alm : listaActualizada) 
			{
				System.out.println(alm);
			}
			
			
			// obtenemos el aula para eliminarla e imprimimos la lista otra vez...
			
			
			Aula b  = a.getById(listaActualizada.get(listaActualizada.size()-1).getIdAula());
			
			System.out.println("\nEliminaremos el aula recién insertada...");
			a.delete(b);
			System.out.println("\nÉxito... imprimiendo lista con el aula eliminada...");
			List<Aula> listaAct = a.getAll();
			for (Aula alm : listaAct) 
			{
				System.out.println(alm);
			}
			
			System.out.println("\nActualizando el nombre del aula con id 1...");
			Aula aulaUpdt = a.getById(1);
			aulaUpdt.setNombre("C.0.10");
			a.update(aulaUpdt);
		
			System.out.println("Mostrando la info de esta aula actualizada...");
			System.out.println(a.getById(1));
			
			
			
			
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
		
	}

	

}
