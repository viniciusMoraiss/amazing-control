package amazingcontrol.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
	
	private Usuario usuario;
	
	@Before
	public void setUp() {
		usuario = new Usuario();
	}
	
	@Test
	public void deve_setar_nome_de_usuario_valido() {
		usuario.setNome("felipe");
		assertTrue(usuario.getNome().equals("felipe"));
	}
	
	@Test
	public void deve_setar_senha_de_usuario_valido() {
		usuario.setNome("felipe");
		usuario.setSenha("segredo");
		assertTrue(usuario.getSenha().equals("segredo"));
	}
	
	@Test
	public void confirmacao_de_senha_deve_ser_igual_a_senha() {
		usuario.setSenha("segredo");
		usuario.setConfirmacaoSenha("segredo");
		assertTrue(usuario.getSenha().equals(usuario.getConfirmacaoSenha()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_lancar_execption_se_confirmacao_de_senha_for_dirente_de_senha() {
		usuario.setSenha("segredo");
		usuario.setConfirmacaoSenha("senha");
		assertTrue(!usuario.getSenha().equals(usuario.getConfirmacaoSenha()));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_lancar_illegal_argument_expection_se_nome_for_vazio() {
		usuario.setNome("");
	}

}
