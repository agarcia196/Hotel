package arbol;

public class NodoB <E extends Comparable<E>>{
	protected E llave;
	protected NodoB<E> padre;
	protected NodoB<E> hijoIzq;
	protected NodoB<E> hijoDer;
	public NodoB(E llave) {
		super();
		this.llave = llave;
		this.padre = null;
		this.hijoIzq = null;
		this.hijoDer = null;
	}
	public NodoB(E llave, NodoB<E> padre, NodoB<E> hijoIzq, NodoB<E> hijoDer) {
		super();
		this.llave = llave;
		this.padre = padre;
		this.hijoIzq = hijoIzq;
		this.hijoDer = hijoDer;
	}
	
	public NodoB<E> getPadre() {
		return padre;
	}
	public void setPadre(NodoB<E> padre) {
		this.padre = padre;
	}
	public NodoB<E> getHijoIzq() {
		return hijoIzq;
	}
	public void setHijoIzq(NodoB<E> hijoIzq) {
		if(hijoIzq!=null) {
			hijoIzq.setPadre(this);
		}
		this.hijoIzq = hijoIzq;
	}
	public NodoB<E> getHijoDer() {
		return hijoDer;
	}
	public void setHijoDer(NodoB<E> hijoDer) {
		if(hijoDer!=null) {
			hijoDer.setPadre(this);
		}
		this.hijoDer = hijoDer;
	}
	public E getLlave() {
		return llave;
	}
	public void setLlave(E llave) {
		this.llave = llave;
	}
	public int alturaNodo() {
		return alturaNodo(this); 
	}
	public int alturaNodo(NodoB<E> nodo) {
		if(nodo==null) return -1;
		 int altder=(nodo.getHijoDer()==null? 0:1+alturaNodo(nodo.getHijoDer()));
		 int altizq=(nodo.getHijoIzq()==null? 0:1+alturaNodo(nodo.getHijoIzq()));
		return Math.max(altder,altizq);
		}
	public int factorEquilibrio() {
		return alturaNodo(this.getHijoDer())-alturaNodo(this.getHijoIzq());
	}
	@Override
	public String toString() {
		String HI=(hijoIzq==null)? "null":hijoIzq.getLlave().toString();
		String HD=(hijoDer==null)? "null":hijoDer.getLlave().toString();		
		return HI+" "+HD;
	}
	
}
