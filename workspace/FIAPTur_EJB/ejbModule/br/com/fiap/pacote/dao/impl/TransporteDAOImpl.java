package br.com.fiap.pacote.dao.impl;

import javax.ejb.Stateless;

import br.com.fiap.dao.impl.DAOImpl;
import br.com.fiap.pacote.dao.TransporteDAO;
import br.com.fiap.pacote.entity.Transporte;

@Stateless
public class TransporteDAOImpl extends DAOImpl<Transporte,Integer> implements TransporteDAO{

	public TransporteDAOImpl() {
		super();
	}

}
