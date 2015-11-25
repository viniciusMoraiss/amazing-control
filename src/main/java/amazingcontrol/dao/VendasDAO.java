package amazingcontrol.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import amazingcontrol.model.Venda;

public class VendasDAO {

	private int ultimaVenda;

	public void cadastrar(Connection con, Venda venda) {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO vendas (data, cliente_id, usuario_id) values ( ?, ?, ?)";

		try {
			// insert table vendas
			stmt = con.prepareStatement(sql, stmt.RETURN_GENERATED_KEYS);
			stmt.setDate(1, new Date(venda.getDate().getTimeInMillis()));
			stmt.setInt(2, venda.getCliente().getId());
			stmt.setInt(3, venda.getUsuario().getId());
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				ultimaVenda = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getUltimaVenda() {
		return ultimaVenda;
	}
}
