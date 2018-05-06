package hotel;

import java.io.Serializable;
import java.util.ArrayList;

public class Hotel implements Serializable{
	
	private static final long serialVersionUID = -2223602071197796134L;
	private ArrayList<Cliente> usuarios;
	private ArrayList<Habitacion> habitaciones;
	private ArrayList<Empleado> personal;
	private String nombre;
	
	
	public Hotel() {
		super();
	}
	public Hotel(String nombre) {
		super();
		this.nombre= nombre;
		usuarios = new ArrayList<Cliente>();
		habitaciones = new ArrayList<Habitacion>();
		personal = new ArrayList<Empleado>();
	}
	
	public void addHabitacion(Habitacion h) {
		habitaciones.add(h);
	}
	
	public void addEmpleado(Empleado e) {
		personal.add(e);
	}
	
	public void addUser(Cliente c) {
		usuarios.add(c);
	}
	
	
	public ArrayList<Cliente> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(ArrayList<Cliente> usuarios) {
		usuarios = usuarios;
	}
	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
		habitaciones = habitaciones;
	}
	public ArrayList<Empleado> getPersonal() {
		return personal;
	}
	public void setPersonal(ArrayList<Empleado> personal) {
		personal = personal;
	}
	
	
}
