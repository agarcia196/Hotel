package hotel;

import java.io.File;
import java.io.Serializable;

import forms.FormLogin;
import forms.FormZeroDay;

public class Main implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1379191340557782810L;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("hotel.dat");
		if(file.exists()) {
			Hotel hotel = Recursos.ReadFileObjectEmpresa("hotel.dat");
			FormLogin inicio = new FormLogin(hotel);
			inicio.setVisible(true);
		}else {
			FormZeroDay principal = new FormZeroDay();
			principal.setVisible(true);
		}
	}

}
