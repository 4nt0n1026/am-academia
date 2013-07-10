package br.com.acad.dao.dieta.impl;

import java.util.List;

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

}
