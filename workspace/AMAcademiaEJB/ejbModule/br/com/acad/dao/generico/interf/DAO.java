package br.com.acad.dao.generico.interf;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

@Remote
public interface DAO<T,K> {
	
	T insert(T entity);
	
	void removeById(K id);
	
	T searchByID(K id);
	
	T update(T entity);
	
	public abstract List<T> buscarTodos();
	
	public abstract long contarTodos(String search);
	
	public abstract List<T> buscarTodos(int page, String search, String order);
	
	public abstract List<T> filtrarTodos(int page, Map<String, String> filtros, String order);
	
	public abstract long contarTodosFiltro(Map<String, String> filtros);
	
}