package br.com.acad.dao.dieta.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.dieta.interf.DietaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.Dieta;

@Stateless
public class DietaDAOImpl extends DAOImpl<Dieta,Integer> implements DietaDAO{

	public DietaDAOImpl() {
		super();
	}

}
