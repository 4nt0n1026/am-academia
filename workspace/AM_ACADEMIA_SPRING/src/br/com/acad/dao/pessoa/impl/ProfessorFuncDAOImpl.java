package br.com.acad.dao.pessoa.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.logic.CriptografiaLogic;
import br.com.acad.model.pessoa.ProfessorFunc;

@Repository
public class ProfessorFuncDAOImpl extends DAOImpl<ProfessorFunc,Integer> implements ProfessorFuncDAO{

	public ProfessorFuncDAOImpl() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProfessorFunc> buscarFieldNome() {
		Query q = getEntityManager().createQuery("select p.id, p.nome from ProfessorFunc p");
		List<ProfessorFunc> professores = new ArrayList<ProfessorFunc>();
		Collection<Object[]> resultado = q.getResultList();
		for (Object[] o:resultado){
			ProfessorFunc p = new ProfessorFunc((Integer) o[0], (String) o[1]);
			professores.add(p);
		}
		return professores;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ProfessorFunc> buscarFieldNomeProf() {
		Query q = getEntityManager().createQuery("select p.id, p.nome from ProfessorFunc p where p.isProfessor=:true");
		q.setParameter("true", true);
		List<ProfessorFunc> professores = new ArrayList<ProfessorFunc>();
		Collection<Object[]> resultado = q.getResultList();
		for (Object[] o:resultado){
			ProfessorFunc p = new ProfessorFunc((Integer) o[0], (String) o[1]);
			professores.add(p);
		}
		return professores;
	}




	@Override
	public List<ProfessorFunc> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfessorFunc logar(String email, String senha) {
		// TODO - Remover (Para Teste)
		if(email.equals("") && senha.equals("")){
			return new ProfessorFunc(4328768, "Christian");
		}
		//--------------------------
		try{
			TypedQuery<ProfessorFunc> q = getEntityManager().createQuery("from ProfessorFunc p where p.email = :email and p.senha = :senha", ProfessorFunc.class);
			q.setParameter("email", email);
			q.setParameter("senha", CriptografiaLogic.encriptar(senha));
			return q.getSingleResult();
	 	} catch(NoResultException e) {
	        return null;
	    }
	}

}
