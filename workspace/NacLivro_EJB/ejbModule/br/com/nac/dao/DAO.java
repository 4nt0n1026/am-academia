package br.com.nac.dao;

import javax.ejb.Remote;

@Remote
public interface DAO<T,K> {
	
	public T inclui(T entity);
	
	public void atualiza(T entity);
	
	public void exclui(T entity);
	
	public void excluiPorId(K id);
	
	public T buscaPorId(K id);
}
