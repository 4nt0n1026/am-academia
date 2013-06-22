package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fiap.dao.DAO;

public abstract class DAOImpl<T,K> implements DAO<T,K>{

	@PersistenceContext(name="CLIENTE_ORACLE")
	protected EntityManager em;
	
	private Class<T> entityClass;
	
	@SuppressWarnings("all")
	public DAOImpl(){
		this.entityClass = (Class<T>) ((ParameterizedType) getClass() 
				.getGenericSuperclass()).getActualTypeArguments()[0]; 
	}
	
	@Override
	public void insert(T entity) {
		em.persist(entity);
		
	}
	
	@Override
	public void removeById(K id){
		T entity = em.find(entityClass,id);
		em.remove(entity);
	}
	
	@Override
	public void remove(T entity) {
		em.merge(entity);
		em.remove(entity);
	}

	@Override
	public T searchByID(K id) {
		return em.find(entityClass, id);
	}

	@Override
	public void update(T entity) {
		em.merge(entity);
	}

}
