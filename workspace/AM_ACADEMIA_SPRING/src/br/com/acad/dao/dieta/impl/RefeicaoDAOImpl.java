package br.com.acad.dao.dieta.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.dieta.interf.RefeicaoDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.Refeicao;

@Repository
public class RefeicaoDAOImpl extends DAOImpl<Refeicao,Integer> implements RefeicaoDAO{

	public RefeicaoDAOImpl() {
		super();
	}

	@Override
	public List<Refeicao> buscarTodos() {
		TypedQuery<Refeicao> q = getEntityManager().createQuery("from Refeicao", Refeicao.class);
		return q.getResultList();
	}


}
