/*
 * @author Alexis García Ramírez
 */
package hotel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.PriorityQueue;

import exception.ECamposVacios;
import exception.ECocina;
import exception.ELetrasEnCampoN;

public class Cocina implements Serializable {

	private static final long serialVersionUID = 7911124575383121936L;
	private PriorityQueue<Plato>cola_servicios;
	private ArrayList<Plato> menu;
	
	public static void main(String[] args) {
		Cocina c = new Cocina();
		try {
			c.addPlato("Bandeja paisa", true, "80", "80.50");
			c.addPlato("Ajiaco", true, "90", "80");
			System.out.println(c.getMenu());
			c.addCola("Bandeja paisa");
			c.addCola("Bandeja paisa");
			c.addCola("Ajiaco");
			System.out.println("Cola "+c.getCola_servicios());
		} catch (ECamposVacios | ELetrasEnCampoN | ECocina e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	public Cocina(PriorityQueue<Plato> cola_servicios, ArrayList<Plato> menu) {
		super();
		this.cola_servicios = new PriorityQueue<Plato>();
		this.menu = new ArrayList<Plato>();
	}
	
	public Cocina() {
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
	
	public boolean addPlato(String nombre, boolean disponibilidad, String duracion, String valor) throws ECamposVacios, ELetrasEnCampoN {
		if(nombre.compareTo("")==0||duracion.compareTo("")==0||valor.compareTo("")==0) {
			throw new ECamposVacios();
		}else if(!Recursos.isNumeric(duracion)&&!Recursos.isNumeric(valor)) {
			throw new ELetrasEnCampoN();
		}else {
			Plato p = new Plato(nombre, disponibilidad, Double.parseDouble(duracion), Double.parseDouble(valor));
			return menu.add(p);
		}
					
		
	}
	public boolean removePlato(String nombredeplato) throws ECocina {
			return menu.remove(buscarPlato(nombredeplato));
	}
	
	public Plato buscarPlato(String nombredeplato) throws ECocina {
		int i=0;
		while (i<menu.size()&&menu.get(i).getNombre().compareTo(nombredeplato)!=0)
			i++;
		if(i==menu.size())
			throw new ECocina("No se encontro el plato");
		else {
			return menu.get(i);
		}
	}
	public boolean addCola(String nombredeplato) throws ECocina {
		return cola_servicios.add(buscarPlato(nombredeplato));
	}
	public Plato despacharPlato() {
		
		return cola_servicios.poll();
	}
	
}
