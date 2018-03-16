package daos;

import modelo.Producto;

public interface productosDAO {
		void registrarProducto(Producto c);
		void borrarProducto(int id);
		Producto[] obtenerProducto();
}
