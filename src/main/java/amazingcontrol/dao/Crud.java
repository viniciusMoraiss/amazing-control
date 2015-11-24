package amazingcontrol.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/*
 * Interface CRUD para padronizar os métodos de Create, Read, Update e Delete
 */
public interface Crud<T> {
	
	/*
	 * Metodo para inserir (Insert) uma nova entidade
	 */
	public void inserir(Connection con, T entidade) throws SQLException;
	
	/*
	 * Metodo para atualizar (Update) uma nova entidade 
	 */
	public void atualizar(Connection con, T entidade) throws SQLException;
	
	/*
	 * Metodo para deletar (Delete) uma entidade
	 */
	public void deletar(Connection con, T entidade) throws SQLException;
	
	/*
	 * Metodo para lista (Read) uma entidade
	 */
	public List<T> lista(Connection con) throws SQLException;

}
