package br.com.nac.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.nac.dao.DAO;

public abstract class DAOImpl<T, K> implements DAO<T, K> {
	
	@PersistenceContext(unitName="CLIENTE_ORACLE")
	protected EntityManager em;
	protected Class<T> entityClass;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DAOImpl() {
		entityClass = (Class) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public T inclui(T entity) {
		em.persist(entity);
		em.flush();
		em.refresh(entity);
		return entity;
	}

	@Override
	public void atualiza(T entity) {
		em.merge(entity);
		
	}

	@Override
	public void exclui(T entity) {
		em.remove(entity);
		
	}

	@Override
	public void excluiPorId(K id){
		T entity = em.getReference(entityClass, id);
		em.remove(entity);
	}

	
	@Override
	public T buscaPorId(K id) {
		return em.find(entityClass, id);
	}

	
	
}
