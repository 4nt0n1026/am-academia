package br.com.acad.dao.treino.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.ExercicioDAO;
import br.com.acad.model.treino.Exercicio;

@Stateless
public class ExercicioDAOImpl extends DAOImpl<Exercicio,Integer> implements ExercicioDAO{

	public ExercicioDAOImpl() {
		super();
	}

	@Override
	public List<Exercicio> buscarTodos() {
		TypedQuery<Exercicio> q = em.createQuery("from Exercicio", Exercicio.class);
		return q.getResultList();
	}

}
