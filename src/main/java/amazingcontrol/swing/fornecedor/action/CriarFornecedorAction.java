package amazingcontrol.swing.fornecedor.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JOptionPane;

import amazingcontrol.model.Fornecedor;
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
		String uf = view.getUfText().getText();
		
		// remover as mascaras telefone e cep
		String telefoneComMascara = view.getTelefoneText().getText();
		String cepComMascara = view.getCepText().getText();
		
		String telefone = null;
		String cep = null;
		
		try {
			telefone = (String) view.getMaskTelefone().stringToValue(telefoneComMascara);
			cep = (String) view.getMaskCep().stringToValue(cepComMascara);;
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		
		// cria objeto com os dados digitados pelo usuario
		Fornecedor fornecedor = new Fornecedor(nome, telefone, endereco, cidade, cep, uf);

		try {
			// tenta salvar o objeto fornecedor no banco de dados
			new FornecedorService().salvar(fornecedor);
			JOptionPane.showMessageDialog(view, "Inserido com sucesso");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(view, "Erro ao inserir");
		}

	}

}
