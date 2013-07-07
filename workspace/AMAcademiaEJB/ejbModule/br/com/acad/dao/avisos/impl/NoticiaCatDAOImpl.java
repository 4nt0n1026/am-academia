package br.com.acad.dao.avisos.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.acad.dao.avisos.interf.NoticiaCatDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.avisos.NoticiaCat;

@Stateless
public class NoticiaCatDAOImpl extends DAOImpl<NoticiaCat,Integer> implements NoticiaCatDAO{

	public NoticiaCatDAOImpl() {
		super();
	}
	
	@Override
	public List<NoticiaCat> buscarTodos() {
		TypedQuery<NoticiaCat> q = em.createQuery("from NoticiaCat", NoticiaCat.class);
		return q.getResultList();
	}

	
	
}
