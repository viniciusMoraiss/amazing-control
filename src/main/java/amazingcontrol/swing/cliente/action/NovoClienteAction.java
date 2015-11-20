package amazingcontrol.swing.cliente.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.swing.cliente.view.TelaCadastroCliente;
import amazingcontrol.swing.cliente.view.TelaCliente;

public class NovoClienteAction implements ActionListener {

	private TelaCliente view;

	public NovoClienteAction(TelaCliente view) {
		this.view = view;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new TelaCadastroCliente(view).setVisible(true);
	}

}
