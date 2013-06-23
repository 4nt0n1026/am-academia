package br.com.acad.dao.treino.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.SerieFeitaDAO;
import br.com.acad.model.treino.SerieFeita;
@Stateless
public class SerieFeitaDAOImpl extends DAOImpl<SerieFeita,Integer> implements SerieFeitaDAO{

	public SerieFeitaDAOImpl() {
		super();
	}

}
