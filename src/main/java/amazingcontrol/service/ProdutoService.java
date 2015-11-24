package amazingcontrol.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import amazingcontrol.connection.ConexaoMySQL;
import amazingcontrol.dao.ProdutoDAO;
import amazingcontrol.model.Fornecedor;
import amazingcontrol.model.Produto;

public class ProdutoService {
	private ProdutoDAO dao;
	private Connection con;

	/*
	 * Cria acesso ao metodos do banco já no construtor
	 */
	public ProdutoService() throws SQLException{
		dao = new ProdutoDAO();
		con = ConexaoMySQL.conectar();
	}

	/*
	 * metodo para carregar lista de produto
	 */
	public List<Produto> listar() {
		return dao.lista(con);
	}

	/*
	 * Metodo para salvar produto no banco de dados, respeitando a logica: - ira
	 * validar os campos - caso o id seja igual a null ira inserir o fornecedor
	 * - caso o id seja diferente de null ira atualizar um produto existente
	 */
	public void salvar(Produto produto, Fornecedor fornecedor) {
		// valida produto antes de inserir ou atualizar
		// validar(produto);

		if (produto.isNullId()) {
			dao.inserir(con, produto, fornecedor);
		} else {
			dao.atualizar(con, produto, fornecedor);
		}
	}

	/*
	 * Metodo para deletar produto
	 */
	public void deletar(Produto produto) {
		dao.deletar(con, produto);
	}
	
	/**
	 * recupera produto pelo id
	 */
	public Produto getProdutoPorId(int id) {
		return dao.getProdutoPorId(con, id);
	}

}
