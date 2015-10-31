package amazingcontrol.app.view;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class CadastroProdutoView extends JDialog {
	
	public CadastroProdutoView() {
		this(null);
	}

	public CadastroProdutoView(JFrame mainView) {
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
