package amazingcontrol.model;

/*
 * Classe usuario
 * herda o id da classe Entidade<PK>, onde informa que seu id é do tipo integer pelo generics
 */
public class Usuario extends Entidate<Integer> {

	private String nome;
	private String senha;
	private String confirmacaoSenha;
	private boolean ativo;
	
	/*
	 * construtor vazio
	 */
	public Usuario() {
	}
	
	/*
	 * Construtor com todas as variaveis
	 */
	public Usuario(String nome, String senha, String confirmacaoSenha, boolean ativo) throws Exception {
		this.nome = nome;
		this.senha = senha;
		setConfirmacaoSenha(confirmacaoSenha);
		this.ativo = ativo;
	}
	
	/*
	 * Getters and Setters 
	 */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}
	
	// verifica se a confirmacao de senha é igual a senha, caso contrario lança uma excessao
	public void setConfirmacaoSenha(String confirmacaoSenha) throws Exception {
		// valida se a confirmacao de senha é a mesma senha digitada
		if (!confirmacaoSenha.equals(senha)) {
			throw new IllegalArgumentException("Confirmacao de senha deve ser igual a senha");
		} else {
			this.confirmacaoSenha = confirmacaoSenha;
		}
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String toString() {
		return nome;
	}

	/*
	 * Validacoes
	 */
	private void valida(String campo, String nomeCampo) throws Exception {

		// Nome nulo
		if (campo == null) {
			throw new IllegalArgumentException(nomeCampo + " nao pode ser nulo!");
		}

		// Nome vazio
		if (campo.isEmpty()) { // nome.equals("");
			throw new IllegalArgumentException(nomeCampo + " nao pode ser vazio!");
		}

		// Nome em branco
		if (campo.matches("^[ ]+$")) { // REGEX
			throw new IllegalArgumentException(nomeCampo + " nao pode ser branco!");
		}

		// FIXME Validar REGEX para invalidos!
	}
	
	public void validaNome() throws Exception {
		valida(nome, "Nome");
	}

	public void validaSenha() throws Exception {
		valida(senha, "Senha");
		
		if(senha.length() < 6) {
			throw new IllegalArgumentException("Senha tem que ser maior que  6 !");
		}
	}
}
