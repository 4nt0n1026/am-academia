package br.com.nac.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.nac.dao.AutorDAO;
import br.com.nac.model.Autor;
import br.com.nac.model.Livro;

@Stateless
public class AutorDAOImpl extends DAOImpl<Autor, Integer> implements AutorDAO{
	
	public AutorDAOImpl(){
		super();
	}

	@Override
	public List<Autor> buscarTodos() {
		TypedQuery<Autor> q = em.createQuery("from Autor", Autor.class);
		return q.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Autor> buscarTodosPorLivro(Livro livro) {
		Query q = em.createQuery("select l.autores from Livro l where l=:livro");
		q.setParameter("livro", livro);
		return q.getResultList();
	}

	
	
	
}
