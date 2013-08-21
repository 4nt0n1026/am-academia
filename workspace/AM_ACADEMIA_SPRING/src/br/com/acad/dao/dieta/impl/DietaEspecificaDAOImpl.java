package br.com.acad.dao.dieta.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.dieta.interf.DietaEspecificaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.dieta.DietaEspecifica;

@Repository
public class DietaEspecificaDAOImpl extends DAOImpl<DietaEspecifica,Integer> implements DietaEspecificaDAO{

	public DietaEspecificaDAOImpl() {
		super();
	}

	@Override
	public List<DietaEspecifica> buscarTodos() {
		TypedQuery<DietaEspecifica> q = getEntityManager().createQuery("from DietaEspecifica", DietaEspecifica.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		Query q = getEntityManager().createQuery(SqlLogic.getCountSql(DietaEspecifica.STATIC_FIELDS, "DietaEspecifica", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<DietaEspecifica> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<DietaEspecifica> q = getEntityManager().createQuery(SqlLogic.getSql(DietaEspecifica.STATIC_FIELDS, "DietaEspecifica", txtSearch, order), DietaEspecifica.class);
		
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}
	
	@Override
	public List<DietaEspecifica> filtrarTodos(int page, Map<String, String> filtros, String order){
		TypedQuery<DietaEspecifica> q = getEntityManager().createQuery(SqlLogic.getFilterSql(filtros, "DietaEspecifica", order), DietaEspecifica.class);
		
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
		Query q = getEntityManager().createQuery(SqlLogic.getCountFilterSql("DietaEspecifica", filtros));
		return  (Long) q.getSingleResult();
	}

}
