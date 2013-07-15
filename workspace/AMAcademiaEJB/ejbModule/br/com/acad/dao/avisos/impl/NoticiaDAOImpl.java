package br.com.acad.dao.avisos.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.acad.dao.avisos.interf.NoticiaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.logic.SqlLogic;
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

	@Override
	public long contarTodos(String search) {
		Query q = em.createQuery(SqlLogic.getCountSql(Noticia.STATIC_FIELDS, "Noticia", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<Noticia> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<Noticia> q = em.createQuery(SqlLogic.getSql(Noticia.STATIC_FIELDS, "Noticia", txtSearch, order), Noticia.class);
		
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}
	
	@Override
	public List<Noticia> filtrarTodos(int page, Map<String, String> filtros, String order){
		TypedQuery<Noticia> q = em.createQuery(SqlLogic.getFilterSql(filtros, "Noticia", order), Noticia.class);
		
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

	@Override
	public long contarTodosFiltro(Map<String, String> filtros) {
		Query q = em.createQuery(SqlLogic.getCountFilterSql("Noticia", filtros));
		return  (Long) q.getSingleResult();
	}
}
