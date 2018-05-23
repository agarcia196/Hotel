package hotel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import arbol.ACliente;
import exception.EArrayVacio;
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
		Habitacion h1 = new Habitacion("301A", "VIP", 1233);
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
		this.usuarios = new ACliente();
		this.habitaciones = new ArrayList<Habitacion>();
		this.personal = new ArrayList<Empleado>();
		this.cocina= new Cocina();
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
	public Reserva buscarReserva (String cedula, LocalDate in) throws ExceptionNodo {
		Cliente c1 = buscarCliente (cedula);
		Reserva reserva = c1.buscarReserva (LocalDate.now ());
		
		if(reserva != null) {
			
			return reserva;
		}else {
			
			throw new ExceptionNodo ("No existe una reserva para la fecha solicitada: " + in.toString ());
		}
	}

	
	public Cliente buscarCliente (String cedula) throws ExceptionNodo {
		return  usuarios.buscarS(cedula).getLlave();
	}
	
	
	public ACliente getUsuarios() {
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
	
	public DefaultTableModel ConsultaUsuarios(DefaultTableModel modeloTable) throws EArrayVacio{
		return usuarios.ConsultaUsuarios(modeloTable);
	}
	public DefaultTableModel ConsultaUsuarios(DefaultTableModel modeloTable,String palabra) throws EArrayVacio{
		return usuarios.ConsultaUsuarios(modeloTable,palabra);
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
			throw new ECliente("Usuario invalido");
		}
		if (pwd.compareTo(persona.getPwd())==0)
			return persona;
		else
			throw new ECliente("Contrase�a Inconrrecta");
	}
		
	
	public DefaultTableModel ConsultaUsuariosEdit(DefaultTableModel modeloTable) throws EArrayVacio{
		return usuarios.ConsultaUsuariosEdit(modeloTable);
	}
	public DefaultTableModel ConsultaUsuariosEdit(DefaultTableModel modeloTable,String palabra) throws EArrayVacio{
		return usuarios.ConsultaUsuariosEdit(modeloTable,palabra);
	}
	
	
	
	public DefaultTableModel ConsultaEmpleados(DefaultTableModel modeloTable) throws EArrayVacio {
		if(!personal.isEmpty()) {
		int i=0;
		while (i<personal.size()) {
			Empleado e= personal.get(i);
			String [] model = {e.getId(),e.getNombre(),e.getApellido(),e.getActivo()};
			modeloTable.addRow(model);	
			i++;
		}
		return modeloTable;}
		else {
			throw new EArrayVacio("No hay empleados");
		}
	}
	
	public DefaultTableModel ConsultaEmpleados(DefaultTableModel modeloTable,String palabra) throws EArrayVacio {
		if(!personal.isEmpty()) {
			int i=0;
			while (i<personal.size()) {
				Empleado e= personal.get(i);
				if(palabra.compareTo("")==0||e.getNombre().toLowerCase().contains(palabra)||e.getApellido().toLowerCase().contains(palabra)||e.getId().toLowerCase().contains(palabra)) {
					String [] model = {e.getId(),e.getNombre(),e.getApellido(),e.getActivo()};
					modeloTable.addRow(model);	
				}
				i++;
			}
		return modeloTable;
		}else {
			throw new EArrayVacio("No hay empleados");
		}
	}
	
	public DefaultTableModel printHabitaciones(DefaultTableModel modeloTable, LocalDate in, LocalDate out) throws EArrayVacio {
		if(this.getHabitaciones().size()>0) {
		int i=0;
		while (i<habitaciones.size() ) {
			if ( this.getHabitaciones().get(i).verDisponibilidad(in, out)) {
			String [] model = {habitaciones.get(i).getID(),habitaciones.get(i).getTipo(),Double.toString(habitaciones.get(i).getPrecioNoche())};
			modeloTable.addRow(model);
			}
			i++;
			
		}
		return modeloTable;}
		else {
			throw new EArrayVacio("No hay habitaciones disponibles");
		}
	}
	

	public DefaultTableModel ConsultaHabitaciones(DefaultTableModel modeloTable) throws EArrayVacio {
		if(!habitaciones.isEmpty()) {
		int i=0;
		while (i<habitaciones.size()) {
			Habitacion habitacion= habitaciones.get(i);
			String [] model = {habitacion.getID(),habitacion.getTipo(),String.valueOf(habitacion.isDisponible()),String.valueOf(habitacion.getPrecioNoche())};
			modeloTable.addRow(model);	
			i++;
		}
		return modeloTable;}
		else {
			throw new EArrayVacio("No hay Habitaciones disponibles");
		}
	}
	public Habitacion buscarHabitacion(String id) throws ECliente {
		int i =0;
		while(i<habitaciones.size()&&habitaciones.get(i).getID().compareTo(id)!=0)
			i++;
		if(i==habitaciones.size())
			throw new ECliente("Habitacion no encontrada");
		else
			return habitaciones.get(i);
		
	}
	
}
