package arbol;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ArbolB<E extends Comparable<E>> {
	protected NodoB<E> raiz;

	public ArbolB(NodoB<E> raiz) {
		super();
		this.raiz = raiz;
	}

	public NodoB<E> getRaiz() {
		return raiz;
	}
	
	public ArbolB() {
		super();
		this.raiz = null;
	}
	public void setRaiz(NodoB<E> raiz) {
		this.raiz = raiz;
	}
	
	public void preOrden() {
		preOrden(raiz);
		System.out.println();
	}
	public void preOrden(NodoB<E> r) {
		if(r!=null) {
			System.out.print(r.getLlave()+" ");
			preOrden(r.getHijoIzq());
			preOrden(r.getHijoDer());
		}
	}
	public ArrayList<E> preOrdenA() {
		ArrayList<E> list = new ArrayList<E>();
		preOrdenA(list,raiz);
		return list;
	}
	public void preOrdenA(ArrayList<E> list,NodoB<E> r) {
		if(r!=null) {
			list.add(r.getLlave());
			preOrdenA(list,r.getHijoIzq());
			preOrdenA(list,r.getHijoDer());			
		}
	}
	
	public void posOrden() {
		posOrden(raiz);
		System.out.println();
	}
	public void posOrden(NodoB<E> r) {
		if(r!=null) {
			posOrden(r.getHijoIzq());
			posOrden(r.getHijoDer());
			System.out.print(r.getLlave()+" ");
		}
	}
	public ArrayList<E> posOrdenA() {
		ArrayList<E> list = new ArrayList<E>();
		posOrdenA(list,raiz);
		return list;
	}
	public void posOrdenA(ArrayList<E> list,NodoB<E> r) {
		if(r!=null) {
			posOrdenA(list,r.getHijoIzq());
			posOrdenA(list,r.getHijoDer());	
			list.add(r.getLlave());
		}
	}
	
	public void inOrden() {
		inOrden(raiz);
		System.out.println();
	}
	public void inOrden(NodoB<E> r) {
		if(r!=null) {
			inOrden(r.getHijoIzq());
			System.out.print(r.getLlave()+" ");
			inOrden(r.getHijoDer());
		}
	}
	public ArrayList<E> inOrdenA() {
		ArrayList<E> list = new ArrayList<E>();
		inOrdenA(list,raiz);
		return list;
	}
	public void inOrdenA(ArrayList<E> list,NodoB<E> r) {
		if(r!=null) {			
			inOrdenA(list,r.getHijoIzq());
			list.add(r.getLlave());
			inOrdenA(list,r.getHijoDer());			
		}
	}

	
		
	public ArrayList<E> obtenerDer(ArrayList<E> inorden, E elemento, int cont){
		if(inorden.isEmpty()) {
			return null;
		}
		else {
		ArrayList<E> mitad = new ArrayList<E>();
		for (int i = cont+1; i < inorden.size(); i++) {
			mitad.add(inorden.get(i));
		}
		return mitad;
	}
	}
	public ArrayList<E> obtenerIzq(ArrayList<E> inorden, E elemento, int cont){
		if(inorden.isEmpty()) {
			return null;
		}
		else {
		ArrayList<E> mitad = new ArrayList<E>();
		for (int i = 0; i < cont-1; i++) {
			mitad.add(inorden.get(i));
		}
		return mitad;
	}
}
	public int buscarpos(ArrayList<E> inorden, E elemento) {
		int i=0;
		for (E e : inorden) {
			if(e.compareTo(elemento)==0) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	public void addizq(NodoB<E> nodo, E elemento) {
		NodoB<E> nhi= new NodoB<E>(elemento);
		nodo.setHijoIzq(nhi);
	}
	public void addder(NodoB<E> nodo, E elemento) {
		NodoB<E> nhd= new NodoB<E>(elemento);
		nodo.setHijoDer(nhd);
	}

	public void printToAnchura() {
		if(raiz!=null) {
			Queue<NodoB<E>> cola = new LinkedList <NodoB<E>>();
			cola.add(raiz);
			while(!cola.isEmpty()) {
				NodoB<E> aux = cola.poll();
				System.out.print(aux.getLlave()+" ");
				if(aux.getHijoIzq()!=null) {
					cola.add(aux.getHijoIzq());
				}
				if(aux.getHijoDer()!=null) {
					cola.add(aux.getHijoDer());
				}
			}
		}
		else{
			System.out.println("Arbol vacÃ­o");
		}
	}
	
}
