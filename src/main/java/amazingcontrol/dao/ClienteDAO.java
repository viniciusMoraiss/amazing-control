package amazingcontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import amazingcontrol.model.Cliente;
import amazingcontrol.model.UF;

public class ClienteDAO {

	private Connection con;

	public ClienteDAO(Connection con) {
		this.con = con;
	}
	
	public void inserir(Cliente cliente) {
		String sql = "INSERT INTO clientes (nome, endereco, telefone , cidade, cep, uf) VALUES (?,?,?,?,?,?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getCidade());
			stmt.setString(5, cliente.getCep());
			stmt.setString(6, cliente.getUf().toString());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletar(Connection con, Cliente cliente) {
		String sql = "DELETE FROM clientes WHERE id = ? ";
		
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, cliente.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	public List<Cliente> lista() {
		List<Cliente> Clientes = new ArrayList<>();
		String sql = " SELECT * FROM clientes";
		
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			try(ResultSet rs = stmt.executeQuery()) {
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
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return Clientes;
	}

	public void atualizar(Cliente cliente) {
		String sql = "UPDATE clientes SET nome = ?, endereco= ?, telefone = ? , cidade = ?, cep = ?, uf= ? WHERE id = ?";
	
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getCidade());
			stmt.setString(5, cliente.getCep());
			stmt.setString(6, cliente.getUf().toString());
			stmt.setInt(7, cliente.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Cliente clientePorId(int id) {
		Cliente cliente = null;
		String sql = "SELECT * FROM clientes where id = ?";

		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			
			// executa a consulta sql
			try(ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					cliente = new Cliente();
					cliente.setId(rs.getInt("id"));
					cliente.setNome(rs.getString("nome"));
					cliente.setEndereco(rs.getString("endereco"));
					cliente.setTelefone(rs.getString("telefone"));
					cliente.setCidade(rs.getString("cidade"));
					cliente.setCep(rs.getString("cep"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cliente;
	}
}