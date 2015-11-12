package amazingcontrol.swing.usuario.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.swing.principal.view.TelaPrincipal;
import amazingcontrol.swing.usuario.view.TelaAlterarSenhaUsuario;

public class TelaAlterarSenhaUsuarioAction implements ActionListener {

	private TelaPrincipal view;

	public TelaAlterarSenhaUsuarioAction(TelaPrincipal view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// chama tela de alterar senha
		new TelaAlterarSenhaUsuario(view).setVisible(true);

	}

}
