package br.com.acad.dao.dieta.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.dieta.interf.SolicitacaoDietaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.SolicitacaoDieta;

@Stateless
public class SolicitacaoDietaDAOImpl extends DAOImpl<SolicitacaoDieta,Integer> implements SolicitacaoDietaDAO{

	public SolicitacaoDietaDAOImpl() {
		super();
	}

}
