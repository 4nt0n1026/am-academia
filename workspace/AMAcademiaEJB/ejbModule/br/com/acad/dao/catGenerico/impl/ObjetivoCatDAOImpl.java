package br.com.acad.dao.catGenerico.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.catGenerico.interf.ObjetivoCatDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.catGenerico.ObjetivoCat;

@Stateless
public class ObjetivoCatDAOImpl extends DAOImpl<ObjetivoCat,Integer> implements ObjetivoCatDAO{

	public ObjetivoCatDAOImpl() {
		super();
	}

}
