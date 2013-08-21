package br.com.acad.dao.treino.interf;

import java.util.List;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.pessoa.Aluno;
import br.com.acad.model.treino.Treino;

public interface TreinoDAO extends DAO<Treino,Integer>{

	List<Treino> buscarPorAluno(Aluno aluno);
	
	
}
