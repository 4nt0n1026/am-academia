package br.com.acad.dao.dieta.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.acad.dao.dieta.interf.DietaEspecificaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.DietaEspecifica;

@Stateless
public class DietaEspecificaDAOImpl extends DAOImpl<DietaEspecifica,Integer> implements DietaEspecificaDAO{

	public DietaEspecificaDAOImpl() {
		super();
	}

	@Override
	public List<DietaEspecifica> buscarTodos() {
		TypedQuery<DietaEspecifica> q = em.createQuery("from DietaEspecifica", DietaEspecifica.class);
		return q.getResultList();
	}

}
