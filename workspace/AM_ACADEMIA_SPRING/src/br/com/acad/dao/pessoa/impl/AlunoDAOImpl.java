package br.com.acad.dao.pessoa.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.pessoa.interf.AlunoDAO;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.pessoa.Aluno;

@Repository
public class AlunoDAOImpl extends DAOImpl<Aluno,Integer> implements AlunoDAO{

	public AlunoDAOImpl() {
		super();
	}

	@Override
	public List<Aluno> buscarTodos() {
		TypedQuery<Aluno> q = getEntityManager().createQuery("from Aluno", Aluno.class);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aluno> buscarFieldNome() {
		Query q = getEntityManager().createQuery("select a.id, a.nome from Aluno a");
		List<Aluno> alunos = new ArrayList<Aluno>();
		Collection<Object[]> resultado = q.getResultList();
		for (Object[] o:resultado){
			Aluno a = new Aluno((Integer) o[0], (String) o[1]);
			alunos.add(a);
		}
		return alunos;
	}


	@Override
	public Aluno logar(Aluno aluno){
		// TODO - Remover (Para Teste)
		if(aluno.getEmail().equals("") && aluno.getEmail().equals("")){
			return new Aluno(4328768, "Christian");
		}
		//--------------------------
		try{
			TypedQuery<Aluno> q = getEntityManager().createQuery("from Aluno a where a.email = :email and a.senha = :senha", Aluno.class);
			q.setParameter("email", aluno.getEmail());
			q.setParameter("senha", aluno.getSenha());
			return q.getSingleResult();
	 	} catch(NoResultException e) {
	        return null;
	    }
	}

}
