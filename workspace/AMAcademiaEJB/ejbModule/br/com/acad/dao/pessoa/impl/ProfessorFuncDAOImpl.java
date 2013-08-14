package br.com.acad.dao.pessoa.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.pessoa.ProfessorFunc;

@Stateless
public class ProfessorFuncDAOImpl extends DAOImpl<ProfessorFunc,Integer> implements ProfessorFuncDAO{

	public ProfessorFuncDAOImpl() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProfessorFunc> buscarFieldNome() {
		Query q = em.createQuery("select p.id, p.nome from ProfessorFunc p");
		List<ProfessorFunc> professores = new ArrayList<ProfessorFunc>();
		Collection<Object[]> resultado = q.getResultList();
		for (Object[] o:resultado){
			ProfessorFunc p = new ProfessorFunc((Integer) o[0], (String) o[1]);
			professores.add(p);
		}
		return professores;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ProfessorFunc> buscarFieldNomeProf() {
		Query q = em.createQuery("select p.id, p.nome from ProfessorFunc p where p.isProfessor=:true");
		q.setParameter("true", true);
		List<ProfessorFunc> professores = new ArrayList<ProfessorFunc>();
		Collection<Object[]> resultado = q.getResultList();
		for (Object[] o:resultado){
			ProfessorFunc p = new ProfessorFunc((Integer) o[0], (String) o[1]);
			professores.add(p);
		}
		return professores;
	}

	@Override
	public long contarTodos(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProfessorFunc> buscarTodos(int page, String search,
			String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long contarTodosProf(String search) {
		if(search==null || search.length()==0){
			search=" ";
		}
		String sql = SqlLogic.getCountSql(ProfessorFunc.STATIC_FIELDS, "ProfessorFunc", search) + " and isProfessor = true";
		Query q = em.createQuery(sql);
		return  (Long) q.getSingleResult();
	}

	@Override
	public long contarTodosFunc(String search) {
		if(search==null || search.length()==0){
			search=" ";
		}
		String sql = SqlLogic.getCountSql(ProfessorFunc.STATIC_FIELDS, "ProfessorFunc", search) + " and isProfessor = false";
		Query q = em.createQuery(sql);
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<ProfessorFunc> buscarTodosProf(int page, String search, String order) {
		StringBuilder sql = new StringBuilder("from ProfessorFunc ");
		String sqlWhere = SqlLogic.getWhereSql(ProfessorFunc.STATIC_FIELDS, search);
		if(sqlWhere.length()>4){
			sql.append(sqlWhere).append(" and isProfessor = true");
		}else{
			sql.append(" where isProfessor = true");
		}
		if(order.length()>0){
			sql.append(" order by " + order);
		}
		
		TypedQuery<ProfessorFunc> q = em.createQuery(sql.toString(), ProfessorFunc.class);
		
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

	@Override
	public List<ProfessorFunc> buscarTodosFunc(int page, String search,
			String order) {
		StringBuilder sql = new StringBuilder("from ProfessorFunc ");
		String sqlWhere = SqlLogic.getWhereSql(ProfessorFunc.STATIC_FIELDS, search);
		if(sqlWhere.length()>1){
			sql.append(sqlWhere).append(" and isProfessor = false");
		}else{
			sql.append(" where isProfessor = false");
		}
		if(order.length()>0){
			sql.append(" order by " + order);
		}
		
		TypedQuery<ProfessorFunc> q = em.createQuery(sql.toString(), ProfessorFunc.class);
		
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

	@Override
	public List<ProfessorFunc> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProfessorFunc> filtrarTodos(int page,
			Map<String, String> filtros, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long contarTodosFiltro(Map<String, String> filtros) {
		// TODO Auto-generated method stub
		return 0;
	}

}
