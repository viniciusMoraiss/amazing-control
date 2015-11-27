package amazingcontrol.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
	

	private static Connection con = null;
	
	public static Connection conectar() {
		String user = "amazing";
		String senha = "";

		// tenta localizar o driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// tenta conectar
		try {
			
			if(con == null){
				con = DriverManager.getConnection("jdbc:mysql://localhost/amazing_control", user, senha);
				System.out.println("Conexao aberta");
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
				System.out.println("Conexao fechada");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
