package br.com.acad.dao.treino.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.SolicitacaoTreinoDAO;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.pessoa.Aluno;
import br.com.acad.model.treino.SolicitacaoTreino;

@Stateless
public class SolicitacaoTreinoDAOImpl extends DAOImpl<SolicitacaoTreino,Integer> implements SolicitacaoTreinoDAO{

	public SolicitacaoTreinoDAOImpl() {
		super();
	}

	@Override
	public List<SolicitacaoTreino> buscarTodos() {
		TypedQuery<SolicitacaoTreino> q = em.createQuery("from SolicitacaoTreino", SolicitacaoTreino.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		Query q = em.createQuery(SqlLogic.getCountSql(SolicitacaoTreino.STATIC_FIELDS, "SolicitacaoTreino", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<SolicitacaoTreino> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<SolicitacaoTreino> q = em.createQuery(SqlLogic.getSql(SolicitacaoTreino.STATIC_FIELDS, "SolicitacaoTreino", txtSearch, order), SolicitacaoTreino.class);
				
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

	@Override
	public List<SolicitacaoTreino> filtrarTodos(int page, Map<String, String> filtros, String order){
		TypedQuery<SolicitacaoTreino> q = em.createQuery(SqlLogic.getFilterSql(filtros, "SolicitacaoTreino", order), SolicitacaoTreino.class);
		
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
		Query q = em.createQuery(SqlLogic.getCountFilterSql("SolicitacaoTreino", filtros));
		return  (Long) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SolicitacaoTreino> buscarPorAluno(Aluno aluno) {
		Query q = em.createQuery("select s.id, s.dataSolicitacao from SolicitacaoTreino s where s.aluno.id = :id)");
		q.setParameter("id", aluno.getId());
		List<SolicitacaoTreino> solicitacoes = new ArrayList<SolicitacaoTreino>();
		Collection<Object[]> resultado = q.getResultList();
		for (Object[] o:resultado){
			SolicitacaoTreino s = new SolicitacaoTreino((Integer) o[0], (Calendar) o[1]);
			solicitacoes.add(s);
		}
		return solicitacoes;
	}
}
