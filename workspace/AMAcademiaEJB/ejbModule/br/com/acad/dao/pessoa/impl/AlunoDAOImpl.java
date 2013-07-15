package br.com.acad.dao.pessoa.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.pessoa.interf.AlunoDAO;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.pessoa.Aluno;

@Stateless
public class AlunoDAOImpl extends DAOImpl<Aluno,Integer> implements AlunoDAO{

	public AlunoDAOImpl() {
		super();
	}

	@Override
	public List<Aluno> buscarTodos() {
		TypedQuery<Aluno> q = em.createQuery("from Aluno", Aluno.class);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aluno> buscarFieldNome() {
		Query q = em.createQuery("select a.id, a.nome from Aluno a");
		List<Aluno> alunos = new ArrayList<Aluno>();
		Collection<Object[]> resultado = q.getResultList();
		for (Object[] o:resultado){
			Aluno a = new Aluno((Integer) o[0], (String) o[1]);
			alunos.add(a);
		}
		return alunos;
	}

	@Override
	public long contarTodos(String search) {
		Query q = em.createQuery(SqlLogic.getCountSql(Aluno.STATIC_FIELDS, "Aluno", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<Aluno> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<Aluno> q = em.createQuery(SqlLogic.getSql(Aluno.STATIC_FIELDS, "Aluno", txtSearch, order), Aluno.class);
				
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}
	
	@Override
	public List<Aluno> filtrarTodos(int page, Map<String, String> filtros, String order){
		TypedQuery<Aluno> q = em.createQuery(SqlLogic.getFilterSql(filtros, "Aluno", order), Aluno.class);
		
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
		Query q = em.createQuery(SqlLogic.getCountFilterSql("Aluno", filtros));
		return  (Long) q.getSingleResult();
	}

}
