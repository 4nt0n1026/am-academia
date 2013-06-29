package br.com.nac.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.nac.dao.EmprestimoDAO;
import br.com.nac.model.Emprestimo;

@Stateless
public class EmprestimoDAOImpl extends DAOImpl<Emprestimo, Integer> implements EmprestimoDAO{
	
	public EmprestimoDAOImpl(){
		super();
	}

	@Override
	public List<Emprestimo> buscarTodos() {
		TypedQuery<Emprestimo> q = em.createQuery("from Emprestimo", Emprestimo.class);
		return q.getResultList();
	}
	

}
