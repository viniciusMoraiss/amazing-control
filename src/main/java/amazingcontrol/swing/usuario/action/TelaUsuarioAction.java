package amazingcontrol.swing.usuario.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.swing.principal.view.TelaPrincipal;
import amazingcontrol.swing.usuario.view.TelaUsuario;

/*
 * Classe UsuarioAction
 * Implementa acao de chamar a tela usuario view
 */
public class TelaUsuarioAction implements ActionListener {

	private TelaPrincipal mainView;

	public TelaUsuarioAction(TelaPrincipal mainView) {
		super();
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new TelaUsuario(mainView).setVisible(true);
	}

}
