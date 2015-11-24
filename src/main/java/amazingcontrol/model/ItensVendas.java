package amazingcontrol.model;

public class ItensVendas {
	
	private Produto produto;
	private Venda venda;
	private Integer quantidade;
	
	public ItensVendas() {
	}

	public ItensVendas(Venda venda, Produto produto, Integer quantidade) {
		super();
		this.produto = produto;
		this.venda = venda;
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorTotal() {
		return quantidade * produto.getValorVenda();
	}
}
