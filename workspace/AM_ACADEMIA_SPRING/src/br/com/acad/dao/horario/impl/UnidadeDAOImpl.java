package br.com.acad.dao.horario.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.horario.interf.UnidadeDAO;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.horario.Unidade;

@Repository
public class UnidadeDAOImpl extends DAOImpl<Unidade,Integer> implements UnidadeDAO{

	public UnidadeDAOImpl() {
		super();
	}

	@Override
	public List<Unidade> buscarTodos() {
		TypedQuery<Unidade> q = getEntityManager().createQuery("from Unidade", Unidade.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		Query q = getEntityManager().createQuery(SqlLogic.getCountSql(Unidade.STATIC_FIELDS, "Unidade", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<Unidade> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<Unidade> q = getEntityManager().createQuery(SqlLogic.getSql(Unidade.STATIC_FIELDS, "Unidade", txtSearch, order), Unidade.class);
		
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

	@Override
	public List<Unidade> filtrarTodos(int page, Map<String, String> filtros,
			String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long contarTodosFiltro(Map<String, String> filtros) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Unidade> buscarTodosField() {
		Query q = getEntityManager().createQuery("select u.id, u.nome from Unidade u");
		List<Unidade> unidades = new ArrayList<Unidade>();
		Collection<Object[]> resultado = q.getResultList();
		for (Object[] o:resultado){
			Unidade u = new Unidade((Integer) o[0], (String) o[1]);
			unidades.add(u);
		}
		return unidades;
	}

}
