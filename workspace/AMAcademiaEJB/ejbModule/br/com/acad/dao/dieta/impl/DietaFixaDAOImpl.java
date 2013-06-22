package br.com.acad.dao.dieta.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.dieta.interf.DietaFixaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.DietaFixa;

@Stateless
public class DietaFixaDAOImpl extends DAOImpl<DietaFixa,Integer> implements DietaFixaDAO{

	public DietaFixaDAOImpl() {
		super();
	}

}
