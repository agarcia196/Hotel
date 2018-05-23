package hotel;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import exception.ECliente;
import exception.ExceptionNodo;

public abstract class Empleado extends Persona implements Serializable {

	private static final long serialVersionUID = 8181518522862120375L;
	public Empleado(String nombre, String apellido, String genero, String correo, String id, String tipoId,
			String pwd) {
		super(nombre, apellido, genero, correo, id, tipoId, pwd);
		// TODO Auto-generated constructor stub
	}

	public void checkIn (String cedula, Hotel hotel) throws ECliente, ExceptionNodo {
		
		Cliente cliente = hotel.buscarCliente (cedula);
		
		if (cliente != null) {
			
			LocalDate hoy = LocalDate.now();
			Reserva reserva = cliente.buscarReserva (hoy);
			
			if (reserva != null) {
				
				reserva.getHabitacion ().setDisponible (false);
			} else {
				
				throw new ECliente ("No existe una reserva activa para el d√≠a actual: " + hoy.toString ());
			}
		} else {
			
			throw new ECliente ("No existe un cliente asociado a la c√©dula: " + cedula);
		}
	}
	
	
	
	
	public void checkOut (String cedula, Hotel hotel) throws ECliente, ExceptionNodo{
		
		Cliente cliente = hotel.buscarCliente(cedula);
		
		if (cliente != null) {
			
			LocalDate hoy = LocalDate.now();
			
			Reserva reserva = cliente.buscarReserva(hoy.toString());
			LocalDate out = LocalDate.parse(reserva.getSalida().toString());
			
			if (hoy.compareTo(out)<=0 ) {
				reserva.getHabitacion().setDisponible(true);
			} else {
				Period period = Period.between(out,hoy);
				throw new ECliente("El cliente se pasÛ de la fecha establecida por "+ period + "dÌas" );
			}
		}else {
			throw new ECliente ("No existe un cliente asociado a la c√©dula: " + cedula);
		}
		
		
	}
	public String getActivo(boolean A) {
		A=isActivo();
		if(A==true) {
			return "Activa";
		}else {
			return "Inactiva";
		}
	}
	
	public void addEmpleado(Persona c) {
		// TODO Auto-generated method stub
		
	}

	public void addUser(Cliente c) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean addReserva(LocalDate dateIn, LocalDate dateOut, String ID, Hotel hotel, String cedula) throws ExceptionNodo {
		Cliente cliente;
		
		cliente = hotel.buscarCliente(cedula);
		
		cliente.addReserva(dateIn, dateOut, ID, hotel);
		return false;
	}
}
