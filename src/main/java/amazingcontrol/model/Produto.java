package amazingcontrol.model;

public class Produto extends Entidate<Integer>{

	private String nome;
	private String marca;
	private String tipo;
	private double valorCusto;
	private double valorVenda;
	private int quantidade;
	
	public Produto() {
	}
	
	public Produto(String nome, String marca, String tipo, double valorCusto, double valorVenda,
			int quantidade) {
		this.nome = nome;
		this.marca = marca;
		this.tipo = tipo;
		this.valorCusto = valorCusto;
		this.valorVenda = valorVenda;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValorCusto() {
		return this.valorCusto;
	}

	public void setValorCusto(double valorCusto) {
		this.valorCusto = valorCusto;
	}

	public double getValorVenda() {
		return this.valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidadeDeProduto) {
		this.quantidade = quantidadeDeProduto;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
