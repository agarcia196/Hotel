package hotel;

import java.util.Stack;
import javax.swing.JPanel;

public class VentanaPrincipal {
	private Stack<JPanel> paneles_activos;
	
	
	
	public VentanaPrincipal(Stack<JPanel> paneles_activos) {
		super();
		this.paneles_activos = new Stack<JPanel>();
	}

	public Stack<JPanel> getPaneles_activos() {
		return paneles_activos;
	}

	public void setPaneles_activos(Stack<JPanel> paneles_activos) {
		this.paneles_activos = paneles_activos;
	}

	public JPanel volverAtras() {
		return null;
	}
	public void abrirPanel(JPanel j) {
	
	}
	
}
