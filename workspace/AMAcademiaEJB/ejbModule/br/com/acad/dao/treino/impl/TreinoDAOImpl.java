package br.com.acad.dao.treino.impl;

import java.util.List;

import javax.ejb.Stateless;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.TreinoDAO;
import br.com.acad.model.treino.Treino;

@Stateless
public class TreinoDAOImpl extends DAOImpl<Treino,Integer> implements TreinoDAO{

	public TreinoDAOImpl() {
		super();
	}

	@Override
	public List<Treino> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
