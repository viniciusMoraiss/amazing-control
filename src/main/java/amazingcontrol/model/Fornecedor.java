package amazingcontrol.model;

public class Fornecedor extends Entidate <Integer> {
	
	private String nome;
	private int telefone;
	private String endereço;
	private String cidade;
	private int cep;
	private String uf;
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		nome=nome;
	}
	
	public int getTelefone(){
		return telefone;
	}
	
	public void setTelefone(int telefone){
		telefone = telefone;
	}
	
	public String getEndereço(){
		return endereço;
	}
	public void setEndereço(){
		endereço=endereço;
	}
	public int getCep(){
		return cep;
	}
	public void setCep(int cep){
		cep=cep;
	}
	public  String getUf(){
		return uf;
	}
	public void setUf(String uf){
		uf=uf;
	}
	public String toString(){
		return "Fornecedor: " + nome;
	}
}



