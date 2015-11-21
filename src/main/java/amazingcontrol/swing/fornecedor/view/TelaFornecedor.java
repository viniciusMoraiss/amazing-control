package amazingcontrol.swing.fornecedor.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import amazingcontrol.model.Fornecedor;
import amazingcontrol.service.FornecedorService;
import amazingcontrol.swing.fornecedor.action.AlterarFornecedorAction;
import amazingcontrol.swing.fornecedor.action.DeletarFornecedorAction;
import amazingcontrol.swing.fornecedor.action.NovoFornecedorAction;
import amazingcontrol.swing.principal.view.TelaPrincipal;
import amazingcontrol.swing.view.utils.PopupMouseAdapter;

public class TelaFornecedor extends JDialog {

	private JButton btNovo;
	private JTable jtFornecedor;

	// construtor

	public TelaFornecedor(TelaPrincipal view) {
		super();

		initComponents();
		initListeners();
		initPainel();
		initPopupMenu();

		setTitle("[A-CONTROL] Fornecedores");
		setSize(630, 320);
		setResizable(false);
		setLocationRelativeTo(view);
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setModal(true);

		carregarFornecedores();
	}

	// Getters and Setters
	public JTable getJtFornecedor() {
		return jtFornecedor;
	}

	public TableModel getModel() {
		return getJtFornecedor().getModel();
	}

	private void initComponents() {
		jtFornecedor = new JTable(new DefaultTableModel(new Object[0][0], createColumnNames()));
		btNovo = new JButton("Novo");
	}

	private Object[] createColumnNames() {
		return new Object[] { "Fornecedor", "Cep", "Endereço", "Cidade", "UF", "Telefone" };
	}

	private void initPainel() {
		JPanel painel = new JPanel(new GridBagLayout());
		JPanel form = initForm();

		painel.add(form, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, 0,
				new Insets(0, 10, 10, 10), 0, 0));

		painel.add(new JScrollPane(jtFornecedor), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 500, 200));
		painel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Consultar"));

		add(painel);

	}

	// Simples form com os botoes de acoes
	private JPanel initForm() {
		JPanel form = new JPanel(new GridLayout(1, 5));
		form.add(btNovo);
		return form;
	}

	/** Inicialização de menu de contexto. */
	private void initPopupMenu() {
		final JPopupMenu menu = new JPopupMenu();
		JMenuItem item;

		item = new JMenuItem("Alterar...");
		item.addActionListener(new AlterarFornecedorAction(this));
		menu.add(item);

		item = new JMenuItem("Deletar...");

		item.addActionListener(new DeletarFornecedorAction(this));
		menu.add(item);

		jtFornecedor.addMouseListener(new PopupMouseAdapter(menu));

	}

	private void initListeners() {
		btNovo.addActionListener(new NovoFornecedorAction(this));
	}

	public void carregarFornecedores() {
		try {
			FornecedorService service = new FornecedorService();

			List<Fornecedor> fornecedores = service.listar();
			DefaultTableModel model;

			model = (DefaultTableModel) jtFornecedor.getModel();

			model.getDataVector().clear();

			for (Fornecedor fornecedor : fornecedores) {
				model.addRow(new Object[] { fornecedor, fornecedor.getCep(), fornecedor.getEndereco(),
						fornecedor.getCidade(), fornecedor.getUf(), fornecedor.getTelefone() });

			}
			jtFornecedor.updateUI();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
/*
 * public static void main(String[] args) { new
 * FornecedorView(null).setVisible(true); }
 * 
 * }
 * 
 */
