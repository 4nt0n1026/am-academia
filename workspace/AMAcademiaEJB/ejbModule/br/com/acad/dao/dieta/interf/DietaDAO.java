package br.com.acad.dao.dieta.interf;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.dieta.Dieta;

@Remote
public interface DietaDAO extends DAO<Dieta,Integer>{
	
	
	
}
