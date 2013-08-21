package br.com.acad.dao.treino.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.TreinoDAO;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.pessoa.Aluno;
import br.com.acad.model.treino.Treino;

@Repository
public class TreinoDAOImpl extends DAOImpl<Treino,Integer> implements TreinoDAO{

	public TreinoDAOImpl() {
		super();
	}

	@Override
	public List<Treino> buscarTodos() {
		TypedQuery<Treino> q = getEntityManager().createQuery("from Treino", Treino.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		Query q = getEntityManager().createQuery(SqlLogic.getCountSql(Treino.STATIC_FIELDS, "Treino", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<Treino> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<Treino> q = getEntityManager().createQuery(SqlLogic.getSql(Treino.STATIC_FIELDS, "Treino", txtSearch, order), Treino.class);
		
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}
	
	@Override
	public List<Treino> filtrarTodos(int page, Map<String, String> filtros, String order){
		TypedQuery<Treino> q = getEntityManager().createQuery(SqlLogic.getFilterSql(filtros, "Treino", order), Treino.class);
		
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
		Query q = getEntityManager().createQuery(SqlLogic.getCountFilterSql("Treino", filtros));
		return  (Long) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Treino> buscarPorAluno(Aluno aluno) {
		Query q = getEntityManager().createQuery("select a.treinos from Aluno a where a.id = :idAluno");
		q.setParameter("idAluno", aluno.getId());
		return q.getResultList();
	}

}
