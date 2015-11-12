package amazingcontrol.swing.usuario.action;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import amazingcontrol.model.Usuario;
import amazingcontrol.service.UsuarioService;
import amazingcontrol.swing.principal.view.TelaPrincipal;
import amazingcontrol.swing.usuario.view.TelaLogin;

public class LoginAction implements ActionListener {
	private JTextField usuarioJTextField;
	private JPasswordField senhaJPasswordField;
	private JFrame loginView;

	public LoginAction(TelaLogin loginView, JTextField usuarioJTextField, JPasswordField senhaJPasswordField) {
		this.loginView = loginView;
		this.usuarioJTextField = usuarioJTextField;
		this.senhaJPasswordField = senhaJPasswordField;
	}

	public void actionPerformed(ActionEvent e) {
		// nome e senha digitados pelo usuario
		String nome = usuarioJTextField.getText();
		String senha = new String(senhaJPasswordField.getPassword());
		
		try {
			// busca usuario no banco com os dados digitados pelo usuario
			Usuario usuario = new UsuarioService().getUsuario(nome, senha);

			// verifica se existe usuario e ele está ativo
			if (usuario != null && usuario.isAtivo()) {
				System.out.println("Logado");
				// abre menu do sistema
				new TelaPrincipal(usuario).setVisible(true);
				// fecha tela de login
				loginView.setVisible(false);
				
			} else {
				showMessageDialog(null, "Usuario ou senha invalida");
				// zera os campos de usuario e senha se for invalidos
				usuarioJTextField.setText("");
				senhaJPasswordField.setText("");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
