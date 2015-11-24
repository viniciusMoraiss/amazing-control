package amazingcontrol.swing.vendas.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import amazingcontrol.model.Cliente;
import amazingcontrol.model.Usuario;
import amazingcontrol.service.ClienteService;
import amazingcontrol.swing.vendas.action.PesquisarClienteAction;
import amazingcontrol.swing.vendas.action.VenderAction;
import amazingcontrol.swing.view.utils.CustomizeView;

public class TelaPesquisarCliente extends JDialog {

	private JTextField clienteTextField;
	private JLabel clienteLabel;
	private JButton pesquisarButton;
	private JButton venderButton;
	private JTable clientesJTable;
	private Usuario usuario;

	public TelaPesquisarCliente(Usuario usuario) {
		super();
		this.usuario = usuario;

		initComponents();
		initPainel();
		initListeners();

		setTitle(("[A-CONTROL] Vendas"));
		setSize(630, 420);
		setResizable(false);
		setLocationRelativeTo(null);
		carregarClientes();
	}

	// Getters and Setters
	private void initListeners() {
		venderButton.addActionListener(new VenderAction(this, usuario));
		pesquisarButton.addActionListener(new PesquisarClienteAction(this));
	}

	public JTextField getClienteTextField() {
		return clienteTextField;
	}

	public void setClienteTextField(JTextField clienteTextField) {
		this.clienteTextField = clienteTextField;
	}

	public JLabel getClienteLabel() {
		return clienteLabel;
	}

	public void setClienteLabel(JLabel clienteLabel) {
		this.clienteLabel = clienteLabel;
	}

	public JButton getPesquisarButton() {
		return pesquisarButton;
	}

	public void setPesquisarButton(JButton pesquisarButton) {
		this.pesquisarButton = pesquisarButton;
	}

	public JButton getVenderButton() {
		return venderButton;
	}

	public void setVenderButton(JButton venderButton) {
		this.venderButton = venderButton;
	}

	public JTable getClientesJTable() {
		return clientesJTable;
	}

	public void setClientesJTable(JTable clientesJTable) {
		this.clientesJTable = clientesJTable;
	}

	private void initComponents() {

		clienteLabel = new JLabel("Cliente: ");
		clienteTextField = new JTextField(10);
		CustomizeView.labelsAndInputs(clienteLabel, clienteTextField);

		pesquisarButton = new JButton("Pesquisar");
		venderButton = new JButton("Vender");

		clientesJTable = new JTable(new DefaultTableModel(new Object[0][0], createColumnNames()));
	}

	private Object[] createColumnNames() {
		return new Object[] { "Nome", "CEP", "Endereco", "Cidade", "UF", "Telefone" };
	}

	private void initPainel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		GridBagConstraints gbcClienteLabel = new GridBagConstraints();
		gbcClienteLabel.insets = new Insets(20, 25, 25, 25);
		gbcClienteLabel.gridx = 3;
		gbcClienteLabel.gridy = 2;
		add(clienteLabel, gbcClienteLabel);

		GridBagConstraints gbcClienteTextField = new GridBagConstraints();
		gbcClienteTextField.gridwidth = 7;
		gbcClienteTextField.insets = new Insets(20, 20, 25, 25);
		gbcClienteTextField.fill = GridBagConstraints.BOTH;
		gbcClienteTextField.gridx = 5;
		gbcClienteTextField.gridy = 2;
		add(clienteTextField, gbcClienteTextField);

		GridBagConstraints gbcPesquisarButton = new GridBagConstraints();
		gbcPesquisarButton.insets = new Insets(20, 20, 25, 25);
		gbcPesquisarButton.gridx = 12;
		gbcPesquisarButton.gridy = 2;
		add(pesquisarButton, gbcPesquisarButton);

		GridBagConstraints gbcClienteTable = new GridBagConstraints();
		gbcClienteTable.gridwidth = 10;
		gbcClienteTable.insets = new Insets(5, 25, 5, 25);
		gbcClienteTable.fill = GridBagConstraints.BOTH;
		gbcClienteTable.gridx = 3;
		gbcClienteTable.gridy = 3;
		add(new JScrollPane(clientesJTable), gbcClienteTable);

		GridBagConstraints gbcVenderButton = new GridBagConstraints();
		gbcVenderButton.insets = new Insets(20, 20, 25, 10);
		gbcVenderButton.gridx = 12;
		gbcVenderButton.gridy = 4;
		add(venderButton, gbcVenderButton);
	}

	public void carregarClientes() {
		try {
			ClienteService service = new ClienteService();

			List<Cliente> clientes = service.listar();
			DefaultTableModel model;

			model = (DefaultTableModel) clientesJTable.getModel();

			model.getDataVector().clear();

			for (Cliente cliente : clientes) {
				model.addRow(new Object[] { cliente, cliente.getCep(), cliente.getEndereco(), cliente.getCidade(),
						cliente.getUf(), cliente.getTelefone() });
			}

			clientesJTable.updateUI();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
