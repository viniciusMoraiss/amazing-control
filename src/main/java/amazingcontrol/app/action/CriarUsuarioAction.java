package amazingcontrol.app.action;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import amazingcontrol.app.view.CadastroUsuarioView;
import amazingcontrol.model.Usuario;
import amazingcontrol.service.UsuarioService;

public class CriarUsuarioAction implements ActionListener {
	private CadastroUsuarioView view;

	public CriarUsuarioAction(CadastroUsuarioView cadastroUsuarioView) {
		this.view = cadastroUsuarioView;
	}

	public void actionPerformed(ActionEvent e) {
		// valores digitados pelo usuario
		String nome = view.getNomeTextField().getText();
		String senha = new String(view.getSenhaPasswordField().getPassword());
		// é preciso converter o password para string, pois o getPassword retorna um array de chars
		String confirmacaoSenha = new String(view.getConfirmacaoSenhaPasswordField().getPassword());
		boolean ativo = view.getAtivoCheckBox().isSelected();
		
		try {
			// cria objeto usuario com os valores digitados na tela
			Usuario usuario = new Usuario(nome, senha, confirmacaoSenha, ativo);
			
			// insere usuario se nao houver nenhum erro
			new UsuarioService().salvar(usuario);
			
			// mensagem de sucesso
			showMessageDialog(view, "Usuario inserido com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
			
			// chama o metodo privado para limpar os campos
			limpaCampos();
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			// imprime os erros se houver
			showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// Metodo para limpar os campos
	private void limpaCampos() {
		view.getNomeTextField().setText("");
		view.getSenhaPasswordField().setText("");
		view.getConfirmacaoSenhaPasswordField().setText("");
		view.getAtivoCheckBox().setSelected(false);
	}
}
