package arbol;

import exception.ExceptionNodo;
import hotel.Cliente;

public class ACliente extends ABB<Cliente> {
	
	
	
	
	public ACliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ACliente(NodoB<Cliente> raiz) {
		super(raiz);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public NodoB<Cliente> buscarS(String elemento) throws ExceptionNodo {
		//NodoB<Cliente> c = new NodoB<Cliente>();
		return buscarS(raiz, elemento);
	}
	private NodoB<Cliente>buscarS(NodoB<Cliente> nodo, String elemento) throws ExceptionNodo {
		if(nodo == null)
			throw new ExceptionNodo("No existe el nodo");
		else {
			if(nodo.getLlave().getId().compareTo(elemento)==0){
				return nodo;
			}
			if(nodo.getLlave().getId().compareTo(elemento)>0) {
				return buscarS(nodo.getHijoIzq(),elemento);
			}
			if(nodo.getLlave().getId().compareTo(elemento)<0) {
				return buscarS(nodo.getHijoDer(),elemento);
			}
		}
		return nodo;
	}


	
	

	public static void main(String[] args) throws ExceptionNodo {
		// TODO Auto-generated method stub
		ACliente c = new ACliente();
		
		Cliente e1 = new Cliente("Lopez", "Daniel", "Sin especificar", "DD", "1234", "CC", "123");
		Cliente e2 = new Cliente("Lopez", "Daniel", "Sin especificar", "DD", "abc", "CC", "123");
		Cliente e3 = new Cliente("Lopez", "Daniel", "Sin especificar", "DD", "def", "CC", "123");
		Cliente e4 = new Cliente("Lopez", "Daniel", "Sin especificar", "DD", "ghi", "CC", "123");
		Cliente e5 = new Cliente("Lopez", "Daniel", "Sin especificar", "DD", "jkl", "CC", "123");
		Cliente e6 = new Cliente("Lopez", "Daniel", "Sin especificar", "DD", "mno", "CC", "123");
		
		
		c.insertNodo(e1);
		c.insertNodo(e2);
		c.insertNodo(e3);
		c.insertNodo(e4);
		c.insertNodo(e5);
		c.insertNodo(e6);
		c.printToAnchura();
		
		//System.out.print(c.buscarS("def"));
		
		
	}

}
