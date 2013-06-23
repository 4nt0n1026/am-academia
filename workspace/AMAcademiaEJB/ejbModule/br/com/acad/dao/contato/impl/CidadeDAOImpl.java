package br.com.acad.dao.contato.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.contato.interf.CidadeDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.contato.Cidade;

@Stateless
public class CidadeDAOImpl extends DAOImpl<Cidade,Integer> implements CidadeDAO{

	public CidadeDAOImpl() {
		super();
	}

}
