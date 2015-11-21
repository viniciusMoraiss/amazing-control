package amazingcontrol.swing.fornecedor.action;

import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.model.Fornecedor;
import amazingcontrol.service.FornecedorService;
import amazingcontrol.swing.fornecedor.view.TelaFornecedor;

public class DeletarFornecedorAction implements ActionListener {

	private TelaFornecedor view;

	public DeletarFornecedorAction(TelaFornecedor view) {
		this.view = view;
		
	}

	public void actionPerformed(ActionEvent e) {

		int rows = view.getJtFornecedor().getSelectedRowCount();

		if (rows == 0) {
			showMessageDialog(view, "selecione uma linha ou mais");
			return;
		}
		if (showConfirmDialog(view, "Confirma") != YES_OPTION) {
			return;
		}

		try {
			int[] indexes = view.getJtFornecedor().getSelectedRows();
			Fornecedor fornecedor = null;

			for (int index : indexes) {
				fornecedor = (Fornecedor) view.getModel().getValueAt(index, 0);
				new FornecedorService().deletar(fornecedor);
			}

			if (fornecedor != null) {
				view.getJtFornecedor().clearSelection();
				view.carregarFornecedores();
			}

		} catch (Exception cause) {
			cause.printStackTrace();
			showMessageDialog(view, cause.getMessage());
		}

	}
}
