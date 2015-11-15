package amazingcontrol.swing.produto.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import amazingcontrol.model.UF;
import amazingcontrol.swing.view.utils.CustomizeView;

public class TelaCadastroProduto extends JDialog {

	private JLabel nomeLabel;
	private JTextField nomeText;
	private JLabel marcaLabel;
	private JTextField marcaText;
	private JLabel tipoLabel;
	private JTextField tipoText;
	private JLabel valorCustoLabel;
	private JTextField valorCustoText;
	private JLabel valorVendaLabel;
	private JTextField valorVendaText;
	private JLabel quantidadeDeProdutoLabel;
	private JTextField quantidadeDeProdutoText;
	private JButton cadastrarBt;
	private JButton cancelarBt;

	public TelaCadastroProduto() {
		this(null);
	}

	public TelaCadastroProduto(JFrame view) {
		super();

		initComponents();
		initPainel();
		// initListeners();

		setTitle(("[A-CONTROL] Fornecedor"));
		setSize(630, 470);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
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

	public JTextField getTipoText() {
		return tipoText;
	}

	public void setTipoText(JTextField tipoText) {
		this.tipoText = tipoText;
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

	private void initComponents() {

		nomeLabel = new JLabel("Nome ");
		nomeText = new JTextField(20);
		CustomizeView.labelsAndInputs(nomeLabel, nomeText);

		marcaLabel = new JLabel("Marca");
		marcaText = new JFormattedTextField(10);
		CustomizeView.labelsAndInputs(marcaLabel, marcaText);

		tipoLabel = new JLabel("Tipo");
		tipoText = new JTextField(20);
		CustomizeView.labelsAndInputs(tipoLabel, tipoText);

		valorCustoLabel = new JLabel("Valor Custo");
		valorCustoText = new JTextField(10);
		CustomizeView.labelsAndInputs(valorCustoLabel, valorCustoText);

		valorVendaLabel = new JLabel("Valor Venda");
		valorVendaText = new JFormattedTextField(10);
		CustomizeView.labelsAndInputs(valorVendaLabel, valorVendaText);

		quantidadeDeProdutoLabel = new JLabel("Valor Custo");
		quantidadeDeProdutoText = new JFormattedTextField(10);
		CustomizeView.labelsAndInputs(quantidadeDeProdutoLabel, quantidadeDeProdutoText);

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
		painel.add(tipoText, constraints);

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
		constraints.anchor = GridBagConstraints.CENTER;
		painel.add(cadastrarBt, constraints);

		constraints.gridx = 1;
		constraints.anchor = GridBagConstraints.SOUTH;
		painel.add(cancelarBt, constraints);

		painel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Fornecedor"));

		add(painel);

	}
}
