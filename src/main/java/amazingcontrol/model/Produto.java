package amazingcontrol.model;

import amazingcontrol.model.utils.Validacoes;

public class Produto extends Entidate<Integer>{

	private String nome;
	private String marca;
	private String tipo;
	private double valorCusto;
	private double valorVenda;
	private int quantidade;
	
	public Produto() {
	}
	
	public Produto(String nome, String marca, String tipo, Double valorCusto, Double valorVenda, Integer quantidade) {
		setNome(nome);
		setMarca(marca);
		setTipo(tipo);
		setValorCusto(valorCusto);
		setValorVenda(valorVenda);
		setQuantidade(quantidade);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		Validacoes.validaNuloOuVazio("Nome ", nome);
		this.nome = nome;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		Validacoes.validaNuloOuVazio("Marca ", marca);
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

	public void setValorCusto(Double valorCusto) {
		Validacoes.validaNulo(valorCusto);
		this.valorCusto = valorCusto;
	}

	public double getValorVenda() {
		return this.valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		Validacoes.validaNulo(valorVenda);
		this.valorVenda = valorVenda;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		Validacoes.validaNulo(quantidade);
		this.quantidade = quantidade;
	}
	
	
	
	@Override
	public String toString() {
		return nome;
	}
}
