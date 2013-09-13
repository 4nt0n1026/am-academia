package br.com.acad.dao.treino.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.TreinoFixoDAO;
import br.com.acad.model.treino.TreinoFixo;

@Repository
public class TreinoFixoDAOImpl extends DAOImpl<TreinoFixo,Integer> implements TreinoFixoDAO{

	public TreinoFixoDAOImpl() {
		super();
	}

	@Override
	public List<TreinoFixo> buscarTodos() {
		TypedQuery<TreinoFixo> q = getEntityManager().createQuery("from TreinoFixo", TreinoFixo.class);
		return q.getResultList();
	}



}
