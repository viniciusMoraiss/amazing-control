package amazingcontrol.swing.fornecedor.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.swing.fornecedor.view.TelaCadastroFornecedor;
import amazingcontrol.swing.fornecedor.view.TelaFornecedor;

// chama a TelaCadastroFornecedor atravez do btNovo da TelaFornecedor
public class NovoFornecedorAction implements ActionListener {

	private TelaFornecedor view;

	public NovoFornecedorAction(TelaFornecedor view) {
		this.view = view;
	}

	public void actionPerformed(ActionEvent e) {
		new TelaCadastroFornecedor(view).setVisible(true);
	}

}
