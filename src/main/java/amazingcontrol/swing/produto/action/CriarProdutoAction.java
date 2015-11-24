package amazingcontrol.swing.produto.action;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import amazingcontrol.model.Fornecedor;
import amazingcontrol.model.Produto;
import amazingcontrol.model.Tipo;
import amazingcontrol.service.ProdutoService;
import amazingcontrol.swing.produto.view.TelaCadastroProduto;

public class CriarProdutoAction implements ActionListener {
	
	private TelaCadastroProduto view;

	public CriarProdutoAction(TelaCadastroProduto view) {
		this.view = view;
	}

	public void actionPerformed(ActionEvent e) {
		// pega os atributos digitados pelo usuario e adiciona a uma variavel
		String nome = view.getNomeText().getText();
		String marca = view.getMarcaText().getText();
		Tipo tipo = (Tipo) view.getTipoComboBox().getSelectedItem();
		double valorCusto = Double.parseDouble(view.getValorCustoText().getText());
		double valorVenda = Double.parseDouble(view.getValorVendaText().getText());
		int quantidade = Integer.parseInt(view.getQuantidadeDeProdutoText().getText());
		Fornecedor fornecedor = (Fornecedor) view.getFornecedorCombo().getSelectedItem();
		
		try {
			// cria objeto com os dados digitados pelo usuario
			Produto produto = new Produto(nome, marca, tipo, valorCusto, valorVenda, quantidade);
			
			// tenta salvar o objeto fornecedor no banco de dados
			new ProdutoService().salvar(produto, fornecedor);
			
			// mensagem de sucesso
			showMessageDialog(view, "Inserido com sucesso", "OK", INFORMATION_MESSAGE);
			
			// recarrega os produtos
			view.getProdutos();
			
			view.dispose();
			
		} catch (SQLException | IllegalArgumentException ex) {
			ex.printStackTrace();
			showMessageDialog(view, ex.getMessage(), "Erro", ERROR_MESSAGE);
		}
	}

}
