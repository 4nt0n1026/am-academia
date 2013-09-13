package br.com.acad.dao.horario.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.horario.interf.AulaDAO;
import br.com.acad.model.horario.Aula;

@Repository
public class AulaDAOImpl extends DAOImpl<Aula,Integer> implements AulaDAO{

	public AulaDAOImpl() {
		super();
	}

	@Override
	public List<Aula> buscarTodos() {
		TypedQuery<Aula> q = getEntityManager().createQuery("from Aula", Aula.class);
		return q.getResultList();
	}


}
