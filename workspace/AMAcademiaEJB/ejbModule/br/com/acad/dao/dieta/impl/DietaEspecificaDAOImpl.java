package br.com.acad.dao.dieta.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.dieta.interf.DietaEspecificaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.DietaEspecifica;

@Stateless
public class DietaEspecificaDAOImpl extends DAOImpl<DietaEspecifica,Integer> implements DietaEspecificaDAO{

	public DietaEspecificaDAOImpl() {
		super();
	}

}
