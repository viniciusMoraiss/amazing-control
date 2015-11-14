package amazingcontrol.model;

public class Fornecedor extends Entidate<Integer> {

	private String nome;
	private String telefone;
	private String endereco;
	private String cidade;
	private String cep;
	private String uf;

	
	// construtor para passar os paramentros para a tela (CriarFornecedorAction)
	
	public Fornecedor(String nome, String telefone, String endereco, String cidade, String cep, String uf) {
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	// toString

	public String toString() {
		return "Fornecedor: " + nome;
	}
}
