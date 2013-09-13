package br.com.acad.dao.catGenerico.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.catGenerico.interf.DuracaoTreinoCatDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.cat.DuracaoTreinoCat;

@Repository
public class DuracaoTreinoCatDAOImpl extends DAOImpl<DuracaoTreinoCat,Integer> implements DuracaoTreinoCatDAO{

	public DuracaoTreinoCatDAOImpl() {
		super();
	}

	@Override
	public List<DuracaoTreinoCat> buscarTodos() {
		TypedQuery<DuracaoTreinoCat> q = getEntityManager().createQuery("from DuracaoTreinoCat", DuracaoTreinoCat.class);
		return q.getResultList();
	}



}
