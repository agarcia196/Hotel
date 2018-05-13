/*
 * @author Alexis García Ramírez
 */
package hotel;

import java.io.Serializable;

public class Plato implements Comparable<Plato>, Serializable {

	private static final long serialVersionUID = -2580818623849027985L;
	private String nombre;
	private Double duracion;
	private boolean disponibilidad;
	private double valor;
		
	public Plato(String nombre, boolean disponibilidad, Double duracion, double valor) {
		super();
		this.nombre = nombre;
		this.disponibilidad = disponibilidad;
		this.duracion = duracion;
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}
	
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(Double duracion) {
		this.duracion = duracion;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return "Plato [nombre=" + nombre + ", duracion=" + duracion + ", disponibilidad=" + disponibilidad + ", valor="
				+ valor + "]";
	}

	@Override
	public int compareTo(Plato arg0) {
		// TODO Auto-generated method stub
		return (duracion.compareTo(arg0.getDuracion())>0)?-1:(duracion.compareTo(arg0.getDuracion())<0)? 1:0;
	}

}
