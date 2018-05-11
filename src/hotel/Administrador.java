/*
 * @author Alexis García Ramírez
 */
package hotel;

import java.io.Serializable;
import java.util.Date;

import exception.ECamposVacios;
import exception.EIgualdad;
import exception.ELongitud;
import exception.ETipoInconrrecto;

public class Administrador extends Empleado implements Serializable {

	private static final long serialVersionUID = -3017452336359703718L;

	public Administrador(String nombre, String apellido, String genero, String correo, String id, String tipoId,
			String pwd) {
		super(nombre, apellido, genero, correo, id, tipoId, pwd);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Agregar habitación.
	 *
	 * @param iD  número de la habitación
	 * @param tipo Categoría de habitación;
	 * @param h El hotel
	 * @throws ECamposVacios the e campos vacíos
	 */
	public void addHabitacion(String iD, String tipo,Hotel h) throws ECamposVacios {
		if (iD.compareTo("")==0 ||tipo.compareTo("")==0) {
			throw new ECamposVacios();
		}
		else {
			h.addHabitacion(new Habitacion(iD, tipo));
		}
	}
	
	/**
	 * Agregar Usuario al sistema.
	 *
	 * @param nombre El nombre
	 * @param apellido El apellido
	 * @param genero El genero
	 * @param correo  El correo
	 * @param id El número de cédula
	 * @param tipoId El tipo de cédula
	 * @param pwd La contraseña
	 * @param cpwd La confirmación de contraseña
	 * @param cargo El cargo
	 * @param h El hotel
	 * @throws ELongitud the e longitud
	 * @throws ECamposVacios the e campos vacíos
	 * @throws EIgualdad the e igualdad
	 * @throws ETipoInconrrecto the e tipo incorrecto
	 */
	@Override
	public void addUser(String nombre, String apellido, String genero, String correo, String id, String tipoId,
			String pwd, String cpwd, String cargo , Hotel h) throws ELongitud, ECamposVacios, EIgualdad, ETipoInconrrecto {
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
			default:
				throw new ETipoInconrrecto();
			}
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
	public void deleteUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Reserva buscarReserva(String id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean editReserva(String id, Date dateIn, Date dateOut, Habitacion habitacion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addReserva(Date dateIn, Date dateOut, Habitacion habitacion, Cliente usuario) {
		// TODO Auto-generated method stub
		return false;
	}

}
