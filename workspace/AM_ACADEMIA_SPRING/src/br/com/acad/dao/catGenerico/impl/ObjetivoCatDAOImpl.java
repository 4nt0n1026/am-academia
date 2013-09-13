package br.com.acad.dao.catGenerico.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.catGenerico.interf.ObjetivoCatDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.cat.ObjetivoCat;

@Repository
public class ObjetivoCatDAOImpl extends DAOImpl<ObjetivoCat,Integer> implements ObjetivoCatDAO{

	public ObjetivoCatDAOImpl() {
		super();
	}

	@Override
	public List<ObjetivoCat> buscarTodos() {
		TypedQuery<ObjetivoCat> q = getEntityManager().createQuery("from ObjetivoCat", ObjetivoCat.class);
		return q.getResultList();
	}



}
