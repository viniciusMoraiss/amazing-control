package amazingcontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import amazingcontrol.connection.ConexaoMySQL;
import amazingcontrol.model.Fornecedor;

public class FornecedorDAO {

	public void inserir(Fornecedor fornecedor) {
		Connection con = ConexaoMySQL.conectar();
		String sql = "INSERT INTO fornecedor (nome, telefone, endereço, cidade, cep, uf) VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, fornecedor.getNome());
			stmt.setInt(2, fornecedor.getTelefone());
			stmt.setString(3, fornecedor.getEndereco());
			stmt.setString(4, fornecedor.getCidade());
			stmt.setInt(5, fornecedor.getCep());
			stmt.setString(6, fornecedor.getUf());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexaoMySQL.desconectar(con, stmt, null);
		}
	}

	public void apagar(Fornecedor fornecedor) {
		Connection con = ConexaoMySQL.conectar();
		String sql = "DELETE FROM fornecedor WHERE id = ? ";
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
		String sql = "UPDATE INTO fornecedor (nome, telefone, endereço, cidade, cep, uf) VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, fornecedor.getNome());
			stmt.setInt(2, fornecedor.getTelefone());
			stmt.setString(3, fornecedor.getEndereco());
			stmt.setString(4, fornecedor.getCidade());
			stmt.setInt(5, fornecedor.getCep());
			stmt.setString(6, fornecedor.getUf());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexaoMySQL.desconectar(con, stmt, null);
		}
	}

	public List<Fornecedor> listaFornecedores() {
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
				fornecedor.setTelefone(rs.getInt("telefone"));
				fornecedor.setEndereco(rs.getString("endereço"));
				fornecedor.setCidade(rs.getString("cidade"));
				fornecedor.setCep(rs.getInt("cep"));
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