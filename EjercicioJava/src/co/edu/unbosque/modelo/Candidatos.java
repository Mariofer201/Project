package co.edu.unbosque.modelo;

import java.io.Serializable;

public class Candidatos implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellido;
	private String cedula;
	private int edad;
	private String cargo;
	
	
	
	public Candidatos(String pNombre, int pEdad, String pCedula, String pApellido, String pCargo){
		nombre=pNombre;
		edad=pEdad;
		cedula=pCedula;
		apellido=pApellido;
		cargo=pCargo;
		
		verificarInvariante();
		
	}

	public Candidatos(String nombre, String apellido, String cedula, int edad, String cargo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.edad = edad;
		this.cargo = cargo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	private void verificarInvariante()
    {
        assert nombre != null: "El nombre no puede ser null";
        assert apellido != null: "El apellido no puede ser null";
        assert edad>0: "La edad no puede ser menor o igual a 0";
        assert cedula!=null: "La cedula no puede ser null";
        assert cargo!=null: "El cargo no puede ser null";
     
    }

}
