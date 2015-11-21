package amazingcontrol.swing.produto.action;

import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.model.Cliente;
import amazingcontrol.model.Produto;
import amazingcontrol.service.ClienteService;
import amazingcontrol.service.ProdutoService;
import amazingcontrol.swing.cliente.view.TelaCliente;
import amazingcontrol.swing.produto.view.TelaProduto;

public class DeletarProdutoAction implements ActionListener {

	private TelaProduto view;

	public DeletarProdutoAction(TelaProduto view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int rows = view.getProdutoJTable().getSelectedRowCount();

		if (rows == 0) {
			showMessageDialog(view, "Selecione uma linha ou mais linha!");
			return;
		}

		if (showConfirmDialog(view, "Confirma") != YES_OPTION) {
			return;
		}

		try {
			int[] indexes = view.getProdutosJTable().getSelectedRows();
			Produto produto = null;

			for (int index : indexes) {
				produto = (Produto) view.getModel().getValueAt(index, 0);
				new ProdutoService().deletar(produto);
			}

			if (produto != null) {
				view.getProdutoJTable().clearSelection();
				view.carregarProdutos();
			}

		} catch (Exception cause) {
			cause.printStackTrace();
			showMessageDialog(view, cause.getMessage());
		}

	}

}
