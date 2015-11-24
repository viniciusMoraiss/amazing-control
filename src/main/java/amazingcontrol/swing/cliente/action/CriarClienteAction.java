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
			
			if(uf.isNotSelecionado()) {
				showMessageDialog(clienteCadastroView, "Por favor, selecione uma UF", "OK", INFORMATION_MESSAGE);
			}

			if (telefoneComMascara != null && telefoneComMascara.matches(".*\\d+.*")) {
				telefone = (String) clienteCadastroView.getMaskTelefone().stringToValue(telefoneComMascara);
			}

			if (cepComMascara != null && cepComMascara.matches(".*\\d+.*")) {
				cep = (String) clienteCadastroView.getMaskCep().stringToValue(cepComMascara);
			}

			// cria objeto com os dados digitados pelo usuario
			Cliente cliente = new Cliente(nome, endereco, telefone, cidade, cep, uf);
			
			// caso seja alteração
			if(clienteCadastroView.getCliente() != null) {
				cliente.setId(clienteCadastroView.getCliente().getId());
			}

			// tenta salvar o objeto fornecedor no banco de dados
			new ClienteService().salvar(cliente);
			
			clienteCadastroView.getClienteView().carregarClientes();
			
			String msg = cliente.getId() == null ? "Inserido com sucesso" : "Alterado com sucesso";
			
			// mensagem de sucesso
			showMessageDialog(clienteCadastroView, msg, "OK", INFORMATION_MESSAGE);
			
			// fehca janela apos cadastro
			clienteCadastroView.dispose();

		} catch (SQLException | IllegalArgumentException |ParseException ex) {
			ex.printStackTrace();
			showMessageDialog(clienteCadastroView, ex.getMessage(), "Erro", ERROR_MESSAGE);
		}
	}
}
