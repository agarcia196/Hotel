package arbol;

import exception.ExceptionNodo;

public class ABB<E extends Comparable<E>> extends ArbolB<E> {
	
	public ABB() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ABB(NodoB<E> raiz) {
		super(raiz);
		// TODO Auto-generated constructor stub
	}
    
	public void eliminar(E info) throws ExceptionNodo {
		raiz=eliminar(info, raiz);
	}

	public NodoB<E> eliminar(E info, NodoB<E> nodo) throws ExceptionNodo {
		if(nodo==null) 
			throw new ExceptionNodo("El nodo está repetido");

		if(nodo.getLlave().compareTo(info)>0)
			nodo.setHijoIzq(eliminar(info, nodo.getHijoIzq()));			
		else
			if(nodo.getLlave().compareTo(info)<0)
				nodo.setHijoDer(eliminar(info,nodo.getHijoDer()));
				else {
					if(nodo.getHijoDer()!=null && nodo.getHijoIzq()!=null) {
						NodoB<E> antecesor=buscarAntecesor(nodo);
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
	public NodoB<E> buscar(E elemento) throws ExceptionNodo {
		return buscar(raiz, elemento);
	}
	private NodoB<E>buscar(NodoB<E> nodo, E elemento) throws ExceptionNodo {
		if(nodo == null)
			throw new ExceptionNodo("No existe el nodo");
		else {
			if(nodo.getLlave().compareTo(elemento)==0){
				return nodo;
			}
			if(nodo.getLlave().compareTo(elemento)>0) {
				return buscar(nodo.getHijoIzq(),elemento);
			}
			if(nodo.getLlave().compareTo(elemento)<0) {
				return buscar(nodo.getHijoDer(),elemento);
			}
		}
		return nodo;
	}
	
	public NodoB<E> buscarAntecesor(NodoB<E> k) throws ExceptionNodo {
		if(k.getHijoIzq()==null)
			throw new ExceptionNodo("Error en algoritmo");
		return buscarMax(k.getHijoIzq());
	}
	public NodoB<E> buscarMax(NodoB<E> k){
		if(k.getHijoDer()==null)
			return k;
		else
			return buscarMax(k.getHijoDer());
	}
	public void insertNodo(E a) throws ExceptionNodo{
		NodoB<E> e= new NodoB<E>(a);
		raiz = insertNodo(e,raiz);
	}
	private NodoB<E> insertNodo(NodoB<E> n, NodoB<E> r) throws ExceptionNodo{
		if(r==null) {
			r=n;
		}else {
			if(n.getLlave().compareTo(r.getLlave())<0)
				r.setHijoIzq(insertNodo(n, r.getHijoIzq()));
			if(n.getLlave().compareTo(r.getLlave())>0)
				r.setHijoDer(insertNodo(n, r.getHijoDer()));
			if(n.getLlave().compareTo(r.getLlave())==0)
				throw new ExceptionNodo("El nodo está repetido");
		}
		
		return r;		
	}
}
