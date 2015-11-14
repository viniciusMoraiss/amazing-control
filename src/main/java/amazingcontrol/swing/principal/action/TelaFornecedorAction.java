package amazingcontrol.swing.principal.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.swing.fornecedor.view.TelaFornecedor;
import amazingcontrol.swing.principal.view.TelaPrincipal;
/**
 * class TelaFornecedorAction
 * Ação responsavel por chamar a tela de fornecedor 
 */
public class TelaFornecedorAction implements ActionListener {
	
	/**
	 * Variavel view de referencia para tela principal
	 */
	private TelaPrincipal view;
	
	/**
	 * Construtor recebendo a tela principal como parametro
	 * @param view
	 */
	public TelaFornecedorAction(TelaPrincipal view) {
		this.view = view;
	}
	
	/**
	 * metodo que chama a tela de fornecedor
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		new TelaFornecedor(view).setVisible(true);	
	}

}
