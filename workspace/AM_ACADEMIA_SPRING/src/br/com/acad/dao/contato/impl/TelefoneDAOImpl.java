package br.com.acad.dao.contato.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.contato.interf.TelefoneDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.contato.Telefone;

@Repository
public class TelefoneDAOImpl extends DAOImpl<Telefone,Integer> implements TelefoneDAO{

	public TelefoneDAOImpl() {
		super();
	}

	@Override
	public List<Telefone> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long contarTodos(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Telefone> buscarTodos(int page, String txtSearch, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Telefone> filtrarTodos(int page, Map<String, String> filtros,
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
