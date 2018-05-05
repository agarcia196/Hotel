package hotel;

import java.util.ArrayList;

public class Hotel {
	ArrayList<Cliente> Usuarios;
	ArrayList<Habitacion> Habitaciones;
	ArrayList<Empleado> Personal;
	
	
	public Hotel() {
		super();
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
