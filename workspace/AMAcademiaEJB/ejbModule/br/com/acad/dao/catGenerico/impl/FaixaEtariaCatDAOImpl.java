package br.com.acad.dao.catGenerico.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.acad.dao.catGenerico.interf.FaixaEtariaCatDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.cat.FaixaEtariaCat;

@Stateless
public class FaixaEtariaCatDAOImpl extends DAOImpl<FaixaEtariaCat,Integer> implements FaixaEtariaCatDAO{

	public FaixaEtariaCatDAOImpl() {
		super();
	}

	@Override
	public List<FaixaEtariaCat> buscarTodos() {
		TypedQuery<FaixaEtariaCat> q = em.createQuery("from FaixaEtariaCat", FaixaEtariaCat.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		Query q = em.createQuery(SqlLogic.getCountSql(FaixaEtariaCat.STATIC_FIELDS, "FaixaEtariaCat", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<FaixaEtariaCat> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<FaixaEtariaCat> q = em.createQuery(SqlLogic.getSql(FaixaEtariaCat.STATIC_FIELDS, "FaixaEtariaCat", txtSearch, order), FaixaEtariaCat.class);
				
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

}
