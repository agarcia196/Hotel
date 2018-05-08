package hotel;

import java.util.Date;

public class Recepcion extends Empleado   {
	

	
	private static final long serialVersionUID = 3300864296393909387L;
	public Recepcion (String nombre, String apellido, String genero, String correo, String id, String tipoId,String pwd) {
		super(nombre, apellido, genero, correo, id, tipoId, pwd);
	}
	
	
	public void checkIn(String id, Hotel h,Date dateIn, Date dateOut, Habitacion habitacion) {
		if (h.buscarReserva(id)==null) {
			addCliente();
			addReserva( dateIn,  dateOut,  habitacion,  usuario);
			
		}
		
		
		
		// preguntar si tiene reservaactiva sino addCLiente, addReserva (buscar habitacion disponible )
		
		
	}
	
	public void checkOut() {
		
	}




	@Override
	public void addCliente() {
		// TODO Auto-generated method stub
	
	}


	@Override
	public boolean addReserva(Date dateIn, Date dateOut, Habitacion habitacion, Cliente usuario) {
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
	public void deleteUser() {
		// TODO Auto-generated method stub
		
	}


	
	

	
	

	
	
	
}
