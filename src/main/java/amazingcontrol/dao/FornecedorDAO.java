package amazingcontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import amazingcontrol.connection.ConexaoMySQL;
import amazingcontrol.model.Fornecedor;

public class FornecedorDAO implements Crud<Fornecedor> {

	public void inserir(Fornecedor fornecedor) {
		Connection con = ConexaoMySQL.conectar();
		String sql = "INSERT INTO fornecedores (nome, telefone, endereco, cidade, cep, uf) VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, fornecedor.getNome());
			stmt.setString(2, fornecedor.getTelefone());
			stmt.setString(3, fornecedor.getEndereco());
			stmt.setString(4, fornecedor.getCidade());
			stmt.setString(5, fornecedor.getCep());
			stmt.setString(6, fornecedor.getUf());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexaoMySQL.desconectar(con, stmt, null);
		}
	}

	public void deletar(Fornecedor fornecedor) {
		Connection con = ConexaoMySQL.conectar();
		String sql = "DELETE FROM fornecedores WHERE id = ? ";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, fornecedor.getId());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexaoMySQL.desconectar(con, stmt, null);
		}
	}

	public void atualizar(Fornecedor fornecedor) {
		Connection con = ConexaoMySQL.conectar();
		String sql = "UPDATE INTO fornecedores (nome, telefone, endereço, cidade, cep, uf) VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, fornecedor.getNome());
			stmt.setString(2, fornecedor.getTelefone());
			stmt.setString(3, fornecedor.getEndereco());
			stmt.setString(4, fornecedor.getCidade());
			stmt.setString(5, fornecedor.getCep());
			stmt.setString(6, fornecedor.getUf());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexaoMySQL.desconectar(con, stmt, null);
		}
	}

	public List<Fornecedor> lista() {
		Connection con = ConexaoMySQL.conectar();
		List<Fornecedor> fornecedores = new ArrayList<>();
		String sql = " SELECT * FROM Fornecedores";
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			Fornecedor fornecedor;

			while (rs.next()) {
				fornecedor = new Fornecedor();
				fornecedor.setId(rs.getInt("id"));
				fornecedor.setNome(rs.getString("nome"));
				fornecedor.setTelefone(rs.getString("telefone"));
				fornecedor.setEndereco(rs.getString("endereço"));
				fornecedor.setCidade(rs.getString("cidade"));
				fornecedor.setCep(rs.getString("cep"));
				fornecedor.setUf(rs.getString("uf"));

				fornecedores.add(fornecedor);
			}

			return fornecedores;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexaoMySQL.desconectar(con, stmt, rs);
		}

		return fornecedores;
	}
}