package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import daos.ClientesDAO;
import daos.ConstantesSql;
import daos.GenericDAO;

public class ClientesDAOImpl extends GenericDAO implements ClientesDAO{

	@Override
	public void registrarCliente(Cliente cliente) {
conectar();
		try {
			System.out.println("intentamos insertar cliente");
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSql.INSERCION_CLIENTE);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getCalle());
			ps.setString(3, cliente.getNumeracion());
			ps.setString(4, cliente.getCodigoPostal());
			ps.setString(5, cliente.getPoblacion());
			ps.setString(6, cliente.getTelefono());
			ps.setString(7, cliente.getEmail());
			ps.setString(8, cliente.getParticularOEmpresa());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("error sql insertar");
		}
		desconectar();
	}//end registrar

	@Override
	public List<Cliente> obtenerClientes() {
		conectar();
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(ConstantesSql.SELECCION_CLIENTES);
			ResultSet resultado =ps.executeQuery();
			
			while(resultado.next()){
				Cliente cliente = new Cliente();
				cliente.setNombre(resultado.getString("nombre"));
				cliente.setCalle(resultado.getString("calle"));
				cliente.setNumeracion(resultado.getString("numeracion"));
				cliente.setCodigoPostal(resultado.getString("codigo_postal"));
				cliente.setPoblacion(resultado.getString("poblacion"));
				cliente.setTelefono(resultado.getString("telefono"));
				cliente.setEmail(resultado.getString("email"));
				cliente.setParticularOEmpresa(resultado.getString("particular_empresa"));
				cliente.setId(resultado.getInt("id"));
				clientes.add(cliente);
				}
			} catch (SQLException e) {
			System.out.println("error sql listar");
			System.out.println(e.getMessage());
		}
		desconectar();
		return clientes;
	}//end obtener

	@Override
	public void borrarCliente(int id) {
		conectar();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSql.BORRAR_CLIENTE);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("error sql borrar");
		}
		desconectar();
	}//fin borrarcliente

	@Override
	public Cliente obtenerClientePorId(int id) {
		conectar();
		Cliente cliente = new Cliente();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSql.OBTENER_CLIENTE_POR_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				cliente.setNombre(rs.getString("nombre"));
				cliente.setCalle(rs.getString("calle"));
				cliente.setNumeracion(rs.getString("numeracion"));
				cliente.setCodigoPostal(rs.getString("codigo_postal"));
				cliente.setPoblacion(rs.getString("poblacion"));
				cliente.setTelefono(rs.getString("telefono"));
				cliente.setEmail(rs.getString("email"));
				cliente.setParticularOEmpresa(rs.getString("particular_empresa"));
				cliente.setId(rs.getInt("id"));
				cliente.setId(id);
				
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("error sql obtener cliente por id");
			System.out.println(e.getMessage());
		}
		desconectar();
		return cliente;
	}//fin obtener por id

	@Override
	public void guardarCambiosCliente(Cliente cliente) {
conectar();
		
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSql.GUARDAR_CAMBIOS_CLIENTE);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getCalle());;
			ps.setString(3, cliente.getNumeracion());
			ps.setString(4, cliente.getCodigoPostal());
			ps.setString(5, cliente.getPoblacion());
			ps.setString(6, cliente.getTelefono());
			ps.setString(7, cliente.getEmail());
			ps.setString(8, cliente.getParticularOEmpresa());
			ps.setInt(9, cliente.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("error sql guardar cliente");
		}
		
		desconectar();
	}

}
