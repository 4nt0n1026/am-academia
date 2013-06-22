package br.com.fiap.cliente.dao.impl;

import javax.ejb.Stateless;

import br.com.fiap.cliente.dao.CidadeDAO;
import br.com.fiap.cliente.entity.Cidade;
import br.com.fiap.dao.impl.DAOImpl;

@Stateless
public class CidadeDAOImpl extends DAOImpl<Cidade,Integer> implements CidadeDAO{

	public CidadeDAOImpl() {
		super();
	}

}
