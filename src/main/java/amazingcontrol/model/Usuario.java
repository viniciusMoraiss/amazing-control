package amazingcontrol.model;

import java.util.HashMap;
import java.util.Map;

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
	public Usuario(String nome, String senha, String confirmacaoSenha, boolean ativo) throws Exception {
		this.nome = nome;
		this.senha = senha;
		this.ativo = ativo;
		// chama o metodo set por haver validacao
		setConfirmacaoSenha(confirmacaoSenha);
	}
	
	/**
	 * Recupera nome
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * configura nome
	 * @param nome
	 */
	public void setNome(String nome) {
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
	 */
	public void setSenha(String senha) {
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
	public void setConfirmacaoSenha(String confirmacaoSenha) throws Exception {
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
	
	/**
	 * metodo equals para comparar este objeto, onde se for o mesmo id e nome são iguais
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (ativo != other.ativo)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	public void validaAtributos() throws Exception {
		Map<String, String> atributos = new HashMap<>();
		atributos.put(senha, "Senha");
		atributos.put(nome, "Nome");
		Validacoes.valida(atributos);
	}

	public void validaSenha() throws Exception {
		if(senha.length() < 6) {
			throw new IllegalArgumentException("Senha tem que ser maior que  6 !");
		}
	}
}
