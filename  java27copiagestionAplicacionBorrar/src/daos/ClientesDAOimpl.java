package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

public class ClientesDAOimpl implements ClientesDAO {

	private Connection miConexion = null;

	public ClientesDAOimpl() {
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

	public void registrarCliente(Cliente c) {

		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(ConstantesSQL.sqlInsercionCliente);
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getDomicilio());
			ps.setString(3, c.getPoblacion());
			ps.setString(4, c.getCodigopostal());
			ps.setString(5, c.getTelefono());

			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("error sql insertar");
		}

	}// close registrarCliente

	public void borrarCliente(int id) {
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.sqlBorradoCliente);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("la sql de borrado esta mal");
		}

	}

	public Cliente[] obtenerClientes() {

		Cliente[] clientes = null;
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.sqlSeleccionCliente);
			ResultSet resultado = ps.executeQuery();
			List<Cliente> listClientes = new ArrayList<Cliente>();
			while(resultado.next()){
				Cliente c = new Cliente();
				c.setNombre(resultado.getString("nombre"));
				c.setDomicilio(resultado.getString("domicilio"));
				c.setPoblacion(resultado.getString("Poblacion"));
				c.setCodigopostal(resultado.getString("codigo_postal"));
				c.setTelefono(resultado.getString("telefono"));
				c.setId(resultado.getInt("id"));
				listClientes.add(c);
				
				clientes=listClientes.toArray(new Cliente[listClientes.size()]);
				
			}//end while
			
			
		} catch (SQLException e) {
			System.out.println("error sql listar");
			System.out.println(e.getMessage());
		}

		return clientes;
	}// end obtenerclientes
	
	/*main para testear
public static void main(String[] args) {
	ClientesDAOimpl dao=new ClientesDAOimpl();
	Cliente[] clientes = dao.obtenerClientes();
	for (Cliente cliente : clientes) {
		System.out.println(cliente.toString());
	}
	}*/
	
}
