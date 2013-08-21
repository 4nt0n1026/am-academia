package br.com.acad.dao.treino.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.ParteCorpoDAO;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.treino.Exercicio;
import br.com.acad.model.treino.ParteCorpo;

@Repository
public class ParteCorpoDAOImpl extends DAOImpl<ParteCorpo,Integer> implements ParteCorpoDAO{

	public ParteCorpoDAOImpl() {
		super();
	}

	@Override
	public List<ParteCorpo> buscarTodos() {
		TypedQuery<ParteCorpo> q = getEntityManager().createQuery("from ParteCorpo order by nome", ParteCorpo.class);
		return q.getResultList();
	}
	
	@Override
	public List<ParteCorpo> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<ParteCorpo> q = getEntityManager().createQuery(SqlLogic.getSql(ParteCorpo.STATIC_FIELDS, "ParteCorpo", txtSearch, order), ParteCorpo.class);
		
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ParteCorpo> buscarPartesPrimarias(Exercicio exercicio) {
		Query q = getEntityManager().createQuery("select e.parteCorpoPrimaria from Exercicio e where e.id = :id");
		q.setParameter("id", exercicio.getId());
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ParteCorpo> buscarPartesSecundaria(Exercicio exercicio) {
		Query q = getEntityManager().createQuery("select e.parteCorpoSecundaria from Exercicio e where e.id = :id");
		q.setParameter("id", exercicio.getId());
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		Query q = getEntityManager().createQuery(SqlLogic.getCountSql(ParteCorpo.STATIC_FIELDS, "ParteCorpo", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<ParteCorpo> filtrarTodos(int page, Map<String, String> filtros,
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
