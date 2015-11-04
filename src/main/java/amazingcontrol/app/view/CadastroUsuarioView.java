package amazingcontrol.app.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import amazingcontrol.app.action.CriarUsuarioAction;
import amazingcontrol.app.action.WindowCancelarAction;

public class CadastroUsuarioView extends JDialog {

	private JLabel nomeLabel;
	private JLabel senhaLabel;
	private JLabel confirmacaoSenhaLabel;
	private JLabel ativoLabel;
	private JTextField nomeTextField;
	private JPasswordField senhaPasswordField;
	private JPasswordField confirmacaoSenhaPasswordField;
	private JCheckBox ativoCheckBox;
	private JButton botaoCriarUsuario;
	private JButton botaoCancelar;

	public CadastroUsuarioView() {
		this(null);
	}

	public CadastroUsuarioView(JFrame mainView) {
		super();

		initComponents();
		initPainel();
		initListeners();

		setTitle("[A-CONTROL] Cadastro de usuarios");
		setSize(630, 320);
		setResizable(false);
		setLocationRelativeTo(mainView);
		//setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setModalityType(ModalityType.DOCUMENT_MODAL);
		//setAlwaysOnTop(true);
		//pack();
		setModal(true);
	}
	

	/*
	 * getters and setters
	 */
	public JLabel getNomeLabel() {
		return nomeLabel;
	}

	public void setNomeLabel(JLabel nomeLabel) {
		this.nomeLabel = nomeLabel;
	}

	public JLabel getSenhaLabel() {
		return senhaLabel;
	}

	public void setSenhaLabel(JLabel senhaLabel) {
		this.senhaLabel = senhaLabel;
	}

	public JLabel getConfirmacaoSenhaLabel() {
		return confirmacaoSenhaLabel;
	}

	public void setConfirmacaoSenhaLabel(JLabel confirmacaoSenhaLabel) {
		this.confirmacaoSenhaLabel = confirmacaoSenhaLabel;
	}

	public JLabel getAtivoLabel() {
		return ativoLabel;
	}

	public void setAtivoLabel(JLabel ativoLabel) {
		this.ativoLabel = ativoLabel;
	}

	public JTextField getNomeTextField() {
		return nomeTextField;
	}

	public void setNomeTextField(JTextField nomeTextField) {
		this.nomeTextField = nomeTextField;
	}

	public JPasswordField getSenhaPasswordField() {
		return senhaPasswordField;
	}

	public void setSenhaPasswordField(JPasswordField senhaPasswordField) {
		this.senhaPasswordField = senhaPasswordField;
	}

	public JPasswordField getConfirmacaoSenhaPasswordField() {
		return confirmacaoSenhaPasswordField;
	}

	public void setConfirmacaoSenhaPasswordField(JPasswordField confirmacaoSenhaPasswordField) {
		this.confirmacaoSenhaPasswordField = confirmacaoSenhaPasswordField;
	}

	public JCheckBox getAtivoCheckBox() {
		return ativoCheckBox;
	}

	public void setAtivoCheckBox(JCheckBox ativoCheckBox) {
		this.ativoCheckBox = ativoCheckBox;
	}

	public JButton getBotaoCriarUsuario() {
		return botaoCriarUsuario;
	}

	public void setBotaoCriarUsuario(JButton botaoCriarUsuario) {
		this.botaoCriarUsuario = botaoCriarUsuario;
	}

	public JButton getBotaoCancelar() {
		return botaoCancelar;
	}

	public void setBotaoCancelar(JButton botaoCancelar) {
		this.botaoCancelar = botaoCancelar;
	}
	
	
	/*
	 *  metodos para contruir a tela
	 */
	private void initComponents() {
	
		// label e input para nome
		nomeLabel = new JLabel("Nome: ");
		nomeTextField = new JTextField(20);
		CustomizeView.labelsAndInputs(nomeLabel, nomeTextField);

		// label e input para senha
		senhaLabel = new JLabel("Senha: ");
		senhaPasswordField = new JPasswordField(20);
		CustomizeView.labelsAndInputs(senhaLabel, senhaPasswordField);

		// label e input para confirmacao de senha
		confirmacaoSenhaLabel = new JLabel("Confirmação de senha: ");
		confirmacaoSenhaPasswordField = new JPasswordField(20);
		CustomizeView.labelsAndInputs(confirmacaoSenhaLabel, confirmacaoSenhaPasswordField);
		
		ativoLabel = new JLabel("Ativo?: ");
		ativoCheckBox = new JCheckBox();
		ativoLabel.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 14));
		
		botaoCriarUsuario = new JButton("Criar usuario");
		botaoCancelar = new JButton("Cancelar");
	}
	


	private void initPainel() {
		JPanel painel = new JPanel(new GridBagLayout());
		
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        
        // posiciona label nome
        constraints.gridx = 0; // coluna
        constraints.gridy = 0; // linha    
        painel.add(nomeLabel, constraints);
        
        // posicona input nome
        constraints.gridx = 1;
        painel.add(nomeTextField, constraints);
        
        // posiciona label senha
        constraints.gridx = 0;
        constraints.gridy = 1; // linha
        painel.add(senhaLabel, constraints);
        
        // posicona input senha
        constraints.gridx = 1;
        painel.add(senhaPasswordField, constraints);
        
        // posiciona label confirmacao de senha
        constraints.gridx = 0;
        constraints.gridy = 2; // linha
        painel.add(confirmacaoSenhaLabel, constraints);
        
        // posicona input confirmacao senha
        constraints.gridx = 1;
        painel.add(confirmacaoSenhaPasswordField, constraints);
        
        // posiciona label ativo
        constraints.gridx = 0;
        constraints.gridy = 4;     
        painel.add(ativoLabel, constraints);
        
        // posicona checkbox ativo
        constraints.gridx = 1;
        painel.add(ativoCheckBox, constraints);
        
        // botao criar usuario
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.anchor = GridBagConstraints.CENTER;
		painel.add(botaoCriarUsuario, constraints);
        
		// botao cancelar
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.SOUTH;
		painel.add(botaoCancelar, constraints);
        
		// configura borda
        painel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Login Panel"));
        
		add(painel);
	}
	
	/*
	 * Chama a responsabilidade de ação do botao para outra classe
	 */
	private void initListeners() {
		botaoCriarUsuario.addActionListener(new CriarUsuarioAction(this));
		botaoCancelar.addActionListener(new WindowCancelarAction(this, "[A-CONTROL] Usuarios"));
	}
}
