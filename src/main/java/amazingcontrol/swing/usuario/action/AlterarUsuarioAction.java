package amazingcontrol.swing.usuario.action;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.model.Usuario;
import amazingcontrol.swing.usuario.view.TelaCadastroUsuario;
import amazingcontrol.swing.usuario.view.TelaUsuario;

public class AlterarUsuarioAction implements ActionListener {

	private TelaUsuario view;

	public AlterarUsuarioAction(TelaUsuario view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int rows = view.getUsuariosJTable().getSelectedRowCount();
		
		if (rows != 1) {
			showMessageDialog(view, "Selecione uma linha!");
			return;
		}
		
		int row = view.getUsuariosJTable().getSelectedRow();
		
		// recupera usuario selecionado
		Usuario usuario = (Usuario) view.getModel().getValueAt(row, 0);
		
		//seta dados do usuario na tela
		TelaCadastroUsuario cadastroUsuarioView = new TelaCadastroUsuario(view);
		cadastroUsuarioView.setIdUsuario(usuario.getId());
		cadastroUsuarioView.getNomeTextField().setText(usuario.getNome());
		cadastroUsuarioView.getAtivoCheckBox().setSelected(usuario.isAtivo());
		cadastroUsuarioView.getBotaoCriarUsuario().setText("Atualizar");
		cadastroUsuarioView.setVisible(true);
	}

}
