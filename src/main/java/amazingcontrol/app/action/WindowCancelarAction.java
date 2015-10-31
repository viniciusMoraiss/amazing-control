package amazingcontrol.app.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class WindowCancelarAction implements ActionListener {

    private JDialog window;
    private String titulo;
    private String mensagem;

    public WindowCancelarAction(JDialog window, String titulo) {
        this(window, titulo, "Deseja fechar o cadastro?");
    }

    public WindowCancelarAction(JDialog window, String titulo, String mensagem) {
        super();
        this.window = window;
        this.titulo = titulo;
        this.mensagem = mensagem;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		int opcao = JOptionPane.OK_CANCEL_OPTION;

        if (JOptionPane.showConfirmDialog(window, mensagem, titulo, opcao) == 0) {
            window.dispose();
        }

	}
}
