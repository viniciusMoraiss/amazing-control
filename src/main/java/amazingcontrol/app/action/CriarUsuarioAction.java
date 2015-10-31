package amazingcontrol.app.action;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import amazingcontrol.app.view.CadastroUsuarioView;
import amazingcontrol.dao.UsuarioDAO;
import amazingcontrol.model.Usuario;

public class CriarUsuarioAction implements ActionListener {
	private CadastroUsuarioView view;

	public CriarUsuarioAction(CadastroUsuarioView cadastroUsuarioView) {
		this.view = cadastroUsuarioView;
	}

	public void actionPerformed(ActionEvent e) {
		String nome = view.getNomeTextField().getText();
		String senha = new String(view.getSenhaPasswordField().getPassword());
		String confirmacaoSenha = new String(view.getConfirmacaoSenhaPasswordField().getPassword());
		boolean ativo = view.getAtivoCheckBox().isSelected();
		
		Usuario usuario = new Usuario(nome, senha, confirmacaoSenha, ativo);
		
		try {
			UsuarioDAO dao = new UsuarioDAO();
			
			if(!senha.equals(confirmacaoSenha)){
				showMessageDialog(view, "Confirmação de senha não pode ser diferente da senha", "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				dao.inserir(usuario);
				showMessageDialog(view, "Usuario inserido com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
