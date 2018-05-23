package hotel;

import java.io.Serializable;
import java.time.LocalDate;
import exception.ECamposVacios;
import exception.ECliente;
import exception.EIgualdad;
import exception.ELongitud;
import exception.ETipoInconrrecto;
import exception.ExceptionNodo;

public class Recepcion extends Empleado implements Serializable{
	
	
	
	private static final long serialVersionUID = 3300864296393909387L;
	
	public Recepcion (String nombre, String apellido, String genero, String correo, String id, String tipoId,String pwd) {
		super(nombre, apellido, genero, correo, id, tipoId, pwd);
	}
	
	public void checkIn (String cedula, Hotel hotel) throws ECliente, ExceptionNodo {
		
		super.checkIn (cedula, hotel);
	}
	
	public double checkOut (String cedula, String idReserva, Hotel hotel) throws ECliente, ExceptionNodo {
		
		return super.checkOut (cedula, idReserva, hotel);
	}


	@Override
	
	public boolean addReserva (LocalDate dateIn, LocalDate dateOut, String tipo, Hotel hotel, Cliente cliente) {

		int i = 0;
		
		while (i < hotel.getHabitaciones ().size () && (hotel.getHabitaciones().get(i).getTipo() != tipo || !hotel.getHabitaciones().get (i).isDisponible ())) {
			
			i++;
		}
		
		if (i >= hotel.getHabitaciones ().size ()) {
			
			return false;
		} else {
			
			
			cliente.addReserva(dateIn, dateOut, tipo, hotel);
			
			return true;
		}
	}


	@Override
	public void cancelReserva() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean editReserva(String id, LocalDate dateIn, LocalDate dateOut, Habitacion habitacion) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void checkReserva() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Reserva buscarReserva(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addUser(String nombre, String apellido, String genero, String correo, String id, String tipoId,
			String pwd, String cpwd, String cargo, Hotel h)
			throws ELongitud, ECamposVacios, EIgualdad, ETipoInconrrecto, ExceptionNodo{
		Recursos.validarCamposVaciosU(nombre, apellido, genero, correo, id, tipoId, pwd, cpwd, cargo);
		Recursos.validarLongitudPwd(cpwd);
		Recursos.validarIgualdadPwd(pwd, cpwd);
		if(cargo=="Cliente") {
		h.addUser(new Cliente(nombre, apellido, genero, correo, id, tipoId, cpwd));}
		else {
				throw new ETipoInconrrecto();}
}
	



	@Override
	public Reserva buscarReserva(LocalDate dateIn) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	@Override
	public void deleteUser(Cliente cliente, Hotel h) throws ExceptionNodo {
		// TODO Auto-generated method stub
		
	}	
}
