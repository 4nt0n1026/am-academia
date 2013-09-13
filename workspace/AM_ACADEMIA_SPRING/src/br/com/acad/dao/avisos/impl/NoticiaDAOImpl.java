package br.com.acad.dao.avisos.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.avisos.interf.NoticiaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.avisos.Noticia;

@Repository
public class NoticiaDAOImpl extends DAOImpl<Noticia,Integer> implements NoticiaDAO{

	public NoticiaDAOImpl() {
		super();
	}
	
	@Override
	public List<Noticia> buscarTodos() {
		TypedQuery<Noticia> q = getEntityManager().createQuery("from Noticia", Noticia.class);
		return q.getResultList();
	}

}
