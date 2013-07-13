package br.com.acad.dao.treino.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.SolicitacaoTreinoDAO;
import br.com.acad.model.treino.SolicitacaoTreino;

@Stateless
public class SolicitacaoTreinoDAOImpl extends DAOImpl<SolicitacaoTreino,Integer> implements SolicitacaoTreinoDAO{

	public SolicitacaoTreinoDAOImpl() {
		super();
	}

	@Override
	public List<SolicitacaoTreino> buscarTodos() {
		TypedQuery<SolicitacaoTreino> q = em.createQuery("from SolicitacaoTreino", SolicitacaoTreino.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SolicitacaoTreino> buscarTodos(int page, String txtSearch,
			String order) {
		// TODO Auto-generated method stub
		return null;
	}

}
