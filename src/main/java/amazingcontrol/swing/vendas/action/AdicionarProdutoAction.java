package amazingcontrol.swing.vendas.action;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import amazingcontrol.model.Produto;
import amazingcontrol.service.ProdutoService;
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

		List<Produto> produtos = view.getVenda().getProdutos();

		try {

			int quantidadeBanco = new ProdutoService().getProdutoPorId(produto.getId()).getQuantidade();

			int quantidade = Integer.parseInt(view.getQuantidadeTextField().getText());

			if (produtos.size() > 0) {
				// verificar se produto já está na lista, se nao estiver retorna
				// nulo
				if (getProdutoLista(produto, produtos) != null) {
					if (quantidade + produto.getQuantidade() <= quantidadeBanco) {
						produto.setQuantidade(quantidade + produto.getQuantidade());
					}
				} else if (quantidade <= quantidadeBanco) {
					produto.setQuantidade(quantidade);
					produtos.add(produto);
				} else {
					showMessageDialog(view, "Quantidade insuficiente", "ERRO", ERROR_MESSAGE);
				}

			} else if (quantidade <= quantidadeBanco) {
				produto.setQuantidade(quantidade);
				produtos.add(produto);
			} else {
				showMessageDialog(view, "Quantidade insuficiente", "ERRO", ERROR_MESSAGE);
			}

			for (Produto p : produtos) {
				// "Nome", "Marca", "Tipo", "Valor Custo", "Valor Venda",
				// "Quantidade"
				model.addRow(new Object[] { p, p.getMarca(), p.getTipo(), p.getValorCusto(), p.getValorVenda(),
						p.getQuantidade() });
			}

			view.getProdutosJTable().updateUI();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	private Produto getProdutoLista(Produto produto, List<Produto> produtos) {
		// verificar se produto já está na lista
		for (int i = 0; i < produtos.size(); i++) {
			// se estiver soma a quantidade com a já inserida
			if (produto.getId().equals(produtos.get(i).getId())) {
				return produto;
			}
		}

		return null;

	}

}
