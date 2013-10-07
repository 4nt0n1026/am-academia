package br.com.acad.dao.catGenerico.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.catGenerico.interf.SexoCatDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.cat.SexoCat;

@Repository
public class SexoCatDAOImpl extends DAOImpl<SexoCat,Integer> implements SexoCatDAO{

	public SexoCatDAOImpl() {
		super();
	}

	@Override
	public List<SexoCat> buscarTodos() {
		TypedQuery<SexoCat> q = em.createQuery("from SexoCat", SexoCat.class);
		return q.getResultList();
	}
	
}
