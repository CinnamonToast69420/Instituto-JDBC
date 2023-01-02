package miClase;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Aula {
	private List<Alumno> alumnosDeEstaClase = new ArrayList<Alumno>();
	
	public int idAula;
	public String nombre;
	public String centro;
	public String localidad;
	
	public Aula(String nombre, String centro, String localidad) {
		super();
		this.nombre = nombre;
		this.centro = centro;
		this.localidad = localidad;
	}
	
	public Aula(int idAula, String nombre, String centro, String localidad) {
		super();
		this.idAula = idAula;
		this.nombre = nombre;
		this.centro = centro;
		this.localidad = localidad;
	}
	
	public int getIdAula() {
		return idAula;
	}




	public void setIdAula(int idAula) {
		this.idAula = idAula;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getCentro() {
		return centro;
	}




	public void setCentro(String centro) {
		this.centro = centro;
	}




	public String getLocalidad() {
		return localidad;
	}




	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}		
	public void alumnoNuevo(Alumno a) 
	{
		
		alumnosDeEstaClase.add(a);
	}
	
	public void setListAlumnos(List<Alumno> listaAlumnos)
	{
		this.alumnosDeEstaClase=listaAlumnos;
	}
	
	public List<Alumno> getList() {
        return this.alumnosDeEstaClase;
    }

	/*int contarAlumnosMayoresQue (int edad) 
	{
		return  (int) alumnosDeEstaClase.stream()
		.filter((a)->(a).getEdad()>edad).count();
	}
	
	float edadMedia() 
	{
		return this.alumnosDeEstaClase.stream()
		.collect(Collectors.averagingDouble(a -> a.getEdad())).floatValue();
	}*/
	
	List<String> nombreSuspendidos()
	{
		return alumnosDeEstaClase.stream()
		.filter((a) -> (a).getNota()<5f)
		.map(Alumno::getNombre)
		.collect(Collectors.toList());
		
	} 
	
	 public void listadoPorNiaDescendente (){
	      alumnosDeEstaClase.sort(null);
	      alumnosDeEstaClase.forEach(System.out::println);
	    }


	@Override
	public String toString() {
		return "--Aula--\n idBD=: " + idAula + "\nnombre= " + nombre + "\ncentro= " + centro
				+ "\nlocalidad= " + localidad;
	}
	
	/* public boolean encontarAlumnosDelMismoMesQue(Alumno a) {
	        return alumnosDeEstaClase.stream()
	                .filter(b -> a.getFechaNacimiento().getMonthValue() == b.getFechaNacimiento().getMonthValue())
	                .count() > 0;
	    }*/
	

}
