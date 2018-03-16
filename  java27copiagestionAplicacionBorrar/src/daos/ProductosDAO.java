package daos;

import modelo.Producto;

public interface ProductosDAO {
		void registrarProducto(Producto c);
		void borrarProducto(int id);
		Producto[] obtenerProducto();
}
