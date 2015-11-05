package amazingcontrol.swing.usuario.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import amazingcontrol.swing.usuario.view.CadastroUsuarioView;

/*
 * Classe MenuCadastroUsuarioAction
 * implementa acao de chamar a tela de cadastro do usuario (CadastroUsuarioView)
 */
public class CadastroUsuarioAction implements ActionListener {
	
	private JFrame mainView;

	public CadastroUsuarioAction(JFrame mainView) {
		super();
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new CadastroUsuarioView(mainView).setVisible(true);
	}

}
