package amazingcontrol.app.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import amazingcontrol.app.view.MainView;
import amazingcontrol.dao.UsuarioDAO;
import amazingcontrol.model.Usuario;

public class LoginAction implements ActionListener {
	private JTextField usuarioJTextField;
	private JTextField senhaJTextField;

	public LoginAction(JTextField usuarioJTextField, JTextField senhaJTextField) {
		this.usuarioJTextField = usuarioJTextField;
		this.senhaJTextField = senhaJTextField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// nome e senha digitados pelo usuario
		String nome = usuarioJTextField.getText();
		String senha = senhaJTextField.getText();
		
		try {
			// busca usuario no banco com os dados digitados pelo usuario
			Usuario usuario = new UsuarioDAO().getUsuario(nome, senha);

			// verifica se existe usuario
			if (usuario != null) {
				System.out.println("Logado");
				// abre menu do sistema
				new MainView().setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Usuario ou senha invalida");
				// zera os campos de usuario e senha se for invalidos
				usuarioJTextField.setText("");
				senhaJTextField.setText("");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
