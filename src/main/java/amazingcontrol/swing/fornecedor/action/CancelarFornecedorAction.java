package amazingcontrol.swing.fornecedor.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.swing.fornecedor.view.TelaCadastroFornecedor;

public class CancelarFornecedorAction implements ActionListener {

	private TelaCadastroFornecedor view;

	public CancelarFornecedorAction(TelaCadastroFornecedor view) {
		this.view = view;

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == view.getCancelarBt()) {
			view.dispose();

		}
	}

}
