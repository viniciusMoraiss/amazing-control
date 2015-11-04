package amazingcontrol.app.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import amazingcontrol.app.action.LoginAction;

public class LoginView extends JFrame {

	private JLabel usuarioJLabel;
	private JLabel senhaJLabel;
	private JTextField usuarioJTextField;
	private JPasswordField senhaJPasswordField;
	private JButton okJButton;

	public LoginView() {
		super("[A-CONTROL] Login");
		
		// inicia componentes
		initComponents();
		
		// inicia paineis
		initPanel();
		
		// acoes
		initListeners();

		// Configurar a janela
		setSize(630, 320);
		setResizable(false);
		
		// Centro da tela
		setLocationRelativeTo(null); 
		//setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void initPanel() {
		// Layout
		JPanel painel = new JPanel(new GridBagLayout());
			
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        
        // Usuario
        // posiciona label nome
        constraints.gridx = 0; // coluna
        constraints.gridy = 0; // linha    
        painel.add(usuarioJLabel, constraints);
        
        // posicona input nome
        constraints.gridx = 1;
        painel.add(usuarioJTextField, constraints);
        
        // Senha
        // posiciona label senha
        constraints.gridx = 0; // coluna
        constraints.gridy = 1; // linha    
        painel.add(senhaJLabel, constraints);
        
        // posicona input senha
        constraints.gridx = 1;
        painel.add(senhaJPasswordField, constraints);
		
        
        // botao criar usuario
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.CENTER;
		painel.add(okJButton, constraints);
		
		// configura borda
        painel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Login"));
        
		add(painel);
	}

	private void initComponents() {
		// Usuario
		usuarioJLabel = new JLabel("Usuario");
		usuarioJTextField = new JTextField(10);
		CustomizeView.labelsAndInputs(usuarioJLabel, usuarioJTextField);
		
		// Senha
		senhaJLabel = new JLabel("Senha");
		senhaJPasswordField = new JPasswordField(10);
		CustomizeView.labelsAndInputs(senhaJLabel, senhaJPasswordField);

		// Botões
		okJButton = new JButton("Entrar");
	}
	
	private void initListeners() {
		// redireciona a acao do botao para classe LoginAction
		okJButton.addActionListener(new LoginAction(this, usuarioJTextField, senhaJPasswordField));
	}

}
