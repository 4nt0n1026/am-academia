package br.com.acad.dao.catGenerico.interf;

import java.util.List;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.cat.DuracaoTreinoCat;

@Remote
public interface DuracaoTreinoCatDAO extends DAO<DuracaoTreinoCat,Integer>{
	
	public List<DuracaoTreinoCat> buscarTodos();
	
	
}
