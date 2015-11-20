package amazingcontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import amazingcontrol.connection.ConexaoMySQL;
import amazingcontrol.model.Usuario;

/*
 * Classe UsuarioDAO (Data Access Object)
 * Reponsável por toda logica que envolve codigos
 * referente a banco de dados da classe usuario
 */
public class UsuarioDAO implements Crud<Usuario> {

	/*
	 * (non-Javadoc)
	 * @see amazingcontrol.dao.Crud#inserir(java.lang.Object)
	 */
	public void inserir(Usuario usuario) {
		Connection con = ConexaoMySQL.conectar();
		PreparedStatement stmt = null;
		String sql = "INSERT INTO usuarios(nome, senha, confirmacaoSenha, ativo) VALUES (?,?,?,?)";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getConfirmacaoSenha());
			stmt.setBoolean(4, usuario.isAtivo());
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoMySQL.desconectar(con, stmt, null);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see amazingcontrol.dao.Crud#atualizar(java.lang.Object)
	 */
	public void atualizar(Usuario usuario) {
		Connection con = ConexaoMySQL.conectar();
		String sql = "UPDATE usuarios SET nome = ?, senha = ?, confirmacaoSenha = ?, ativo = ? WHERE id = ?";
		PreparedStatement stmt = null;

		try {	
			stmt = con.prepareStatement(sql);
			// prepara consulta
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getConfirmacaoSenha());
			stmt.setBoolean(4, usuario.isAtivo());
			stmt.setInt(5, usuario.getId());
			
			// executa 
			int rows = stmt.executeUpdate();
			
			// tratar os resultados
			if (rows == 0) {
				throw new IllegalArgumentException("DEVERIA TER ATUALIZADO!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoMySQL.desconectar(con, stmt, null);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see amazingcontrol.dao.Crud#deletar(java.lang.Object)
	 */
	public void deletar(Usuario usuario) {
		// TODO verificar se usuario possui venda, caso contrario não pode ser
		// deletado. Implementar quando tiver a classe venda
		Connection con = ConexaoMySQL.conectar();
		String sql = "DELETE FROM usuarios WHERE id = ? ";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, usuario.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoMySQL.desconectar(con, stmt, null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see amazingcontrol.dao.Crud#lista()
	 */
	public List<Usuario> lista() {
		Connection con = ConexaoMySQL.conectar();
		List<Usuario> usuarios = new ArrayList<>();
		String sql = "SELECT * FROM usuarios";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement(sql);

			// executa a consulta sql
			rs = stmt.executeQuery();

			Usuario usuario;

			while (rs.next()) {
				// cria um objeto usuario com id, nome e ativo
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setAtivo(rs.getBoolean("ativo"));

				// adiciona usuario na lista
				usuarios.add(usuario);
			}
			return usuarios;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoMySQL.desconectar(con, stmt, rs);
		}
		return usuarios;
	}

	/*
	 * metodo que recupera um usuario caso ele exista de acordo com os
	 * parametros
	 */
	public Usuario getUsuario(String nome, String senha) {
		Connection con = ConexaoMySQL.conectar();
		Usuario usuario = null;
		String sql = "SELECT * FROM usuarios where nome = ? and senha = ?";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setString(2, senha);
			// executa a consulta sql
			rs = stmt.executeQuery();

			while (rs.next()) {
				String nomeBanco = rs.getString("nome");
				String senhaBanco = rs.getString("senha");

				// retorna usuario se a senha e login for igual ao do banco de
				// dados
				if (nomeBanco.equals(nome) && senhaBanco.equals(senha)) {
					usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setAtivo(rs.getBoolean("ativo"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoMySQL.desconectar(con, stmt, rs);
		}
		return usuario;
	}
	
	public Usuario getUsuarioPorId(Integer id) {
		Connection con = ConexaoMySQL.conectar();
		Usuario usuario = null;
		String sql = "SELECT * FROM usuarios where id = ?";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			// executa a consulta sql
			rs = stmt.executeQuery();

			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setConfirmacaoSenha(rs.getString("confirmacaoSenha"));
				usuario.setAtivo(rs.getBoolean("ativo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoMySQL.desconectar(con, stmt, rs);
		}
		return usuario;
	}
	
	public boolean alterarStatus(Usuario usuario) {
		Connection con = ConexaoMySQL.conectar();
		PreparedStatement stmt = null;
		String sql = "UPDATE usuarios SET ativo = ?  WHERE id = ?";
		boolean alterou = false;

		try {
			Usuario usuarioBanco = getUsuarioPorId(usuario.getId());
			
			if(usuarioBanco != null && usuarioBanco.isAtivo() != usuario.isAtivo()) {
				stmt = con.prepareStatement(sql);
				stmt.setBoolean(1, usuario.isAtivo());
				stmt.setInt(2, usuario.getId());
				
				// executa 
				int rows = stmt.executeUpdate();
				
				// tratar os resultados
				if (rows == 0) {
					throw new IllegalArgumentException("DEVERIA TER ATIVADO!!!");
				}
				
				alterou = true;
			} else {
				alterou = false;
			}

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoMySQL.desconectar(con, stmt, null);
		}
		
		return alterou;
	}

}
