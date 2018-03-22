package modelo;

public class Cliente {
	private String nombre;
	private String calle;
	private String numeracion;
	private String codigoPostal;
	private String poblacion;
	private String telefono;
	private String email;
	private String particularOEmpresa;
	private int id;

	public Cliente(String nombre, String calle, String numeracion,
			String codigoPostal, String poblacion, String telefono,
			String email, String particularOEmpresa) {
		super();
		this.nombre = nombre;
		this.calle = calle;
		this.numeracion = numeracion;
		this.codigoPostal = codigoPostal;
		this.poblacion = poblacion;
		this.telefono = telefono;
		this.email = email;
		this.particularOEmpresa = particularOEmpresa;
	}
	public Cliente(){}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumeracion() {
		return numeracion;
	}
	public void setNumeracion(String numeracion) {
		this.numeracion = numeracion;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getParticularOEmpresa() {
		return particularOEmpresa;
	}
	public void setParticularOEmpresa(String particularOEmpresa) {
		this.particularOEmpresa = particularOEmpresa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", calle=" + calle
				+ ", numeracion=" + numeracion + ", codigoPostal="
				+ codigoPostal + ", poblacion=" + poblacion + ", telefono="
				+ telefono + ", email=" + email + ", particularOEmpresa="
				+ particularOEmpresa + ", id=" + id + "]";
	}
	
	
}// fin class
