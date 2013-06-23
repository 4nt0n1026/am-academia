package br.com.acad.dao.contato.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.contato.interf.LogradouroDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.contato.Logradouro;

@Stateless
public class LogradouroDAOImpl extends DAOImpl<Logradouro,Integer> implements LogradouroDAO{

	public LogradouroDAOImpl() {
		super();
	}

}
