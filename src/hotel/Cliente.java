package hotel;

import java.util.ArrayList;
import java.util.Date;

public class Cliente extends Persona implements Usuario{

	public ArrayList <Reserva> reservasActivas;
	
	//Constructors
	
	public Cliente(String nombre, String apellido, String genero, String correo, String id, String tipoId, String pwd) {
		super(nombre, apellido, genero, correo, id, tipoId, pwd); 
		
	}
	
	
	//Gets y sets
	public ArrayList<Reserva> getReservasActivas() {
		return reservasActivas;
	}

	public void setReservasActivas(ArrayList<Reserva> reservasActivas) {
		this.reservasActivas = reservasActivas;
	}
	
	
	//METODOS DE LA INTERFACE USUARIO


	@Override
	public void addReserva() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelReserva() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editReserva() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkReserva() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
		
	}
}
