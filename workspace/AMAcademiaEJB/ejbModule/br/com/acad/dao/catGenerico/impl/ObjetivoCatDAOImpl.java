package br.com.acad.dao.catGenerico.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.acad.dao.catGenerico.interf.ObjetivoCatDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.cat.ObjetivoCat;

@Stateless
public class ObjetivoCatDAOImpl extends DAOImpl<ObjetivoCat,Integer> implements ObjetivoCatDAO{

	public ObjetivoCatDAOImpl() {
		super();
	}

	@Override
	public List<ObjetivoCat> buscarTodos() {
		TypedQuery<ObjetivoCat> q = em.createQuery("from ObjetivoCat", ObjetivoCat.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		Query q = em.createQuery(SqlLogic.getCountSql(ObjetivoCat.STATIC_FIELDS, "ObjetivoCat", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<ObjetivoCat> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<ObjetivoCat> q = em.createQuery(SqlLogic.getSql(ObjetivoCat.STATIC_FIELDS, "ObjetivoCat", txtSearch, order), ObjetivoCat.class);
				
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

	@Override
	public List<ObjetivoCat> filtrarTodos(int page, Map<String, String> filtros,
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
