package daosInstituto;

import java.util.List;

import miClase.Alumno;

public interface DAO<T, K> {

	void insert(T a) throws DAOException;
	
	void update(T a) throws DAOException;
	
	void delete(T a) throws DAOException;
	
	List<T> getAll() throws DAOException;
	
	T getById(K idAlumno) throws DAOException;

}
