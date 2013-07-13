package br.com.acad.dao.catGenerico.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.acad.dao.catGenerico.interf.DiasTreinoCatDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.cat.DiasTreinoCat;

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

	@Override
	public long contarTodos(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DiasTreinoCat> buscarTodos(int page, String txtSearch,
			String order) {
		// TODO Auto-generated method stub
		return null;
	}

}
