package hotel;

import java.io.Serializable;
import java.sql.Date;

public class Reserva implements Serializable{
	private static final long serialVersionUID = 8428205740350054875L;
	private Date Llegada,Salida;
	private Habitacion Habitacion;
	private double Tarifa;
	
		
	public Date getLlegada() {
		return Llegada;
	}



	public void setLlegada(Date llegada) {
		Llegada = llegada;
	}



	public Date getSalida() {
		return Salida;
	}



	public void setSalida(Date salida) {
		Salida = salida;
	}



	public Habitacion getHabitacion() {
		return Habitacion;
	}



	public void setHabitacion(Habitacion habitacion) {
		Habitacion = habitacion;
	}



	public double getTarifa() {
		return Tarifa;
	}



	public void setTarifa(double tarifa) {
		Tarifa = tarifa;
	}



	public void CalcularTarifa() {
		
	}

}
