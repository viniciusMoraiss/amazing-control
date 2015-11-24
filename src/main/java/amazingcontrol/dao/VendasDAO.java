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
	
	/*
	public Venda vendas() {

		Connection con = ConexaoMySQL.conectar();
		Venda venda = null;
		String sql = "SELECT * FROM vendas where id = ?";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, ultimaVenda);
			// executa a consulta sql
			rs = stmt.executeQuery();

			if (rs.next()) {
				venda = new Venda();

				int IdCliente = rs.getInt("cliente_id");
				Cliente cliente = new ClienteService().getClientePorId(IdCliente);

				int idUsuario = rs.getInt("usuario_id");
				Usuario usuario = new UsuarioService().getUsuarioPorId(idUsuario);

				venda.setCliente(cliente);
				venda.setUsuario(usuario);

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				venda.setDate(data);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return venda;
	}
	*/
}
