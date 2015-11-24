package amazingcontrol.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoMySQL {

	public static Connection conectar() {

		// tenta localizar o driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = null;

		// tenta conectar
		try {
			String user = "amazing";
			String senha = "";
			conn = DriverManager.getConnection("jdbc:mysql://localhost/amazing_control", user, senha);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	public void desconectar(Connection conn, PreparedStatement pstm, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
