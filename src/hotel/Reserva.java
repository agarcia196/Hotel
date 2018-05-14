package hotel;

import java.io.Serializable;
import java.util.Date;

public class Reserva implements Serializable {
	private static final long serialVersionUID = 8428205740350054875L;
	private Date date_in,date_out;
	private Habitacion habitacion;
	private String id;
	private double tarifa;
	
	// Para hacer la búsqueda de una reserva
	private String idReserva;
	// Este será el id (para garantizarlo único)
	private static int numeroDeReservas = 0;
	
	
	public Date getDate_in() {
		return date_in;
	}


	public void setDate_in(Date date_in) {
		this.date_in = date_in;
	}


	public Date getDate_out() {
		return date_out;
	}


	public void setDate_out(Date date_out) {
		this.date_out = date_out;
	}


	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Reserva(Date date_in, Date date_out, Habitacion habitacion, String id) {
		super();
		this.date_in = date_in;
		this.date_out = date_out;
		this.habitacion = habitacion;
		this.id = id;
		++numeroDeReservas;
		this.idReserva = "ABC"+numeroDeReservas;
	}


	public Reserva (Date in,Date out,Habitacion h) {
		
		date_in=in;
		date_out=out;
		habitacion=h;
		
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
		this.habitacion = habitacion;
	}



	public double getTarifa() {
		return tarifa;
	}



	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}



	public void CalcularTarifa() {
		
	}


	public String getIdReserva() {
		return idReserva;
	}


	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}
}
