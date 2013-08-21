package br.com.acad.dao.dieta.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.dieta.interf.SolicitacaoDietaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.dieta.SolicitacaoDieta;
import br.com.acad.model.pessoa.Aluno;

@Repository
public class SolicitacaoDietaDAOImpl extends DAOImpl<SolicitacaoDieta,Integer> implements SolicitacaoDietaDAO{

	public SolicitacaoDietaDAOImpl() {
		super();
	}

	@Override
	public List<SolicitacaoDieta> buscarTodos() {
		TypedQuery<SolicitacaoDieta> q = getEntityManager().createQuery("from SolicitacaoDieta", SolicitacaoDieta.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		Query q = getEntityManager().createQuery(SqlLogic.getCountSql(SolicitacaoDieta.STATIC_FIELDS, "SolicitacaoDieta", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<SolicitacaoDieta> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<SolicitacaoDieta> q = getEntityManager().createQuery(SqlLogic.getSql(SolicitacaoDieta.STATIC_FIELDS, "SolicitacaoDieta", txtSearch, order), SolicitacaoDieta.class);
				
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

	@Override
	public List<SolicitacaoDieta> filtrarTodos(int page, Map<String, String> filtros, String order){
		TypedQuery<SolicitacaoDieta> q = getEntityManager().createQuery(SqlLogic.getFilterSql(filtros, "SolicitacaoDieta", order), SolicitacaoDieta.class);
		
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
		Query q = getEntityManager().createQuery(SqlLogic.getCountFilterSql("SolicitacaoDieta", filtros));
		return  (Long) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SolicitacaoDieta> buscarPorAluno(Aluno aluno) {
		Query q = getEntityManager().createQuery("select s.id, s.dataSolicitacao from SolicitacaoDieta s where s.aluno.id = :id)");
		q.setParameter("id", aluno.getId());
		List<SolicitacaoDieta> solicitacoes = new ArrayList<SolicitacaoDieta>();
		Collection<Object[]> resultado = q.getResultList();
		for (Object[] o:resultado){
			SolicitacaoDieta s = new SolicitacaoDieta((Integer) o[0], (Calendar) o[1]);
			solicitacoes.add(s);
		}
		return solicitacoes;
	}

}
