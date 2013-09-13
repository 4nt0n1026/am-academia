package br.com.acad.dao.contato.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.contato.interf.EstadoDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.contato.Estado;

@Repository
public class EstadoDAOImpl extends DAOImpl<Estado,Integer> implements EstadoDAO{

	public EstadoDAOImpl() {
		super();
	}

	@Override
	public List<Estado> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
