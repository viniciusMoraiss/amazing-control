package amazingcontrol.view;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import amazingcontrol.dao.UsuarioDAO;
import amazingcontrol.model.Usuario;

public class LoginView extends JFrame implements ActionListener{

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
		
		setLocationRelativeTo(null); // Centro da tela
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void initListeners() {

		okJButton.addActionListener(this);
	}

	private void initPanel() {
		// Painel
		JPanel painel = new JPanel();

		// Layout
		painel.setLayout(new GridLayout(0, 2));

		// Componentes relacionados ao painel
		
		// Usuario
		painel.add(usuarioJLabel);
		painel.add(usuarioJTextField);

		// Senha
		painel.add(senhaJLabel);
		painel.add(senhaJTextField);

		// Botões
		painel.add(okJButton);
		painel.add(fecharJButton);

		// Painel relacionado � janela
		this.add(painel);
	}

	private void initComponents() {
		// Usuario
		usuarioJLabel = new JLabel("Usuario");
		usuarioJTextField = new JTextField();
		
		// Senha
		senhaJLabel = new JLabel("Senha");
		senhaJTextField = new JTextField();

		// Botões
		okJButton = new JButton("Entrar");
		fecharJButton = new JButton("Fechar");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(okJButton)){
			try {
				// nome e senha digitados pelo usuario
				String nome = usuarioJTextField.getText();
				String senha = senhaJTextField.getText();
				
				// busca usuario no banco com os dados digitados pelo usuario
				Usuario usuario = new UsuarioDAO().getUsuario(nome, senha);
				
				// verifica se existe usuario
				if(usuario != null){
					JOptionPane.showMessageDialog(this, "logado");
				} else {
					JOptionPane.showMessageDialog(this, "Usuario ou senha invalida");
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
