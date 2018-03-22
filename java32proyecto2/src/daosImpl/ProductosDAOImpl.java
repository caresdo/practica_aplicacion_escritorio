package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Producto;
import daos.ConstantesSql;
import daos.GenericDAO;
import daos.ProductosDAO;

public class ProductosDAOImpl extends GenericDAO implements ProductosDAO{

	@Override
	public void registrarProducto(Producto producto) {
	conectar();
			try {
				System.out.println("intentamos insertar producto");
				PreparedStatement ps = miConexion.prepareStatement(ConstantesSql.INSERCION_PRODUCTO);
				ps.setString(1, producto.getNombre());
				ps.setString(2, producto.getCantidad());
				ps.setString(3, producto.getPrecio());
				ps.setString(4, producto.getOferta());
				ps.setString(5, producto.getFechaCad());
				ps.setString(6, producto.getProveedor());
				ps.setString(7, producto.getComentario());
				ps.execute();
				ps.close();
			} catch (SQLException e) {
				System.out.println("error sql");
			}
			desconectar();
		}//end registrar

	@Override
	public List<Producto> obtenerProductos() {
		conectar();
		List<Producto> productos = new ArrayList<Producto>();
		
		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(ConstantesSql.SELECCION_PRODUCTOS);
			ResultSet resultado =ps.executeQuery();
			
			while(resultado.next()){
				Producto producto = new Producto();
				producto.setNombre(resultado.getString("nombre"));
				producto.setCantidad(resultado.getString("cantidad"));
				producto.setPrecio(resultado.getString("precio"));
				producto.setOferta(resultado.getString("oferta"));
				producto.setFechaCad(resultado.getString("fecha_cad"));
				producto.setProveedor(resultado.getString("proveedor"));
				producto.setComentario(resultado.getString("comentario"));
				producto.setId(resultado.getInt("id"));
				productos.add(producto);
				}
			} catch (SQLException e) {
			System.out.println("error sql listar");
			System.out.println(e.getMessage());
		}
		desconectar();
		return productos;
	}//end obtener

	@Override
	public void borrarProducto(int id) {
		conectar();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSql.BORRAR_PRODUCTO);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("error sql borrar");
		}
		desconectar();
	}//fin borrarproducto

	@Override
	public Producto obtenerProductoPorId(int id) {
		conectar();
		Producto producto = new Producto();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSql.OBTENER_PRODUCTO_POR_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				producto.setNombre(rs.getString("nombre"));
				producto.setCantidad(rs.getString("cantidad"));
				producto.setPrecio(rs.getString("precio"));
				producto.setOferta(rs.getString("oferta"));
				producto.setFechaCad(rs.getString("fecha_cad"));
				producto.setProveedor(rs.getString("proveedor"));
				producto.setComentario(rs.getString("comentario"));
				producto.setId(id);
				
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("error sql obtener producto por id");
		}
		desconectar();
		return producto;
	}//fin obtener por id

	@Override
	public void guardarCambiosProducto(Producto producto) {
conectar();
		
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSql.GUARDAR_CAMBIOS_PRODUCTO);
			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getCantidad());;
			ps.setString(3, producto.getPrecio());
			ps.setString(6, producto.getOferta());
			ps.setString(4, producto.getFechaCad());
			ps.setString(5, producto.getProveedor());
			ps.setString(7, producto.getComentario());
			ps.setInt(8, producto.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("error sql guardar producto");
		}
		
		desconectar();
	}

}
