package br.com.acad.dao.catGenerico.interf;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.catGenerico.SexoCat;

@Remote
public interface SexoCatDAO extends DAO<SexoCat,Integer>{
	
	
	
}
