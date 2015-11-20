package amazingcontrol.model;

import amazingcontrol.model.utils.Validacoes;

/**
 * Classe usuario
 * herda o id da classe Entidade <PK>, onde informa que seu id é do tipo integer pelo generics
 */
public class Usuario extends Entidate<Integer> {

	private String nome;
	private String senha;
	private String confirmacaoSenha;
	private boolean ativo;
	
	/**
	 * construtor vazio
	 */
	public Usuario() {
	}
	
	/**
	 * Construtor com todos os atributos
	 */
	public Usuario(String nome, String senha, String confirmacaoSenha, boolean ativo) {
		setNome(nome);
		setSenha(senha);
		setConfirmacaoSenha(confirmacaoSenha);
		setAtivo(ativo);
	}
	
	/**
	 * Recupera nome
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * configura nome se for valido
	 * @param nome
	 * @throws Exception 
	 */
	public void setNome(String nome) {
		Validacoes.validaNuloOuVazio("Nome ", nome);
		this.nome = nome;
	}
	
	/**
	 * Recupera Senha
	 * @return senha
	 */
	public String getSenha() {
		return senha;
	}
	
	/**
	 * configura senha
	 * @param senha
	 * @throws Exception 
	 */
	public void setSenha(String senha) {
		String label = "Senha ";
		Validacoes.validaNuloOuVazio(label, senha);
		Validacoes.validaTamanho(label, senha, 4, 10);
		this.senha = senha;
	}
	
	/**
	 * recupera confirmacao de senha
	 * @return
	 */
	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}
	
	/**
	 * verifica se a confirmacao de senha é igual a senha, caso contrario lança exception
	 * <br>
	 * @param confirmacaoSenha
	 * @throws Exception
	 */
	public void setConfirmacaoSenha(String confirmacaoSenha) {
		// valida se a confirmacao de senha é a mesma senha digitada
		if (!confirmacaoSenha.equals(senha)) {
			throw new IllegalArgumentException("Confirmacao de senha deve ser igual a senha");
		} else {
			this.confirmacaoSenha = confirmacaoSenha;
		}
	}
	
	/**
	 * recupera status do usuario (Ativo = true, Inativo = false)
	 * @return
	 */
	public boolean isAtivo() {
		return ativo;
	}
	
	/**
	 * configura status do usuario (Ativo = true, Inativo = false)
	 * @param ativo
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String toString() {
		return nome;
	}
}
