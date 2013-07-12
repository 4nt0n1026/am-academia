package br.com.acad.dao.treino.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.ParteCorpoDAO;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.treino.Exercicio;
import br.com.acad.model.treino.ParteCorpo;

@Stateless
public class ParteCorpoDAOImpl extends DAOImpl<ParteCorpo,Integer> implements ParteCorpoDAO{

	public ParteCorpoDAOImpl() {
		super();
	}

	@Override
	public List<ParteCorpo> buscarTodos() {
		TypedQuery<ParteCorpo> q = em.createQuery("from ParteCorpo order by nome", ParteCorpo.class);
		return q.getResultList();
	}
	
	@Override
	public List<ParteCorpo> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<ParteCorpo> q = em.createQuery(SqlLogic.getSql(ParteCorpo.STATIC_FIELDS, "ParteCorpo", txtSearch, order), ParteCorpo.class);
		
		q.setMaxResults(TABLE_SIZE);

		if(page>0){
		q.setFirstResult((page -1)*TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ParteCorpo> buscarPartesPrimarias(Exercicio exercicio) {
		Query q = em.createQuery("select e.parteCorpoPrimaria from Exercicio e where e.id = :id");
		q.setParameter("id", exercicio.getId());
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ParteCorpo> buscarPartesSecundaria(Exercicio exercicio) {
		Query q = em.createQuery("select e.parteCorpoSecundaria from Exercicio e where e.id = :id");
		q.setParameter("id", exercicio.getId());
		return q.getResultList();
	}

}
