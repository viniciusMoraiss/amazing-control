package amazingcontrol.swing.usuario.action;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import amazingcontrol.model.Usuario;
import amazingcontrol.service.UsuarioService;
import amazingcontrol.swing.usuario.view.TelaUsuario;

public class InativarApagarAction implements ActionListener {

	private TelaUsuario view;

	public InativarApagarAction(TelaUsuario view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int rows = view.getUsuariosJTable().getSelectedRowCount();

		if (rows != 1) {
			showMessageDialog(view, "Selecione uma linha!", "ERRO", JOptionPane.ERROR_MESSAGE);
			return;
		}

		int row = view.getUsuariosJTable().getSelectedRow();

		// recupera usuario selecionado
		Usuario usuario = (Usuario) view.getModel().getValueAt(row, 0);

		try {
			usuario.setAtivo(false);
			boolean alterou = new UsuarioService().alterarStatus(usuario);
			
			if (alterou) {
				showMessageDialog(view, "Inativado com sucesso", "INFORMACAO", JOptionPane.INFORMATION_MESSAGE);
			} else {
				showMessageDialog(view, "Usuario já esta inativo", "ERRO", JOptionPane.ERROR_MESSAGE);
			}

			view.carregarUsuarios();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
