package amazingcontrol.swing.usuario.action;

import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.model.Usuario;
import amazingcontrol.service.UsuarioService;
import amazingcontrol.swing.usuario.view.TelaUsuario;

public class DeletarUsuarioAction implements ActionListener {

	private TelaUsuario view;

	public DeletarUsuarioAction(TelaUsuario view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int rows = view.getUsuariosJTable().getSelectedRowCount();

		if (rows == 0) {
			showMessageDialog(view, "Selecione uma linha ou mais linha!");
			return;
		}

		if (showConfirmDialog(view, "Confirma") != YES_OPTION) {
			return;
		}

		try {
			int[] indexes = view.getUsuariosJTable().getSelectedRows();
			Usuario usuario = null;

			for (int index : indexes) {
				usuario = (Usuario) view.getModel().getValueAt(index, 0);
				new UsuarioService().deletar(usuario);
			}

			if (usuario != null) {
				view.getUsuariosJTable().clearSelection();
				view.carregarUsuarios();
			}

		} catch (Exception cause) {
			cause.printStackTrace();
			showMessageDialog(view, cause.getMessage());
		}
	}

}
