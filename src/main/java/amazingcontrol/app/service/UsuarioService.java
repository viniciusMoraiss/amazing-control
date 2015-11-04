package amazingcontrol.app.service;

import java.sql.SQLException;

import amazingcontrol.dao.UsuarioDAO;
import amazingcontrol.model.Usuario;

public class UsuarioService {
	UsuarioDAO dao;
	
	public UsuarioService() throws SQLException {
		dao = new UsuarioDAO();
	}
	
	private void validar(Usuario usuario) throws Exception {
		usuario.validaNome();
		usuario.validaSenha();
	}
	
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
