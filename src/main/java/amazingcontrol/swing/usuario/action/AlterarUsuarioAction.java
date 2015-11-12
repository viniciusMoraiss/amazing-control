package amazingcontrol.swing.usuario.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.swing.principal.view.TelaPrincipal;
import amazingcontrol.swing.usuario.view.TelaAlterarSenhaUsuario;

public class AlterarUsuarioAction implements ActionListener {

	private TelaPrincipal view;

	public AlterarUsuarioAction(TelaPrincipal view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * Deixar comentado, pode ser que use em outras telas que tenham tabela
		 * 
		int rows = view.getUsuariosJTable().getSelectedRowCount();
		
		if (rows != 1) {
			showMessageDialog(view, "Selecione uma linha!", "ERRO", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		int row = view.getUsuariosJTable().getSelectedRow();
		
		// recupera usuario selecionado
		Usuario usuario = (Usuario) view.getModel().getValueAt(row, 0);
		
		if(view.getUsuario().equals(usuario)) {
			//seta dados do usuario na tela
			TelaCadastroUsuario cadastroUsuarioView = new TelaCadastroUsuario(view);
			cadastroUsuarioView.setIdUsuario(usuario.getId());
			cadastroUsuarioView.getNomeTextField().setText(usuario.getNome());
			cadastroUsuarioView.getAtivoCheckBox().setSelected(usuario.isAtivo());
			cadastroUsuarioView.getBotaoCriarUsuario().setText("Atualizar");
			cadastroUsuarioView.setVisible(true);
		} else {
			showMessageDialog(view, "Sem permissão", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		*/
		// chama tela de alterar senha
		new TelaAlterarSenhaUsuario(view).setVisible(true);

	}

}
