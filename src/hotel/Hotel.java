package hotel;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import arbol.ABB;
import arbol.ACliente;
import exception.ECliente;
import exception.ExceptionNodo;

public class Hotel implements Serializable{
	
	private static final long serialVersionUID = -2223602071197796134L;
	private ACliente usuarios;
	private ArrayList<Habitacion> habitaciones;
	private ArrayList<Empleado> personal;
	private String nombre;
	private Cocina cocina;
	//Prueba
	public static void main(String[] args) {
		Hotel h = new Hotel("Trivago");
		Habitacion h1 = new Habitacion("301A", "VIP");
		Administrador e = new Administrador("Lopez", "Daniel", "Sin especificar", "DD", "123", "CC", "123");
		Empleado c= new Recepcion("Juan", "Carlos", "Mas", "juan@", "01", "cedula", "2");
		h.addHabitacion(h1);
		h.addEmpleado(e);
		h.addEmpleado(c);
	try {
		System.out.println(h.buscarEmpleado("12345"));
	} catch (ECliente e1) {
		// TODO Auto-generated catch block
		System.out.println(e1.getMessage());
	}
		
	}
	
	public String getNombre () {
		
		return nombre;
	}
	public void setNombre (String nombre) {
		
		this.nombre = nombre;
	}
	public Hotel() {
		super();
		usuarios = new ACliente();
		habitaciones = new ArrayList<Habitacion>();
		personal = new ArrayList<Empleado>();
		cocina= new Cocina();
	}
	public Hotel(String nombre) {
		super();
		this.nombre= nombre;
		usuarios = new ACliente();
		habitaciones = new ArrayList<Habitacion>();
		personal = new ArrayList<Empleado>();
		cocina= new Cocina();
	}
	//AAGREGAR USUARIO CON COMBO BOX,EMPLEADO,ADMINISTRADOR Y CLIENTE.ELIMINAR USUARIO Y EDITAR USUARIO, 
	public Cocina getCocina() {
		return cocina;
	}
	
	public void addHabitacion(Habitacion h) {
		habitaciones.add(h);
	}
	
	public void addEmpleado(Empleado e) {
		personal.add(e);
	}
	
	public void addUser(Cliente c) throws ExceptionNodo {
		usuarios.insertNodo(c);
	}
	
	// buscar reserva 
	public Reserva buscarReserva (String cedula,Date in) throws ExceptionNodo {
		Cliente c1=buscarCliente(cedula);
		if(c1.getReservasActivas().contains(in)) {
			return c1.buscarReserva(in);
		}else {
			return null;
		}
		
	}
	
	public Cliente buscarCliente (String cedula) throws ExceptionNodo {
		
		return  usuarios.buscarS(cedula).getLlave();
	}
	
	
	public ABB<Cliente> getUsuarios() {
		return usuarios;
	}
	
	public void setUsuarios (ACliente usuarios) {
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
	public Empleado buscarEmpleado(String cedula ) throws ECliente {
		int i =0;
		while(i<personal.size()&&personal.get(i).getId().compareTo(cedula)!=0)
			i++;
		if(i==personal.size())
			throw new ECliente("Usuario no encontrado");
		else
			return personal.get(i);
	}
	public DefaultTableModel limpiarMenu(DefaultTableModel modeloTable){
		int numFilas = modeloTable.getRowCount();
		for (int i=numFilas-1; i>=0; i--) {				//Eliminar los datos de la tabla
			modeloTable.removeRow(i);
		}
		return modeloTable;
	}
	public Persona login(String typeUser,String id,String pwd) throws ExceptionNodo, ECliente {
		Persona persona =null;
		switch (typeUser) {
		case "Visitor":
			persona= buscarCliente(id);
			break;
		case "Employee":
			persona= buscarEmpleado(id);
			break;
		default:
			break;
		}
		if (pwd.compareTo(persona.getPwd())==0)
			return persona;
		else
			throw new ECliente("Contraseña Inconrrecta");
	}
}
