package br.com.acad.dao.pessoa.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.pessoa.interf.AlunoDAO;
import br.com.acad.model.pessoa.Aluno;

@Stateless
public class AlunoDAOImpl extends DAOImpl<Aluno,Integer> implements AlunoDAO{

	public AlunoDAOImpl() {
		super();
	}

	@Override
	public List<Aluno> buscarTodos() {
		TypedQuery<Aluno> q = em.createQuery("from Aluno", Aluno.class);
		return q.getResultList();
	}

}
