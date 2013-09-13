package br.com.acad.dao.contato.impl;

import java.util.List;

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


}
