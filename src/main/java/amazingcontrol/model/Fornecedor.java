package amazingcontrol.model;

import amazingcontrol.model.utils.Validacoes;

public class Fornecedor extends Entidate<Integer> {

	private String nome;
	private String telefone;
	private String endereco;
	private String cidade;
	private String cep;
	private UF uf;

	// construtor para passar os paramentros para a tela (CriarFornecedorAction)
	public Fornecedor(String nome, String telefone, String endereco, String cidade, String cep, UF uf) {
		setNome(nome);
		setTelefone(telefone);
		setEndereco(endereco);
		setCidade(cidade);
		setCep(cep);
		this.uf = uf;
	}

	// construtor padrao
	public Fornecedor() {
	}

	// getters and setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		Validacoes.validaNuloOuVazio("Nome ", nome);
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		Validacoes.validaNuloOuVazio("Endereco ", endereco);
		this.endereco = endereco;
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
		Validacoes.validaNuloOuVazio("CEP ", cep);
		this.cep = cep;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	// toString
	public String toString() {
		return nome;
	}
}
