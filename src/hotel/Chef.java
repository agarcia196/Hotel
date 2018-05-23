package hotel;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import exception.EArrayVacio;
import exception.ECocina;


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

}
