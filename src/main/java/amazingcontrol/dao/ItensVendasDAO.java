package amazingcontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import amazingcontrol.model.ItensVendas;

public class ItensVendasDAO {
	public void inserir(ItensVendas itensVendas, Connection con) {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO itensVendas (produtos_id, vendas_id, valorTotal, quantidade) values (?, ?, ?, ?)";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, itensVendas.getProduto().getId());
			stmt.setInt(2, itensVendas.getVenda().getId());
			stmt.setDouble(3, itensVendas.getValorTotal());
			stmt.setInt(4, itensVendas.getQuantidade());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
