package br.com.acad.dao.treino.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.ExercicioDAO;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.treino.Exercicio;
import br.com.acad.model.treino.ParteCorpo;

@Repository
public class ExercicioDAOImpl extends DAOImpl<Exercicio,Integer> implements ExercicioDAO{

	public ExercicioDAOImpl() {
		super();
	}

	@Override
	public List<Exercicio> buscarTodos() {
		TypedQuery<Exercicio> q = getEntityManager().createQuery("from Exercicio", Exercicio.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		Query q = getEntityManager().createQuery(SqlLogic.getCountSql(Exercicio.STATIC_FIELDS, "Exercicio", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<Exercicio> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<Exercicio> q = getEntityManager().createQuery(SqlLogic.getSql(Exercicio.STATIC_FIELDS, "Exercicio", txtSearch, order), Exercicio.class);
		
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

	@Override
	public List<Exercicio> filtrarTodos(int page, Map<String, String> filtros, String order){
		TypedQuery<Exercicio> q = getEntityManager().createQuery(SqlLogic.getFilterSql(filtros, "Exercicio", order), Exercicio.class);
		
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
		Query q = getEntityManager().createQuery(SqlLogic.getCountFilterSql("Exercicio", filtros));
		return  (Long) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Exercicio> buscarFieldNome() {
		Query q = getEntityManager().createQuery("select e.id, e.nome from Exercicio e");
		List<Exercicio> alunos = new ArrayList<Exercicio>();
		Collection<Object[]> resultado = q.getResultList();
		for (Object[] o:resultado){
			Exercicio e = new Exercicio((Integer) o[0], (String) o[1]);
			alunos.add(e);
		}
		return alunos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Exercicio> buscarPorParteCorpo(ParteCorpo parteCorpo) {
		Query q = getEntityManager().createQuery("select e.id, e.nome, e.fotoLocal from Exercicio e, IN(e.parteCorpoPrimaria) p where p.id = :id)");
		q.setParameter("id", parteCorpo.getId());
		List<Exercicio> exercicios = new ArrayList<Exercicio>();
		Collection<Object[]> resultado = q.getResultList();
		for (Object[] o:resultado){
			Exercicio e = new Exercicio((Integer) o[0], (String) o[1], (String)o[2]);
			exercicios.add(e);
		}
		return exercicios;
	}
}
