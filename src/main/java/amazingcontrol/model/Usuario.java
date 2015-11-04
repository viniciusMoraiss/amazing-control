package amazingcontrol.model;

import amazingcontrol.app.model.Entidate;

public class Usuario extends Entidate<Integer> {

	private String nome;
	private String senha;
	private String confirmacaoSenha;
	private boolean ativo;

	public Usuario() {
	}

	public Usuario(String nome, String senha, String confirmacaoSenha, boolean ativo) throws Exception {
		this.nome = nome;
		this.senha = senha;
		setConfirmacaoSenha(confirmacaoSenha);
		this.ativo = ativo;
	}

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
		return "Nome: " + nome + " Ativo: " + ativo;
	}

	// Validacoes
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

	// Validacoes
	public void validaSenha() throws Exception {
		valida(senha, "Senha");
		
		if(senha.length() < 6) {
			throw new IllegalArgumentException("Senha tem que ser maior que  6 !");
		}
	}
}
