package br.com.acad.dao.avisos.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.acad.dao.avisos.interf.NoticiaCatDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.avisos.NoticiaCat;

@Stateless
public class NoticiaCatDAOImpl extends DAOImpl<NoticiaCat,Integer> implements NoticiaCatDAO{

	public NoticiaCatDAOImpl() {
		super();
	}
	
	@Override
	public List<NoticiaCat> buscarTodos() {
		TypedQuery<NoticiaCat> q = em.createQuery("from NoticiaCat", NoticiaCat.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		Query q = em.createQuery(SqlLogic.getCountSql(NoticiaCat.STATIC_FIELDS, "NoticiaCat", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<NoticiaCat> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<NoticiaCat> q = em.createQuery(SqlLogic.getSql(NoticiaCat.STATIC_FIELDS, "NoticiaCat", txtSearch, order), NoticiaCat.class);
		
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

	@Override
	public List<NoticiaCat> filtrarTodos(int page, Map<String, String> filtros,
			String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long contarTodosFiltro(Map<String, String> filtros) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
}
