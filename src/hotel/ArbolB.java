package hotel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ArbolB<E extends Comparable<E>> {
	protected NodoB<E> raiz;
	public static void main(String[] args) {
		/*NodoB<Integer> n1 = new NodoB<Integer>(10);
		NodoB<Integer> n2 = new NodoB<Integer>(7);
		NodoB<Integer> n3 = new NodoB<Integer>(15);
		NodoB<Integer> n4 = new NodoB<Integer>(5);
		NodoB<Integer> n5 = new NodoB<Integer>(9);
		NodoB<Integer> n6 = new NodoB<Integer>(12);
		n3.setHijoIzq(n6);
		n2.setHijoIzq(n4);
		n2.setHijoDer(n5);
		n1.setHijoIzq(n2);
		n1.setHijoDer(n3);
		ArbolB<Integer> tree = new ArbolB<Integer>(n1);*/
		/*System.out.println("Ã�rbol preorden: ");
		tree.preOrden();
		System.out.println("Ã�rbol posorden: ");
		tree.posOrden();
		System.out.println("Ã�rbol inOrden: ");
		tree.inOrden();
		System.out.println("Ã�rbol preorden: ");
		for (Integer inte : tree.preOrdenA()) {
			System.out.print(inte+" ");
		}
		System.out.println("Ã�rbol posorden: ");
		tree.posOrdenA();
		System.out.println("Ã�rbol inOrden: ");
		tree.inOrdenA();*/
		ArbolB<Integer> tree = new ArbolB<Integer>();
		
		/*ArbolGenerico<Integer> num =new ArbolGenerico<Integer>();
		num.addNodo(2, 0);
		num.addNodo(3, 2);
		num.addNodo(5, 2);
		num.addNodo(4, 3);
		tree.convertirABinario(num);
		tree.preOrden();*/
		ArrayList<Integer> inorden = new ArrayList<Integer>();
		ArrayList<Integer> preorden = new ArrayList<Integer>();
		for (int i = 1; i < 11; i++) {
			inorden.add(i);
		}
		preorden.add(5);
		preorden.add(2);
		preorden.add(1);
		preorden.add(3);
		preorden.add(4);
		preorden.add(8);
		preorden.add(7);
		preorden.add(6);
		preorden.add(9);
		preorden.add(10);
		tree.crearArbol(inorden, preorden);
		tree.printToAnchura();
		
	}
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
	/*
	public ArbolB<E> convertirABinario(ArbolGenerico<E> arbol) {
		NodoB<E> raiz = new NodoB<E>(arbol.getRaiz().getLlave());
		ArbolB<E> a1 = new ArbolB<E>(raiz);
		NodoG<E> aux = arbol.getRaiz();
		while(aux.getHijos()!=null) {
			
		}
		return a1;
	}	*/
	public void convertirABinario(ArbolGenerico<E> arbol) {
		NodoB<E> raiza = new NodoB<E>(arbol.getRaiz().getLlave());
		raiz= raiza;
		convertirABinario(raiz,arbol.getRaiz());
	}
	private void convertirABinario(NodoB<E> nodo,NodoG<E> r) {
		int i=1;
		if(r!=null) {
			NodoB<E> aux = new NodoB<E>(r.getLlave());
			if(i==1) {
				nodo.setHijoIzq(aux);
				i++;}
			else {
				nodo.setHijoDer(aux);
				i++;
			}
			for (NodoG<E> e : r.getHijos()) {
				convertirABinario(nodo,e);
			}			
		}else {i=1;}
	}
	/*
	public void addNodo(E elemento,E padre) {
		raiz = addNodo(raiz,elemento,padre); 
	}
	private NodoB<E> addNodo(NodoB<E> nodo,E elemento,E padre) {
		if(nodo==null) {
			nodo = new NodoB<E>(elemento);
		}else {
			NodoB<E> nodopadre = buscarelemento(padre);
			if(nodopadre!=null)
				if(nodopadre.getHijoIzq()==null)
				nodopadre.getHijos().add(new NodoG<E>(elemento));
			else
				nodo.getHijos().add(new NodoG<E>(elemento));
		}
		return nodo;
	}
	public NodoB<E> buscarelemento(E elemento){
		NodoB<E> result=null;
		return buscarelemento(raiz,result,elemento);
	}
	private NodoB<E> buscarelemento(NodoB<E> nodo,NodoB<E>result,E elemento){
		if(nodo==null)
			result=null;
		if(elemento.compareTo(nodo.getLlave())==0) {
			result= nodo;
			return result;
		}
			result=buscarelemento(nodo.getHijoDer(),result,elemento);
			result=buscarelemento(nodo.getHijoIzq(),result,elemento);
		return result;
	}*/
	
	/*public NodoB<E> crearArbol(ArrayList<E> inorden, ArrayList<E> preorden,NodoB<E>nodo){
		
		
	}*/
	
		
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
	
	public NodoB<E> crearArbol(ArrayList<E> inorden, ArrayList<E> preorden) {
		return raiz = crearArbol(inorden, preorden, raiz);
	}
	public NodoB<E> crearArbol(ArrayList<E> inorden, ArrayList<E> preorden, NodoB<E> nodo) {
		if(inorden.isEmpty() && preorden.isEmpty())
			return null;
		else {
			ArrayList<E> npreordenz = new ArrayList<E>();
			ArrayList<E> ninordenz = new ArrayList<E>();
			ArrayList<E> npreordend = new ArrayList<E>();
			ArrayList<E> ninordend = new ArrayList<E>();
			if(nodo==null) {
				NodoB<E> aux = new NodoB<E>(preorden.get(0));
				nodo=aux;
				int i= 0;
				while (inorden.get(i).compareTo(preorden.get(0))!=0) {
					ninordenz.add(inorden.get(i));
					npreordenz.add(preorden.get(i+1));
					i++;				
				}
				i++;
				while (i<inorden.size()) {
					ninordend.add(inorden.get(i));
					npreordend.add(preorden.get(i));
					i++;			
				}
				nodo.setHijoIzq(crearArbol(ninordenz,npreordenz, nodo.getHijoIzq()));
				nodo.setHijoDer(crearArbol(ninordend,npreordend, nodo.getHijoDer()));
			}else
				nodo.setLlave(preorden.get(0));	
		}	
		return nodo;
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
