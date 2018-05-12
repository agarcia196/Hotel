package hotel;

import java.io.File;

import forms.FormLogin;
import forms.FormZeroDay;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("hotel.dat");
		if(file.exists()) {
			Hotel hotel = new Hotel();
			hotel = Recursos.ReadFileObjectEmpresa("hotel.dat");
			FormLogin inicio = new FormLogin(hotel);
			inicio.setVisible(true);
		}else {
			FormZeroDay principal = new FormZeroDay();
			principal.setVisible(true);
		}
	}

}
