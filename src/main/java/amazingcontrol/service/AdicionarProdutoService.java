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
			
			if (produtos.size() > 0) {
				// verificar se produto já está na lista, se nao estiver retorna nulo
				if (getProdutoLista(produto, produtos) != null) {
					if (quantidade + produto.getQuantidade() <= quantidadeBanco) {
						produto.setQuantidade(quantidade + produto.getQuantidade());
					} else {
						throw new IllegalArgumentException("Quantidade insuficiente");
					}
				} else if (quantidade <= quantidadeBanco) {
					produto.setQuantidade(quantidade);
					produtos.add(produto);
				} else {
					throw new IllegalArgumentException("Quantidade insuficiente");
				}

			} else if (quantidade <= quantidadeBanco) {
				produto.setQuantidade(quantidade);
				produtos.add(produto);
			} else {
				throw new IllegalArgumentException("Quantidade insuficiente");
			}
			
		} catch(SQLException ex) {
			ex.printStackTrace();
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
