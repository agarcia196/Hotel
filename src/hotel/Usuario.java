/*
 * @author Alexis Garc�a Ram�rez
 */
package hotel;

import java.util.Date;

public interface Usuario {
	
/**
 * Buscar una reserva.
 */
public Reserva buscarReserva (String id);

public void addCliente ();

/**
* Agregar reserva.
*/
public boolean addReserva(Date dateIn, Date dateOut, Habitacion habitacion);
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
 * Borrar Usuario.
 */
public void deleteUser();

}
