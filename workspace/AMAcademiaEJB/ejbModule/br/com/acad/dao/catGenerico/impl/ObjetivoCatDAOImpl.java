package br.com.acad.dao.catGenerico.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.acad.dao.catGenerico.interf.ObjetivoCatDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.cat.ObjetivoCat;

@Stateless
public class ObjetivoCatDAOImpl extends DAOImpl<ObjetivoCat,Integer> implements ObjetivoCatDAO{

	public ObjetivoCatDAOImpl() {
		super();
	}

	@Override
	public List<ObjetivoCat> buscarTodos() {
		TypedQuery<ObjetivoCat> q = em.createQuery("from ObjetivoCat", ObjetivoCat.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ObjetivoCat> buscarTodos(int page, String txtSearch,
			String order) {
		// TODO Auto-generated method stub
		return null;
	}

}
