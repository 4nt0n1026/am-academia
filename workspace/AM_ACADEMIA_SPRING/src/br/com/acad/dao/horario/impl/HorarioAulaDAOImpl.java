package br.com.acad.dao.horario.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.horario.interf.HorarioAulaDAO;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.horario.Aula;
import br.com.acad.model.horario.HorarioAula;

@Repository
public class HorarioAulaDAOImpl extends DAOImpl<HorarioAula,Integer> implements HorarioAulaDAO{

	public HorarioAulaDAOImpl() {
		super();
	}

	@Override
	public List<HorarioAula> buscarTodos() {
		TypedQuery<HorarioAula> q = getEntityManager().createQuery("from HorarioAula", HorarioAula.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		Query q = getEntityManager().createQuery(SqlLogic.getCountSql(HorarioAula.STATIC_FIELDS, "HorarioAula", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<HorarioAula> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<HorarioAula> q = getEntityManager().createQuery(SqlLogic.getSql(HorarioAula.STATIC_FIELDS, "HorarioAula", txtSearch, order), HorarioAula.class);
		
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

	@Override
	public List<HorarioAula> filtrarTodos(int page, Map<String, String> filtros, String order){
		TypedQuery<HorarioAula> q = getEntityManager().createQuery(SqlLogic.getFilterSql(filtros, "HorarioAula", order), HorarioAula.class);
		
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
		Query q = getEntityManager().createQuery(SqlLogic.getCountFilterSql("HorarioAula", filtros));
		return  (Long) q.getSingleResult();
	}


	@Override
	public List<HorarioAula> buscarPorAula(Aula aula) {
		TypedQuery<HorarioAula> q = getEntityManager().createQuery("from HorarioAula h where h.aula.id = :idAula", HorarioAula.class);
		q.setParameter("idAula", aula.getId());
		return q.getResultList();
	}

}
