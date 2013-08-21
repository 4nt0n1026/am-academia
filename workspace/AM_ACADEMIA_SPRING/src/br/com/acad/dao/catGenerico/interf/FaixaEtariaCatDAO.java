package br.com.acad.dao.catGenerico.interf;

import java.util.List;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.cat.FaixaEtariaCat;

public interface FaixaEtariaCatDAO extends DAO<FaixaEtariaCat,Integer>{
	
	public List<FaixaEtariaCat> buscarTodos();
	
}
