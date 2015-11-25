package amazingcontrol.swing.vendas.view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import amazingcontrol.model.Cliente;
import amazingcontrol.model.Produto;
import amazingcontrol.model.Usuario;
import amazingcontrol.model.Venda;
import amazingcontrol.service.AdicionarProdutoService;
import amazingcontrol.service.ProdutoService;
import amazingcontrol.swing.vendas.action.AdicionarProdutoAction;
import amazingcontrol.swing.vendas.action.FinalizarVendaAction;

public class TelaVenderProdutos extends JDialog {

	private JComboBox<Produto> produtosComboBox;
	private TextField quantidadeTextField;
	private JLabel produtosLabel;
	private JButton adicionarProdutoButton;
	private JButton finalizarVendaButton;
	private JTable produtosJTable;
	private Venda venda;
	private AdicionarProdutoService adicionarService;
	private Component quantidadeLabel;

	public TelaVenderProdutos(TelaPesquisarCliente telaPesquisarCliente, Usuario usuario, Cliente cliente) {
		super();
		
		adicionarService = new AdicionarProdutoService();
		venda = new Venda(usuario, cliente, Calendar.getInstance());

		initComponents();
		initPainel();
		initListeners();

		setTitle(("[A-CONTROL] Vendas"));
		setSize(730, 520);
		setResizable(false);
		setLocationRelativeTo(null);
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setModal(true);
		carregarProdutos();
	}

	public JComboBox<Produto> getProdutosComboBox() {
		return produtosComboBox;
	}

	public void setProdutosComboBox(JComboBox<Produto> produtosComboBox) {
		this.produtosComboBox = produtosComboBox;
	}

	public JLabel getProdutosLabel() {
		return produtosLabel;
	}

	public void setProdutosLabel(JLabel produtosLabel) {
		this.produtosLabel = produtosLabel;
	}

	public JButton getAdicionarProdutoButton() {
		return adicionarProdutoButton;
	}

	public void setAdicionarProdutoButton(JButton adicionarButton) {
		this.adicionarProdutoButton = adicionarButton;
	}

	public JButton getFinalizarVendaButton() {
		return finalizarVendaButton;
	}

	public void setFinalizarVendaButton(JButton finalizarVendaButton) {
		this.finalizarVendaButton = finalizarVendaButton;
	}

	public JTable getProdutosJTable() {
		return produtosJTable;
	}

	public void setProdutosJTable(JTable produtosJTable) {
		this.produtosJTable = produtosJTable;
	}

	public TextField getQuantidadeTextField() {
		return quantidadeTextField;
	}

	public void setQuantidadeTextField(TextField quantidadeTextField) {
		this.quantidadeTextField = quantidadeTextField;
	}

	public Venda getVenda() {
		return venda;
	}
	
	public AdicionarProdutoService getAdicionarService() {
		return adicionarService;
	}

	private void initListeners() {
		finalizarVendaButton.addActionListener(new FinalizarVendaAction(this));
		adicionarProdutoButton.addActionListener(new AdicionarProdutoAction(this));
	}

	public void carregarProdutos() {
		List<Produto> produtos;
		try {
			produtos = new ProdutoService().listar();

			for (Produto produto : produtos) {
				produtosComboBox.addItem(produto);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private void initComponents() {
		produtosLabel = new JLabel("Produtos: ");
		produtosComboBox = new JComboBox<Produto>();
		quantidadeLabel = new JLabel("Qtd: ");
		quantidadeTextField = new TextField(5);
		adicionarProdutoButton = new JButton("Adicionar");
		finalizarVendaButton = new JButton("Finalizar Venda");
		produtosJTable = new JTable(new DefaultTableModel(new Object[0][0], createColumnNames()));
	}

	private Object[] createColumnNames() {
		return new Object[] { "Nome", "Marca", "Tipo", "Valor Venda", "Quantidade", "Valor Total" };
	}

	private void initPainel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 10, 20, 20, 20 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 1.0 };
		setLayout(gridBagLayout);

		GridBagConstraints gbcProdutosLabel = new GridBagConstraints();
		gbcProdutosLabel.insets = new Insets(0, 20, 5, 25);
		gbcProdutosLabel.gridx = 1;
		gbcProdutosLabel.gridy = 1;
		add(produtosLabel, gbcProdutosLabel);

		GridBagConstraints gbcProdutosComboBox = new GridBagConstraints();
		gbcProdutosComboBox.gridwidth = 9;
		gbcProdutosComboBox.insets = new Insets(0, 0, 5, 5);
		gbcProdutosComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbcProdutosComboBox.gridx = 2;
		gbcProdutosComboBox.gridy = 1;
		add(produtosComboBox, gbcProdutosComboBox);

		GridBagConstraints gbcQtdLabel = new GridBagConstraints();
		gbcQtdLabel.insets = new Insets(0, 0, 5, 5);
		gbcQtdLabel.gridx = 11;
		gbcQtdLabel.gridy = 1;
		add(quantidadeLabel, gbcQtdLabel);

		GridBagConstraints gbcQuantidadeText = new GridBagConstraints();
		gbcQuantidadeText.anchor = GridBagConstraints.WEST;
		gbcQuantidadeText.fill = GridBagConstraints.VERTICAL;
		gbcQuantidadeText.insets = new Insets(0, 0, 5, 5);
		gbcQuantidadeText.gridx = 12;
		gbcQuantidadeText.gridy = 1;
		add(quantidadeTextField, gbcQuantidadeText);

		GridBagConstraints gbcAdicionarButton = new GridBagConstraints();
		gbcAdicionarButton.insets = new Insets(0, 0, 5, 5);
		gbcAdicionarButton.gridx = 13;
		gbcAdicionarButton.gridy = 1;
		add(adicionarProdutoButton, gbcAdicionarButton);

		GridBagConstraints gbcJTable = new GridBagConstraints();
		gbcJTable.insets = new Insets(0, 0, 0, 5);
		gbcJTable.gridwidth = 13;
		gbcJTable.fill = GridBagConstraints.BOTH;
		gbcJTable.gridx = 1;
		gbcJTable.gridy = 2;
		add(new JScrollPane(produtosJTable), gbcJTable);

		GridBagConstraints gbcVenderButton = new GridBagConstraints();
		gbcVenderButton.insets = new Insets(0, 0, 0, 5);
		gbcVenderButton.gridx = 13;
		gbcVenderButton.gridy = 3;
		add(finalizarVendaButton, gbcVenderButton);
	}
}
