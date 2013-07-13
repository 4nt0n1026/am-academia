package br.com.acad.dao.treino.impl;

import java.util.List;

import javax.ejb.Stateless;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.SerieFeitaDAO;
import br.com.acad.model.treino.SerieFeita;
@Stateless
public class SerieFeitaDAOImpl extends DAOImpl<SerieFeita,Integer> implements SerieFeitaDAO{

	public SerieFeitaDAOImpl() {
		super();
	}

	@Override
	public List<SerieFeita> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long contarTodos(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SerieFeita> buscarTodos(int page, String txtSearch, String order) {
		// TODO Auto-generated method stub
		return null;
	}

}
