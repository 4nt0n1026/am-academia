package br.com.acad.dao.horario.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

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
		TypedQuery<Aula> q = em.createQuery("from Aula", Aula.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Aula> buscarTodos(int page, String txtSearch, String order) {
		// TODO Auto-generated method stub
		return null;
	}

}
