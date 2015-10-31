package amazingcontrol.app.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import amazingcontrol.app.view.CadastroUsuarioView;

public class MenuCadastroUsuarioAction implements ActionListener {
	
	private JFrame mainView;

	public MenuCadastroUsuarioAction(JFrame mainView) {
		super();
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new CadastroUsuarioView(mainView).setVisible(true);
	}

}
