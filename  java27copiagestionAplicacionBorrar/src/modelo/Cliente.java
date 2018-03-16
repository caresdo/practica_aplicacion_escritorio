package modelo;

public class Cliente {
	private String nombre;
	private String Domicilio;
	private String Poblacion;
	private String codigopostal;
	private String telefono;
	private int id;
	
	public Cliente() {}

	public Cliente(String nombre, String domicilio, String poblacion,
			String codigopostal, String telefono) {
		super();
		this.nombre = nombre;
		Domicilio = domicilio;
		Poblacion = poblacion;
		this.codigopostal = codigopostal;
		this.telefono = telefono;
	}
//geters y seters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return Domicilio;
	}

	public void setDomicilio(String domicilio) {
		Domicilio = domicilio;
	}

	public String getPoblacion() {
		return Poblacion;
	}

	public void setPoblacion(String poblacion) {
		Poblacion = poblacion;
	}

	public String getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//tostring
	public String toString() {
		return "Cliente [nombre=" + nombre + ", Domicilio=" + Domicilio
				+ ", Poblacion=" + Poblacion + ", codigopostal=" + codigopostal
				+ ", telefono=" + telefono + "]";
	}
	
	
}
