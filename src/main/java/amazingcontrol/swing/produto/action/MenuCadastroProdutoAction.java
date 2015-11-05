package amazingcontrol.swing.produto.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import amazingcontrol.swing.principal.view.MainView;
import amazingcontrol.swing.produto.view.CadastroProdutoView;

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
