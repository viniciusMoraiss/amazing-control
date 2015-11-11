package amazingcontrol.swing.produto.view;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class TelaCadastroProduto extends JDialog {
	
	public TelaCadastroProduto() {
		this(null);
	}

	public TelaCadastroProduto(JFrame mainView) {
		super();
		
		setTitle("[A-CONTROL] Cadastro de usuarios");
		setSize(630, 320);
		setResizable(false);
		setLocationRelativeTo(mainView);
		//setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setAlwaysOnTop(true);
		setModal(true);
	}

}
