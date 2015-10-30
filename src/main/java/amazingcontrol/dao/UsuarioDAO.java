package amazingcontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import amazingcontrol.connection.ConexaoMySQL;
import amazingcontrol.model.Usuario;

public class UsuarioDAO {
	private Connection con;
	
	public UsuarioDAO() throws SQLException {
		con = ConexaoMySQL.conectar();
	}
	
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
			
			while(rs.next()) {
				String nomeBanco = rs.getString("nome");
				String senhaBanco = rs.getString("senha");
				
				// retorna usuario se a senha e login for igual ao do banco de dados
				if(nomeBanco.equals(nome) && senhaBanco.equals(senha)) {
					usuario = new Usuario();
					usuario.setNome(rs.getString("nome"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setConfirmacaoSenha(rs.getString("confirmacaoSenha"));
					usuario.setAtivo(rs.getBoolean("ativo"));
					return usuario;				
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
}
