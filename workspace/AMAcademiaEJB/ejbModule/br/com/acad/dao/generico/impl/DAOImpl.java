package br.com.acad.dao.generico.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import br.com.acad.dao.generico.interf.DAO;

@Stateless
public abstract class DAOImpl<T,K> implements DAO<T,K>{

	@PersistenceContext(unitName="CLIENTE_MYSQL", type=PersistenceContextType.EXTENDED)
	protected EntityManager em;
	
	
	private Class<T> entityClass;
	
	@SuppressWarnings("all")
	public DAOImpl(){
		this.entityClass = (Class<T>) ((ParameterizedType) getClass() 
				.getGenericSuperclass()).getActualTypeArguments()[0]; 
	}
	
	@Override
	public T insert(T entity) {
		em.persist(entity);
		em.flush();
		em.refresh(entity);
		return entity;
	}
	
	@Override
	public void removeById(K id){
		T entity = em.find(entityClass,id);
		em.remove(entity);
	}
	
	@Override
	public T searchByID(K id) {
		return (T) em.find(entityClass, id);
	}

	@Override
	public T update(T entity) {
		em.merge(entity);
		return entity;
	}


	public abstract List<T> buscarTodos();
	
	
	
}