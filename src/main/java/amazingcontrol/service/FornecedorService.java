package amazingcontrol.service;

import java.sql.SQLException;
import java.util.List;

import amazingcontrol.dao.FornecedorDAO;
import amazingcontrol.model.Fornecedor;

public class FornecedorService {
	private FornecedorDAO dao;

	/*
	 * Cria acesso ao metodos do banco já no construtor
	 */
	public FornecedorService() throws SQLException {
		dao = new FornecedorDAO();
	}

	/*
	 * metodo para carregar lista de fornecedor
	 */
	public List<Fornecedor> listar() {
		return dao.lista();
	}

	/*
	 * Metodo para salvar fornecedor no banco de dados, respeitando a logica: -
	 * ira validar os campos - caso o id seja igual a null ira inserir o
	 * fornecedor - caso o id seja diferente de null ira atualizar um fornecedor
	 * existente
	 */
	public void salvar(Fornecedor fornecedor) {
		// valida fornecedor antes de inserir ou atualizar
		// validar(fornecedor);

		if (fornecedor.isNullId()) {
			dao.inserir(fornecedor);
		} else {
			dao.atualizar(fornecedor);
		}
	}

	/*
	 * Metodo para deletar fornecedor
	 */
	public void deletar(Fornecedor fornecedor) {
		dao.deletar(fornecedor);
	}

}
