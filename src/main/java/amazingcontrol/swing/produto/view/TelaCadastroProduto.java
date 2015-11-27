package amazingcontrol.swing.produto.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Dialog.ModalityType;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import amazingcontrol.model.Fornecedor;
import amazingcontrol.model.Produto;
import amazingcontrol.model.Tipo;
import amazingcontrol.service.FornecedorService;
import amazingcontrol.swing.produto.action.CriarProdutoAction;
import amazingcontrol.swing.view.utils.CustomizeView;
import amazingcontrol.swing.view.utils.WindowCancelarAction;

public class TelaCadastroProduto extends JDialog {

	private JLabel nomeLabel;
	private JTextField nomeText;
	private JLabel marcaLabel;
	private JTextField marcaText;
	private JLabel tipoLabel;
	private JComboBox<Object> tipoComboBox;
	private JLabel valorCustoLabel;
	private JTextField valorCustoText;
	private JLabel valorVendaLabel;
	private JTextField valorVendaText;
	private JLabel quantidadeDeProdutoLabel;
	private JTextField quantidadeDeProdutoText;
	private JButton cadastrarBt;
	private JButton cancelarBt;
	private TelaProduto view;
	private JComboBox<Fornecedor> fornecedorCombo;
	private JLabel fornecedorLabel;
	private Produto produto;

	public TelaCadastroProduto() {
		this(null);
	}

	public TelaCadastroProduto(TelaProduto view) {
		super();
		this.view = view;

		initComponents();
		initPainel();
		initListeners();
		
		setTitle(("[A-CONTROL] Produto"));
		setSize(630, 470);
		setResizable(false);
		setLocationRelativeTo(view);
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setModal(true);
		carregarFornecedores();
	}

	private void initListeners() {
		cadastrarBt.addActionListener(new CriarProdutoAction(this));
		cancelarBt.addActionListener(new WindowCancelarAction(this, "[A-CONTROL] Produto"));
	}

	// getters and setters

	public JLabel getNomeLabel() {
		return nomeLabel;
	}

	public void setNomeLabel(JLabel nomeLabel) {
		this.nomeLabel = nomeLabel;
	}

	public JTextField getNomeText() {
		return nomeText;
	}

	public void setNomeText(JTextField nomeText) {
		this.nomeText = nomeText;
	}

	public JLabel getMarcaLabel() {
		return marcaLabel;
	}

	public void setMarcaLabel(JLabel marcaLabel) {
		this.marcaLabel = marcaLabel;
	}

	public JTextField getMarcaText() {
		return marcaText;
	}

	public void setMarcaText(JTextField marcaText) {
		this.marcaText = marcaText;
	}

	public JLabel getTipoLabel() {
		return tipoLabel;
	}

	public void setTipoLabel(JLabel tipoLabel) {
		this.tipoLabel = tipoLabel;
	}

	public JComboBox<Object> getTipoComboBox() {
		return tipoComboBox;
	}

	public void setTipoComboBox(JComboBox<Object> tipoComboBox) {
		this.tipoComboBox = tipoComboBox;
	}

	public JComboBox<Fornecedor> getFornecedorCombo() {
		return fornecedorCombo;

	}

	public void setFornecedorCombo(JComboBox<Fornecedor> fornecedorCombo) {
		this.fornecedorCombo = fornecedorCombo;

	}

	public JLabel getValorCustoLabel() {
		return valorCustoLabel;
	}

	public void setValorCustoLabel(JLabel valorCustoLabel) {
		this.valorCustoLabel = valorCustoLabel;
	}

	public JTextField getValorCustoText() {
		return valorCustoText;
	}

	public void setValorCustoText(JTextField valorCustoText) {
		this.valorCustoText = valorCustoText;
	}

	public JLabel getValorVendaLabel() {
		return valorVendaLabel;
	}

	public void setValorVendaLabel(JLabel valorVendaLabel) {
		this.valorVendaLabel = valorVendaLabel;
	}

	public JTextField getValorVendaText() {
		return valorVendaText;
	}

	public void setValorVendaText(JTextField valorVendaText) {
		this.valorVendaText = valorVendaText;
	}

	public JLabel getQuantidadeDeProdutoLabel() {
		return quantidadeDeProdutoLabel;
	}

