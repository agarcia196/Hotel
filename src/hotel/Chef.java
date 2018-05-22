package hotel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import exception.EArrayVacio;
import exception.ECamposVacios;
import exception.ECocina;
import exception.EIgualdad;
import exception.ELongitud;
import exception.ETipoInconrrecto;
import exception.ExceptionNodo;

public class Chef extends Empleado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3345700466006234852L;

	public Chef(String nombre, String apellido, String genero, String correo, String id, String tipoId, String pwd) {
		super(nombre, apellido, genero, correo, id, tipoId, pwd);
		// TODO Auto-generated constructor stub
	}
		
	public boolean despachar(String id_pedido,Hotel hotel) throws EArrayVacio {
		return hotel.getCocina().despacharPlato(id_pedido); 
	}
	public void finalizarPedido(Cliente reserva,ArrayList<Plato> platos,Hotel hotel) throws ECocina {
		if(!platos.isEmpty()&& reserva!=null) {
			Pedido pedido = new Pedido(reserva, platos);
			addCola(pedido, hotel.getCocina());
		}else {
			throw new ECocina("Faltan datos");
		}
	}
	
	private boolean addCola(Pedido p,Cocina cocina) throws ECocina {
		return cocina.addCola(p);
	}
	
	public DefaultTableModel consultarCola(DefaultTableModel modeloTable,Hotel hotel) throws EArrayVacio {
		return 	hotel.getCocina().consultaCola(modeloTable);
	}
	
	@Override
	public void addUser(String nombre, String apellido, String genero, String correo, String id, String tipoId,
			String pwd, String cpwd, String cargo, Hotel h)
			throws ELongitud, ECamposVacios, EIgualdad, ETipoInconrrecto, ExceptionNodo {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(Cliente cliente, Hotel h) throws ExceptionNodo {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addReserva(LocalDate dateIn, LocalDate dateOut, String tipo, Hotel hotel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cancelReserva() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean editReserva(String id, LocalDate dateIn, LocalDate dateOut, Habitacion habitacion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void checkReserva() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Reserva buscarReserva(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reserva buscarReserva(LocalDate dateIn) {
		// TODO Auto-generated method stub
		return null;
	}

}
