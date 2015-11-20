package amazingcontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import amazingcontrol.connection.ConexaoMySQL;
import amazingcontrol.model.Cliente;
import amazingcontrol.model.UF;

public class ClienteDAO implements Crud<Cliente> {

	public void inserir(Cliente cliente) {
		Connection con = ConexaoMySQL.conectar();
		String sql = "INSERT INTO clientes (nome, endereco, telefone , cidade, cep, uf) VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getCidade());
			stmt.setString(5, cliente.getCep());
			stmt.setString(6, cliente.getUf().toString());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexaoMySQL.desconectar(con, stmt, null);
		}
	}

	@Override
	public void deletar(Cliente cliente) {
		Connection con = ConexaoMySQL.conectar();
		String sql = "DELETE FROM clientes WHERE id = ? ";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, cliente.getId());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexaoMySQL.desconectar(con, stmt, null);
		}
	}

	public List<Cliente> lista() {
		Connection con = ConexaoMySQL.conectar();
		List<Cliente> Clientes = new ArrayList<>();
		String sql = " SELECT * FROM clientes";
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
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setCep(rs.getString("cep"));
				
				// seta uf do banco
				for(UF uf : UF.values()) {
					if(rs.getString("uf").equals(uf.toString())) {
						cliente.setUf(uf);
					}
				}
				
				Clientes.add(cliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexaoMySQL.desconectar(con, stmt, rs);
		}

		return Clientes;
	}

	@Override
	public void atualizar(Cliente cliente) {
		Connection con = ConexaoMySQL.conectar();
		String sql = "UPDATE INTO clientes (nome,endereco,telefone , cidade, cep, uf) VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getCidade());
			stmt.setString(5, cliente.getCep());
			stmt.setString(6, cliente.getUf().toString());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexaoMySQL.desconectar(con, stmt, null);
		}

	}
}