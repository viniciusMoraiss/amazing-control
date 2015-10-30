package amazingcontrol.model;

import amazingcontrol.dao.UsuarioDAO;

public class UsuarioTest {
	public static void main(String[] args) {
		Usuario user = new Usuario();
		user.setNome("psicologo");
		user.setSenha("segredo");
		user.setConfirmacaoSenha("segredo");
		user.setAtivo(false);
		
		UsuarioDAO dao = null;
		
		try {
			dao = new UsuarioDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
