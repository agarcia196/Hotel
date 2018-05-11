package hotel;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

public class Habitacion implements Serializable {

	private static final long serialVersionUID = -1958359261029677855L;
	private String ID, tipo;
	private ArrayList<Reserva> disponibilidad;
	private boolean disponible;
	
	public Habitacion (String id, String tipo) {
		
		this.tipo = tipo;
		ID = id;
		this.disponibilidad = new ArrayList<Reserva>();
	}
	
	public boolean addReserva (Reserva reserva) {
		
		
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
	
	public ArrayList<Reserva> getDisponibilidad() {
		return disponibilidad;
	}
	
	public void setDisponibilidad (ArrayList<Reserva> disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	public boolean verDisponibilidad (Date dateIn, Date dateOut) {
		
		int i = 0;
		
		boolean disponible = true;
		
		while (i < disponibilidad.size () && disponible) {
			
			Date inOcupada = disponibilidad.get (i).getLlegada() , outOcupada = disponibilidad.get (i).getSalida ();
			
			if ((dateIn.before (inOcupada) && dateOut.before(inOcupada)) || (dateIn.after (outOcupada) && dateOut.after(outOcupada))) { }
			else {disponible = false;}
			
			i++;
		}
		
		return disponible;
	}
	
	public static void main (String[] args) {
		
		Habitacion habitacion = new Habitacion("310A", "VIP");
		
		ArrayList<Reserva> disponibilidad = new ArrayList<Reserva> ();
		disponibilidad.add (new Reserva(new Date (), new Date(2018-1900, 4, 20), habitacion));
		
		habitacion.setDisponibilidad (disponibilidad);
		System.out.println (habitacion.verDisponibilidad(new Date (), new Date(2018-1900, 5, 0)));
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible (boolean disponible) {
		this.disponible = disponible;
	}
}
