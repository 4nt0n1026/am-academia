package br.com.acad.dao.treino.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.TreinoFixoDAO;
import br.com.acad.model.treino.TreinoFixo;

@Stateless
public class TreinoFixoDAOImpl extends DAOImpl<TreinoFixo,Integer> implements TreinoFixoDAO{

	public TreinoFixoDAOImpl() {
		super();
	}

	@Override
	public List<TreinoFixo> buscarTodos() {
		TypedQuery<TreinoFixo> q = em.createQuery("from TreinoFixo", TreinoFixo.class);
		return q.getResultList();
	}

}
