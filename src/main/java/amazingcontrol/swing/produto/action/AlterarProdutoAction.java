package amazingcontrol.swing.produto.action;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.model.Produto;
import amazingcontrol.swing.produto.view.TelaCadastroProduto;
import amazingcontrol.swing.produto.view.TelaProduto;

public class AlterarProdutoAction implements ActionListener {

	private TelaProduto produtoView;

	public AlterarProdutoAction(TelaProduto produtoView) {
		this.produtoView = produtoView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// recupera a linha selecionada pelo usuario
		int row = produtoView.getJtProduto().getSelectedRowCount();

		// caso a linha for igual a zero, pede para o usuario selecionar alguma
		if (row == 0) {
			showMessageDialog(produtoView, "Selecione uma linha para alterar o cliente desejado");
			return;
		}

		// recupera todas as linhas selecionada pelo usuario
		int[] indexes = produtoView.getJtProduto().getSelectedRows();

		// caso tenha mais de uma linha selecionada pede para selecionar apenas
		// uma
		if (indexes.length > 1) {
			showMessageDialog(produtoView, "Selecione apenas uma linha");
			return;
		}

		// recupera a linha selecionada
		int rowSelected = produtoView.getJtProduto().getSelectedRow();

		// Cliente inicia com o valor nulo
		Produto produto = null;

		// recupera o cliente selecionado
		produto = (Produto) produtoView.getJtProduto().getModel().getValueAt(rowSelected, 0);

		// abre a tela de cadastro setando os campos os dados do cliente a ser
		// alterado
		TelaCadastroProduto cadastroProdutoView = new TelaCadastroProduto(produtoView);
		cadastroProdutoView.setProduto(produto);
		cadastroProdutoView.getNomeText().setText(produto.getNome());
		cadastroProdutoView.getMarcaText().setText(produto.getMarca());
		cadastroProdutoView.getTipoComboBox().setSelectedItem(produto.getTipo());

		String valorCusto = "" + produto.getValorCusto();
		cadastroProdutoView.getValorCustoText().setText(valorCusto);
		String valorVenda = "" + produto.getValorVenda();
		cadastroProdutoView.getValorVendaText().setText(valorVenda);
		String quantidade = "" + produto.getQuantidade();
		cadastroProdutoView.getQuantidadeDeProdutoText().setText(quantidade);
		cadastroProdutoView.getCadastrarBt().setText("Alterar");
		cadastroProdutoView.setVisible(true);

		// se cliente for diferente de nulo, limpa a selecao e recarrega os
		// clientes
		if (produto != null) {
			produtoView.getJtProduto().clearSelection();
			produtoView.carregarProdutos();
		}
	}
}
