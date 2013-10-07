package br.com.acad.dao.treino.impl;

import java.util.List;

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
		Query q = em.createQuery("select e.series from ExercicioTreino e where e.id=:id");
		q.setParameter("id", exercicio.getId());
		return q.getResultList();
	}


}
