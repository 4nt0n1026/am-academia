package br.com.acad.dao.dieta.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.acad.dao.dieta.interf.DietaFixaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.dieta.DietaFixa;

@Stateless
public class DietaFixaDAOImpl extends DAOImpl<DietaFixa,Integer> implements DietaFixaDAO{

	public DietaFixaDAOImpl() {
		super();
	}

	@Override
	public List<DietaFixa> buscarTodos() {
		TypedQuery<DietaFixa> q = em.createQuery("from DietaFixa", DietaFixa.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		Query q = em.createQuery(SqlLogic.getCountSql(DietaFixa.STATIC_FIELDS, "DietaFixa", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<DietaFixa> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<DietaFixa> q = em.createQuery(SqlLogic.getSql(DietaFixa.STATIC_FIELDS, "DietaFixa", txtSearch, order), DietaFixa.class);
				
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

	@Override
	public List<DietaFixa> filtrarTodos(int page, Map<String, String> filtros, String order){
		TypedQuery<DietaFixa> q = em.createQuery(SqlLogic.getFilterSql(filtros, "DietaFixa", order), DietaFixa.class);
		
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

	@Override
	public long contarTodosFiltro(Map<String, String> filtros) {
		Query q = em.createQuery(SqlLogic.getCountFilterSql("DietaFixa", filtros));
		return  (Long) q.getSingleResult();
	}

}
