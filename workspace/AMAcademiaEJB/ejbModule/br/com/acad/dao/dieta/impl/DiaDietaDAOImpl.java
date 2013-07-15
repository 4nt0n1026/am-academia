package br.com.acad.dao.dieta.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.acad.dao.dieta.interf.DiaDietaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.DiaDieta;

@Stateless
public class DiaDietaDAOImpl extends DAOImpl<DiaDieta,Integer> implements DiaDietaDAO{

	public DiaDietaDAOImpl() {
		super();
	}

	@Override
	public List<DiaDieta> buscarTodos() {
		TypedQuery<DiaDieta> q = em.createQuery("from DiaDieta", DiaDieta.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DiaDieta> buscarTodos(int page, String txtSearch, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DiaDieta> filtrarTodos(int page, Map<String, String> filtros,
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
