package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daos.AdministradoresDAO;
import daos.ConstantesSql;
import daos.GenericDAO;

public class AdministradoresDAOImpl extends GenericDAO implements AdministradoresDAO{

	@Override
	public boolean identificarAdministrador(String login, String pass) {
		boolean identificado = false;
		conectar();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSql.IDENTIFICACION_ADMINISTRADOR);
			ps.setString(1, login);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				//si esto se cumple la identificacion es correcta
				identificado=true;
			}
		} catch (SQLException e) {
			System.out.println("error al identificarse");
			System.out.println(e.getMessage());
		}
		
		desconectar();
	return identificado;
}


}
