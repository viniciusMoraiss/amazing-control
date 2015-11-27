package amazingcontrol.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
	
	private static Connection con = null;
	
	
	public static Connection conectar() {

		// tenta localizar o driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// tenta conectar
		try {
			
			if(con == null){
				String user = "amazing";
				String senha = "";
				con = DriverManager.getConnection("jdbc:mysql://localhost/amazing_control", user, senha);
				return con;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

	public static void desconectar(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
