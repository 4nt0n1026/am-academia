package br.com.fiap.cliente.dao.impl;

import javax.ejb.Stateless;

import br.com.fiap.cliente.dao.EnderecoDAO;
import br.com.fiap.cliente.entity.Endereco;
import br.com.fiap.dao.impl.DAOImpl;

@Stateless
public class EnderecoDAOImpl extends DAOImpl<Endereco,Integer> implements EnderecoDAO{

	public EnderecoDAOImpl() {
		super();
	}

}
