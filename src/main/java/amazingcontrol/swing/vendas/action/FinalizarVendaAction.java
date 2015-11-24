package amazingcontrol.swing.vendas.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import amazingcontrol.model.Produto;
import amazingcontrol.model.Venda;
import amazingcontrol.service.FinalizarVendaService;
import amazingcontrol.swing.vendas.view.TelaVenderProdutos;

public class FinalizarVendaAction implements ActionListener {

	private TelaVenderProdutos view;

	public FinalizarVendaAction(TelaVenderProdutos view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Venda venda = view.getVenda();

		List<Produto> produtos = venda.getProdutos();

		try {
			// tenta cadastrar a venda de cada produto no banco de dados
			for (Produto produto : produtos) {
				// cadastrar venda no banco de dados
				new FinalizarVendaService().cadastrar(venda, produto);
			}

			JOptionPane.showMessageDialog(view, "Inserido com sucesso");
			
			view.dispose();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
