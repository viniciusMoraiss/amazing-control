package amazingcontrol.app.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import amazingcontrol.app.action.LoginAction;
import amazingcontrol.dao.UsuarioDAO;
import amazingcontrol.model.Usuario;

public class LoginView extends JFrame{

	private JLabel usuarioJLabel;
	private JLabel senhaJLabel;
	private JTextField usuarioJTextField;
	private JTextField senhaJTextField;
	private JButton okJButton;
	private JButton fecharJButton;

	public LoginView() {
		super("[FELIPE] Sistem Logins");
		
		// inicia componentes
		initComponents();
		
		// inicia paineis
		initPanel();
		
		// acoes
		initListeners();

		// Configurar a janela
		setSize(300, 100);
		
		// Centro da tela
		setLocationRelativeTo(null); 
		//setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void initListeners() {
		okJButton.addActionListener(new LoginAction(usuarioJTextField, senhaJTextField));
	}

	private void initPanel() {
		// Layout
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		// Paineis
		JPanel painelLogin = new JPanel(new GridLayout(1, 2));
		JPanel painelSenha = new JPanel(new GridLayout(1, 2));
		JPanel painelBotoes = new JPanel(new FlowLayout());
		
		// Usuario
		painelLogin.add(usuarioJLabel);
		painelLogin.add(usuarioJTextField);

		// Senha
		painelSenha.add(senhaJLabel);
		painelSenha.add(senhaJTextField);

		// Botões
		painelBotoes.add(okJButton);
		painelBotoes.add(fecharJButton);

		// Painel relacionado � janela
		container.add(painelLogin);
		container.add(painelSenha);
		container.add(painelBotoes);	
	}

	private void initComponents() {
		// Usuario
		usuarioJLabel = new JLabel("Usuario");
		usuarioJTextField = new JTextField(10);
		
		// Senha
		senhaJLabel = new JLabel("Senha");
		senhaJTextField = new JTextField(10);

		// Botões
		okJButton = new JButton("Entrar");
		fecharJButton = new JButton("Fechar");
	}
}
