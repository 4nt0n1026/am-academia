package br.com.acad.dao.horario.impl;

import java.util.List;

import javax.ejb.Stateless;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.horario.interf.AulaDAO;
import br.com.acad.model.horario.Aula;

@Stateless
public class AulaDAOImpl extends DAOImpl<Aula,Integer> implements AulaDAO{

	public AulaDAOImpl() {
		super();
	}

	@Override
	public List<Aula> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
