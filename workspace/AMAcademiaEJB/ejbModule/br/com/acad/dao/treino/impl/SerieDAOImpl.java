package br.com.acad.dao.treino.impl;

import java.util.List;

import javax.ejb.Stateless;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.SerieDAO;
import br.com.acad.model.treino.Serie;

@Stateless
public class SerieDAOImpl extends DAOImpl<Serie,Integer> implements SerieDAO{

	public SerieDAOImpl() {
		super();
	}

	@Override
	public List<Serie> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
