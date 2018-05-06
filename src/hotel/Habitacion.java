package hotel;

import java.sql.Date;
import java.util.ArrayList;

public class Habitacion {
	String ID,tipo;
	ArrayList<Date> disponibilidad;
	
	
	public Habitacion(String id,String tipo) {
		this.tipo=tipo;
		ID=id;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		tipo = tipo;
	}
	public ArrayList<Date> getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(ArrayList<Date> disponibilidad) {
		disponibilidad = disponibilidad;
	}
	
	
}
