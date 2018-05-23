package hotel;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import exception.EArrayVacio;

public class Reserva implements Serializable {
	private static final long serialVersionUID = 8428205740350054875L;
	private LocalDate date_in,date_out;
	private Habitacion habitacion;
	private double tarifa;
	
	private String idReserva;
	private static int numeroDeReservas = 0;
	
	
	public LocalDate getDate_in() {
		return date_in;
	}


	public void setDate_in(LocalDate date_in) {
		this.date_in = date_in;
	}


	public LocalDate getDate_out() {
		return date_out;
	}


	public void setDate_out(LocalDate date_out) {
		this.date_out = date_out;
	}


	public Reserva(LocalDate date_in, LocalDate date_out, Habitacion habitacion) {
		super();
		this.date_in = date_in;
		this.date_out = date_out;
		this.habitacion = habitacion;
		++numeroDeReservas;
		this.idReserva = "ABC"+numeroDeReservas;
	}
	
		
	public LocalDate getLlegada() {
		return date_in;
	}



	public void setLlegada(LocalDate llegada) {
		date_in = llegada;
	}



	public LocalDate getSalida() {
		return date_out;
	}



	public void setSalida(LocalDate salida) {
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



	public double CalcularTarifa() {
		
		Period dias ;
		
		dias =  Period.between(date_in,date_out);
		tarifa= habitacion.getPrecioNoche()*(dias.getDays());
		return tarifa;
		
	}


	public String getIdReserva() {
		return idReserva;
	}


	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}
	
	
}
