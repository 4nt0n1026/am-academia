package br.com.acad.dao.contato.impl;

import java.util.List;

import javax.ejb.Stateless;

import br.com.acad.dao.contato.interf.CidadeDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.contato.Cidade;

@Stateless
public class CidadeDAOImpl extends DAOImpl<Cidade,Integer> implements CidadeDAO{

	public CidadeDAOImpl() {
		super();
	}

	@Override
	public List<Cidade> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long contarTodos(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Cidade> buscarTodos(int page, String txtSearch, String order) {
		// TODO Auto-generated method stub
		return null;
	}

}
