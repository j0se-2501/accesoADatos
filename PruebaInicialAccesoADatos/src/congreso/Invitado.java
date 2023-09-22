package congreso;

public class Invitado {
	
	protected String dni;
	protected String apellidos;
	protected String nombre;
	protected String centroAcademico;
	protected int edad;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCentroAcademico() {
		return centroAcademico;
	}
	public void setCentroAcademico(String centroAcademico) {
		this.centroAcademico = centroAcademico;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public Invitado(String dni, String apellidos, String nombre, String centroAcademico, int edad) {
		super();
		this.dni = dni;
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.centroAcademico = centroAcademico;
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Invitado [dni=" + dni + ", apellidos=" + apellidos + ", nombre=" + nombre + ", centro academico="
				+ centroAcademico + ", edad=" + edad + "]";
	}
	
	

}
