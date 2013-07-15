package br.com.acad.dao.treino.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.TreinoEspecificoDAO;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.treino.TreinoEspecifico;

@Stateless
public class TreinoEspecificoDAOImpl extends DAOImpl<TreinoEspecifico,Integer> implements TreinoEspecificoDAO{

	public TreinoEspecificoDAOImpl() {
		super();
	}

	@Override
	public List<TreinoEspecifico> buscarTodos() {
		TypedQuery<TreinoEspecifico> q = em.createQuery("from TreinoEspecifico", TreinoEspecifico.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		Query q = em.createQuery(SqlLogic.getCountSql(TreinoEspecifico.STATIC_FIELDS, "TreinoEspecifico", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<TreinoEspecifico> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<TreinoEspecifico> q = em.createQuery(SqlLogic.getSql(TreinoEspecifico.STATIC_FIELDS, "TreinoEspecifico", txtSearch, order), TreinoEspecifico.class);
				
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}
}
