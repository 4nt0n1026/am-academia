package br.com.acad.dao.catGenerico.interf;

import java.util.List;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.cat.SexoCat;

@Remote
public interface SexoCatDAO extends DAO<SexoCat,Integer>{
	
	public List<SexoCat> buscarTodos();
	
}
