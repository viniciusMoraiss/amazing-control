package amazingcontrol.swing.login.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import amazingcontrol.swing.login.view.TelaLogin;

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
		Logar.fazerLogin(loginView, usuarioJTextField, senhaJPasswordField );
	}
}
