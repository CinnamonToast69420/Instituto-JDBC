package miClase;

import java.sql.Date;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Alumno {	
	// Constructor para escribir alumno en la base de datos; No tiene el atributo idAlumno porque la base de datos lo genera solo.
	public Alumno(String nombre, Date fechaNac, String dni, int nia, int aula, String telefono, String email, float nota) {
		super();
		//this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.dni = dni;
		this.nia = nia;
		this.aula = aula;
		this.telefono = telefono;
		this.email = email;
		this.nota = nota;
		
	}
	// Constructor para extraer todos los datos del alumno de la base de datos y hacer actualizaciones
	public Alumno(int idAlumno, String nombre, Date fechaNac, String dni, int nia, int aula, String telefono, String email, float nota) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.dni = dni;
		this.nia = nia;
		this.aula = aula;
		this.telefono = telefono;
		this.email = email;
		this.nota = nota;
		
	}
	
	private int idAlumno;
	
	private String nombre;
	
	private Date fechaNac;
	
	private String dni;
	
	private int nia;
	
	private int aula;
	
	
	private String telefono;
	
	private String email;
	
	private float nota;
	
	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}


	
	public Date getFechaNac() {
		return fechaNac;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public int getAula() {
		return aula;
	}
	public void setAula(int aula) {
		this.aula = aula;
	}



	public String getNombre() {
		return this.nombre;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getNia() {
		return nia;
	}
	public void setNia(int nia) {
		this.nia = nia;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	/*public int getEdad() 
	{
		Period p = Period.between(getFechaNacimiento(), LocalDate.now());
		return p.getYears();
		
	}*/

	@Override
	public String toString() {
	    return
    		"\n--- Alumnos del aula ---" +
	    	"\nId interno del alumno: " + getIdAlumno()+
	        "\nNombre del alumno: " + getNombre() +
	        "\nFecha de nacimiento: " + getFechaNac() + 
	        "\nDNI: " + getDni() +
	        "\nNIA: " + getNia() +
	        "\nAula: "+getAula() + 
	        "\nEmail: " + getEmail() +
	        "\nTelefono: " + getTelefono() +
	        "\nNota: " + getNota() + "\n";
	}
}
