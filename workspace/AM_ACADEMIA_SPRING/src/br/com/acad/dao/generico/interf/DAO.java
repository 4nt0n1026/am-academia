package br.com.acad.dao.generico.interf;

import java.util.List;
import java.util.Map;

public interface DAO<T,K> {
	
	T insert(T entity);
	
	void remove(T entity);

	void removeById(K id);
	
	T update(T entity);
	
	T searchById(K id);
	
	List<T> buscarTodos(String[] columns, int page, String search, String order, String view);
	
	long contarTodos(String[] columns, String search, String view);
	
	List<T> filtrarTodos(int page, Map<String, String> filtros, String order);

	long contarTodosFiltro(Map<String, String> filtros);
	
	String getClassName();
	
	public abstract List<T> buscarTodos();
	
	
	
	
}