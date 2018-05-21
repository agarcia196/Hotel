package hotel;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Comparable<Pedido>,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4557397842131081670L;
	private int id;
	private Cliente cliente;
	private ArrayList<Plato> platos;
	private Double tiempo;
	private Double costo;
	private static int count=0;
	public Pedido(Cliente cliente, ArrayList<Plato> platos) {
		super();
		this.id = ++count;
		this.cliente = cliente;
		this.platos = platos;
		this.tiempo = calcularTiempo(platos);
		this.costo = calcularCosto(platos);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public ArrayList<Plato> getPlatos() {
		return platos;
	}
	public void setPlatos(ArrayList<Plato> platos) {
		this.platos = platos;
	}
	public double getTiempo() {
		return tiempo;
	}
	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	private double calcularTiempo(ArrayList<Plato> p) {
		double tiempo=0;
		for (Plato plato : p) {
			tiempo+=plato.getDuracion();
		}
		return tiempo;		
	}
	private double calcularCosto(ArrayList<Plato> p) {
		double Valor=0;
		for (Plato plato : p) {
			tiempo+=plato.getValor();
		}
		return Valor;		
	}
	@Override
	public String toString() {
		return "Pedido :" + id + ", cliente:" + cliente + ", platos:" + platos;
	}
	@Override
	public int compareTo(Pedido arg0) {
		// TODO Auto-generated method stub
		return (tiempo.compareTo(arg0.getTiempo())<0)?-1:(tiempo.compareTo(arg0.getTiempo())>0)? 1:0 ;
	}

}
