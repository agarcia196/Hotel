package hotel;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import exception.ECamposVacios;
import exception.ECliente;
import exception.EIgualdad;
import exception.ELongitud;
import exception.ExceptionNodo;

public abstract class Empleado extends Persona implements Serializable {

	private static final long serialVersionUID = 8181518522862120375L;
	public Empleado(String nombre, String apellido, String genero, String correo, String id, String tipoId,
			String pwd) {
		super(nombre, apellido, genero, correo, id, tipoId, pwd);
		// TODO Auto-generated constructor stub
	}

	public void checkIn (String cedula, Hotel hotel) throws ECliente, ExceptionNodo {
		
		Reserva reserva = hotel.buscarReserva(cedula, LocalDate.now ());
		
		reserva.getHabitacion ().setDisponible (false);
	}
	
	
	
	
	@Override
	public void editarUsuario(String nombre, String apellido, String genero, String correo, String id, String pwd,
			String cpwd, Hotel h, Persona c) throws ECamposVacios, EIgualdad, ELongitud {
		c.setNombre(nombre);
		c.setCorreo(correo);
		c.setApellido(apellido);
		c.setCorreo(correo);
		c.setId(id);
		c.setPwd(cpwd);
	}

	public double checkOut (String cedula, String idReserva, Hotel hotel) throws ECliente, ExceptionNodo {
		
		Cliente cliente =  hotel.buscarCliente (cedula);
		
		if (cliente != null) {
			Reserva reserva = cliente.buscarReserva (idReserva);
			
			if (reserva != null) {
				Period diasRecargo = Period.between(reserva.getSalida (), LocalDate.now ());
				
				reserva.setTarifa (reserva.getTarifa () + diasRecargo.getDays() * reserva.getHabitacion().getPrecioNoche ());
				
				double tarifaTotal = reserva.getTarifa ();
				
				cliente.getReservasActivas().remove (reserva);
				cliente.getHistorialReservas().add(reserva);
				
				return tarifaTotal;
			} else {

				throw new ECliente ("El cliente con cédula " + cedula + " no tiene ninguna reserva con ID: " + idReserva);
			}
		} else { 
			
			throw new ECliente ("No existe un cliente asociado a la cédula " + cedula);
		}
	}
	
		
	public boolean addReserva(LocalDate dateIn, LocalDate dateOut, String ID, Hotel hotel, String cedula) throws ExceptionNodo {
		
		Cliente cliente;
		
		cliente = hotel.buscarCliente(cedula);
		
		cliente.addReserva(dateIn, dateOut, ID, hotel);
		
		return false;
	}
}
