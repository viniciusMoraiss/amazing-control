package amazingcontrol.swing.vendas.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.model.Usuario;
import amazingcontrol.swing.vendas.view.TelaPesquisarCliente;

public class TelaVendasAction implements ActionListener {

	private Usuario usuario;

	public TelaVendasAction(Usuario usuario) {
		this.usuario = usuario;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new TelaPesquisarCliente(usuario).setVisible(true);
	}

}
