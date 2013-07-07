package br.com.acad.dao.generico.interf;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface DAO<T,K> {
	
	T insert(T entity);
	
	void removeById(K id);
	
	T searchByID(K id);
	
	void update(T entity);
	
	public abstract List<T> buscarTodos();
	
}