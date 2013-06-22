package br.com.acad.dao.dieta.interf;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.dieta.DiaDieta;

@Remote
public interface DiaDietaDAO extends DAO<DiaDieta,Integer>{
	
	
	
}
