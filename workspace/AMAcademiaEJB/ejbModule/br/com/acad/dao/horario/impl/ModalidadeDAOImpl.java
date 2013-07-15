package br.com.acad.dao.horario.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.horario.interf.ModalidadeDAO;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.horario.Modalidade;

@Stateless
public class ModalidadeDAOImpl extends DAOImpl<Modalidade,Integer> implements ModalidadeDAO{

	public ModalidadeDAOImpl() {
		super();
	}

	@Override
	public List<Modalidade> buscarTodos() {
		TypedQuery<Modalidade> q = em.createQuery("from Modalidade", Modalidade.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		Query q = em.createQuery(SqlLogic.getCountSql(Modalidade.STATIC_FIELDS, "Modalidade", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<Modalidade> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<Modalidade> q = em.createQuery(SqlLogic.getSql(Modalidade.STATIC_FIELDS, "Modalidade", txtSearch, order), Modalidade.class);
		
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}
	
	@Override
	public List<Modalidade> filtrarTodos(int page, Map<String, String> filtros, String order){
		TypedQuery<Modalidade> q = em.createQuery(SqlLogic.getFilterSql(filtros, "Modalidade", order), Modalidade.class);
		
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
		Query q = em.createQuery(SqlLogic.getCountFilterSql("Modalidade", filtros));
		return  (Long) q.getSingleResult();
	}

	
	
}
