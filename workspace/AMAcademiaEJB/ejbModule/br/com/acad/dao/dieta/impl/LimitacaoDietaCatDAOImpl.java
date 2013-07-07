package br.com.acad.dao.dieta.impl;

import java.util.List;

import javax.ejb.Stateless;

import br.com.acad.dao.dieta.interf.LimitacaoDietaCatDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.LimitacaoDietaCat;

@Stateless
public class LimitacaoDietaCatDAOImpl extends DAOImpl<LimitacaoDietaCat,Integer> implements LimitacaoDietaCatDAO{

	public LimitacaoDietaCatDAOImpl() {
		super();
	}

	@Override
	public List<LimitacaoDietaCat> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
