package amazingcontrol.swing.principal.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.swing.principal.view.TelaPrincipal;
import amazingcontrol.swing.produto.view.TelaProduto;

public class MenuCadastroProdutoAction implements ActionListener {

	private TelaPrincipal view;

	public MenuCadastroProdutoAction(TelaPrincipal view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new TelaProduto(view).setVisible(true);
	}

}
