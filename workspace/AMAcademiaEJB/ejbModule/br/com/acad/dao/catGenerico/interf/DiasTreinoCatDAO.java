package br.com.acad.dao.catGenerico.interf;

import java.util.List;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.cat.DiasTreinoCat;

@Remote
public interface DiasTreinoCatDAO extends DAO<DiasTreinoCat,Integer>{
	
	public List<DiasTreinoCat> buscarTodos();
	
	
}
