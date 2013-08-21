package br.com.acad.dao.contato.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.contato.interf.LogradouroDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.contato.Logradouro;

@Repository
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

	@Override
	public List<Logradouro> filtrarTodos(int page, Map<String, String> filtros,
			String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long contarTodosFiltro(Map<String, String> filtros) {
		// TODO Auto-generated method stub
		return 0;
	}


}
