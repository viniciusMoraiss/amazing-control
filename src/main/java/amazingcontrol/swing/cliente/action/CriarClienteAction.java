package amazingcontrol.swing.cliente.action;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import amazingcontrol.model.Cliente;
import amazingcontrol.model.UF;
import amazingcontrol.service.ClienteService;
import amazingcontrol.swing.cliente.view.TelaCadastroCliente;

public class CriarClienteAction implements ActionListener {

	private TelaCadastroCliente clienteCadastroView;

	public CriarClienteAction(TelaCadastroCliente clienteCadastroView) {
		this.clienteCadastroView = clienteCadastroView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// pega os atributos digitados pelo usuario e adiciona a uma variavel
		String nome = clienteCadastroView.getNomeTextField().getText();
		String endereco = clienteCadastroView.getEnderecoTextField().getText();
		String cidade = clienteCadastroView.getCidadeTextField().getText();
		UF uf = (UF) clienteCadastroView.getUfJComboBox().getSelectedItem();

		// remover as mascaras telefone e cep para salvar no banco
		String telefoneComMascara = clienteCadastroView.getTelefoneTextField().getText();
		String cepComMascara = clienteCadastroView.getCepTextField().getText();

		String telefone = null;
		String cep = null;

		try {

			if (telefoneComMascara != null && telefoneComMascara.matches(".*\\d+.*")) {
				telefone = (String) clienteCadastroView.getMaskTelefone().stringToValue(telefoneComMascara);
			}

			if (cepComMascara != null && cepComMascara.matches(".*\\d+.*")) {
				cep = (String) clienteCadastroView.getMaskCep().stringToValue(cepComMascara);
			}

			// cria objeto com os dados digitados pelo usuario
			Cliente cliente = new Cliente(nome, telefone, endereco, cidade, cep, uf);

			// tenta salvar o objeto fornecedor no banco de dados
			new ClienteService().salvar(cliente);
			
			clienteCadastroView.getClienteView().carregarClientes();

			// mensagem de sucesso
			showMessageDialog(clienteCadastroView, "Inserido com sucesso", "OK", INFORMATION_MESSAGE);

		} catch (SQLException | ParseException ex) {
			ex.printStackTrace();
			showMessageDialog(clienteCadastroView, ex.getMessage(), "Erro", ERROR_MESSAGE);
		}
	}
}
