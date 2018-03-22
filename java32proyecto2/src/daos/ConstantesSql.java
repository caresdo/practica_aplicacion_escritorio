package daos;

public class ConstantesSql {

	public static final String IDENTIFICACION_ADMINISTRADOR = "select login from tabla_admin where login = ? and password = ?";
	public static final String INSERCION_CLIENTE = "insert into tabla_clientes(nombre,calle,numeracion,codigo_postal,poblacion,telefono,email,particular_empresa) values (?,?,?,?,?,?,?,?)";
	public static final String INSERCION_PRODUCTO = "insert into tabla_productos(nombre, cantidad, precio, oferta, fecha_cad, proveedor, comentario) values (?,?,?,?,?,?,?)";
	public static final String SELECCION_CLIENTES = "select * from tabla_clientes";
	public static final String SELECCION_PRODUCTOS = "select * from tabla_productos";
	public static final String BORRAR_CLIENTE = "delete from tabla_clientes where id = ?";
	public static final String BORRAR_PRODUCTO = "delete from tabla_productos where id = ?";
	public static final String OBTENER_CLIENTE_POR_ID = "select * from tabla_clientes where id = ?";
	public static final String OBTENER_PRODUCTO_POR_ID = "select * from tabla_productos where id = ?";
	public static final String GUARDAR_CAMBIOS_PRODUCTO = "update tabla_productos set nombre=?, cantidad=?, precio=?, oferta=?, fecha_cad=?, proveedor=?, comentario=? WHERE id=?;";
	public static final String GUARDAR_CAMBIOS_CLIENTE = "update tabla_clientes set nombre=?, calle=?, numeracion=?, codigo_postal=?, poblacion=?, telefono=?, email=?, particular_empresa=? WHERE id=?;";
}//end class
