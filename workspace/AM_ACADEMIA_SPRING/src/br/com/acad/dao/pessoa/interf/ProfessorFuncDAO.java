package br.com.acad.dao.pessoa.interf;

import java.util.List;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.pessoa.ProfessorFunc;

public interface ProfessorFuncDAO extends DAO<ProfessorFunc,Integer>{
	
	public List<ProfessorFunc> buscarFieldNome();
	public List<ProfessorFunc> buscarFieldNomeProf();
	public long contarTodosProf(String search);
	public long contarTodosFunc(String search);
	public List<ProfessorFunc> buscarTodosProf(int page, String txtSearch, String order);
	public List<ProfessorFunc> buscarTodosFunc(int page, String txtSearch,String order);
	public ProfessorFunc logar(String email, String senha);
	
}
