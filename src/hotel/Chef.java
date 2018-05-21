package hotel;

import java.io.Serializable;
import java.util.Date;
import exception.ECamposVacios;
import exception.EIgualdad;
import exception.ELongitud;
import exception.ETipoInconrrecto;
import exception.ExceptionNodo;

public class Chef extends Empleado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3345700466006234852L;

	public Chef(String nombre, String apellido, String genero, String correo, String id, String tipoId, String pwd) {
		super(nombre, apellido, genero, correo, id, tipoId, pwd);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addUser(String nombre, String apellido, String genero, String correo, String id, String tipoId,
			String pwd, String cpwd, String cargo, Hotel h)
			throws ELongitud, ECamposVacios, EIgualdad, ETipoInconrrecto, ExceptionNodo {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(Cliente cliente, Hotel h) throws ExceptionNodo {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addReserva(Date dateIn, Date dateOut, String tipo, Hotel hotel) {
		// TODO Auto-generated method stub
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
	public Reserva buscarReserva(Date dateIn) {
		// TODO Auto-generated method stub
		return null;
	}

}
