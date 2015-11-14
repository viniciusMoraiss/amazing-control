package amazingcontrol.service;

import java.sql.SQLException;
import java.util.List;

import amazingcontrol.dao.ProdutoDAO;
import amazingcontrol.model.Produto;

public class ProdutoService {
	private ProdutoDAO dao;

	/*
	 * Cria acesso ao metodos do banco já no construtor
	 */
	public ProdutoService() throws SQLException {
		dao = new ProdutoDAO();
	}

	/*
	 * metodo para carregar lista de produto
	 */
	public List<Produto> listar() {
		return dao.lista();
	}

	/*
	 * Metodo para salvar produto no banco de dados, respeitando a logica: - ira
	 * validar os campos - caso o id seja igual a null ira inserir o fornecedor
	 * - caso o id seja diferente de null ira atualizar um produto existente
	 */
	public void salvar(Produto produto) {
		// valida produto antes de inserir ou atualizar
		// validar(produto);

		if (produto.isNullId()) {
			dao.inserir(produto);
		} else {
			dao.atualizar(produto);
		}
	}

	/*
	 * Metodo para deletar produto
	 */
	public void deletar(Produto produto) {
		dao.deletar(produto);
	}

}
