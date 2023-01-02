package mySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

import daosInstituto.DAOAula;
import daosInstituto.DAOException;
import miClase.Alumno;
import miClase.Aula;

public class MySQLAulaDAO implements DAOAula{

	private Connection con;
	private String insert = "INSERT INTO aula(idAula, nombre, centro, localidad) VALUES(?, ?, ?, ?)";
	private String update = "UPDATE aula SET nombre = ?, centro = ?, localidad = ? WHERE idAula = ?";
	private String delete = "DELETE FROM aula WHERE idAula = ?";
	private String getAll = "SELECT idAula, nombre, centro, localidad FROM aula";
	private String getById = "SELECT idAula, nombre, centro, localidad FROM aula WHERE idAula = ?";
	
	
	public MySQLAulaDAO(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public void insert(Aula a) throws DAOException {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(insert);
			ps.setNull(1, Types.INTEGER);
			ps.setString(2, a.getNombre());
			ps.setString(3, a.getCentro());
			ps.setString(4, a.getLocalidad());
			if(ps.executeUpdate()==0) 
			{
				throw new DAOException("es probable que los datos no se hayan guardado!");
			}
		} catch(SQLException se) {
			throw new DAOException("Error en SQL", se);
			
		}
		
		finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Aula a) throws DAOException{
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(update);
			ps.setString(1, a.getNombre());
			ps.setString(2, a.getCentro());
			ps.setString(3, a.getLocalidad());
			ps.setInt(4, a.getIdAula());
			if(ps.executeUpdate()==0) 
			{
				throw new DAOException("es probable que los datos no se hayan guardado!");
			}
		} catch(SQLException se) {
			throw new DAOException("Error en SQL", se);
			
		}
		
		finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(Aula a) throws DAOException {
		// TODO Auto-generated method stub
	    PreparedStatement statement  = null;
	    
	    try {
			 statement = con.prepareStatement(delete);
			 statement.setInt(1, a.getIdAula());
			
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
	
	public Aula convertir(ResultSet rs) throws SQLException
	{
		int id  =rs.getInt("idAula");
		String nombre = rs.getString("nombre");
		String centro = rs.getString("centro");
		String loca = rs.getString("localidad");
		
		Aula a  = new Aula(id, nombre, centro, loca);
		return a;
	}

	@Override
	public List<Aula> getAll() throws DAOException {
		PreparedStatement stm = null;
		ResultSet rs = null;
		List<Aula> aulas = new ArrayList<>();
		try {
			stm = con.prepareStatement(getAll);
			 rs = stm.executeQuery();
			 while(rs.next())
			 {
				 aulas.add(convertir(rs));
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
		return aulas;
	}

	@Override
	public Aula getById(Integer idAula) throws DAOException {
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		Aula a = null;
		try {
			stm = con.prepareStatement(getById);
			 stm.setInt(1, idAula);
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
