/*
 * @author Alexis Garc�a Ram�rez
 */
package hotel;

import java.util.Date;

import exception.ECamposVacios;
import exception.EIgualdad;
import exception.ELongitud;
import exception.ETipoInconrrecto;

public interface Usuario {

	/**
	 * Agregar un cliente
	 */
	public void addCliente ();
	
	/**
	* Agregar reserva.
	*/
	public boolean addReserva (Date dateIn, Date dateOut, String tipo, Hotel hotel);
	/**
	 * Cancelar reserva.
	 */
	public void cancelReserva();
	/**
	 * Editar reserva.
	 */
	public boolean editReserva (String id, Date dateIn, Date dateOut, Habitacion habitacion);
	/**
	 * Verificar reserva.
	 */
	public void checkReserva();
	
	/**
	 * Métodos de búsqueda
	 */
	public Reserva buscarReserva (String id);
	public Reserva buscarReserva (Date dateIn);
	/**
	 * Borrar Usuario.
	 */
	public void deleteUser();
	public void addUser(String nombre, String apellido, String genero, String correo, String id, String tipoId,
			String pwd, String cpwd, String cargo , Hotel h)throws ELongitud, ECamposVacios, EIgualdad, ETipoInconrrecto ;

}
