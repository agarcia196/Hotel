package hotel;

import java.io.Serializable;
import java.util.ArrayList;

public class Hotel implements Serializable{
	
	private static final long serialVersionUID = -2223602071197796134L;
	private ArrayList<Cliente> Usuarios;
	private ArrayList<Habitacion> Habitaciones;
	private ArrayList<Empleado> Personal;
	private String nombre;
	
	
	public Hotel() {
		super();
	}
	public Hotel(String nombre) {
		super();
		this.nombre= nombre;
		Usuarios = new ArrayList<Cliente>();
		Habitaciones = new ArrayList<Habitacion>();
		Personal = new ArrayList<Empleado>();
	}
	public ArrayList<Cliente> getUsuarios() {
		return Usuarios;
	}
	public void setUsuarios(ArrayList<Cliente> usuarios) {
		Usuarios = usuarios;
	}
	public ArrayList<Habitacion> getHabitaciones() {
		return Habitaciones;
	}
	public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
		Habitaciones = habitaciones;
	}
	public ArrayList<Empleado> getPersonal() {
		return Personal;
	}
	public void setPersonal(ArrayList<Empleado> personal) {
		Personal = personal;
	}
	public void addHabitacion(Habitacion h) {
		
	}
	public void addEmpleado(Empleado e ) {
		
	}
	
	
}
