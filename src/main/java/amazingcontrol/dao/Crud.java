package amazingcontrol.dao;

import java.util.List;

/*
 * Interface CRUD para padronizar os métodos de Create, Read, Update e Delete
 */
public interface Crud<T> {
	
	/*
	 * Metodo para inserir (Insert) uma nova entidade
	 */
	public void inserir(T entidade);
	
	/*
	 * Metodo para atualizar (Update) uma nova entidade 
	 */
	public void atualizar(T entidade);
	
	/*
	 * Metodo para deletar (Delete) uma entidade
	 */
	public void deletar(T entidade);
	
	/*
	 * Metodo para lista (Read) uma entidade
	 */
	public List<T> lista();

}
