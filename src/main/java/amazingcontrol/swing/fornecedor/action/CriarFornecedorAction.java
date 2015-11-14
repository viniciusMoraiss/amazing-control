package amazingcontrol.swing.fornecedor.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import amazingcontrol.model.Fornecedor;
import amazingcontrol.service.FornecedorService;
import amazingcontrol.swing.fornecedor.view.TelaCadastroFornecedor;

public class CriarFornecedorAction implements ActionListener {

	private TelaCadastroFornecedor view;

	public CriarFornecedorAction(TelaCadastroFornecedor view) {
		this.view = view;
	}

	// o actionperformed pega os getters da TelaCadastroFornecedor e atribui a
	// uma variavel

	public void actionPerformed(ActionEvent e) {
		String nome = view.getNomeText().getText();
		String telefone = view.getTelefoneText().getText();
		String endereco = view.getEnderecoText().getText();
		String cidade = view.getCidadeText().getText();
		String cep = view.getCepText().getText();
		String uf = view.getUfText().getText();

		Fornecedor fornecedor = new Fornecedor(nome, telefone, endereco, cidade, cep, uf);

		// os dados fornecidos serao salvos no banco de dados

		try {
			new FornecedorService().salvar(fornecedor);
			JOptionPane.showMessageDialog(view, "Inserido com sucesso");
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}
