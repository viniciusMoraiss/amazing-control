package amazingcontrol.swing.login.action;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import amazingcontrol.swing.login.view.TelaLogin;

public class LoginEnterAction implements KeyListener {

	private JTextField usuarioJTextField;
	private JPasswordField senhaJPasswordField;
	private TelaLogin loginView;

	public LoginEnterAction(TelaLogin loginView, JTextField usuarioJTextField, JPasswordField senhaJPasswordField) {
		this.loginView = loginView;
		this.usuarioJTextField = usuarioJTextField;
		this.senhaJPasswordField = senhaJPasswordField;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER){
			Logar.fazerLogin(loginView, usuarioJTextField, senhaJPasswordField);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER){
			Logar.fazerLogin(loginView, usuarioJTextField, senhaJPasswordField);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER){
			Logar.fazerLogin(loginView, usuarioJTextField, senhaJPasswordField);
		}
	}

}
