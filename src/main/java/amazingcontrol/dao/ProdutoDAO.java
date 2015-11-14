package amazingcontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import amazingcontrol.connection.ConexaoMySQL;
import amazingcontrol.model.Produto;

public class ProdutoDAO implements Crud<Produto> {

	@Override
	public void inserir(Produto produto) {
		Connection con = ConexaoMySQL.conectar();
		PreparedStatement stmt = null;
		String sql = "INSERT INTO produto(nome, marca, tipo, valorCusto, valorVenda, quantidadeDeProduto ) VALUES (?,?,?,?,?,?)";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getMarca());
			stmt.setString(3, produto.getTipo());
			stmt.setDouble(4, produto.getValorCusto());
			stmt.setDouble(5, produto.getValorVenda());
			stmt.setInt(6, produto.getQuantidadeDeProduto());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexaoMySQL.desconectar(con, stmt, null);
		}
	}

	@Override
	public void atualizar(Produto produto) {
		Connection con = ConexaoMySQL.conectar();
		String sql = "UPDATE INTO produto (nome, marca, tipo, valorCusto, valorVenda, quantidadeDeProduto) VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getMarca());
			stmt.setString(3, produto.getTipo());
			stmt.setDouble(4, produto.getValorCusto());
			stmt.setDouble(5, produto.getValorVenda());
			stmt.setInt(6, produto.getQuantidadeDeProduto());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexaoMySQL.desconectar(con, stmt, null);
		}
	}

	@Override
	public void deletar(Produto produto) {
		Connection con = ConexaoMySQL.conectar();
		String sql = "DELETE FROM produto WHERE id = ? ";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, produto.getId());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexaoMySQL.desconectar(con, stmt, null);
		}
	}

	@Override
	public List<Produto> lista() {
		Connection con = ConexaoMySQL.conectar();
		List<Produto> produtos = new ArrayList<>();
		String sql = " SELECT * FROM produto";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			Produto produto;

			while (rs.next()) {
				produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setMarca(rs.getString("Marca"));
				produto.setTipo(rs.getString("Tipo"));
				produto.setValorCusto(rs.getDouble("Valor Custo"));
				produto.setValorVenda(rs.getDouble("Valor Venda"));
				produto.setQuantidadeDeProduto(rs.getInt("Produto"));
				produtos.add(produto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexaoMySQL.desconectar(con, stmt, rs);
		}

		return produtos;
	}

}
