package br.com.acad.dao.dieta.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.acad.dao.dieta.interf.UnidadeMedidaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.UnidadeMedida;

@Stateless
public class UnidadeMedidaDAOImpl extends DAOImpl<UnidadeMedida,Integer> implements UnidadeMedidaDAO{

	public UnidadeMedidaDAOImpl() {
		super();
	}

	@Override
	public List<UnidadeMedida> buscarTodos() {
		TypedQuery<UnidadeMedida> q = em.createQuery("from UnidadeMedida", UnidadeMedida.class);
		return q.getResultList();
	}

}
