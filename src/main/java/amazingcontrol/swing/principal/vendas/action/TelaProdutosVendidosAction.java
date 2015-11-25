package amazingcontrol.swing.principal.vendas.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.swing.principal.view.TelaPrincipal;
import amazingcontrol.swing.vendas.view.TelaProdutosVendidos;

public class TelaProdutosVendidosAction implements ActionListener {
	TelaPrincipal view;
	
	public TelaProdutosVendidosAction(TelaPrincipal view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new TelaProdutosVendidos(view).setVisible(true);;
	}

}
