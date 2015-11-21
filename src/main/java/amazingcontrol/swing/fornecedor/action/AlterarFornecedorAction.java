package amazingcontrol.swing.fornecedor.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazingcontrol.model.Fornecedor;
import amazingcontrol.swing.fornecedor.view.TelaCadastroFornecedor;
import amazingcontrol.swing.fornecedor.view.TelaFornecedor;
import static javax.swing.JOptionPane.showMessageDialog;

public class AlterarFornecedorAction implements ActionListener {

	private TelaFornecedor fornecedorView;

	public AlterarFornecedorAction(TelaFornecedor fornecedorView) {
		this.fornecedorView = fornecedorView;

	}

	public void actionPerformed(ActionEvent e) {
		// recupera a linha selecionada
		int row = fornecedorView.getJtFornecedor().getSelectedRow();

		// logica invertida
		// if (row == 0) {
		// showMessageDialog(fornecedorView, "Selecione uma linha");
		// return;
		// }

		// recupera todas as linha selecionadas
		int[] indexes = fornecedorView.getJtFornecedor().getSelectedRows();

		// caso tenha mais de uma linha selecionada pede para seleciona somente
		// uma
		if (indexes.length > 1) {
			showMessageDialog(fornecedorView, "Selecione apenas uma linha");
			return;

		}
		// recupera a linha selecionada
		int rowSelected = fornecedorView.getJtFornecedor().getSelectedRow();

		// fornecedor inicia com o valor nulo
		Fornecedor fornecedor = null;

		// recupera o fornecedor selecionado
		fornecedor = (Fornecedor) fornecedorView.getModel().getValueAt(rowSelected, 0);

		// abre a tela de cadastro setando os campos os dados do cliente a ser
		// alterado
		TelaCadastroFornecedor cadastroFornecedorView = new TelaCadastroFornecedor(fornecedorView);
		cadastroFornecedorView.setFornecedor(fornecedor);
		cadastroFornecedorView.getNomeText().setText(fornecedor.getNome());
		cadastroFornecedorView.getTelefoneText().setText(fornecedor.getTelefone());
		cadastroFornecedorView.getEnderecoText().setText(fornecedor.getEndereco());
		cadastroFornecedorView.getCidadeText().setText(fornecedor.getCidade());
		cadastroFornecedorView.getCepText().setText(fornecedor.getCep());
		cadastroFornecedorView.getUfJComboBox().setSelectedItem(fornecedor.getUf());
		cadastroFornecedorView.getCadastrarBt().setText("Alterar");
		cadastroFornecedorView.setVisible(true);

		if (fornecedor != null) {
			fornecedorView.getJtFornecedor().clearSelection();
			fornecedorView.carregarFornecedores();
		}

	}

}
