package hotel;

import java.util.ArrayList;
import java.util.Date;

import exception.ECamposVacios;
import exception.ECliente;
import exception.EIgualdad;
import exception.ELongitud;
import exception.ETipoInconrrecto;
import exception.ExceptionNodo;

public class Recepcion extends Empleado   {
	

	
	private static final long serialVersionUID = 3300864296393909387L;
	public Recepcion (String nombre, String apellido, String genero, String correo, String id, String tipoId,String pwd) {
		super(nombre, apellido, genero, correo, id, tipoId, pwd);
	}
	
	public void checkIn (String cedula, Hotel hotel) throws ECliente, ExceptionNodo {
		
		super.checkIn (cedula, hotel);
	}
	
	public void checkOut (String cedula, Hotel hotel) throws ECliente {
		super.checkOut(cedula, hotel);
	}


	@Override
	public boolean addReserva(Date dateIn, Date dateOut, String tipo, Hotel hotel) {

		return false;
	}


	@Override
	public void cancelReserva() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean editReserva(String id, Date dateIn, Date dateOut, Habitacion habitacion) {
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


	@Override
	public void addUser(String nombre, String apellido, String genero, String correo, String id, String tipoId,
			String pwd, String cpwd, String cargo, Hotel h)
			throws ELongitud, ECamposVacios, EIgualdad, ETipoInconrrecto {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Reserva buscarReserva(Date dateIn) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	@Override
	public void deleteUser(Cliente cliente, Hotel h) throws ExceptionNodo {
		// TODO Auto-generated method stub
		
	}	
}
