package hotel;


import java.util.ArrayList;
import java.util.Date;

import arbol.NodoB;
import exception.ECamposVacios;
import exception.EIgualdad;
import exception.ELongitud;
import exception.ETipoInconrrecto;
import exception.ExceptionNodo;

public class Cliente extends Persona implements Usuario,Comparable<Cliente> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7178957623346929138L;
	private ArrayList <Reserva> reservasActivas;
	private ArrayList<Reserva> historialReservas;
	
	//Constructors
	
	public Cliente(String cedula) {
		super(cedula);
		reservasActivas=null;
		historialReservas=null;
	}
	
	public Cliente (String nombre, String apellido, String genero, String correo, String id, String tipoId, String pwd) {
		
		super (nombre, apellido, genero, correo, id, tipoId, pwd);
		reservasActivas = new ArrayList<Reserva>();
		historialReservas = new ArrayList<Reserva>();
	}
	
	
	//Gets y sets
	public ArrayList<Reserva> getReservasActivas () {
		
		return reservasActivas;
	}

	public void setReservasActivas (ArrayList<Reserva> reservasActivas) {
		
		this.reservasActivas = reservasActivas;
	}
	
	
	//METODOS DE LA INTERFACE USUARIO


	@Override
	public boolean addReserva (Date dateIn, Date dateOut, String tipo, Hotel hotel) {

		int i = 0;
		
		while (i < hotel.getHabitaciones ().size () && (hotel.getHabitaciones().get(i).getTipo() != tipo || !hotel.getHabitaciones().get (i).isDisponible ())) {
			
			i++;
		}
		
		if (i >= hotel.getHabitaciones ().size ()) {
			
			return false;
		} else {
			
			reservasActivas.add (new Reserva (dateIn, dateOut, hotel.getHabitaciones ().get(i)));
			
			return true;
		}
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

		
	}

	@Override
	public void deleteUser(Cliente cliente, Hotel h ) throws ExceptionNodo {
	
		NodoB<Cliente> c= h.getUsuarios().buscar(cliente) ;
		if (c !=null) {
//			int i =0;
//			while(cliente.getId().compareTo(usuarios.get(i).getId())!=0) {
//				i++;
//			}
//			usuarios.remove(i);
			h.getUsuarios().eliminar(cliente);
			
		}
		
	}

	@Override
	public Reserva buscarReserva (String id) {
		
		int i = 0;
		
		while (i < reservasActivas.size() && !reservasActivas.get(i).getIdReserva ().equals(id)) { i++; }
		
		return (i >= reservasActivas.size ()) ? null : reservasActivas.get (i);
	}

	

	@Override
	public void addUser(String nombre, String apellido, String genero, String correo, String id, String tipoId,
			String pwd, String cpwd, String cargo, Hotel h)
			throws ELongitud, ECamposVacios, EIgualdad, ETipoInconrrecto {
		
		
	}


	public ArrayList<Reserva> getHistorialReservas() {
		return historialReservas;
	}


	public void setHistorialReservas (ArrayList<Reserva> historialReservas) {
		this.historialReservas = historialReservas;
	}



	@Override
	public Reserva buscarReserva (Date dateIn) {
		
		int i = 0;
		
		while (i < reservasActivas.size () && dateIn.compareTo (reservasActivas.get (i).getLlegada ()) != 0) { i++; }
		
		if (i < reservasActivas.size ()) {
			
			return reservasActivas.get (i);
		}
		
		return null;
	}


	@Override
	public void cancelReserva() {
		// TODO Auto-generated method stub
		
		Reserva r = buscarReserva(id);
		reservasActivas.remove(r);
		
		
	}


	

	@Override
	public String toString() {
		return "Cliente " + super.toString();
	}

	

	@Override
	public int compareTo(Cliente a) {
		// TODO Auto-generated method stub
		return this.getId().compareTo(a.getId());
	}
}
