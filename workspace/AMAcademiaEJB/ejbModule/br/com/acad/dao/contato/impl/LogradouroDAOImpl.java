package br.com.acad.dao.contato.impl;

import java.util.List;

import javax.ejb.Stateless;

import br.com.acad.dao.contato.interf.LogradouroDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.contato.Logradouro;

@Stateless
public class LogradouroDAOImpl extends DAOImpl<Logradouro,Integer> implements LogradouroDAO{

	public LogradouroDAOImpl() {
		super();
	}

	@Override
	public List<Logradouro> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long contarTodos(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Logradouro> buscarTodos(int page, String txtSearch, String order) {
		// TODO Auto-generated method stub
		return null;
	}

}
