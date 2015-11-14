package amazingcontrol.swing.fornecedor.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.swing.fornecedor.view.TelaCadastroFornecedor;

// chama a TelaCadastroFornecedor atravez do btNovo da TelaFornecedor

public class NovoFornecedorAction implements ActionListener {

	public void actionPerformed(ActionEvent arg0) {
		new TelaCadastroFornecedor().setVisible(true);
	}

}
