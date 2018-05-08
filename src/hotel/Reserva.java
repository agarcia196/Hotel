package hotel;

import java.io.Serializable;
import java.util.Date;

public class Reserva implements Serializable{
	private static final long serialVersionUID = 8428205740350054875L;
	private Date date_in,date_out;
	private Habitacion habitacion;
	private double tarifa;
	private Cliente usuario;
	
	// Para hacer la búsqueda de una reserva
	private String idReserva;
	// Este será el id (para garantizarlo único)
	private static int numeroDeReservas = 0;
	
	public Reserva (Date in,Date out,Habitacion h, Cliente u) {
		
		date_in=in;
		date_out=out;
		habitacion=h;
		usuario=u;
		
		setIdReserva("" + numeroDeReservas++);
	}
	
		
	public Date getLlegada() {
		return date_in;
	}



	public void setLlegada(Date llegada) {
		date_in = llegada;
	}



	public Date getSalida() {
		return date_out;
	}



	public void setSalida(Date salida) {
		date_out = salida;
	}



	public Habitacion getHabitacion() {
		return habitacion;
	}



	public void setHabitacion(Habitacion habitacion) {
		habitacion = habitacion;
	}



	public double getTarifa() {
		return tarifa;
	}



	public void setTarifa(double tarifa) {
		tarifa = tarifa;
	}



	public void CalcularTarifa() {
		
	}


	public String getIdReserva() {
		return idReserva;
	}


	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}


	public Cliente getUsuario() {
		return usuario;
	}


	public void setUsuario(Cliente usuario) {
		this.usuario = usuario;
	}
	

}
