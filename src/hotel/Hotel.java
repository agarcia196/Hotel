package hotel;

import java.io.Serializable;
import java.util.ArrayList;

public class Hotel implements Serializable{
	
	private static final long serialVersionUID = -2223602071197796134L;
	private ArrayList<Cliente> usuarios;
	private ArrayList<Habitacion> habitaciones;
	private ArrayList<Empleado> personal;
	private String nombre;
	
	//Prueba
	public static void main(String[] args) {
		Hotel h = new Hotel("Trivago");
		Habitacion h1 = new Habitacion("301A", "VIP");
		Administrador e = new Administrador("Lopez", "Daniel", "Sin especificar", "DD", "123", "CC", "123");
		h.addHabitacion(h1);
		h.addEmpleado(e);
	  System.out.println(h.getPersonal().get(0).getNombre() +" "+ h.getHabitaciones().get(0).getID() );
	}
	
	public String getNombre () {
		
		return nombre;
	}
	public void setNombre (String nombre) {
		
		this.nombre = nombre;
	}
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
		this.usuarios = usuarios;
	}
	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	public ArrayList<Empleado> getPersonal() {
		return personal;
	}
	public void setPersonal(ArrayList<Empleado> personal) {
		this.personal = personal;
	}
}
