package br.com.acad.dao.horario.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.horario.interf.HorarioAulaDAO;
import br.com.acad.model.horario.HorarioAula;

@Stateless
public class HorarioAulaDAOImpl extends DAOImpl<HorarioAula,Integer> implements HorarioAulaDAO{

	public HorarioAulaDAOImpl() {
		super();
	}

	@Override
	public List<HorarioAula> buscarTodos() {
		TypedQuery<HorarioAula> q = em.createQuery("from HorarioAula", HorarioAula.class);
		return q.getResultList();
	}

}
