package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class GenericDAO {
	protected Connection miConexion = null;
	// carga del driver de conexion con jdbc
	static {
		// bloque especial que se ejecuta una unica vez a lo largo de la
		// aplicacion la primera vez que esta clase es usada
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("error driver");

		}
	}//fin static
	protected void conectar(){

		
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/db_practica2";
			miConexion = DriverManager.getConnection(url, "root", "jeveris");
		} catch (SQLException e) {
			System.out.println("no puedo conectar a la base de datos");
			e.printStackTrace();
		}
	}//fin conectar
	protected void desconectar(){
		try {
			miConexion.close();
		} catch (SQLException e) {
			System.out.println("no pude desconectar");
		}
	}//fin desconectar
}//fin clase