	public void setQuantidadeDeProdutoLabel(JLabel quantidadeDeProdutoLabel) {
		this.quantidadeDeProdutoLabel = quantidadeDeProdutoLabel;
	}

	public JTextField getQuantidadeDeProdutoText() {
		return quantidadeDeProdutoText;
	}

	public void setQuantidadeDeProdutoText(JTextField quantidadeDeProdutoText) {
		this.quantidadeDeProdutoText = quantidadeDeProdutoText;
	}

	public JButton getCadastrarBt() {
		return cadastrarBt;
	}

	public void setCadastrarBt(JButton cadastrarBt) {
		this.cadastrarBt = cadastrarBt;
	}

	public JButton getCancelarBt() {
		return cancelarBt;
	}

	public void setCancelarBt(JButton cancelarBt) {
		this.cancelarBt = cancelarBt;
	}

	public void getProdutos() {
		view.carregarProdutos();
	}
	
	public Produto getProduto() {
		return produto;
	}

	private void initComponents() {

		nomeLabel = new JLabel("Nome ");
		nomeText = new JTextField(20);
		CustomizeView.labelsAndInputs(nomeLabel, nomeText);

		marcaLabel = new JLabel("Marca");
		marcaText = new JFormattedTextField();
		CustomizeView.labelsAndInputs(marcaLabel, marcaText);

		Object[] tipos = Tipo.values();
		tipoLabel = new JLabel("Tipo");
		tipoComboBox = new JComboBox<>(tipos);

		valorCustoLabel = new JLabel("Valor Custo");
		valorCustoText = new JTextField();
		CustomizeView.labelsAndInputs(valorCustoLabel, valorCustoText);

		valorVendaLabel = new JLabel("Valor Venda");
		valorVendaText = new JTextField();
		CustomizeView.labelsAndInputs(valorVendaLabel, valorVendaText);

		quantidadeDeProdutoLabel = new JLabel("Quantidade");
		quantidadeDeProdutoText = new JTextField();
		CustomizeView.labelsAndInputs(quantidadeDeProdutoLabel, quantidadeDeProdutoText);

		fornecedorLabel = new JLabel("Fornecedor");
		fornecedorCombo = new JComboBox<Fornecedor>();
		CustomizeView.labels(fornecedorLabel);

		cadastrarBt = new JButton("Cadastrar");
		cancelarBt = new JButton("Cancelar");
	}

	private void initPainel() {
		JPanel painel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);

		constraints.gridy = 0; // linha
		painel.add(nomeLabel, constraints);

		constraints.gridx = 1; // coluna
		painel.add(nomeText, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		painel.add(marcaLabel, constraints);

		constraints.gridx = 1;
		painel.add(marcaText, constraints);

		constraints.gridx = 0;
		constraints.gridy = 3; // linha
		painel.add(tipoLabel, constraints);

		constraints.gridx = 1;
		painel.add(tipoComboBox, constraints);

		constraints.gridx = 0;
		constraints.gridy = 4; // linha
		painel.add(valorCustoLabel, constraints);

		constraints.gridx = 1;
		painel.add(valorCustoText, constraints);

		constraints.gridx = 0;
		constraints.gridy = 5;
		painel.add(valorVendaLabel, constraints);

		constraints.gridx = 1;
		painel.add(valorVendaText, constraints);

		constraints.gridx = 0;
		constraints.gridy = 6;
		painel.add(quantidadeDeProdutoLabel, constraints);

		constraints.gridx = 1;
		painel.add(quantidadeDeProdutoText, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 7;
		painel.add(fornecedorLabel, constraints);

		constraints.gridx = 1;
		painel.add(fornecedorCombo, constraints);

		
		constraints.gridx = 0;
		constraints.gridy = 8;
		constraints.anchor = GridBagConstraints.CENTER;
		painel.add(cadastrarBt, constraints);

		constraints.gridx = 1;
		constraints.anchor = GridBagConstraints.SOUTH;
		painel.add(cancelarBt, constraints);

		painel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Produto"));

		add(painel);

	}
	
	private void carregarFornecedores() {
		List<Fornecedor> fornecedores;
		
		try {
			fornecedores = new FornecedorService().listar();
			
			for (Fornecedor fornecedor : fornecedores) {
				fornecedorCombo.addItem(fornecedor);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new TelaCadastroProduto().setVisible(true);
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
