package br.com.acad.dao.treino.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.SerieDAO;
import br.com.acad.model.treino.ExercicioTreino;
import br.com.acad.model.treino.Serie;

@Repository
public class SerieDAOImpl extends DAOImpl<Serie,Integer> implements SerieDAO{

	public SerieDAOImpl() {
		super();
	}

	@Override
	public List<Serie> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Serie> buscarPorExercicioTreino(ExercicioTreino exercicio) {
		Query q = getEntityManager().createQuery("select e.series from ExercicioTreino e where e.id=:id");
		q.setParameter("id", exercicio.getId());
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Serie> buscarTodos(int page, String txtSearch, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Serie> filtrarTodos(int page, Map<String, String> filtros,
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
