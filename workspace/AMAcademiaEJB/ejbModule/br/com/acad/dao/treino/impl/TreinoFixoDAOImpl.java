package br.com.acad.dao.treino.impl;

import java.util.List;

import javax.ejb.Stateless;

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
		// TODO Auto-generated method stub
		return null;
	}

}
