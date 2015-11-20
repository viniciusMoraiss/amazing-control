package amazingcontrol.service;

import java.sql.SQLException;
import java.util.List;

import amazingcontrol.dao.ClienteDAO;
import amazingcontrol.model.Cliente;

/**
 * Classe service para intermediar entre a view e dao 
 */
public class ClienteService {

	private ClienteDAO dao;

	/**
	 * Instacia o ClienteDAO
	 * @throws SQLException
	 */
	public ClienteService() throws SQLException {
		dao = new ClienteDAO();
	}

	/**
	 * Chama metodo lista do ClienteDAO
	 * @return lista de usuarios
	 */
	public List<Cliente> listar() {
		return dao.lista();
	}

	/**
	 * Ira salvar o cliente caso o cliente no parametro não tenha id. Se o cliente
	 * tiver id ira chamar o metodo atualizar
	 * 
	 * @param cliente
	 * @throws Exception
	 */
	public void salvar(Cliente cliente) {
		// valida cliente antes de inserir ou atualizar
		// validar(cliente);

		if (cliente.isNullId()) {
			dao.inserir(cliente);
		} else {
			dao.atualizar(cliente);
		}
	}

	/**
	 * Chama metodo deletar do ClienteDAO passando o cliente a ser deletado
	 * 
	 * @param cliente
	 */
	public void deletar(Cliente cliente) {
		dao.deletar(cliente);
	}
}
