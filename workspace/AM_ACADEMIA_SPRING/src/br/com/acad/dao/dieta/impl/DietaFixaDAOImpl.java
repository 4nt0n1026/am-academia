package br.com.acad.dao.dieta.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.dieta.interf.DietaFixaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.DietaFixa;

@Repository
public class DietaFixaDAOImpl extends DAOImpl<DietaFixa,Integer> implements DietaFixaDAO{

	public DietaFixaDAOImpl() {
		super();
	}

	@Override
	public List<DietaFixa> buscarTodos() {
		TypedQuery<DietaFixa> q = em.createQuery("from DietaFixa", DietaFixa.class);
		return q.getResultList();
	}

}
