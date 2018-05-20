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

	
	public void eliminar(String info) throws ExceptionNodo {
		raiz=eliminar(info, raiz);
	}

	public NodoB<Cliente> eliminar(String info, NodoB<Cliente> nodo) throws ExceptionNodo {
		if(nodo==null) 
			throw new ExceptionNodo("El nodo está repetido");

		if(nodo.getLlave().getId().compareTo(info)>0)
			nodo.setHijoIzq(eliminar(info, nodo.getHijoIzq()));			
		else
			if(nodo.getLlave().getId().compareTo(info)<0)
				nodo.setHijoDer(eliminar(info,nodo.getHijoDer()));
				else {
					if(nodo.getHijoDer()!=null && nodo.getHijoIzq()!=null) {
						NodoB<Cliente> antecesor=buscarAntecesor(nodo);
						nodo.setLlave(antecesor.getLlave());
						nodo.setHijoIzq(eliminar(antecesor.getLlave(),nodo.getHijoIzq()));
					}else {
						if(nodo.getHijoDer()!=null) {
							nodo=nodo.getHijoDer();
						}else {
							nodo=nodo.getHijoIzq();
						}
					}
				}
				return nodo;
			}

	
	

	public static void main(String[] args) throws ExceptionNodo {
		// TODO Auto-generated method stub
		ACliente c = new ACliente();
		
		Cliente a = new Cliente("a", "a", "Sin especificar", "DD", "1234", "CC", "123");
		Cliente b = new Cliente("b", "b", "Sin especificar", "DD", "abc", "CC", "123");
		Cliente g = new Cliente("g", "c", "Sin especificar", "DD", "def", "CC", "123");
		Cliente d = new Cliente("d", "d", "Sin especificar", "DD", "ghi", "CC", "123");
		Cliente e = new Cliente("e", "e", "Sin especificar", "DD", "jkl", "CC", "123");
		Cliente f = new Cliente("f", "f", "Sin especificar", "DD", "mno", "CC", "123");
		
		
		c.insertNodo(d);
		c.insertNodo(b);
		c.insertNodo(a);
		c.insertNodo(g);
		c.insertNodo(f);
		c.insertNodo(e);
		c.printToAnchura();
		c.eliminar("1234");
		System.out.println("");
		
		
		c.printToAnchura();
		
		System.out.println("");
		System.out.println(c.buscarS("abc"));
		
		//System.out.print(c.buscarS("def"));
		
		
	}

}
