package br.com.acad.dao.dieta.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.acad.dao.dieta.interf.LimitacaoDietaCatDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.LimitacaoDietaCat;

@Stateless
public class LimitacaoDietaCatDAOImpl extends DAOImpl<LimitacaoDietaCat,Integer> implements LimitacaoDietaCatDAO{

	public LimitacaoDietaCatDAOImpl() {
		super();
	}

	@Override
	public List<LimitacaoDietaCat> buscarTodos() {
		TypedQuery<LimitacaoDietaCat> q = em.createQuery("from LimitacaoDietaCat", LimitacaoDietaCat.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<LimitacaoDietaCat> buscarTodos(int page, String txtSearch,
			String order) {
		// TODO Auto-generated method stub
		return null;
	}

}
