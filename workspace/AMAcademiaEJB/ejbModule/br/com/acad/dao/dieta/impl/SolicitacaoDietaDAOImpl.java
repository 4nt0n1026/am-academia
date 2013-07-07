package br.com.acad.dao.dieta.impl;

import java.util.List;

import javax.ejb.Stateless;

import br.com.acad.dao.dieta.interf.SolicitacaoDietaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.SolicitacaoDieta;

@Stateless
public class SolicitacaoDietaDAOImpl extends DAOImpl<SolicitacaoDieta,Integer> implements SolicitacaoDietaDAO{

	public SolicitacaoDietaDAOImpl() {
		super();
	}

	@Override
	public List<SolicitacaoDieta> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
