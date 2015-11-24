package amazingcontrol.swing.vendas.action;

import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.model.Cliente;
import amazingcontrol.model.Usuario;
import amazingcontrol.swing.vendas.view.TelaPesquisarCliente;
import amazingcontrol.swing.vendas.view.TelaVenderProdutos;

public class VenderAction implements ActionListener {

	private TelaPesquisarCliente telaPesquisarCliente;
	private Usuario usuario;

	public VenderAction(TelaPesquisarCliente telaPesquisarCliente, Usuario usuario) {
		this.telaPesquisarCliente = telaPesquisarCliente;
		this.usuario = usuario;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int row = telaPesquisarCliente.getClientesJTable().getSelectedRowCount();

		if (row == 0) {
			showMessageDialog(telaPesquisarCliente, "Selecione um cliente!");
			return;
		}
		
		if(row > 1 ) {
			showMessageDialog(telaPesquisarCliente, "Selecione apenas um cliente!");
			return;
		}

		int selected = telaPesquisarCliente.getClientesJTable().getSelectedRow();
		
		Cliente cliente = (Cliente) telaPesquisarCliente.getClientesJTable().getModel().getValueAt(selected, 0);

		if (cliente != null) {
			telaPesquisarCliente.getClientesJTable().clearSelection();
			
			if (showConfirmDialog(telaPesquisarCliente, "Voce selecionou o cliente: " + cliente.getNome() + ", confirma?") != YES_OPTION) {
				return;
			}
		}
		
		new TelaVenderProdutos(telaPesquisarCliente, usuario, cliente).setVisible(true);
	}
}
