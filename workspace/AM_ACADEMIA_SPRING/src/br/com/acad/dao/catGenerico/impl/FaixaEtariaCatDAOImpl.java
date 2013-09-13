package br.com.acad.dao.catGenerico.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.catGenerico.interf.FaixaEtariaCatDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.cat.FaixaEtariaCat;

@Repository
public class FaixaEtariaCatDAOImpl extends DAOImpl<FaixaEtariaCat,Integer> implements FaixaEtariaCatDAO{

	public FaixaEtariaCatDAOImpl() {
		super();
	}

	@Override
	public List<FaixaEtariaCat> buscarTodos() {
		TypedQuery<FaixaEtariaCat> q = getEntityManager().createQuery("from FaixaEtariaCat", FaixaEtariaCat.class);
		return q.getResultList();
	}


}
