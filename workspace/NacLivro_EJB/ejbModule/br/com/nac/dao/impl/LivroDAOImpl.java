package br.com.nac.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.nac.dao.LivroDAO;
import br.com.nac.model.Livro;

@Stateless
public class LivroDAOImpl extends DAOImpl<Livro, Integer> implements LivroDAO {

	public LivroDAOImpl(){
		super();
	}
	
	@Override
	public List<Livro> buscaTodos() {
		TypedQuery<Livro> q =  em.createQuery("select l from Livro l", Livro.class);		
		return q.getResultList();
	}

	@Override
	public List<Livro> buscaPorTitulo(String titulo) {
		TypedQuery<Livro> q =  em.createQuery("select l from Livro l where l.titulo like :t", Livro.class);
		q.setParameter("t", "%" + titulo + "%");
		return q.getResultList();
	}

}
