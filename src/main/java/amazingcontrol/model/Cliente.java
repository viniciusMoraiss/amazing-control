package amazingcontrol.model;

import amazingcontrol.model.utils.Validacoes;

public class Cliente extends Entidate<Integer> {

	private String nome;
	private String endereco;
	private String telefone;
	private String cidade;
	private String cep;
	private UF uf;
	
	public Cliente() {
	}

	public Cliente(String nome, String endereco, String telefone, String cidade, String cep, UF uf) {
		setNome(nome);
		setEndereco(endereco);
		setTelefone(telefone);
		setCidade(cidade);
		setCep(cep);
		setUf(uf);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		Validacoes.validaNuloOuVazio("Nome ", nome);
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		Validacoes.validaNuloOuVazio("Endereco ", endereco);
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		Validacoes.validaNuloOuVazio("Cidade ", cidade);
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		Validacoes.validaNuloOuVazio("CEP", cep);
		this.cep = cep;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public String toString() {
		return nome;
	}
}
