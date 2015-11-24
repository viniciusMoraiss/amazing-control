package amazingcontrol.swing.cliente.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import amazingcontrol.model.Cliente;
import amazingcontrol.service.ClienteService;
import amazingcontrol.swing.cliente.action.AlterarClienteAction;
import amazingcontrol.swing.cliente.action.DeletarClienteAction;
import amazingcontrol.swing.cliente.action.NovoClienteAction;
import amazingcontrol.swing.principal.view.TelaPrincipal;
import amazingcontrol.swing.view.utils.PopupMouseAdapter;

public class TelaCliente extends JDialog {

	private JTable clientesJTable;
	private JButton novoJButton;

	public TelaCliente(TelaPrincipal view) {

		initComponents();
		initPainel();
		initListeners();
		initPopupMenu();

		setTitle("[A-CONTROL] Cadastro de usuarios");
		setSize(630, 320);
		setResizable(false);
		setLocationRelativeTo(view);
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setModal(true);

		// carrega usuarios ao abrir a tela
		carregarClientes();
	}
	
	// Getters and Setters
	public JTable getClientesJTable() {
		return clientesJTable;
	}
	
	public TableModel getModel() {
		return getClientesJTable().getModel();
	}

	// Outros metodos
	private void initComponents() {
		clientesJTable = new JTable(new DefaultTableModel(new Object[0][0], createColumnNames()));
		novoJButton = new JButton("Novo Cliente");
	}

	private Object[] createColumnNames() {
		return new Object[] { "Nome", "CEP", "Endereco", "Cidade", "UF", "Telefone" };
	}

	private void initPainel() {
		JPanel painel = new JPanel(new GridBagLayout());
		JPanel form = initForm();

		painel.add(form, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, 0,
				new Insets(0, 10, 10, 10), 0, 0));

		painel.add(new JScrollPane(clientesJTable), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 500, 200));

		add(painel);

	}

	// Simples form com os botoes de acoes
	private JPanel initForm() {
		JPanel form = new JPanel(new GridLayout(1, 5));
		form.add(novoJButton);
		return form;
	}

	/** Inicialização de menu de contexto. */
	private void initPopupMenu() {
		final JPopupMenu menu = new JPopupMenu();
		JMenuItem item;

		item = new JMenuItem("Deletar...");
		item.addActionListener(new DeletarClienteAction(this));
		menu.add(item);
		
		item = new JMenuItem("Alterar...");
		item.addActionListener(new AlterarClienteAction(this));
		menu.add(item);

		clientesJTable.addMouseListener(new PopupMouseAdapter(menu));
	}

	private void initListeners() {
		novoJButton.addActionListener(new NovoClienteAction(this));
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
