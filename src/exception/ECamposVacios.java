package exception;

import java.io.Serializable;

public class ECamposVacios extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8715332810941532169L;

	/**
	 * 
	 */
	
	public ECamposVacios() {
		// TODO Auto-generated constructor stub
		super("Todos los campos deben rellenarse");
	}

}
