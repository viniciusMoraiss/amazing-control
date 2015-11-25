package amazingcontrol.swing.vendas.action;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import amazingcontrol.model.Produto;
import amazingcontrol.swing.vendas.view.TelaVenderProdutos;

public class AdicionarProdutoAction implements ActionListener {

	private TelaVenderProdutos view;

	public AdicionarProdutoAction(TelaVenderProdutos view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Produto produto = (Produto) view.getProdutosComboBox().getSelectedItem();

		DefaultTableModel model;

		model = (DefaultTableModel) view.getProdutosJTable().getModel();

		model.getDataVector().clear();

		int quantidade = Integer.parseInt(view.getQuantidadeTextField().getText());
		
		if(quantidade <= 0 ) {
			showMessageDialog(view, "Valor deve ser maior ou igual 1", "ERRO", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		try {
			
			view.getAdicionarService().addProdutos(produto, quantidade);

			List<Produto> produtos = view.getAdicionarService().getProdutos();

			for (Produto p : produtos) {
				//"Nome", "Marca", "Tipo", "Valor Venda", "Quantidade", "Valor Total" 
				model.addRow(new Object[] { p, p.getMarca(), p.getTipo(), p.getValorVenda(),
						p.getQuantidade(), p.getValorTotal() });
			}

			view.getProdutosJTable().updateUI();
			
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
			showMessageDialog(view, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

}
