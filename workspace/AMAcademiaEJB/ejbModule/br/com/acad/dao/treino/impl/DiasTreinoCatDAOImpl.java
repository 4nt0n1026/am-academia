package br.com.acad.dao.treino.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.DiasTreinoCatDAO;
import br.com.acad.model.treino.DiasTreinoCat;

@Stateless
public class DiasTreinoCatDAOImpl extends DAOImpl<DiasTreinoCat,Integer> implements DiasTreinoCatDAO{

	public DiasTreinoCatDAOImpl() {
		super();
	}

	@Override
	public List<DiasTreinoCat> buscarTodos() {
		TypedQuery<DiasTreinoCat> q = em.createQuery("from DiasTreinoCat", DiasTreinoCat.class);
		return q.getResultList();
	}

}
