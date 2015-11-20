package amazingcontrol.swing.produto.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import amazingcontrol.model.Produto;
import amazingcontrol.service.ProdutoService;
import amazingcontrol.swing.principal.view.TelaPrincipal;
import amazingcontrol.swing.produto.action.NovoProdutoAction;
import amazingcontrol.swing.view.utils.PopupMouseAdapter;

public class TelaProduto extends JFrame {

	private JButton btNovo;
	private JTable jtProduto;

	// construtor

	public TelaProduto(TelaPrincipal view) {
		super();

		initComponents();
		initListeners();
		initPainel();
		initPopupMenu();

		setTitle("[A-CONTROL] Lista de Produtos");
		setSize(630, 320);
		setResizable(false);
		setLocationRelativeTo(null);
		
		// carrega os produtos cadastrados
		try {
			carregarProdutos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initComponents() {
		jtProduto = new JTable(new DefaultTableModel(new Object[0][0], createColumnNames()));
		btNovo = new JButton("Novo");
	}

	private Object[] createColumnNames() {
		return new Object[] { "Nome", "Marca", "Tipo", "Valor Custo", "Valor Venda", "Quantidade" };
	}

	private void initPainel() {
		JPanel painel = new JPanel(new GridBagLayout());
		JPanel form = initForm();

		painel.add(form, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, 0,
				new Insets(0, 10, 10, 10), 0, 0));

		painel.add(new JScrollPane(jtProduto), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
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
		// item.addActionListener(new FornecedorAlterarAction(this));
		menu.add(item);

		item = new JMenuItem("Deletar...");

		// item.addActionListener(new FornecedorDeletarAction(this));
		menu.add(item);

		jtProduto.addMouseListener(new PopupMouseAdapter(menu));

	}

	private void initListeners() {
		btNovo.addActionListener(new NovoProdutoAction(this));
	}

	public void carregarProdutos() { 
		ProdutoService service;
		try {
			service = new ProdutoService();
			List<Produto> produtos = service.listar(); DefaultTableModel model;
			model = (DefaultTableModel) jtProduto.getModel();
			
			model.getDataVector().clear();
			
			for (Produto produto : produtos) {
				//"Nome", "Marca", "Tipo", "Valor Custo", "Valor Venda", "Quantidade"
				model.addRow(new Object[] { produto, 
											produto.getMarca(), 
											produto.getTipo(), 
											produto.getValorCusto(), 
											produto.getValorVenda(),
											produto.getQuantidade()
											});
			}

			jtProduto.updateUI();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
