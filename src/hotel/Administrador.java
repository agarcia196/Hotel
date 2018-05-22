/*
 * @author Alexis Garc�a Ram�rez
 */
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

public class Administrador extends Empleado implements Serializable {

	private static final long serialVersionUID = -3017452336359703718L;

	public Administrador(String nombre, String apellido, String genero, String correo, String id, String tipoId,
			String pwd) {
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
	/**
	 * Agregar habitaci�n.
	 *
	 * @param iD  n�mero de la habitaci�n
	 * @param tipo Categor�a de habitaci�n;
	 * @param h El hotel
	 * @throws ECamposVacios the e campos vac�os
	 */
	public void addHabitacion(String iD, String tipo,Hotel h, double costo) throws ECamposVacios {
		if (iD.compareTo("")==0 ||tipo.compareTo("")==0) {
			throw new ECamposVacios();
		}
		else {
			h.addHabitacion(new Habitacion(iD, tipo, costo));
		}
	}
	
	/**
	 * Agregar Usuario al sistema.
	 *
	 * @param nombre El nombre
	 * @param apellido El apellido
	 * @param genero El genero
	 * @param correo  El correo
	 * @param id El n�mero de c�dula
	 * @param tipoId El tipo de c�dula
	 * @param pwd La contrase�a
	 * @param cpwd La confirmaci�n de contrase�a
	 * @param cargo El cargo
	 * @param h El hotel
	 * @throws ELongitud the e longitud
	 * @throws ECamposVacios the e campos vac�os
	 * @throws EIgualdad the e igualdad
	 * @throws ETipoInconrrecto the e tipo incorrecto
	 * @throws ExceptionNodo 
	 */
	@Override
	public void addUser(String nombre, String apellido, String genero, String correo, String id, String tipoId,
			String pwd, String cpwd, String cargo , Hotel h) throws ELongitud, ECamposVacios, EIgualdad, ETipoInconrrecto, ExceptionNodo {
			Recursos.validarCamposVaciosU(nombre, apellido, genero, correo, id, tipoId, pwd, cpwd, cargo);
			Recursos.validarLongitudPwd(cpwd);
			Recursos.validarIgualdadPwd(pwd, cpwd);
			switch (cargo) {
			case "Administrador":
				h.addEmpleado(new Administrador(nombre, apellido, genero, correo, id, tipoId, pwd));
				break;
			case "Recepcion":
				h.addEmpleado(new Recepcion(nombre, apellido, genero, correo, id, tipoId, cpwd));
				break;
			case "Cliente":
				h.addUser(new Cliente(nombre, apellido, genero, correo, id, tipoId, cpwd));
				break;
			case "Chef":
				h.addEmpleado(new Chef(nombre, apellido, genero, correo, id, tipoId, cpwd));
				break;
			default:
				throw new ETipoInconrrecto();
			}
	}
	
	public void editUser(String nombre, String apellido, String genero, String correo, String id,
			String pwd, String cpwd, Hotel h,Persona c, int ind) throws ECamposVacios, EIgualdad, ELongitud {
		Recursos.validarCamposVaciosU(nombre, apellido, genero, correo, id, pwd, cpwd);
		Recursos.validarLongitudPwd(cpwd);
		Recursos.validarIgualdadPwd(pwd, cpwd);
		c.setNombre(nombre);
		c.setApellido(apellido);
		c.setCorreo(correo);
		c.setPwd(cpwd);
	}
	

	@Override
	public void cancelReserva() {
		// TODO Auto-generated method stub
		
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
	public boolean editReserva(String id, LocalDate dateIn, LocalDate dateOut, Habitacion habitacion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addReserva(LocalDate dateIn, LocalDate dateOut, String tipo, Hotel hotel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reserva buscarReserva(LocalDate dateIn) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void deleteUser(Cliente cliente, Hotel h) throws ExceptionNodo {
		// TODO Auto-generated method stub
		
	}

}
