package amazingcontrol.model;

import java.util.HashMap;
import java.util.Map;

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
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cidade = cidade;
		this.cep = cep;
		this.uf = uf;
	}

	// construtor padrao para o fornecedorDAO
	public Fornecedor(){		
	}
	
	// getters and setters 
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
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
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
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
		return "Fornecedor: " + nome;
	}
	
	// validacoes
	public void valida() throws Exception {
		Map<String, String> atributos = new HashMap<>();
		atributos.put("Nome", nome);
		atributos.put("CEP", cep);
		atributos.put("Endereço", endereco );
		atributos.put("Cidade", cidade);
		Validacoes.valida(atributos);
	}
}
