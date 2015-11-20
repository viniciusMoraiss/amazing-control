package amazingcontrol.swing.cliente.view;

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

import amazingcontrol.model.UF;
import amazingcontrol.swing.cliente.action.CriarClienteAction;
import amazingcontrol.swing.view.utils.CustomizeView;

public class TelaCadastroCliente extends JDialog {

	private JLabel nomeLabel;
	private JTextField nomeTextField;
	private JLabel telefoneLabel;
	private JTextField telefoneTextField;
	private JLabel enderecoLabel;
	private JTextField enderecoTextField;
	private JLabel cidadeLabel;
	private JTextField cidadeTextField;
	private JLabel cepLabel;
	private JTextField cepTextField;
	private JLabel ufLabel;
	private JComboBox<Object> ufJComboBox;
	private MaskFormatter maskTelefone;
	private MaskFormatter maskCep;
	private JButton cadastrarButton;
	private JButton cancelarButton;
	private TelaCliente clienteView;

	public TelaCadastroCliente(TelaCliente clienteView) {
		super();
		this.clienteView = clienteView;
		initComponents();
		initPainel();
		initListeners();

		setTitle(("[A-CONTROL] Cadastro de clientes"));
		setSize(630, 470);
		setResizable(false);
		setLocationRelativeTo(clienteView);
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setModal(true);
	}
	
	// Getters and Setters
	public JLabel getNomeLabel() {
		return nomeLabel;
	}

	public void setNomeLabel(JLabel nomeLabel) {
		this.nomeLabel = nomeLabel;
	}

	public JTextField getNomeTextField() {
		return nomeTextField;
	}

	public void setNomeTextField(JTextField nomeTextField) {
		this.nomeTextField = nomeTextField;
	}

	public JLabel getTelefoneLabel() {
		return telefoneLabel;
	}

	public void setTelefoneLabel(JLabel telefoneLabel) {
		this.telefoneLabel = telefoneLabel;
	}

	public JTextField getTelefoneTextField() {
		return telefoneTextField;
	}

	public void setTelefoneTextField(JTextField telefoneTextField) {
		this.telefoneTextField = telefoneTextField;
	}

	public JLabel getEnderecoLabel() {
		return enderecoLabel;
	}

	public void setEnderecoLabel(JLabel enderecoLabel) {
		this.enderecoLabel = enderecoLabel;
	}

	public JTextField getEnderecoTextField() {
		return enderecoTextField;
	}

	public void setEnderecoTextField(JTextField enderecoTextField) {
		this.enderecoTextField = enderecoTextField;
	}

	public JLabel getCidadeLabel() {
		return cidadeLabel;
	}

	public void setCidadeLabel(JLabel cidadeLabel) {
		this.cidadeLabel = cidadeLabel;
	}

	public JTextField getCidadeTextField() {
		return cidadeTextField;
	}

	public void setCidadeTextField(JTextField cidadeTextField) {
		this.cidadeTextField = cidadeTextField;
	}

	public JLabel getCepLabel() {
		return cepLabel;
	}

	public void setCepLabel(JLabel cepLabel) {
		this.cepLabel = cepLabel;
	}

	public JTextField getCepTextField() {
		return cepTextField;
	}

	public void setCepTextField(JTextField cepTextField) {
		this.cepTextField = cepTextField;
	}

	public JLabel getUfLabel() {
		return ufLabel;
	}

	public void setUfLabel(JLabel ufLabel) {
		this.ufLabel = ufLabel;
	}

	public JComboBox<Object> getUfJComboBox() {
		return ufJComboBox;
	}

	public void setUfJComboBox(JComboBox<Object> ufJComboBox) {
		this.ufJComboBox = ufJComboBox;
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

	public JButton getCadastrarButton() {
		return cadastrarButton;
	}

	public void setCadastrarButton(JButton cadastrarButton) {
		this.cadastrarButton = cadastrarButton;
	}

	public JButton getCancelarButton() {
		return cancelarButton;
	}

	public void setCancelarButton(JButton cancelarButton) {
		this.cancelarButton = cancelarButton;
	}
	
	public TelaCliente getClienteView() {
		return clienteView;
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
		nomeTextField = new JTextField(20);
		CustomizeView.labelsAndInputs(nomeLabel, nomeTextField);

		cepLabel = new JLabel("Cep");
		cepTextField = new JFormattedTextField(maskCep);
		CustomizeView.labelsAndInputs(cepLabel, cepTextField);

		enderecoLabel = new JLabel("Endereço");
		enderecoTextField = new JTextField(20);
		CustomizeView.labelsAndInputs(enderecoLabel, enderecoTextField);

		cidadeLabel = new JLabel("Cidade");
		cidadeTextField = new JTextField();
		CustomizeView.labelsAndInputs(cidadeLabel, cidadeTextField);

		Object[] ufs = UF.values();
		ufLabel = new JLabel("UF");
		ufJComboBox = new JComboBox<>(ufs);

		telefoneLabel = new JLabel("Telefone");
		telefoneTextField = new JFormattedTextField(maskTelefone);
		CustomizeView.labelsAndInputs(telefoneLabel, telefoneTextField);

		cadastrarButton = new JButton("Cadastrar");
		cancelarButton = new JButton("Cancelar");

	}

	private void initPainel() {
		JPanel painel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);

		constraints.gridy = 0; // linha
		painel.add(nomeLabel, constraints);

		constraints.gridx = 1; // coluna
		painel.add(nomeTextField, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		painel.add(cepLabel, constraints);

		constraints.gridx = 1;
		painel.add(cepTextField, constraints);

		constraints.gridx = 0;
		constraints.gridy = 3; // linha
		painel.add(enderecoLabel, constraints);

		constraints.gridx = 1;
		painel.add(enderecoTextField, constraints);

		constraints.gridx = 0;
		constraints.gridy = 4; // linha
		painel.add(cidadeLabel, constraints);

		constraints.gridx = 1;
		painel.add(cidadeTextField, constraints);

		constraints.gridx = 0;
		constraints.gridy = 5;
		painel.add(ufLabel, constraints);

		constraints.gridx = 1;
		painel.add(ufJComboBox, constraints);

		constraints.gridx = 0;
		constraints.gridy = 6;
		painel.add(telefoneLabel, constraints);

		constraints.gridx = 1;
		painel.add(telefoneTextField, constraints);

		constraints.gridx = 0;
		constraints.gridy = 7;
		constraints.anchor = GridBagConstraints.CENTER;
		painel.add(cadastrarButton, constraints);

		constraints.gridx = 1;
		constraints.anchor = GridBagConstraints.SOUTH;
		painel.add(cancelarButton, constraints);

		painel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Fornecedor"));

		add(painel);
	}

	private void initListeners() {
		cadastrarButton.addActionListener(new CriarClienteAction(this));
	}
}
