package amazingcontrol.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import amazingcontrol.connection.ConexaoMySQL;
import amazingcontrol.dao.UsuarioDAO;
import amazingcontrol.model.Usuario;

/*
 * Classe UsuarioService
 * Resposavel por centralizar as logicas referente ao modelo Usuario
 */
public class UsuarioService {
	private Connection con;
	private UsuarioDAO dao;
	
	/*
	 * Cria acesso ao metodos do banco já no construtor
	 */
	public UsuarioService() throws SQLException {
		dao = new UsuarioDAO();
		con = ConexaoMySQL.conectar();
	}
	
	/*
	 * metodo para carregar lista de usuarios
	 */
	public List<Usuario> listar() {
		return dao.lista(con);
	}
	
	/*
	 * Metodo para salvar usuario no banco de dados, respeitando a logica:
	 * - ira validar os campos
	 * - caso o id seja igual a null ira inserir o usuario
	 * - caso o id seja diferente de null ira atualizar um usuario existente
	 */
	public void salvar(Usuario usuario) {
		if (usuario.isNullId()) {
			dao.inserir(con, usuario);
		} else {
			dao.atualizar(con, usuario);
		}
	}
	
	/*
	 * Metodo para deletar usuario
	 */
	public void deletar(Usuario usuario) {
		dao.deletar(con, usuario);
	}
	
	public Usuario getUsuario(String nome, String senha) {
		return dao.getUsuario(con, nome, senha);
	}
	
	public boolean alterarStatus(Usuario usuario) {
		return dao.alterarStatus(con, usuario);
	}

	public Usuario getUsuarioPorId(int id) {
		return dao.getUsuarioPorId(con, id);
	}
	
}
