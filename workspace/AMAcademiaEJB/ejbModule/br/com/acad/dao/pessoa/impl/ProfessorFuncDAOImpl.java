package br.com.acad.dao.pessoa.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.model.pessoa.ProfessorFunc;

@Stateless
public class ProfessorFuncDAOImpl extends DAOImpl<ProfessorFunc,Integer> implements ProfessorFuncDAO{

	public ProfessorFuncDAOImpl() {
		super();
	}

}
