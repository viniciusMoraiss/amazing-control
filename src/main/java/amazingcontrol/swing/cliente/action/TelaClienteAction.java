package amazingcontrol.swing.cliente.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.model.Cliente;
import amazingcontrol.swing.cliente.view.TelaCliente;
import amazingcontrol.swing.principal.view.TelaPrincipal;

public class TelaClienteAction implements ActionListener {

	private TelaPrincipal view;

	public TelaClienteAction(TelaPrincipal telaPrincipal) {
		this.view = telaPrincipal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new TelaCliente(view).setVisible(true);
	}

}
