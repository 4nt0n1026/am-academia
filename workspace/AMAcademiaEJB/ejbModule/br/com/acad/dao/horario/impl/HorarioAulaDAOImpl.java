package br.com.acad.dao.horario.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.horario.interf.HorarioAulaDAO;
import br.com.acad.model.horario.HorarioAula;

@Stateless
public class HorarioAulaDAOImpl extends DAOImpl<HorarioAula,Integer> implements HorarioAulaDAO{

	public HorarioAulaDAOImpl() {
		super();
	}

	@Override
	public List<HorarioAula> buscarTodos() {
		TypedQuery<HorarioAula> q = em.createQuery("from HorarioAula", HorarioAula.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HorarioAula> buscarTodos(int page, String txtSearch,
			String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HorarioAula> filtrarTodos(int page,
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
