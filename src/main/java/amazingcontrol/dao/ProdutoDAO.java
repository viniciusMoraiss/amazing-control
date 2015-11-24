package amazingcontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import amazingcontrol.model.Produto;

public class ProdutoDAO implements Crud<Produto> {

	@Override
	public void inserir(Connection con, Produto produto) {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO produtos(nome, marca, tipo, valorCusto, valorVenda, quantidade ) VALUES (?,?,?,?,?,?)";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getMarca());
			stmt.setString(3, produto.getTipo());
			stmt.setDouble(4, produto.getValorCusto());
			stmt.setDouble(5, produto.getValorVenda());
			stmt.setInt(6, produto.getQuantidade());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Connection con, Produto produto) {
		String sql = "UPDATE produtos SET nome = ?, marca = ?, tipo = ?, valorCusto = ?, valorVenda = ?, quantidade = ? where id = ?";

		try (PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getMarca());
			stmt.setString(3, produto.getTipo());
			stmt.setDouble(4, produto.getValorCusto());
			stmt.setDouble(5, produto.getValorVenda());
			stmt.setInt(6, produto.getQuantidade());
			stmt.setInt(7, produto.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletar(Connection con, Produto produto) {
		String sql = "DELETE FROM produtos WHERE id = ? ";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, produto.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Produto> lista(Connection con) {
		List<Produto> produtos = new ArrayList<>();
		String sql = " SELECT * FROM produtos";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			try (ResultSet rs = stmt.executeQuery()) {

				Produto produto;

				while (rs.next()) {
					produto = new Produto();
					produto.setId(rs.getInt("id"));
					produto.setNome(rs.getString("nome"));
					produto.setMarca(rs.getString("Marca"));
					produto.setTipo(rs.getString("Tipo"));
					produto.setValorCusto(rs.getDouble("ValorCusto"));
					produto.setValorVenda(rs.getDouble("ValorVenda"));
					produto.setQuantidade(rs.getInt("quantidade"));

					// adiciona produto na lista
					produtos.add(produto);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return produtos;
	}

	public Produto getProdutoPorId(Connection con, int id) {
		Produto produto = null;
		String sql = "SELECT * FROM produtos where id = ?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);

			// executa a consulta sql
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					produto = new Produto();
					produto.setId(rs.getInt("id"));
					produto.setNome(rs.getString("nome"));
					produto.setMarca(rs.getString("Marca"));
					produto.setTipo(rs.getString("Tipo"));
					produto.setValorCusto(rs.getDouble("ValorCusto"));
					produto.setValorVenda(rs.getDouble("ValorVenda"));
					produto.setQuantidade(rs.getInt("quantidade"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return produto;
	}
}
