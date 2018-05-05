/*
 * @author Alexis García Ramírez
 */
package hotel;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Cocina {
	private PriorityQueue<Plato>cola_servicios;
	private ArrayList<Plato> menu;
	
	public Cocina(PriorityQueue<Plato> cola_servicios, ArrayList<Plato> menu) {
		super();
		this.cola_servicios = new PriorityQueue<Plato>();
		this.menu = new ArrayList<Plato>();
	}

	public PriorityQueue<Plato> getCola_servicios() {
		return cola_servicios;
	}

	public void setCola_servicios(PriorityQueue<Plato> cola_servicios) {
		this.cola_servicios = cola_servicios;
	}

	public ArrayList<Plato> getMenu() {
		return menu;
	}

	public void setMenu(ArrayList<Plato> menu) {
		this.menu = menu;
	}
	
	public void addPlato(Plato plato) {
		
	}
	public void removePlato() {
		
	}
	public void addCola() {
		
	}
	public void despacharPlato() {
		
	}
	
}
