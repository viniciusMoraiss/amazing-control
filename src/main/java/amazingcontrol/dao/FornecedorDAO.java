package amazingcontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import amazingcontrol.connection.ConexaoMySQL;
import amazingcontrol.model.Fornecedor;
import amazingcontrol.model.Usuario;

public class FornecedorDAO {
	private Connection con;

	public FornecedorDAO() throws SQLException {
		con = ConexaoMySQL.conectar();
	}

	public void inserir(Fornecedor fornecedor) {
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
		}
	}

	public void delete(Fornecedor fornecedor) {
		String sql = "DELETE FROM fornecedor WHERE id = ? ";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, fornecedor.getId());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Fornecedor fornecedor) {
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
		}
	}

	public List<Fornecedor> listaFornecedores() {
		List<Fornecedor> Fornecedores = new ArrayList<>();
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

				Fornecedores.add(fornecedor);
				return Fornecedores;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Fornecedores;
	}

	public void atualizar(Usuario usuario) {
		// TODO implementar metodo de atualizar um usuario

	}
}