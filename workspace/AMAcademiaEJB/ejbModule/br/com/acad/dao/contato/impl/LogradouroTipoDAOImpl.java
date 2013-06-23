package br.com.acad.dao.contato.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.contato.interf.LogradouroTipoDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.contato.LogradouroTipo;

@Stateless
public class LogradouroTipoDAOImpl extends DAOImpl<LogradouroTipo,Integer> implements LogradouroTipoDAO{

	public LogradouroTipoDAOImpl() {
		super();
	}

}
