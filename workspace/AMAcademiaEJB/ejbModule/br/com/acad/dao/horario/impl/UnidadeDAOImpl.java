package br.com.acad.dao.horario.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.horario.interf.UnidadeDAO;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.horario.Unidade;

@Stateless
public class UnidadeDAOImpl extends DAOImpl<Unidade,Integer> implements UnidadeDAO{

	public UnidadeDAOImpl() {
		super();
	}

	@Override
	public List<Unidade> buscarTodos() {
		TypedQuery<Unidade> q = em.createQuery("from Unidade", Unidade.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		Query q = em.createQuery(SqlLogic.getCountSql(Unidade.STATIC_FIELDS, "Unidade", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<Unidade> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<Unidade> q = em.createQuery(SqlLogic.getSql(Unidade.STATIC_FIELDS, "Unidade", txtSearch, order), Unidade.class);
		
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

	@Override
	public List<Unidade> filtrarTodos(int page, Map<String, String> filtros,
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
