package br.com.acad.dao.dieta.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.acad.dao.dieta.interf.SolicitacaoDietaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.SolicitacaoDieta;

@Stateless
public class SolicitacaoDietaDAOImpl extends DAOImpl<SolicitacaoDieta,Integer> implements SolicitacaoDietaDAO{

	public SolicitacaoDietaDAOImpl() {
		super();
	}

	@Override
	public List<SolicitacaoDieta> buscarTodos() {
		TypedQuery<SolicitacaoDieta> q = em.createQuery("from SolicitacaoDieta", SolicitacaoDieta.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SolicitacaoDieta> buscarTodos(int page, String txtSearch,
			String order) {
		// TODO Auto-generated method stub
		return null;
	}

}
