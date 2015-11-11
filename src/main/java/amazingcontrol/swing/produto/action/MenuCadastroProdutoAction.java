package amazingcontrol.swing.produto.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import amazingcontrol.swing.principal.view.TelaPrincipal;
import amazingcontrol.swing.produto.view.TelaCadastroProduto;

public class MenuCadastroProdutoAction implements ActionListener {
	
	private JFrame mainView;

	public MenuCadastroProdutoAction(TelaPrincipal mainView) {
       this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new TelaCadastroProduto(mainView).setVisible(true);
	}

}
