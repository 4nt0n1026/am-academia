package br.com.acad.dao.generico.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.generico.interf.DAO;

@Repository
public abstract class DAOImpl<T,K> implements DAO<T,K>{

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	protected Class<T> entityClass;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DAOImpl(){
		this.entityClass = (Class) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public T insert(T entity) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		
		em.persist(entity);
		
		em.getTransaction().commit();
		return entity;
	}

	@Override
	public void remove(T entity) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		
		em.remove(entity);
		
		em.getTransaction().commit();
	}

	@Override
	public T update(T entity) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		
		em.merge(entity);
		
		em.getTransaction().commit();
		return entity;
		
	}

	@Override
	public T searchById(K id) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		
		return getEntityManager().find(entityClass, id);
		
	}

	@Override
	public void removeById(K id) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		
		T entity = em.find(entityClass, id);
		
		em.remove(entity);
		
		em.getTransaction().commit();
	}


	public abstract List<T> buscarTodos();
	
	public abstract long contarTodos(String search);
	
	public abstract List<T> buscarTodos(int page, String txtSearch, String order);
	
	public abstract List<T> filtrarTodos(int page, Map<String, String> filtros, String order);
	
	public abstract long contarTodosFiltro(Map<String, String> filtros);
	
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
}