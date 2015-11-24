package amazingcontrol.swing.vendas.action;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import amazingcontrol.model.Cliente;
import amazingcontrol.service.ClienteService;
import amazingcontrol.swing.vendas.view.TelaPesquisarCliente;

public class PesquisarClienteAction implements ActionListener {

	private TelaPesquisarCliente telaPesquisarCliente;

	public PesquisarClienteAction(TelaPesquisarCliente telaPesquisarCliente) {
		this.telaPesquisarCliente = telaPesquisarCliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		List<Cliente> clientesPesquisados = new ArrayList<>();

		String clienteApesquisar = telaPesquisarCliente.getClienteTextField().getText();

		try {
			List<Cliente> clientes = new ClienteService().listar();

			for (int i = 0; i < clientes.size(); i++) {
				String nome = clientes.get(i).getNome();

				if (nome.contains(clienteApesquisar)) {
					clientesPesquisados.add(clientes.get(i));
				} else if (nome.startsWith(clienteApesquisar)) {
					clientesPesquisados.add(clientes.get(i));
				}
			}

			DefaultTableModel model;

			model = (DefaultTableModel) telaPesquisarCliente.getClientesJTable().getModel();

			model.getDataVector().clear();

			for (Cliente cliente : clientesPesquisados) {
				model.addRow(new Object[] { cliente, cliente.getCep(), cliente.getEndereco(), cliente.getCidade(),
						cliente.getUf(), cliente.getTelefone() });
			}

			telaPesquisarCliente.getClientesJTable().updateUI();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
