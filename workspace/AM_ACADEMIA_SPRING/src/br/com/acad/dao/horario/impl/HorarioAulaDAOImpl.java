package br.com.acad.dao.horario.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.horario.interf.HorarioAulaDAO;
import br.com.acad.model.horario.Aula;
import br.com.acad.model.horario.HorarioAula;

@Repository
public class HorarioAulaDAOImpl extends DAOImpl<HorarioAula,Integer> implements HorarioAulaDAO{

	public HorarioAulaDAOImpl() {
		super();
	}

	@Override
	public List<HorarioAula> buscarTodos() {
		TypedQuery<HorarioAula> q = em.createQuery("from HorarioAula", HorarioAula.class);
		return q.getResultList();
	}


	@Override
	public List<HorarioAula> buscarPorAula(Aula aula) {
		TypedQuery<HorarioAula> q = em.createQuery("from HorarioAula h where h.aula.id = :idAula", HorarioAula.class);
		q.setParameter("idAula", aula.getId());
		return q.getResultList();
	}

}
