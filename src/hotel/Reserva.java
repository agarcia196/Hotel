package hotel;

import java.io.Serializable;
import java.sql.Date;

public class Reserva implements Serializable{
	private static final long serialVersionUID = 8428205740350054875L;
	private Date date_in,date_out;
	private Habitacion habitacion;
	private double tarifa;
	
	public Reserva(Date in,Date out,Habitacion h,double T) {
		date_in=in;
		date_out=out;
		habitacion=h;
		tarifa=T;
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

}
