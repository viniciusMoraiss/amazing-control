package amazingcontrol.swing.cliente.action;

import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.model.Cliente;
import amazingcontrol.service.ClienteService;
import amazingcontrol.swing.cliente.view.TelaCliente;

public class DeletarClienteAction implements ActionListener {

	private TelaCliente view;

	public DeletarClienteAction(TelaCliente view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int rows = view.getClientesJTable().getSelectedRowCount();

		if (rows == 0) {
			showMessageDialog(view, "Selecione uma linha ou mais linha!");
			return;
		}

		if (showConfirmDialog(view, "Confirma") != YES_OPTION) {
			return;
		}

		try {
			int[] indexes = view.getClientesJTable().getSelectedRows();
			Cliente cliente = null;

			for (int index : indexes) {
				cliente = (Cliente) view.getModel().getValueAt(index, 0);
				new ClienteService().deletar(cliente);
			}

			if (cliente != null) {
				view.getClientesJTable().clearSelection();
				view.carregarClientes();
			}

		} catch (Exception cause) {
			cause.printStackTrace();
			showMessageDialog(view, cause.getMessage());
		}

	}

}
