package br.com.acad.dao.pessoa.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.pessoa.interf.AlunoDAO;
import br.com.acad.model.pessoa.Aluno;
import br.com.acad.model.pessoa.ProfessorFunc;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Aluno> buscarFieldNome() {
		Query q = em.createQuery("select a.id, p.nome from Aluno a");
		List<Aluno> alunos = new ArrayList<Aluno>();
		Collection<Object[]> resultado = q.getResultList();
		for (Object[] o:resultado){
			Aluno a = new Aluno((Integer) o[0], (String) o[1]);
			alunos.add(a);
		}
		return alunos;
	}

}
