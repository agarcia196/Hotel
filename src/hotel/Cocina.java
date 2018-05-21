/*
 * @author Alexis García Ramírez
 */
package hotel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.PriorityQueue;

import javax.swing.table.DefaultTableModel;

import exception.EArrayVacio;
import exception.ECamposVacios;
import exception.ECocina;
import exception.ELetrasEnCampoN;

public class Cocina implements Serializable {

	private static final long serialVersionUID = 7911124575383121936L;
	private PriorityQueue<Pedido>cola_servicios;
	private ArrayList<Plato> menu;
	
	public static void main(String[] args) {
		Cocina c = new Cocina();
		try {
			c.addPlato("Bandeja paisa", "No", "80", "80.50");
			c.addPlato("Ajiaco", "Sí", "90", "80");
			System.out.println(c.getMenu());
			System.out.println("Cola "+c.getCola_servicios());
		} catch (ECamposVacios | ELetrasEnCampoN e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	public Cocina(PriorityQueue<Pedido> cola_servicios, ArrayList<Plato> menu) {
		super();
		this.cola_servicios = new PriorityQueue<Pedido>();
		this.menu = new ArrayList<Plato>();
	}
	
	public Cocina() {
		super();
		this.cola_servicios = new PriorityQueue<Pedido>();
		this.menu = new ArrayList<Plato>();
	}
	public PriorityQueue<Pedido> getCola_servicios() {
		return cola_servicios;
	}

	public void setCola_servicios(PriorityQueue<Pedido> cola_servicios) {
		this.cola_servicios = cola_servicios;
	}

	public ArrayList<Plato> getMenu() {
		return menu;
	}

	public void setMenu(ArrayList<Plato> menu) {
		this.menu = menu;
	}
	
	public boolean addPlato(String nombre, String disponibilidad, String duracion, String valor) throws ECamposVacios, ELetrasEnCampoN {
		if(nombre.compareTo("")==0||duracion.compareTo("")==0||valor.compareTo("")==0) {
			throw new ECamposVacios();
		}else if(!Recursos.isNumeric(duracion)&&!Recursos.isNumeric(valor)) {
			throw new ELetrasEnCampoN();
		}else {
			Plato p = new Plato(nombre, (disponibilidad=="Sí")?true:false, Double.parseDouble(duracion), Double.parseDouble(valor));
			return menu.add(p);
		}
	}
	public void editPlato(String disponibilidad, String duracion, String valor,Plato p) throws ECamposVacios, ELetrasEnCampoN, ECocina {
		if(duracion.compareTo("")==0||valor.compareTo("")==0) {
			throw new ECamposVacios();
		}else if(!Recursos.isNumeric(duracion)&&!Recursos.isNumeric(valor)) {
			throw new ELetrasEnCampoN();
		}else {
			p.setDisponibilidad((disponibilidad=="Sí")?true:false);
			p.setDuracion(Double.parseDouble(duracion));
			p.setValor(Double.parseDouble(valor));
		}
	}
	public boolean removePlato(Plato nombredeplato) throws ECocina {
			return menu.remove(nombredeplato);
	}
	//"Id ", "Nombre", "Platos","Posición"
	public DefaultTableModel consultaCola(DefaultTableModel modeloTable) throws EArrayVacio {
		if(cola_servicios.size()>0) {
			Iterator<Pedido> lista =cola_servicios.iterator();
			int i=1;
			while (lista.hasNext()) {
				Pedido pedido= lista.next();
				String [] model = {String.valueOf(pedido.getId()),pedido.getCliente().getNombre(),pedido.getPlatos().toString(),String.valueOf(i)};
				i++;
				modeloTable.addRow(model);	
			}
			return modeloTable;
		}else {
			throw new EArrayVacio("No hay pedidos en cola");
		}
	}
	public DefaultTableModel printMenu(DefaultTableModel modeloTable) throws EArrayVacio {
		if(menu.size()>0) {
		int i=0;
		while (i<menu.size()) {
			String [] model = {menu.get(i).getNombre(),Boolean.toString(menu.get(i).isDisponibilidad()),
					Double.toString(menu.get(i).getDuracion()),Double.toString(menu.get(i).getValor())};
			modeloTable.addRow(model);	
			i++;
		}
		return modeloTable;}
		else {
			throw new EArrayVacio("No hay platos disponibles en el menú");
		}
	}
	
	public String [] printMenu(int i) throws EArrayVacio {
		if(menu.size()>0) {
		String [] model = {menu.get(i).getNombre(),Boolean.toString(menu.get(i).isDisponibilidad()),
				Double.toString(menu.get(i).getDuracion()),Double.toString(menu.get(i).getValor())};
		return model;
		}else {
			throw new EArrayVacio("No hay platos disponibles en el menu");
		}
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
	
	public boolean addCola(Pedido p) throws ECocina {
		return cola_servicios.add(p);
	}
	public Pedido despacharPlato() {
		
		return cola_servicios.poll();
	}
	
}
