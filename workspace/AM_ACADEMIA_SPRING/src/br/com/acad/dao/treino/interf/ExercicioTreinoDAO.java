package br.com.acad.dao.treino.interf;

import java.util.List;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.treino.DiaTreino;
import br.com.acad.model.treino.ExercicioTreino;

public interface ExercicioTreinoDAO extends DAO<ExercicioTreino,Integer>{
	
	public List<ExercicioTreino> buscarPorDiaTreino(DiaTreino dia);
	
	
}
