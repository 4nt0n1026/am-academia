package br.com.acad.dao.treino.interf;

import java.util.List;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.treino.DiaTreino;
import br.com.acad.model.treino.Treino;

@Remote
public interface DiaTreinoDAO extends DAO<DiaTreino,Integer>{
	
	public List<DiaTreino> buscaPorTreino(Treino treino);
	
}
