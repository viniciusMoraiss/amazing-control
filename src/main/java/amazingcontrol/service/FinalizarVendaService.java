package amazingcontrol.service;

import java.sql.Connection;
import java.sql.SQLException;

import amazingcontrol.connection.ConexaoMySQL;
import amazingcontrol.dao.VendasDAO;
import amazingcontrol.model.ItensVendas;
import amazingcontrol.model.Produto;
import amazingcontrol.model.Venda;

public class FinalizarVendaService {
	
	private VendasDAO vendasDAO;
	private Connection con;
	
	public void cadastrar(Venda venda, Produto produto) throws SQLException {
		try {
			// cria a conexao e seta auto commit como false
			con = ConexaoMySQL.conectar();
			con.setAutoCommit(false);
			
			// tenta cadastrar a venda
			vendasDAO = new VendasDAO(con);
			vendasDAO.cadastrar(venda);
			
			// recupera o id da venda cadastrada
			venda.setId(vendasDAO.getUltimaVenda());
			
			// cria a itens vendas com os dados da venda
			ItensVendas itensVendas = new ItensVendas(venda, produto, produto.getQuantidade());
			
			new ItensVendasService().cadastrar(itensVendas);
			
			int quantidadeVendida = produto.getQuantidade();

			// recupera quantidade do produto no banco
			int quantidadeBanco = new ProdutoService().getProdutoPorId(produto.getId()).getQuantidade();
			
			// seta quantidade banco - quantidade vendida para atualizar o estoque
			produto.setQuantidade(quantidadeBanco - quantidadeVendida);
			
			// TODO deve chamar o service
			new ProdutoService().salvar(produto, produto.getFornecedor());
			
			// commita as transacoes caso não tenha nenhum erro
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			ConexaoMySQL.desconectar(con);
		}
	}

}
