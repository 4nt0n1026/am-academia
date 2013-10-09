package br.com.acad.dao.treino.interf;

import java.util.List;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.treino.ExercicioTreino;
import br.com.acad.model.treino.Serie;

public interface SerieDAO extends DAO<Serie, Integer>
{

    public List<Serie> buscarPorExercicioTreino(ExercicioTreino exercicio);

}
