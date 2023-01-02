package mySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Types;
import java.sql.Date;
import java.sql.Connection;
import daosInstituto.DAOAlumno;
import daosInstituto.DAOException;
import miClase.Alumno;



public class MySQLAlumnoDAO implements DAOAlumno{
	
	private Connection con;

	public MySQLAlumnoDAO(Connection con) {
		super();
		this.con = con;
	}

	private String insert = "INSERT INTO alumnos(id_alumno, nombre, fecha_nac, dni, nia, aula, telefono, email, nota) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private String update = "UPDATE alumnos SET nombre = ?, fecha_nac = ?, dni = ?, nia = ?, aula = ?, telefono = ?, email = ?, nota = ? WHERE id_alumno = ?";
	private String delete = "DELETE FROM alumnos WHERE id_alumno = ?";
	private String getAll = "SELECT id_alumno, nombre, fecha_nac, dni, nia, aula, telefono, email, nota FROM alumnos";
	private String getById = "SELECT id_alumno, nombre, fecha_nac, dni, nia, aula, telefono, email, nota FROM alumnos WHERE id_alumno = ?";
	@Override
	public void insert(Alumno a) throws DAOException{
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		try{
			statement = con.prepareStatement(insert);
			statement.setNull(1, Types.INTEGER);
			statement.setString(2, a.getNombre());
			statement.setDate(3,  new Date(a.getFechaNac().getYear(), a.getFechaNac().getMonth(), a.getFechaNac().getDay()));
			statement.setString(4, a.getDni());
			statement.setInt(5, a.getNia());
			statement.setInt(6, a.getAula());
			statement.setString(7, String.valueOf(a.getTelefono()));
			statement.setString(8, a.getEmail());
			statement.setFloat(9, a.getNota());
			
			if(statement.executeUpdate()==0) 
			{
				throw new DAOException("es probable que los datos no se hayan guardado!");
			}
		} catch(SQLException se) {
			throw new DAOException("Error en SQL", se);
			
		}
		
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Alumno a) throws DAOException {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		try{
			statement = con.prepareStatement(update);
			
			statement.setString(1, a.getNombre());
			statement.setDate(2,  new Date(a.getFechaNac().getYear(), a.getFechaNac().getMonth(), a.getFechaNac().getDay()));
			statement.setString(3, a.getDni());
			statement.setInt(4, a.getNia());
			statement.setInt(5, a.getAula());
			statement.setString(6, String.valueOf(a.getTelefono()));
			statement.setString(7, a.getEmail());
			statement.setFloat(8, a.getNota());
			statement.setInt(9, a.getIdAlumno());
			
			
			if(statement.executeUpdate()==0) 
			{
				throw new DAOException("es probable que los datos no se hayan guardado!");
			}
		} catch(SQLException se) {
			throw new DAOException("Error en SQL", se);
			
		}
		
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(Alumno a) throws DAOException {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		try {
			 statement = con.prepareStatement(delete);
			 statement.setInt(1, a.getIdAlumno());
			
			 if(statement.executeUpdate()==0) 
			{
				throw new DAOException("es probable que los datos no se hayan borrado!");
			}
		} catch(SQLException se) {
			throw new DAOException("Error en SQL", se);
			
		}
		
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	
	
	private Alumno convertir(ResultSet rs) throws SQLException
	{
		int id = rs.getInt("id_alumno");
		String nombre = rs.getString("nombre");
		Date fechaNac= rs.getDate("fecha_nac");
		String dni = rs.getString("dni");
		int nia = rs.getInt("nia");
		int aula = rs.getInt("aula");
		String telefono = rs.getString("telefono");
		String email = rs.getString("email");
		float nota = rs.getFloat("nota");
		
		Alumno a = new Alumno(id, nombre, fechaNac, dni, nia, aula, telefono, email, nota);
		return a;
	}
	
	@Override
	public List<Alumno> getAll() throws DAOException{
		// TODO Auto-generated method stub
		PreparedStatement stm = null;
		ResultSet rs = null;
		List<Alumno> alumnosDev = new ArrayList<>();
		try {
			stm = con.prepareStatement(getAll);
			 rs = stm.executeQuery();
			 while(rs.next())
			 {
				 alumnosDev.add(convertir(rs));
			 }
		}catch(SQLException se) {
			throw new DAOException("Error en la consulta", se);
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch(SQLException se) {
					throw new DAOException("Error en sql", se);
				}
			}
			
		}
		return alumnosDev;
	}
	
	

	@Override
	public Alumno getById(Integer idAlumno) throws DAOException {
		// TODO Auto-generated method stub
		PreparedStatement stm = null;
		ResultSet rs = null;
		Alumno a = null;
		try {
			stm = con.prepareStatement(getById);
			 stm.setInt(1, idAlumno);
			 rs = stm.executeQuery();
			 if(rs.next()) {
				 a = convertir(rs);
			 }else {
				 throw new DAOException("No se encontró ese registro! >:(");
			 }
		}catch(SQLException se) {
			throw new DAOException("Error en la consulta", se);
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch(SQLException se) {
					throw new DAOException("Error en sql", se);
				}
			}
		}
		return a;
	}

	

}
