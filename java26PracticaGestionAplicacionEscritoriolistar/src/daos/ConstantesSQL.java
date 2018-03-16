package daos;

public class ConstantesSQL {
	final static String sqlInsercionCliente = "insert into tabla_clientes (nombre, domicilio, poblacion, codigo_postal, telefono)"+
				"values (?,?,?,?,?)";
	final static String sqlSeleccionCliente = "select * from tabla_clientes";
	final static String sqlInsercionProducto = "insert into tabla_productos (nombre, cantidad, precio, oferta, fecha_cad, proveedor, comentario )"+
			"values (?,?,?,?,?,?,?)";
	final static String sqlSeleccionProducto = "select * from tabla_productos";
}
