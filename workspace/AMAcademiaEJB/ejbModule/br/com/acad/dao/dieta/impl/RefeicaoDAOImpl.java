package br.com.acad.dao.dieta.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.acad.dao.dieta.interf.RefeicaoDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.Refeicao;

@Stateless
public class RefeicaoDAOImpl extends DAOImpl<Refeicao,Integer> implements RefeicaoDAO{

	public RefeicaoDAOImpl() {
		super();
	}

	@Override
	public List<Refeicao> buscarTodos() {
		TypedQuery<Refeicao> q = em.createQuery("from Refeicao", Refeicao.class);
		return q.getResultList();
	}

}
