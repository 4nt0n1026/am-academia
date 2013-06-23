package br.com.acad.dao.treino.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.DuracaoTreinoCatDAO;
import br.com.acad.model.treino.DuracaoTreinoCat;

@Stateless
public class DuracaoTreinoCatDAOImpl extends DAOImpl<DuracaoTreinoCat,Integer> implements DuracaoTreinoCatDAO{

	public DuracaoTreinoCatDAOImpl() {
		super();
	}

}
