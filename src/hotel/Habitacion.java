package hotel;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Habitacion implements Serializable{

	private static final long serialVersionUID = -1958359261029677855L;
	private String ID,tipo;
	private ArrayList<Date> disponibilidad;
	public Habitacion(String id,String tipo) {
		this.tipo=tipo;
		ID=id;
		this.disponibilidad = new ArrayList<Date>();
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
		this.tipo = tipo;
	}
	public ArrayList<Date> getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(ArrayList<Date> disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	
}
