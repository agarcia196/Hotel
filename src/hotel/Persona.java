package hotel;

public abstract class Persona {

	protected String nombre;
	protected String apellido;
	protected String genero;
	protected String correo;
	protected String id;
	protected String tipoId;
	protected String pwd;
	
	
	public Persona(String nombre, String apellido, String genero, String correo, String id, String tipoId, String pwd) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.correo = correo;
		this.id = id;
		this.tipoId = tipoId;
		this.pwd = pwd;
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
}
