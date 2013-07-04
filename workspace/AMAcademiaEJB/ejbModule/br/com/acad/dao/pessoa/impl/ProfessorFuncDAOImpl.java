package br.com.acad.dao.pessoa.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.model.pessoa.ProfessorFunc;

@Stateless
public class ProfessorFuncDAOImpl extends DAOImpl<ProfessorFunc,Integer> implements ProfessorFuncDAO{

	public ProfessorFuncDAOImpl() {
		super();
	}

	@Override
	public List<ProfessorFunc> buscarTodosProf() {
		TypedQuery<ProfessorFunc> q = em.createQuery("from ProfessorFunc p where p.isProfessor=:bool", ProfessorFunc.class);
		q.setParameter("bool", true);
		return q.getResultList();
	}
	
	@Override
	public List<ProfessorFunc> buscarTodosFunc() {
		TypedQuery<ProfessorFunc> q = em.createQuery("from ProfessorFunc p where p.isProfessor=:bool", ProfessorFunc.class);
		q.setParameter("bool", false);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProfessorFunc> buscarFieldNome() {
		Query q = em.createQuery("select p.id, p.nome from ProfessorFunc p");
		List<ProfessorFunc> professores = new ArrayList<ProfessorFunc>();
		Collection<Object[]> resultado = q.getResultList();
		for (Object[] o:resultado){
			ProfessorFunc p = new ProfessorFunc((Integer) o[0], (String) o[1]);
			professores.add(p);
		}
		return professores;
	}

}
