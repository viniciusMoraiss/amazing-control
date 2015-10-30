package amazingcontrol.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoMySQL {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public static Connection conectar() throws SQLException {
		String user = "amazing";
		String senha = "";
		return DriverManager.getConnection("jdbc:mysql://localhost/amazing_control", user, senha );
	}
	
	public static void desconectar(Connection conn) throws SQLException {
		conn.close();
	}
	
}
