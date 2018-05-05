package hotel;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Habitacion implements Serializable{

	private static final long serialVersionUID = -1958359261029677855L;
	private String ID,Tipo;
	private ArrayList<Date> Disponibilidad;
	
	public Habitacion(String iD, String tipo) {
		super();
		ID = iD;
		Tipo = tipo;
		Disponibilidad = new ArrayList<Date>();
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public ArrayList<Date> getDisponibilidad() {
		return Disponibilidad;
	}
	public void setDisponibilidad(ArrayList<Date> disponibilidad) {
		Disponibilidad = disponibilidad;
	}
	
	
}
