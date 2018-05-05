package hotel;

import java.sql.Date;

public class Reserva {
	Date Llegada,Salida;
	Habitacion Habitacion;
	double Tarifa;
	
	
	
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
