package br.com.acad.dao.horario.interf;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.horario.Aula;

@Remote
public interface AulaDAO extends DAO<Aula,Integer>{
	
	
	
}
