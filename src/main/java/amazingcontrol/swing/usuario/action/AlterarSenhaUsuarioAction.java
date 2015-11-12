package amazingcontrol.swing.usuario.action;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import amazingcontrol.model.Usuario;
import amazingcontrol.service.UsuarioService;
import amazingcontrol.swing.usuario.view.TelaAlterarSenhaUsuario;

public class AlterarSenhaUsuarioAction implements ActionListener {

	private TelaAlterarSenhaUsuario view;

	public AlterarSenhaUsuarioAction(TelaAlterarSenhaUsuario view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// valores digitados pelo usuario
		String senhaAtual = new String(view.getSenhaAtualPasswordField().getPassword());
		String senha = new String(view.getSenhaPasswordField().getPassword());
		// é preciso converter o password para string, pois o getPassword retorna um array de chars
		String confirmacaoSenha = new String(view.getConfirmacaoSenhaPasswordField().getPassword());

		String msg;

		try {
			// cria objeto usuario com os valores do usuario a ser alterado (logado)
			Usuario usuario = view.getUsuario();
			
			if(senhaAtual.equals(usuario.getSenha())) {
				usuario.setSenha(senha);
				usuario.setConfirmacaoSenha(confirmacaoSenha);
				
				// altera usuario se nao houver nenhum erro
				new UsuarioService().salvar(usuario);
				msg = "Usuario alterado com sucesso";
			} else {
				msg = "Senha atual invalida";
			}
			
			
			showMessageDialog(view, msg, "Informação", JOptionPane.INFORMATION_MESSAGE);
			
		
		} catch (Exception ex) {
			ex.printStackTrace();
			// imprime os erros se houver
			showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			// limpa campos
			limpaCampos();
		}
	}
	
	// Metodo para limpar os campos
	private void limpaCampos() {
		view.getSenhaAtualPasswordField().setText("");
		view.getSenhaPasswordField().setText("");
		view.getConfirmacaoSenhaPasswordField().setText("");
	}

}
