package hotel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Cliente extends Persona implements Usuario{

	private ArrayList <Reserva> reservasActivas;
	
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
	public boolean addReserva (Date dateIn, Date dateOut, Habitacion habitacion, Cliente cliente) {

		if (habitacion.verDisponibilidad(dateIn, dateOut)) {
			
			reservasActivas.add (new Reserva(dateIn, dateOut, habitacion, cliente));
			
			return true;
		} 
		
		return false;	
	}

	
	public void cancelReserva (String id) {
		
		Reserva r = buscarReserva(id);
		reservasActivas.remove(r);
		
	}

	@Override
	public boolean editReserva (String id, Date dateIn, Date dateOut, Habitacion habitacion) {

		Reserva reserva = buscarReserva (id);
		
		if (reserva != null) {
			
			reserva.setLlegada (dateIn);
			reserva.setSalida (dateOut);
			reserva.setHabitacion (habitacion);
			
			return true;
		}
		
		return false;
	}

	@Override
	public void checkReserva() {
		// TODO Auto-generated method stub
		
	}

	public void deleteUser(Cliente cliente, ArrayList<Cliente> usuario) {
	
		
		if (usuario.contains(cliente)==true) {
			int i =0;
			while(cliente.getId().compareTo(usuario.get(i).getId())!=0) {
				i++;
			}
			usuario.remove(i);
		}
		
	}

	@Override
	public Reserva buscarReserva (String id) {
		
		int i = 0;
		
		while (i < reservasActivas.size() && !reservasActivas.get(i).getIdReserva ().equals(id)) { i++; }
		
		return (i >= reservasActivas.size ()) ? null : reservasActivas.get (i);
	}
}
