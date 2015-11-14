package amazingcontrol.swing.fornecedor.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.swing.fornecedor.view.TelaCadastroFornecedor;
import amazingcontrol.swing.principal.view.TelaPrincipal;

// chama a TelaCadastroFornecedor atravez do btNovo da TelaFornecedor
public class NovoFornecedorAction implements ActionListener {

	private TelaPrincipal view;

	public NovoFornecedorAction(TelaPrincipal view) {
		this.view = view;
	}

	public void actionPerformed(ActionEvent e) {
		new TelaCadastroFornecedor(view).setVisible(true);
	}

}
