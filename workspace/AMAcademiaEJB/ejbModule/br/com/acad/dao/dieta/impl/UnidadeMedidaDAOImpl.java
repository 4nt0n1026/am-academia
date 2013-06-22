package br.com.acad.dao.dieta.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.dieta.interf.UnidadeMedidaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.UnidadeMedida;

@Stateless
public class UnidadeMedidaDAOImpl extends DAOImpl<UnidadeMedida,Integer> implements UnidadeMedidaDAO{

	public UnidadeMedidaDAOImpl() {
		super();
	}

}
