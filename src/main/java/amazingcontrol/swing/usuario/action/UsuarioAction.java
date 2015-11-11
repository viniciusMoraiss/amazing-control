package amazingcontrol.swing.usuario.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import amazingcontrol.swing.usuario.view.TelaUsuario;

/*
 * Classe UsuarioAction
 * Implementa acao de chamar a tela usuario view
 */
public class UsuarioAction implements ActionListener {

	private JFrame mainView;

	public UsuarioAction(JFrame mainView) {
		super();
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new TelaUsuario(mainView).setVisible(true);
	}

}
