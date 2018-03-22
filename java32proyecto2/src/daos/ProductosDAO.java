package daos;

import java.util.List;

import modelo.Producto;

public interface ProductosDAO {
	void registrarProducto(Producto producto);
	List<Producto>obtenerProductos();
	void borrarProducto(int id);
	Producto obtenerProductoPorId(int id);
	void guardarCambiosProducto(Producto producto);
	
}
