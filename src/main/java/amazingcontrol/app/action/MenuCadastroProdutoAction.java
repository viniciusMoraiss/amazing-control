package amazingcontrol.app.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import amazingcontrol.app.view.CadastroProdutoView;
import amazingcontrol.app.view.MainView;

public class MenuCadastroProdutoAction implements ActionListener {
	
	private JFrame mainView;

	public MenuCadastroProdutoAction(MainView mainView) {
       this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new CadastroProdutoView(mainView).setVisible(true);
	}

}
