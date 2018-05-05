package hotel;

import exception.ECamposVacios;
import exception.EIgualdad;
import exception.ELongitud;
import exception.ETipoInconrrecto;

public class Administrador extends Empleado {

	
	public Administrador(String nombre, String apellido, String genero, String correo, String id, String tipoId,
			String pwd) {
		super(nombre, apellido, genero, correo, id, tipoId, pwd);
		// TODO Auto-generated constructor stub
	}
	public void addHabitacion() {
		
	}
	public void addEmpleado(String nombre, String apellido, String genero, String correo, String id, String tipoId,
			String pwd, String cpwd, String cargo , Hotel h) throws ELongitud, ECamposVacios, EIgualdad, ETipoInconrrecto {
		if (nombre.compareTo("")==0 ||apellido.compareTo("")==0 || id.compareTo("")==0 || tipoId.compareTo("")==0 
				|| pwd.compareTo("") == 0 ||cpwd.compareTo("") == 0) {
			throw new ECamposVacios();
		}else if(pwd.length()<8) {
			throw new ELongitud();
		}else if(pwd.compareTo(cpwd)!=0) {
			throw new EIgualdad();
		}else {
			switch (cargo) {
			case "Gerente":
				//h.addEmpleado(new Administrador(nombre, apellido, genero, correo, id, tipoId, pwd));
				break;
			case "Bodeguero":
				
				//h.addEmpleado(new Rece);
				break;
			default:
				throw new ETipoInconrrecto();
			}
		}
	}
	@Override
	public void addReserva() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelReserva() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editReserva() {
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

}
