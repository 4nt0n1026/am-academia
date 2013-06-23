package br.com.acad.dao.pessoa.interf;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.pessoa.Aluno;

@Remote
public interface AlunoDAO extends DAO<Aluno,Integer>{
	
	
	
}
