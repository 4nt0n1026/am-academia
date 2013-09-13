package br.com.acad.dao.dieta.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.dieta.interf.LimitacaoDietaCatDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.LimitacaoDietaCat;

@Repository
public class LimitacaoDietaCatDAOImpl extends DAOImpl<LimitacaoDietaCat,Integer> implements LimitacaoDietaCatDAO{

	public LimitacaoDietaCatDAOImpl() {
		super();
	}

	@Override
	public List<LimitacaoDietaCat> buscarTodos() {
		TypedQuery<LimitacaoDietaCat> q = getEntityManager().createQuery("from LimitacaoDietaCat", LimitacaoDietaCat.class);
		return q.getResultList();
	}


}
