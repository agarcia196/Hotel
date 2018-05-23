package arbol;

import java.io.Serializable;

import javax.swing.table.DefaultTableModel;
import exception.EArrayVacio;
import exception.ExceptionNodo;
import hotel.Cliente;

public class ACliente extends ABB<Cliente>  implements Serializable{
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8829709942015922601L;
	public ACliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ACliente(NodoB<Cliente> raiz) {
		super(raiz);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isEmpty() {
		return raiz==null;	
	}	
	
	public NodoB<Cliente> buscarS(String elemento) throws ExceptionNodo {
		//NodoB<Cliente> c = new NodoB<Cliente>();
		return buscarS(raiz, elemento);
	}
	private NodoB<Cliente>buscarS(NodoB<Cliente> nodo, String elemento) throws ExceptionNodo {
		if(nodo == null)
			throw new ExceptionNodo("Cliente no encontrado");
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
	}/*
	public DefaultTableModel ConsultaUsuarios(DefaultTableModel modeloTable) throws EArrayVacio{
		ArrayList<Cliente> lista = usuarios.inOrdenA();
		if(lista.size()>0) {
			int i=0;
			while (i<lista.size()) {
				if(lista.get(i).isActivo()) {
					String [] model = {lista.get(i).getNombre(),lista.get(i).getApellido(),lista.get(i).getId(),String.valueOf(!lista.get(i).getReservasActivas().isEmpty())};
					modeloTable.addRow(model);	}
				i++;
			}
			return modeloTable;}
		else {
			throw new EArrayVacio("No hay Usuarios");
		}
	}*/
	public DefaultTableModel ConsultaUsuarios(DefaultTableModel modeloTable) throws EArrayVacio {
		if(raiz!=null) {
			ConsultaUsuarios(modeloTable,raiz);
			return modeloTable;
		}else {
			throw new EArrayVacio("No hay Usuarios");
		}		
	}
	
	private void ConsultaUsuarios(DefaultTableModel list,NodoB<Cliente> r) {
		if(r!=null) {			
			ConsultaUsuarios(list,r.getHijoIzq());
			if(r.getLlave().isActivo()) {
				String [] model = {r.getLlave().getId(),r.getLlave().getNombre(),r.getLlave().getApellido(),String.valueOf(!r.getLlave().getReservasActivas().isEmpty())};
				list.addRow(model);	}
			ConsultaUsuarios(list,r.getHijoDer());			
		}
	}
	public DefaultTableModel ConsultaUsuarios(DefaultTableModel modeloTable,String palabra) throws EArrayVacio {
		if(raiz!=null) {
			ConsultaUsuarios(modeloTable,raiz,palabra);
			return modeloTable;
		}else {
			throw new EArrayVacio("No hay Usuarios");
		}		
	}
	private void ConsultaUsuarios(DefaultTableModel list,NodoB<Cliente> r,String palabra) {
		if(r!=null) {			
			ConsultaUsuarios(list,r.getHijoIzq(),palabra);
			if(r.getLlave().isActivo()) {
				if(r.getLlave().getNombre().toLowerCase().contains(palabra)||r.getLlave().getApellido().toLowerCase().contains(palabra)||r.getLlave().getId().toLowerCase().contains(palabra)) {
					String [] model = {r.getLlave().getId(),r.getLlave().getNombre(),r.getLlave().getApellido(),String.valueOf(!r.getLlave().getReservasActivas().isEmpty())};
					list.addRow(model);	}
			}
			ConsultaUsuarios(list,r.getHijoDer(),palabra);			
		}
	}
	
	
	
	public DefaultTableModel ConsultaUsuariosEdit(DefaultTableModel modeloTable,String palabra) throws EArrayVacio {
		if(raiz!=null) {
			ConsultaUsuariosEdit(modeloTable,raiz,palabra);
			return modeloTable;
		}else {
			throw new EArrayVacio("No hay Usuarios");
		}		
	}
	private void ConsultaUsuariosEdit(DefaultTableModel list,NodoB<Cliente> r,String palabra) {
		if(r!=null) {			
			ConsultaUsuariosEdit(list,r.getHijoIzq(),palabra);
			if(r.getLlave().getNombre().toLowerCase().contains(palabra)||r.getLlave().getApellido().toLowerCase().contains(palabra)||r.getLlave().getId().toLowerCase().contains(palabra)) {
				String [] model = {r.getLlave().getId(),r.getLlave().getNombre(),r.getLlave().getApellido(),(r.getLlave().getActivo())};
				list.addRow(model);	}
			ConsultaUsuariosEdit(list,r.getHijoDer(),palabra);			
		}
	}
	
	public void eliminar(String info) throws ExceptionNodo {
		raiz=eliminar(info, raiz);
	}
	
	public DefaultTableModel ConsultaUsuariosEdit(DefaultTableModel modeloTable) throws EArrayVacio {
		if(raiz!=null) {
			ConsultaUsuariosEdit(modeloTable,raiz);
			return modeloTable;
		}else {
			throw new EArrayVacio("No hay Usuarios");
		}		
	}
	private void ConsultaUsuariosEdit(DefaultTableModel list,NodoB<Cliente> r) {
		if(r!=null) {			
			ConsultaUsuariosEdit(list,r.getHijoIzq());
				String [] model = {r.getLlave().getId(),r.getLlave().getNombre(),r.getLlave().getApellido(),r.getLlave().getActivo()};
				list.addRow(model);
			ConsultaUsuariosEdit(list,r.getHijoDer());
		}
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
