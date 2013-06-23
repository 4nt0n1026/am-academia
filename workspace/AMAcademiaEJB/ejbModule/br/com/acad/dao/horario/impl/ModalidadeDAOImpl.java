package br.com.acad.dao.horario.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.horario.interf.ModalidadeDAO;
import br.com.acad.model.horario.Modalidade;

@Stateless
public class ModalidadeDAOImpl extends DAOImpl<Modalidade,Integer> implements ModalidadeDAO{

	public ModalidadeDAOImpl() {
		super();
	}

}
