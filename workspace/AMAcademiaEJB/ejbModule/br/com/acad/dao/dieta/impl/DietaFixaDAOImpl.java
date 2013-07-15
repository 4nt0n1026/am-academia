package br.com.acad.dao.dieta.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.acad.dao.dieta.interf.DietaFixaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.DietaFixa;

@Stateless
public class DietaFixaDAOImpl extends DAOImpl<DietaFixa,Integer> implements DietaFixaDAO{

	public DietaFixaDAOImpl() {
		super();
	}

	@Override
	public List<DietaFixa> buscarTodos() {
		TypedQuery<DietaFixa> q = em.createQuery("from DietaFixa", DietaFixa.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DietaFixa> buscarTodos(int page, String txtSearch, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DietaFixa> filtrarTodos(int page, Map<String, String> filtros,
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
