package br.com.acad.dao.horario.impl;

import java.util.List;

import javax.ejb.Stateless;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.horario.interf.UnidadeDAO;
import br.com.acad.model.horario.Unidade;

@Stateless
public class UnidadeDAOImpl extends DAOImpl<Unidade,Integer> implements UnidadeDAO{

	public UnidadeDAOImpl() {
		super();
	}

	@Override
	public List<Unidade> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
