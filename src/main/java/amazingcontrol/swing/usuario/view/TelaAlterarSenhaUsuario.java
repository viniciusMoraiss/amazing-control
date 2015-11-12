package amazingcontrol.swing.usuario.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import amazingcontrol.model.Usuario;
import amazingcontrol.swing.principal.view.TelaPrincipal;
import amazingcontrol.swing.usuario.action.AlterarSenhaUsuarioAction;
import amazingcontrol.swing.view.utils.CustomizeView;
import amazingcontrol.swing.view.utils.WindowCancelarAction;

public class TelaAlterarSenhaUsuario extends JDialog {

	private TelaPrincipal view;
	private JLabel senhaAtualLabel;
	private JLabel senhaLabel;
	private JLabel confirmacaoSenhaLabel;
	private JPasswordField senhaAtualPasswordField;
	private JPasswordField senhaPasswordField;
	private JPasswordField confirmacaoSenhaPasswordField;
	private JButton botaoAlterarUsuario;
	private JButton botaoCancelar;

	public TelaAlterarSenhaUsuario(TelaPrincipal view) {
		super();
		this.view = view;

		initComponents();
		initPainel();
		initListeners();

		setTitle("[A-CONTROL] Cadastro de usuarios");
		setSize(630, 320);
		setResizable(false);
		setLocationRelativeTo(view);
		setModalityType(ModalityType.DOCUMENT_MODAL);
		// setAlwaysOnTop(true);
		// pack();
		setModal(true);
	}

	/*
	 * Getter and Setters
	 */
	public Usuario getUsuario() {
		return view.getUsuario();
	}

	public TelaPrincipal getView() {
		return view;
	}

	public void setView(TelaPrincipal view) {
		this.view = view;
	}

	public JLabel getSenhaAtualLabel() {
		return senhaAtualLabel;
	}

	public void setSenhaAtualLabel(JLabel senhaAtualLabel) {
		this.senhaAtualLabel = senhaAtualLabel;
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

	public JPasswordField getSenhaAtualPasswordField() {
		return senhaAtualPasswordField;
	}

	public void setSenhaAtualPasswordField(JPasswordField senhaAtualPasswordField) {
		this.senhaAtualPasswordField = senhaAtualPasswordField;
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

	public JButton getBotaoAlterarUsuario() {
		return botaoAlterarUsuario;
	}

	public void setBotaoAlterarUsuario(JButton botaoAlterarUsuario) {
		this.botaoAlterarUsuario = botaoAlterarUsuario;
	}

	public JButton getBotaoCancelar() {
		return botaoCancelar;
	}

	public void setBotaoCancelar(JButton botaoCancelar) {
		this.botaoCancelar = botaoCancelar;
	}

	/*
	 * Ira instanciar os objetos labels e TextFields
	 */
	private void initComponents() {

		// label e input para nome
		senhaAtualLabel = new JLabel("Senha Atual: ");
		senhaAtualPasswordField = new JPasswordField(20);
		CustomizeView.labelsAndInputs(senhaAtualLabel, senhaAtualPasswordField);

		// label e input para senha
		senhaLabel = new JLabel("Senha: ");
		senhaPasswordField = new JPasswordField(20);
		CustomizeView.labelsAndInputs(senhaLabel, senhaPasswordField);

		// label e input para confirmacao de senha
		confirmacaoSenhaLabel = new JLabel("Confirmação de senha: ");
		confirmacaoSenhaPasswordField = new JPasswordField(20);
		CustomizeView.labelsAndInputs(confirmacaoSenhaLabel, confirmacaoSenhaPasswordField);

		botaoAlterarUsuario = new JButton("Alterar Usuario");
		botaoCancelar = new JButton("Cancelar");
	}

	/*
	 * Montara painel posicionando os Labels e TextFields
	 */
	private void initPainel() {
		JPanel painel = new JPanel(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);

		// posiciona label nome
		constraints.gridx = 0; // coluna
		constraints.gridy = 0; // linha
		painel.add(senhaAtualLabel, constraints);

		// posicona input nome
		constraints.gridx = 1; // coluna
		painel.add(senhaAtualPasswordField, constraints);

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

		// botao criar usuario
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.anchor = GridBagConstraints.CENTER;
		painel.add(botaoAlterarUsuario, constraints);

		// botao cancelar
		constraints.gridx = 1;
		constraints.anchor = GridBagConstraints.SOUTH;
		painel.add(botaoCancelar, constraints);

		// configura borda
		painel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Alterar Senha"));

		add(painel);
	}

	/*
	 * Chama a responsabilidade de ação do botao para outra classe
	 */
	private void initListeners() {
		botaoAlterarUsuario.addActionListener(new AlterarSenhaUsuarioAction(this));
		botaoCancelar.addActionListener(new WindowCancelarAction(this, "[A-CONTROL] Usuarios"));
	}

}
