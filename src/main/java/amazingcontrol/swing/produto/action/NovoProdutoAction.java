package amazingcontrol.swing.produto.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.swing.produto.view.TelaCadastroProduto;
import amazingcontrol.swing.produto.view.TelaProduto;

public class NovoProdutoAction implements ActionListener {

	private TelaProduto view;

	public NovoProdutoAction(TelaProduto view) {
		this.view = view;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		new TelaCadastroProduto(view).setVisible(true);
	}

}
