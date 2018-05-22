package hotel;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Persona implements Serializable{

	private static final long serialVersionUID = -8652198501390246789L;
	protected String nombre;
	protected String apellido;
	protected String genero;
	protected String correo;
	protected String id;
	protected String tipoId;
	protected String pwd;
	protected boolean activo;
	
	
	public Persona(String nombre, String apellido, String genero, String correo, String id, String tipoId, String pwd) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.correo = correo;
		this.id = id;
		this.tipoId = tipoId;
		this.pwd = pwd;
		this.activo=true;
	}
	
	public String[] imprimirPersonaTabla() {
		String[] a= {this.getNombre(),this.getApellido(),this.getCorreo(),this.getGenero(),this.getId()};
		return a;
	}
	public Persona(String cedula) {
		id=cedula;
		// TODO Auto-generated constructor stub
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTipoId() {
		return tipoId;
	}
	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		activo = activo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", id=" + id +  "]";//", genero=" + genero + ", correo=" + correo+ ", id=" + id + ", tipoId=" + tipoId + ", pwd=" + pwd + "]";
	}

	public boolean addReserva(LocalDate dateIn, LocalDate dateOut, String tipo, Hotel hotel) {
		// TODO Auto-generated method stub
		return false;
	}

	public Reserva buscarReserva(LocalDate dateIn) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addReserva(LocalDate dateIn, LocalDate dateOut, String tipo, Hotel hotel, Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
