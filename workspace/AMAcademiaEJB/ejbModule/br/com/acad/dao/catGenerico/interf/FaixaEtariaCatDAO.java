package br.com.acad.dao.catGenerico.interf;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.catGenerico.FaixaEtariaCat;

@Remote
public interface FaixaEtariaCatDAO extends DAO<FaixaEtariaCat,Integer>{
	
	
	
}
