package br.com.nac.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.nac.dao.ExemplarDAO;
import br.com.nac.model.Exemplar;
import br.com.nac.model.Livro;

@Stateless
public class ExemplarDAOImpl extends DAOImpl<Exemplar, Integer> implements ExemplarDAO{

	public ExemplarDAOImpl(){
		super();
	}

	@Override
	public List<Exemplar> buscarPorLivro(Livro livro) {
		TypedQuery<Exemplar> q = em.createQuery
				("select e from Exemplar e where e.livro = :l", Exemplar.class);
		q.setParameter("l", livro);
		return q.getResultList();
	}
	
	

}
