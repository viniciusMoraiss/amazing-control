package amazingcontrol.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import amazingcontrol.connection.ConexaoMySQL;
import amazingcontrol.model.Cliente;
import amazingcontrol.model.Usuario;


public class ClienteDAO {
	
	private Connection con;

	public ClienteDAO () throws SQLException {
		con = ConexaoMySQL.conectar();
	}

	public void inserir(Cliente cliente) {
		String sql = "INSERT INTO cliente (nome,endereco,telefone , cidade, cep, uf) VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setInt(3, cliente.getTelefone());
			stmt.setString(4, cliente.getCidade());
			stmt.setInt(5, cliente.getCep());
			stmt.setString(6, cliente.getUf());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Cliente cliente) {
		String sql = "DELETE FROM cliente WHERE id = ? ";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, cliente.getId());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Cliente cliente) {
		String sql = "UPDATE INTO cliente (nome,endereco,telefone , cidade, cep, uf) VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setInt(3, cliente.getTelefone());
			stmt.setString(4, cliente.getCidade());
			stmt.setInt(5, cliente.getCep());
			stmt.setString(6, cliente.getUf());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Cliente> listaClientes() {
		List<Cliente> Clientes = new ArrayList<>();
		String sql = " SELECT * FROM cliente";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			Cliente cliente;

			while (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setTelefone(rs.getInt("telefone"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setCep(rs.getInt("cep"));
				cliente.setUf(rs.getString("uf"));

				Clientes.add(cliente);
				return Clientes;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Clientes;
	}

	public void atualizar(Usuario usuario) {
		// TODO implementar metodo de atualizar um usuario

	}
}