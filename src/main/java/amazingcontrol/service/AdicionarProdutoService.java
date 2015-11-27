package amazingcontrol.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import amazingcontrol.model.Produto;

public class AdicionarProdutoService {
	
	private List<Produto> produtos = new ArrayList<>();
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void addProdutos(Produto produto, Integer quantidade) {
		
		try {
			// recupera quantidade de produtos do banco de dados
			int quantidadeBanco = new ProdutoService().getProdutoPorId(produto.getId()).getQuantidade();
			
			// verifica se ja tem produto na lista
			if (produtos.size() > 0) {
				
				addQuantidadeProdutoLista(produto, quantidade, quantidadeBanco);
			} else if (quantidade <= quantidadeBanco) {
				addNovoProdutoLista(produto, quantidade);
			} else {
				throw new IllegalArgumentException("Quantidade insuficiente");
			}
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	private void addQuantidadeProdutoLista(Produto produto, Integer quantidade, int quantidadeBanco) {
		Produto produtoLista = getProdutoLista(produto, produtos);
		
		if (produtoLista != null) {
			setQuantidadeProdutoLista(produto, quantidade, quantidadeBanco);
		} else if (quantidade <= quantidadeBanco) {
			addNovoProdutoLista(produto, quantidade);
		} else {
			throw new IllegalArgumentException("Quantidade insuficiente");
		}
	}

	private void addNovoProdutoLista(Produto produto, Integer quantidade) {
		produto.setQuantidade(quantidade);
		produtos.add(produto);
	}

	private void setQuantidadeProdutoLista(Produto produto, Integer quantidade, int quantidadeBanco) {
		if (quantidade + produto.getQuantidade() <= quantidadeBanco) {
			produto.setQuantidade(quantidade + produto.getQuantidade());
		} else {
			throw new IllegalArgumentException("Quantidade insuficiente");
		}
	}
	
	private Produto getProdutoLista(Produto produto, List<Produto> produtos) {
		// verificar se produto já está na lista
		for (int i = 0; i < produtos.size(); i++) {
			// se estiver soma a quantidade com a já inserida
			if (produto.getId().equals(produtos.get(i).getId())) {
				return produto;
			}
		}

		return null;
	}

}
