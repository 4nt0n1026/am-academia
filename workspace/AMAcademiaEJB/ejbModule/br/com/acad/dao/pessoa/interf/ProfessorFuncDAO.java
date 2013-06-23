package br.com.acad.dao.pessoa.interf;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.pessoa.ProfessorFunc;

@Remote
public interface ProfessorFuncDAO extends DAO<ProfessorFunc,Integer>{
	
	
	
}
