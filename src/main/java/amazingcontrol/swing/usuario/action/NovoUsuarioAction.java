package amazingcontrol.swing.usuario.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.swing.usuario.view.TelaCadastroUsuario;
import amazingcontrol.swing.usuario.view.TelaUsuario;

/*
 * Classe MenuCadastroUsuarioAction
 * implementa acao de chamar a tela de cadastro do usuario (CadastroUsuarioView)
 */
public class NovoUsuarioAction implements ActionListener {

	private TelaUsuario view;

	public NovoUsuarioAction(TelaUsuario view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new TelaCadastroUsuario(view).setVisible(true);
	}

}
