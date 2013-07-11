package br.com.acad.dao.pessoa.interf;

import java.util.List;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.pessoa.ProfessorFunc;

@Remote
public interface ProfessorFuncDAO extends DAO<ProfessorFunc,Integer>{
	
	public List<ProfessorFunc> buscarTodosProf();
	public List<ProfessorFunc> buscarTodosFunc();
	public List<ProfessorFunc> buscarFieldNome();
	public List<ProfessorFunc> buscarFieldNomeProf();
	
}
