package amazingcontrol.swing.fornecedor.view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import amazingcontrol.swing.view.utils.CustomizeView;

public class TelacadastroFornecedor extends JFrame {

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
	private JTextField ufText;
	private JButton cadastrarBt;
	private JButton cancelarBt;

	public TelacadastroFornecedor() {
		super();

		initComponents();
		initPainel();

		setTitle(("[A-CONTROL] Fornecedor"));
		setSize(630, 370);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private void initComponents() {

		// label e input usando a classe customizeView para mudar a fonte e  cor.
		nomeLabel = new JLabel("Nome ");
		nomeText = new JTextField(20);
		CustomizeView.labelsAndInputs(nomeLabel, nomeText);

		telefoneLabel = new JLabel("Telefone");
		telefoneText = new JTextField(20);
		CustomizeView.labelsAndInputs(telefoneLabel, telefoneText);

		enderecoLabel = new JLabel("Endereço");
		enderecoText = new JTextField(20);
		CustomizeView.labelsAndInputs(enderecoLabel, enderecoText);

		cidadeLabel = new JLabel("Cidade");
		cidadeText = new JTextField(20);
		CustomizeView.labelsAndInputs(cidadeLabel, cidadeText);

		cepLabel = new JLabel("Cep");
		cepText = new JTextField(20);
		CustomizeView.labelsAndInputs(cepLabel, cepText);

		ufLabel = new JLabel("UF");
		ufText = new JTextField(20);
		CustomizeView.labelsAndInputs(ufLabel, ufText);

		cadastrarBt = new JButton("Cadastrar");
		cancelarBt = new JButton("Cancelar");

	}

	private void initPainel() {
		JPanel painel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);
		
		// Mascara para cep,tel, uf 
		
		MaskFormatter mascaraTel = null;
		MaskFormatter mascaraCep = null;
		MaskFormatter mascaraUf = null;

		try {
			mascaraCep = new MaskFormatter(" ##### - ### ");
			mascaraTel = new MaskFormatter(" (##) #### - ####  ");
			mascaraUf = new MaskFormatter("  UU  ");

			mascaraCep.setPlaceholderCharacter('_');
			mascaraTel.setPlaceholderCharacter('_');
			mascaraUf.setPlaceholderCharacter('_');
		} catch (ParseException excp) {
			System.err.println("Erro na formatação: " + excp.getMessage());
			System.exit(-1);
		}
		// Seta as mascaras nos objetos
		
		JFormattedTextField mascaracep = new JFormattedTextField(mascaraCep);
		JFormattedTextField mascaratel = new JFormattedTextField(mascaraTel);
		JFormattedTextField mascarauf = new JFormattedTextField(mascaraUf);

		mascaracep.setBounds(150, 40, 100, 20);
		mascaratel.setBounds(150, 40, 100, 20);
		mascarauf.setBounds(150, 40, 100, 20);

		// customizando as mascaras criada cep, tel, uf
		
		CustomizeView.labelsAndInputs(cepLabel, mascaracep);
		CustomizeView.labelsAndInputs(telefoneLabel, mascaratel);
		CustomizeView.labelsAndInputs(ufLabel, mascarauf);

		constraints.gridx = 0; // coluna
		constraints.gridy = 0; // linha
		painel.add(nomeLabel, constraints);

		constraints.gridx = 1; // coluna
		painel.add(nomeText, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1; // linha
		painel.add(cidadeLabel, constraints);

		constraints.gridx = 1;
		painel.add(cidadeText, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2; // linha
		painel.add(enderecoLabel, constraints);

		constraints.gridx = 1;
		painel.add(enderecoText, constraints);

		constraints.gridx = 0;
		constraints.gridy = 4;
		painel.add(telefoneLabel, constraints);

		constraints.gridx = 1;
		painel.add(mascaratel, constraints);

		constraints.gridx = 0;
		constraints.gridy = 5;
		painel.add(cepLabel, constraints);

		constraints.gridx = 1;
		painel.add(mascaracep, constraints);

		constraints.gridx = 0;
		constraints.gridy = 6;
		painel.add(ufLabel, constraints);

		constraints.gridx = 1;
		painel.add(mascarauf, constraints);

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
