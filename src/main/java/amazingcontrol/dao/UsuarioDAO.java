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
public class UsuarioDAO {
	private Connection con;
	
	/*
	 * Cria uma conexão no construtor
	 */
	public UsuarioDAO() throws SQLException {
		con = ConexaoMySQL.conectar();
	}
	
	/*
	 * método para inserir um novo usuario
	 */
	public void inserir(Usuario usuario) {
		String sql = "INSERT INTO usuarios(nome, senha, confirmacaoSenha, ativo) VALUES (?,?,?,?)";

		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getConfirmacaoSenha());
			stmt.setBoolean(4, usuario.isAtivo());
			stmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * metodo que recupera um usuario caso ele exista de acordo com os parametros
	 */
	public Usuario getUsuario(String nome, String senha) {
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
					usuario.setNome(rs.getString("nome"));
					usuario.setAtivo(rs.getBoolean("ativo"));
					return usuario;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	/*
	 * metodo que retorna lista com usuario cadastrados
	 */
	public List<Usuario> listaUsuarios() {
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
				return usuarios;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	/*
	 * metodo que atualiza usuario
	 */
	public void atualizar(Usuario usuario) {
		// TODO implementar metodo de atualizar um usuario
		
	}
}
