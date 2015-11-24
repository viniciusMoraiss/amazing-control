package amazingcontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import amazingcontrol.model.Fornecedor;
import amazingcontrol.model.UF;

public class FornecedorDAO implements Crud<Fornecedor> {

	public void inserir(Connection con, Fornecedor fornecedor) {
		String sql = "INSERT INTO fornecedores (nome, telefone, endereco, cidade, cep, uf) VALUES (?,?,?,?,?,?)";
		
		try(PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, fornecedor.getNome());
			stmt.setString(2, fornecedor.getTelefone());
			stmt.setString(3, fornecedor.getEndereco());
			stmt.setString(4, fornecedor.getCidade());
			stmt.setString(5, fornecedor.getCep());
			stmt.setString(6, fornecedor.getUf().toString());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletar(Connection con, Fornecedor fornecedor) {
		String sql = "DELETE FROM fornecedores WHERE id = ? ";

		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, fornecedor.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Connection con, Fornecedor fornecedor) {
		String sql = "UPDATE fornecedores SET nome = ?, telefone = ?, endereco = ?, cidade = ? , cep = ?, uf = ? where id = ?";
		
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, fornecedor.getNome());
			stmt.setString(2, fornecedor.getTelefone());
			stmt.setString(3, fornecedor.getEndereco());
			stmt.setString(4, fornecedor.getCidade());
			stmt.setString(5, fornecedor.getCep());
			stmt.setString(6, fornecedor.getUf().toString());
			stmt.setInt(7, fornecedor.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Fornecedor> lista(Connection con) {
		List<Fornecedor> fornecedores = new ArrayList<>();
		String sql = " SELECT * FROM fornecedores";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			try (ResultSet rs = stmt.executeQuery()) {
				Fornecedor fornecedor;

				while (rs.next()) {
					fornecedor = new Fornecedor();
					fornecedor.setId(rs.getInt("id"));
					fornecedor.setNome(rs.getString("nome"));
					fornecedor.setTelefone(rs.getString("telefone"));
					fornecedor.setEndereco(rs.getString("endereco"));
					fornecedor.setCidade(rs.getString("cidade"));
					fornecedor.setCep(rs.getString("cep"));

					// seta uf do banco
					for (UF uf : UF.values()) {
						if (rs.getString("uf").equals(uf.toString())) {
							fornecedor.setUf(uf);
						}
					}

					fornecedores.add(fornecedor);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fornecedores;
	}
}