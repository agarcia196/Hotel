/*
 * @author Alexis Garc�a Ram�rez
 */
package hotel;

public class Plato implements Comparable<Plato> {
	private String nombre;
	private boolean disponibilidad;
	private double duracion;
	private double valor;
		
	public Plato(String nombre, boolean disponibilidad, double duracion, double valor) {
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

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public int compareTo(Plato o) {
		// TODO Auto-generated method stub
		return 0;
	}

}