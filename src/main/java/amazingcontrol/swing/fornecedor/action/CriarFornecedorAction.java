package amazingcontrol.swing.fornecedor.action;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import amazingcontrol.model.Fornecedor;
import amazingcontrol.model.UF;
import amazingcontrol.service.FornecedorService;
import amazingcontrol.swing.fornecedor.view.TelaCadastroFornecedor;

public class CriarFornecedorAction implements ActionListener {

	private TelaCadastroFornecedor view;

	public CriarFornecedorAction(TelaCadastroFornecedor view) {
		this.view = view;
	}

	public void actionPerformed(ActionEvent e) {
		// pega os atributos digitados pelo usuario e adiciona a uma variavel
		String nome = view.getNomeText().getText();
		String endereco = view.getEnderecoText().getText();
		String cidade = view.getCidadeText().getText();
		UF uf = (UF) view.getUFComboBox().getSelectedItem();

		// remover as mascaras telefone e cep
		String telefoneComMascara = view.getTelefoneText().getText();
		String cepComMascara = view.getCepText().getText();

		String telefone = null;
		String cep = null;

		try {
			
			if(uf.isNotSelecionado()) {
				showMessageDialog(view, "Por favor selecione a UF", "ERRO", ERROR_MESSAGE);
				return;
			}
			
			if (telefoneComMascara != null && telefoneComMascara.matches(".*\\d+.*")) {
				telefone = (String) view.getMaskTelefone().stringToValue(telefoneComMascara);
			}

			if (cepComMascara != null && cepComMascara.matches(".*\\d+.*")) {
				cep = (String) view.getMaskCep().stringToValue(cepComMascara);
			}

			// cria objeto com os dados digitados pelo usuario
			Fornecedor fornecedor = new Fornecedor(nome, telefone, endereco, cidade, cep, uf);
			
			if (view.getFornecedor() != null) {
				fornecedor.setId(view.getFornecedor().getId());
			}

			// tenta salvar o objeto fornecedor no banco de dados
			new FornecedorService().salvar(fornecedor);
			
			String msg = fornecedor.getId() == null ? "Inserido com sucesso" : "Alterado com sucesso";

			// mensagem de sucesso
			showMessageDialog(view, msg, "OK", INFORMATION_MESSAGE);
			
			view.getFornecedorView().carregarFornecedores();
			
			view.dispose();

		} catch (SQLException | IllegalArgumentException |ParseException ex) {
			ex.printStackTrace();
			showMessageDialog(view, ex.getMessage(), "Erro", ERROR_MESSAGE);

		}

	}
}
