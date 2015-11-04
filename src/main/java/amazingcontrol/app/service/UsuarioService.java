package amazingcontrol.app.service;

import java.sql.SQLException;

import amazingcontrol.dao.UsuarioDAO;
import amazingcontrol.model.Usuario;

/*
 * Classe UsuarioService
 * Resposavel por centralizar as logicas referente ao modelo Usuario
 */
public class UsuarioService {
	UsuarioDAO dao;
	
	/*
	 * Cria acesso ao metodos do banco já no construtor
	 */
	public UsuarioService() throws SQLException {
		dao = new UsuarioDAO();
	}
	
	/*
	 * metodo privado para chamar os metodos de validacoes do usuario
	 */
	private void validar(Usuario usuario) throws Exception {
		usuario.validaNome();
		usuario.validaSenha();
	}
	
	/*
	 * Metodo para salvar usuario no banco de dados, respeitando a logica:
	 * - ira validar os campos
	 * - caso o id seja igual a null ira inserir o usuario
	 * - caso o id seja diferente de null ira atualizar um usuario existente
	 */
	public void salvar(Usuario usuario) throws Exception {
		// valida usuario antes de inserir ou atualizar
		validar(usuario);
		
		if (usuario.isNullId()) {
			dao.inserir(usuario);
		} else {
			dao.atualizar(usuario);
		}
	}
	
}
