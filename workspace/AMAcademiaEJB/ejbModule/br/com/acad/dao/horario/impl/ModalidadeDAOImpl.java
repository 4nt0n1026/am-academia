package br.com.acad.dao.horario.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.horario.interf.ModalidadeDAO;
import br.com.acad.model.horario.Modalidade;

@Stateless
public class ModalidadeDAOImpl extends DAOImpl<Modalidade,Integer> implements ModalidadeDAO{

	public ModalidadeDAOImpl() {
		super();
	}

	@Override
	public List<Modalidade> buscarTodos() {
		TypedQuery<Modalidade> q = em.createQuery("from Modalidade", Modalidade.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Modalidade> buscarTodos(int page, String txtSearch, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
