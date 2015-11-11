package amazingcontrol.swing.usuario.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import amazingcontrol.model.Usuario;
import amazingcontrol.service.UsuarioService;
import amazingcontrol.swing.usuario.action.NovoUsuarioAction;
import amazingcontrol.swing.usuario.action.AlterarUsuarioAction;
import amazingcontrol.swing.view.utils.PopupMouseAdapter;

public class TelaUsuario extends JDialog {

	private JFrame view;
	private JTable usuariosJTable;
	private JButton novoJButton;

	// Construtor
	public TelaUsuario(JFrame view) {
		this.view = view;

		initComponents();
		initPainel();
		initListeners();
		initPopupMenu();

		setTitle("[A-CONTROL] Cadastro de usuarios");
		setSize(630, 320);
		setResizable(false);
		setLocationRelativeTo(view);
		// setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setModalityType(ModalityType.DOCUMENT_MODAL);
		// setAlwaysOnTop(true);
		// pack();
		setModal(true);

		// carrega usuarios ao abrir a tela
		try {
			carregarUsuarios();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Getters and setters
	public JFrame getView() {
		return view;
	}

	public JTable getUsuariosJTable() {
		return usuariosJTable;
	}

	public JButton getNovoJButton() {
		return novoJButton;
	}

	public TableModel getModel() {
		return getUsuariosJTable().getModel();
	}

	// Outros metodos
	private void initComponents() {
		usuariosJTable = new JTable(new DefaultTableModel(new Object[0][0], createColumnNames()));
		novoJButton = new JButton("Novo Usuario");
	}

	private Object[] createColumnNames() {
		return new Object[] { "Nome", "ativo" };
	}

	private void initPainel() {
		JPanel painel = new JPanel(new GridBagLayout());
		JPanel form = initForm();

		painel.add(form, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, 0,
				new Insets(0, 10, 10, 10), 0, 0));

		painel.add(new JScrollPane(usuariosJTable), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
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

		item = new JMenuItem("Alterar...");
		item.addActionListener(new AlterarUsuarioAction(this));
		menu.add(item);

		item = new JMenuItem("Ativar...");
		// item.addActionListener(new UsuarioApagarAction(this));
		menu.add(item);

		item = new JMenuItem("Inativar...");
		// item.addActionListener(new UsuarioApagarAction(this));
		menu.add(item);

		usuariosJTable.addMouseListener(new PopupMouseAdapter(menu));
	}

	private void initListeners() {
		novoJButton.addActionListener(new NovoUsuarioAction(this));
	}

	public void carregarUsuarios() throws Exception {
		UsuarioService service = new UsuarioService();

		List<Usuario> usuarios = service.listar();
		DefaultTableModel model;

		model = (DefaultTableModel) usuariosJTable.getModel();

		model.getDataVector().clear();

		for (Usuario usuario : usuarios) {
			String ativo = usuario.isAtivo() ? "Ativo" : "Inativo";

			model.addRow(new Object[] { usuario, ativo });

		}

		usuariosJTable.updateUI();
	}

}
