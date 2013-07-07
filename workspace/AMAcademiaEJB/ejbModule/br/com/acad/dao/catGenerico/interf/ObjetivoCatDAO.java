package br.com.acad.dao.catGenerico.interf;

import java.util.List;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.cat.ObjetivoCat;

@Remote
public interface ObjetivoCatDAO extends DAO<ObjetivoCat,Integer>{
	
	public List<ObjetivoCat> buscarTodos();
	
	
}
