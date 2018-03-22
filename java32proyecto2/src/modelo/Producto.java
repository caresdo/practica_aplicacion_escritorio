package modelo;

public class Producto {
	private String nombre;
	private String cantidad;
	private String precio;
	private String oferta;
	private String fechaCad;
	private String proveedor;
	private String comentario;
	private int id;

	public Producto(String nombre, String cantidad, String precio,
			String oferta, String fechaCad, String proveedor,
			String comentario) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.oferta = oferta;
		this.fechaCad = fechaCad;
		this.proveedor = proveedor;
		this.comentario = comentario;
	}
	public Producto(){}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getOferta() {
		return oferta;
	}
	public void setOferta(String oferta) {
		this.oferta = oferta;
	}
	public String getFechaCad() {
		return fechaCad;
	}
	public void setFechaCad(String fechaCad) {
		this.fechaCad = fechaCad;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", cantidad=" + cantidad
				+ ", precio=" + precio + ", oferta=" + oferta + ", fechaCad="
				+ fechaCad + ", proveedor=" + proveedor + ", comentario="
				+ comentario + ", id=" + id + "]";
	}
	
	
	
	
}// fin class
