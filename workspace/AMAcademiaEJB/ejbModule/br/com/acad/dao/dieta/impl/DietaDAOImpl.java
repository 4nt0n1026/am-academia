package br.com.acad.dao.dieta.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.acad.dao.dieta.interf.DietaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.Dieta;

@Stateless
public class DietaDAOImpl extends DAOImpl<Dieta,Integer> implements DietaDAO{

	public DietaDAOImpl() {
		super();
	}

	@Override
	public List<Dieta> buscarTodos() {
		TypedQuery<Dieta> q = em.createQuery("from Dieta", Dieta.class);
		return q.getResultList();
	}

}
