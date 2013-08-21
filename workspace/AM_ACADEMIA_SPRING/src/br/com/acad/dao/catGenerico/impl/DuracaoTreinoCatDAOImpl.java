package br.com.acad.dao.catGenerico.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.catGenerico.interf.DuracaoTreinoCatDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.cat.DuracaoTreinoCat;

@Repository
public class DuracaoTreinoCatDAOImpl extends DAOImpl<DuracaoTreinoCat,Integer> implements DuracaoTreinoCatDAO{

	public DuracaoTreinoCatDAOImpl() {
		super();
	}

	@Override
	public List<DuracaoTreinoCat> buscarTodos() {
		TypedQuery<DuracaoTreinoCat> q = getEntityManager().createQuery("from DuracaoTreinoCat", DuracaoTreinoCat.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		Query q = getEntityManager().createQuery(SqlLogic.getCountSql(DuracaoTreinoCat.STATIC_FIELDS, "DuracaoTreinoCat", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<DuracaoTreinoCat> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<DuracaoTreinoCat> q = getEntityManager().createQuery(SqlLogic.getSql(DuracaoTreinoCat.STATIC_FIELDS, "DuracaoTreinoCat", txtSearch, order), DuracaoTreinoCat.class);
		
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

	@Override
	public List<DuracaoTreinoCat> filtrarTodos(int page, Map<String, String> filtros,
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
