package br.com.acad.dao.avisos.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.acad.dao.avisos.interf.NoticiaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.avisos.Noticia;

@Stateless
public class NoticiaDAOImpl extends DAOImpl<Noticia,Integer> implements NoticiaDAO{

	public NoticiaDAOImpl() {
		super();
	}
	
	@Override
	public List<Noticia> buscarTodos() {
		TypedQuery<Noticia> q = em.createQuery("from Noticia", Noticia.class);
		return q.getResultList();
	}
	
}
