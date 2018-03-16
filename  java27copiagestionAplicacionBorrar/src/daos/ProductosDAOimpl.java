package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Producto;

public class ProductosDAOimpl implements ProductosDAO{
	
private Connection miConexion = null;
public ProductosDAOimpl(){
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/practica_escritorio";
		miConexion = DriverManager.getConnection(url, "root", "jeveris");
	} catch (ClassNotFoundException e) {
		System.out.println("error driver");
	} catch (SQLException e) {
		System.out.println("error conectar url");
	}
	

	
	
}

	public void registrarProducto(Producto c) {

		
		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(ConstantesSQL.sqlInsercionProducto);
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getCantidad());
			ps.setString(3, c.getPrecio());
			ps.setBoolean(4, c.isOferta());
			ps.setString(5, c.getFechaCad());
			ps.setString(6, c.getProveedor());
			ps.setString(7, c.getComentario());
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("error sql insertar");
		}
		
		
	}//close registrarProducto

	public void borrarProducto(int id) {
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.sqlBorradoProducto);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("la sql de borrado esta mal");
		}
	}


	public Producto[] obtenerProducto() {
		Producto[] productos = null;
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.sqlSeleccionProducto);
			ResultSet resultado = ps.executeQuery();
			List<Producto> listproductos = new ArrayList<Producto>();
			while(resultado.next()){
				Producto c = new Producto();
				c.setNombre(resultado.getString("nombre"));
				c.setCantidad(resultado.getString("cantidad"));
				c.setPrecio(resultado.getString("precio"));
				c.setOferta(resultado.getBoolean("oferta"));
				c.setFechaCad(resultado.getString("fecha_cad"));
				c.setProveedor(resultado.getString("proveedor"));
				c.setComentario(resultado.getString("comentario"));
				c.setId(resultado.getInt("id"));
				listproductos.add(c);
				
				productos=listproductos.toArray(new Producto[listproductos.size()]);
				
			}//end while
			
			
		} catch (SQLException e) {
			System.out.println("error sql listar");
			System.out.println(e.getMessage());
		}
		

		return productos;
	}//fin obtenerproducto



}