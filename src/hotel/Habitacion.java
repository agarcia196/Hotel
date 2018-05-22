package hotel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import exception.EArrayVacio;

import java.util.ArrayList;

public class Habitacion implements Serializable {

	private static final long serialVersionUID = -1958359261029677855L;
	private String ID, tipo;
	private ArrayList<Reserva> disponibilidad;
	private boolean disponible;
	private double precioNoche;
	
	public Habitacion (String id, String tipo, double precioNoche) {
		this.precioNoche=precioNoche;
		this.tipo = tipo;
		ID = id;
		this.disponibilidad = new ArrayList<Reserva>();
	}
	

	
	public double getPrecioNoche() {
		return precioNoche;
	}

	public void setPrecioNoche(double precioNoche) {
		this.precioNoche = precioNoche;
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
	
	public boolean verDisponibilidad (LocalDate dateIn, LocalDate dateOut) {
		
		int i = 0;
		
		boolean disponible = true;
		
		while (i < disponibilidad.size () && disponible) {
			
			 LocalDate inOcupada = disponibilidad.get (i).getLlegada();
			 LocalDate outOcupada = disponibilidad.get (i).getSalida ();
			
			if ((dateIn.isBefore (inOcupada) && dateOut.isBefore(inOcupada)) || (dateIn.isAfter (outOcupada) && dateOut.isAfter(outOcupada))) { }
			else {disponible = false;}
			
			i++;
		}
		
		return disponible;
	}
	
	
	public DefaultTableModel printHabitaciones(DefaultTableModel modeloTable, Hotel hotel, LocalDate in) throws EArrayVacio {
		if(hotel.getHabitaciones().size()>0) {
		int i=0;
		while (i<hotel.getHabitaciones().size() ) {
			if ( hotel.getHabitaciones().get(i).buscarReserva(in)!=null) {
			String [] model = {hotel.getHabitaciones().get(i).getID(),hotel.getHabitaciones().get(i).getTipo(),
					Double.toString(hotel.getHabitaciones().get(i).getPrecioNoche())};
			modeloTable.addRow(model);
			}
			i++;
			
		}
		return modeloTable;}
		else {
			throw new EArrayVacio("No hay habitaciones disponibles");
		}
	}
	
	
	
	public Reserva buscarReserva(LocalDate localDate) {
		int i = 0;
		Reserva a = null;
		while(i<disponibilidad.size() && a==null) {
			if( disponibilidad.get(i).getDate_in().compareTo(localDate)==0) {
			 a = disponibilidad.get(i);	
		}
			i++;
		}
		return a;
	}
	
	
	public static void main (String[] args) {
		
		Habitacion habitacion = new Habitacion("310A", "VIP",1200);
		
//		ArrayList<Reserva> disponibilidad = new ArrayList<Reserva> ();
//		disponibilidad.add (new Reserva(new Date (), new Date(2018-19-00, 4, 20), habitacion));
//		
//		habitacion.setDisponibilidad (disponibilidad);
//		System.out.println (habitacion.verDisponibilidad(new Date (), new Date(2018-1900, 5, 0)));
//	}
	}
	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible (boolean disponible) {
		this.disponible = disponible;
	}
}
