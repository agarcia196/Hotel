package hotel;

import java.io.Serializable;
import java.util.Date;

import exception.ECliente;
import exception.ExceptionNodo;

public abstract class Empleado extends Persona implements Usuario, Serializable {

	private static final long serialVersionUID = 8181518522862120375L;
	public Empleado(String nombre, String apellido, String genero, String correo, String id, String tipoId,
			String pwd) {
		super(nombre, apellido, genero, correo, id, tipoId, pwd);
		// TODO Auto-generated constructor stub
	}

	public void checkIn (String cedula, Hotel hotel) throws ECliente, ExceptionNodo {
		
		Cliente cliente = hotel.buscarCliente (cedula);
		
		if (cliente != null) {
			
			Date hoy = new Date ();
			Reserva reserva = cliente.buscarReserva (hoy);
			
			if (reserva != null) {
				
				reserva.getHabitacion ().setDisponible (false);
			} else {
				
				throw new ECliente ("No existe una reserva activa para el día actual: " + hoy.toString ());
			}
		} else {
			
			throw new ECliente ("No existe un cliente asociado a la cédula: " + cedula);
		}
	}
	
	
	
	
	public void checkOut () {
		
		
	}
}
