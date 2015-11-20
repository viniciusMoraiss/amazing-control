package amazingcontrol.swing.cliente.action;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.model.Cliente;
import amazingcontrol.swing.cliente.view.TelaCadastroCliente;
import amazingcontrol.swing.cliente.view.TelaCliente;

public class AlterarClienteAction implements ActionListener {

	private TelaCliente clienteView;

	public AlterarClienteAction(TelaCliente clienteView) {
		this.clienteView = clienteView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// recupera a linha selecionada pelo usuario
		int row = clienteView.getClientesJTable().getSelectedRowCount();
		
		// caso a linha for igual a zero, pede para o usuario selecionar alguma
		if (row == 0) {
			showMessageDialog(clienteView, "Selecione uma linha para alterar o cliente desejado");
			return;
		}
		
		// recupera todas as linhas selecionada pelo usuario
		int[] indexes = clienteView.getClientesJTable().getSelectedRows();

		// caso tenha mais de uma linha selecionada pede para selecionar apenas uma
		if (indexes.length > 1) {
			showMessageDialog(clienteView, "Selecione apenas uma linha");
			return;
		}
		
		// recupera a linha selecionada
		int rowSelected = clienteView.getClientesJTable().getSelectedRow();
		
		// Cliente inicia com o valor nulo
		Cliente cliente = null;
		
		// recupera o cliente selecionado
		cliente = (Cliente) clienteView.getModel().getValueAt(rowSelected, 0);
		
		// abre a tela de cadastro setando os campos os dados do cliente a ser alterado
		TelaCadastroCliente cadastroClienteView = new TelaCadastroCliente(clienteView);
		cadastroClienteView.setCliente(cliente);
		cadastroClienteView.getNomeTextField().setText(cliente.getNome());
		cadastroClienteView.getCepTextField().setText(cliente.getCep());
		cadastroClienteView.getEnderecoTextField().setText(cliente.getEndereco());
		cadastroClienteView.getCidadeTextField().setText(cliente.getCidade());
		cadastroClienteView.getUfJComboBox().setSelectedItem(cliente.getUf());
		cadastroClienteView.getTelefoneTextField().setText(cliente.getTelefone());
		cadastroClienteView.getCadastrarButton().setText("Alterar");
		cadastroClienteView.setVisible(true);
		
		// se cliente for diferente de nulo, limpa a selecao e recarrega os clientes
		if (cliente != null) {
			clienteView.getClientesJTable().clearSelection();
			clienteView.carregarClientes();
		}
	}
}
