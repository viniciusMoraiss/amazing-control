package amazingcontrol.swing.fornecedor.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import amazingcontrol.model.Fornecedor;
import amazingcontrol.model.UF;
import amazingcontrol.swing.fornecedor.action.CriarFornecedorAction;
import amazingcontrol.swing.view.utils.CustomizeView;
import amazingcontrol.swing.view.utils.WindowCancelarAction;

public class TelaCadastroFornecedor extends JDialog {

	private JLabel nomeLabel;
	private JTextField nomeText;
	private JLabel telefoneLabel;
	private JTextField telefoneText;
	private JLabel enderecoLabel;
	private JTextField enderecoText;
	private JLabel cidadeLabel;
	private JTextField cidadeText;
	private JLabel cepLabel;
	private JTextField cepText;
	private JLabel ufLabel;
	private JComboBox<Object> ufJComboBox;
	private MaskFormatter maskTelefone;
	private MaskFormatter maskCep;
	private JButton cadastrarBt;
	private JButton cancelarBt;
	private TelaFornecedor fornecedorView;
	private Fornecedor fornecedor;

	public TelaCadastroFornecedor(TelaFornecedor fornecedorView) {
		super();
		this.fornecedorView = fornecedorView;

		initComponents();
		initPainel();
		initListeners();

		setTitle(("[A-CONTROL] Fornecedor"));
		setSize(630, 470);
		setResizable(false);
		setLocationRelativeTo(fornecedorView);
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setModal(true);

	}

	// Getters and Setters

	public JComboBox<Object> getUfJComboBox() {
		return ufJComboBox;
	}

	public void setUfJComboBox(JComboBox<Object> ufJComboBox) {
		this.ufJComboBox = ufJComboBox;
	}

	public TelaFornecedor getFornecedorView() {
		return fornecedorView;
	}

	public void setView(TelaFornecedor fornecedorView) {
		this.fornecedorView = fornecedorView;
	}

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

	public JLabel getTelefoneLabel() {
		return telefoneLabel;
	}

	public void setTelefoneLabel(JLabel telefoneLabel) {
		this.telefoneLabel = telefoneLabel;
	}

	public JTextField getTelefoneText() {
		return telefoneText;
	}

	public void setTelefoneText(JTextField telefoneText) {
		this.telefoneText = telefoneText;
	}

	public JLabel getEnderecoLabel() {
		return enderecoLabel;
	}

	public void setEnderecoLabel(JLabel enderecoLabel) {
		this.enderecoLabel = enderecoLabel;
	}

	public JTextField getEnderecoText() {
		return enderecoText;
	}

	public void setEnderecoText(JTextField enderecoText) {
		this.enderecoText = enderecoText;
	}

	public JLabel getCidadeLabel() {
		return cidadeLabel;
	}

	public void setCidadeLabel(JLabel cidadeLabel) {
		this.cidadeLabel = cidadeLabel;
	}

	public JTextField getCidadeText() {
		return cidadeText;
	}

	public void setCidadeText(JTextField cidadeText) {
		this.cidadeText = cidadeText;
	}

	public JLabel getCepLabel() {
		return cepLabel;
	}

	public void setCepLabel(JLabel cepLabel) {
		this.cepLabel = cepLabel;
	}

	public JTextField getCepText() {
		return cepText;
	}

	public void setCepText(JTextField cepText) {
		this.cepText = cepText;
	}

	public JLabel getUfLabel() {
		return ufLabel;
	}

	public void setUfLabel(JLabel ufLabel) {
		this.ufLabel = ufLabel;
	}

	public JComboBox<Object> getUFComboBox() {
		return ufJComboBox;
	}

	public void setUFComboBox(JComboBox<Object> ufJComboBox) {
		this.ufJComboBox = ufJComboBox;
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

	public MaskFormatter getMaskTelefone() {
		return maskTelefone;
	}

	public void setMaskTelefone(MaskFormatter maskTelefone) {
		this.maskTelefone = maskTelefone;
	}

	public MaskFormatter getMaskCep() {
		return maskCep;
	}

	public void setMaskCep(MaskFormatter maskCep) {
		this.maskCep = maskCep;
	}

	private void initComponents() {

		// cria mascaras para telefone e cep
		try {
			maskTelefone = new MaskFormatter("(##) # ####-####");
			maskCep = new MaskFormatter("##### - ###");
			maskTelefone.setValueContainsLiteralCharacters(false);
			maskCep.setValueContainsLiteralCharacters(false);
		} catch (ParseException excp) {
			excp.printStackTrace();
		}

		nomeLabel = new JLabel("Nome ");
		nomeText = new JTextField(20);
		CustomizeView.labelsAndInputs(nomeLabel, nomeText);

		cepLabel = new JLabel("Cep");
		cepText = new JFormattedTextField(maskCep);
		CustomizeView.labelsAndInputs(cepLabel, cepText);

		enderecoLabel = new JLabel("Endereço");
		enderecoText = new JTextField(20);
		CustomizeView.labelsAndInputs(enderecoLabel, enderecoText);

		cidadeLabel = new JLabel("Cidade");
		cidadeText = new JTextField();
		CustomizeView.labelsAndInputs(cidadeLabel, cidadeText);

		Object[] ufs = UF.values();
		ufLabel = new JLabel("UF");
		ufJComboBox = new JComboBox<>(ufs);

		telefoneLabel = new JLabel("Telefone");
		telefoneText = new JFormattedTextField(maskTelefone);
		CustomizeView.labelsAndInputs(telefoneLabel, telefoneText);

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
		painel.add(cepLabel, constraints);

		constraints.gridx = 1;
		painel.add(cepText, constraints);

		constraints.gridx = 0;
		constraints.gridy = 3; // linha
		painel.add(enderecoLabel, constraints);

		constraints.gridx = 1;
		painel.add(enderecoText, constraints);

		constraints.gridx = 0;
		constraints.gridy = 4; // linha
		painel.add(cidadeLabel, constraints);

		constraints.gridx = 1;
		painel.add(cidadeText, constraints);

		constraints.gridx = 0;
		constraints.gridy = 5;
		painel.add(ufLabel, constraints);

		constraints.gridx = 1;
		painel.add(ufJComboBox, constraints);

		constraints.gridx = 0;
		constraints.gridy = 6;
		painel.add(telefoneLabel, constraints);

		constraints.gridx = 1;
		painel.add(telefoneText, constraints);

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

	private void initListeners() {
		cadastrarBt.addActionListener(new CriarFornecedorAction(this));
		cancelarBt.addActionListener(new WindowCancelarAction(this, "[A-CONTROL] Fornecedor"));

	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
}
