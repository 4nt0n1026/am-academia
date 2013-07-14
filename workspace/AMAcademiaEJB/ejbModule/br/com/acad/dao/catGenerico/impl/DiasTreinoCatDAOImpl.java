package br.com.acad.dao.catGenerico.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.acad.dao.catGenerico.interf.DiasTreinoCatDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.cat.DiasTreinoCat;

@Stateless
public class DiasTreinoCatDAOImpl extends DAOImpl<DiasTreinoCat,Integer> implements DiasTreinoCatDAO{

	public DiasTreinoCatDAOImpl() {
		super();
	}

	@Override
	public List<DiasTreinoCat> buscarTodos() {
		TypedQuery<DiasTreinoCat> q = em.createQuery("from DiasTreinoCat", DiasTreinoCat.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		Query q = em.createQuery(SqlLogic.getCountSql(DiasTreinoCat.STATIC_FIELDS, "DiasTreinoCat", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<DiasTreinoCat> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<DiasTreinoCat> q = em.createQuery(SqlLogic.getSql(DiasTreinoCat.STATIC_FIELDS, "DiasTreinoCat", txtSearch, order), DiasTreinoCat.class);
		
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

}
