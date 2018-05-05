package hotel;

import java.io.Serializable;

public abstract class Empleado extends Persona implements Usuario, Serializable {

	private static final long serialVersionUID = 8181518522862120375L;
	public Empleado(String nombre, String apellido, String genero, String correo, String id, String tipoId,
			String pwd) {
		super(nombre, apellido, genero, correo, id, tipoId, pwd);
		// TODO Auto-generated constructor stub
	}

	public void checkIn () {
		
		
	}
	
	public void checkOut () {
		
		
	}
}
